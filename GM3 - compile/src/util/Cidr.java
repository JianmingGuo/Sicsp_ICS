package util;

import java.util.ArrayList;
import java.util.List;

//关键字implements是一个类，实现一个接口用的关键字，它是用来实现接口中定义的抽象方法。实现一个接口，必须实现接口中的所有方法。使用 implements 关键字可以变相的使java具有多继承的特性，使用范围为类继承接口的情况，可以同时继承多个接口（接口跟接口之间采用逗号分隔） 

public class Cidr implements Comparable<Cidr> {
    public final static long maxIP = 0xFFFFFFFFL; //32位
    public final static short maxBits = 32;

    private long baseIp;
    private short bits;

    private static int log2(long arg) throws IllegalArgumentException {
        if(arg < 1) {
            throw new IllegalArgumentException("Cannot compute log2(" + arg + ")");
        }

        int result = 0;
        for(arg >>>= 1; arg > 0; arg >>>= 1) {
            result++;
        }

        return result;   //数学上的log2计算
    }

    public static String toIp(long ip) {
        return "" + (0xFF & (ip >>> 24)) + "." + (0xFF & (ip >>> 16)) + "." + (0xFF & (ip >>> 8)) + "." + (0xFF & ip);
    }

    public static long toIp(String ipStr) {    //该方法用于字符型ip到数字型的转换，同时对字段合法性执行检查
        String[] ipPartsStr = ipStr.split("\\."); //将ipStr这个字符串分割成四段
        if(ipPartsStr.length != 4) {
            throw new IllegalArgumentException(ipStr + " does not represent an IP address, the IP has " + ipPartsStr.length + " parts.");
        }

        long[] ipParts = new long[4];
        for(int i = 0; i < 4; i++) {
            ipParts[i] = Long.parseLong(ipPartsStr[i]);  
            
            /*了解下Long.parseLong(String s,int n)，s 这是一个包含long表示要解析的字符串,
             * n 是进制数，它是将第一个参数用第二个参数进制来表示，如果不写第二个参数的话默认是十进制，例如：
            parseLong("0", 10) returns 0L
            parseLong("-BB", 16) returns -187L
            */
            
            if(ipParts[i] < 0 || ipParts[i] > 255) {
                throw new IllegalArgumentException(ipStr + " does not represent an IP address, components exist outside [0:255]");
            }
        }

        return (((((ipParts[0] << 8) + ipParts[1]) << 8) + ipParts[2]) << 8) + ipParts[3]; //返回值还原32位二进制数
    }

    public Cidr(byte[] ip) {
        this(( // Casting to a long from a byte will extend the sign bit, so we need to mask back to the desired 8 bits after the conversion.
                (((long) ip[0] & 0xFF) << 24) |
                        (((long) ip[1] & 0xFF) << 16) |
                        (((long) ip[2] & 0xFF) << 8) |
                        ((long) ip[3] & 0xFF)
        ), (short) 32);
    }

    public Cidr(Byte[] ip) {
        this(( // Casting to a long from a byte will extend the sign bit, so we need to mask back to the desired 8 bits after the conversion.
                (((long) ip[0] & 0xFF) << 24) |
                        (((long) ip[1] & 0xFF) << 16) |
                        (((long) ip[2] & 0xFF) << 8) |
                        ((long) ip[3] & 0xFF)
        ), (short) 32);
    }
    public Cidr(String cidrOrIp) {
        String[] parts = cidrOrIp.split("/");
        if(parts.length > 2) {
            throw new IllegalArgumentException(cidrOrIp + " does not represent an IP address or CIDR");
        }

        init(Cidr.toIp(parts[0]), (parts.length == 1 ? (short)32 : Short.parseShort(parts[1])));
    }

    public Cidr(long ip, short bits) {
        init(ip, bits);
    }

    public Cidr(long ip) {
        init(ip, (short)32);
    }

    private void init(long ip, short bits) {
        if(ip < 0) {
            throw new IllegalArgumentException("CIDR(" + ip + ") cannot accept a negative IP");
        }
        if(ip > maxIP) {
            throw new IllegalArgumentException("CIDR(" + ip + ") cannot accept an IP > " + maxIP);
        }
        if(bits < 0) {
            throw new IllegalArgumentException("CIDR(" + ip + ") cannot accept a negative # of bits");
        }
        if(bits > maxBits) {
            throw new IllegalArgumentException("CIDR(" + ip + ") cannot accept a # of bits > " + maxBits);
        }

        this.baseIp = ip;
        this.bits = bits;
    }
    
    //这里注意到所谓ip就是ip地址，bits指的是cidr的网络号位数，默认32位

    @Override
    public String toString() {
        if(bits == 32) {
            return toIp(this.baseIp);
        } else {
            return toIp(this.baseIp & imask(this.bits)) + "/" + this.bits;  //这里涉及子网掩码
        }
    }

    private static int compare(long diff) {
        return (0 == diff) ? 0 : (diff > 0 ? 1 : -1);
    }

    @Override
    public int compareTo(Cidr cidr) {
        if(cidr == null) {
            return 1;
        }

        int ipComp = compare(this.getFirstIp() - cidr.getFirstIp());

        return (0 != ipComp) ? ipComp : compare((long)cidr.bits - (long)this.bits);
    }

    @Override
    public boolean equals(Object other) {
        if(other != null && other instanceof Cidr) {
            return (this.getFirstIp() == ((Cidr)other).getFirstIp()) && (this.bits == ((Cidr)other).bits);
        } else {
            return false;
        }
    }//该函数用于比较

    @Override
    public int hashCode() {
        return (int)this.getFirstIp();
    }

    // == Utility Functions

    private static int imask(int leftBitsToSet) {
        if(leftBitsToSet < 1 || leftBitsToSet > 32) {
            throw new IllegalArgumentException("Cidr.imask(" + leftBitsToSet + ")? Arg must be in [1:32]");
        }
        return (int)(0x0100000000L - (1L << (32 - leftBitsToSet)));
    }
    private static short maxBlock(long ip) {
        if(ip != 0) {
            short result = 32;
            for(int mask = imask(31); (ip & mask) == ip; mask <<= 1) {
                result --;
            }
            return result;
        } else {
            return 0;
        }
    }

    public static List<Cidr> toCidrs(String start, String end) {
        return toCidrs(toIp(start), toIp(end));
    }
    public static List<Cidr> toCidrs(long firstIp, long lastIp) {
        final String prefix = "Cidr.toCidrs(" + toIp(firstIp) + ", " + toIp(lastIp) + ") ";
        List<Cidr> result = new ArrayList<>();

        while(lastIp > firstIp) {
            short maxSize = maxBlock(firstIp);
            short x = (short)log2(lastIp - firstIp + 1);
            short maxDiff = (short)(32 - x);
            maxSize = (short)Math.max(maxSize, maxDiff);

            result.add(new Cidr(firstIp, maxSize));
            firstIp += (1L << (32 - maxSize));
        }
        if(lastIp == firstIp) {
            result.add(new Cidr(firstIp, (short)32));
        }
        return result;
    }

    public long getFirstIp() {
        return this.baseIp & (0xFFFFFFFFL << (32 - this.bits));
    }
    public String getFirstIpString() {
        return Cidr.toIp(this.getFirstIp());
    }
    public long getLastIp() {
        return this.baseIp | (0xFFFFFFFFL >>> this.bits);
    }
    public String getLastIpString() {
        return Cidr.toIp(this.getLastIp());
    }
    public boolean contains(long ip) {
        return contains(new Cidr(ip));
    }
    public boolean contains(String ipOrCidr) {
        return contains(new Cidr(ipOrCidr));
    }
    public boolean contains(Cidr cidr) {
        // For our purposes, a Cidr contains itself.
        return (this.getFirstIp() <= cidr.getFirstIp()) && (this.getLastIp() >= cidr.getLastIp());
    }
    public boolean overlaps(Cidr cidr) {
        return !((this.getFirstIp() > cidr.getLastIp()) || (this.getLastIp() < cidr.getFirstIp()));
    }
}
