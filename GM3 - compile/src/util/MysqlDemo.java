package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import static org.stringtemplate.v4.compiler.STLexer.str;

public class MysqlDemo {
    private Connection conn;
    private Statement st;
    public static String tab;

    public MysqlDemo() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://39.100.88.210/grass", "mulval", "mulval");
//        this.conn = DriverManager.getConnection("jdbc:mysql://localhost/GRASS?useSSL=FALSE&serverTimezone=UTC", "root", "");
        this.st = conn.createStatement();
    }

    public void exec(String cmd) throws SQLException, ClassNotFoundException {
        this.st.execute(cmd);
    }
    public String getname(String cmd) throws SQLException, ClassNotFoundException {
        ResultSet rs = this.st.executeQuery(cmd);
        if (rs.next()) {
            String aa = rs.getString("NICKNAME");
            return aa;
        }
        return null;
    }

    public void nickname() throws SQLException {
        String cmd;
        String name;
        String MAC;
        Statement sst = conn.createStatement();
        int i=1;
        ResultSet rs = this.st.executeQuery("select * from "+tab+"_device"+";");
        HashMap <String,String> ip_cast = new HashMap<>();
        while (rs.next()) {
            MAC = rs.getString("MAC");
            cmd = "update "+tab+"_device"+" set `NICKNAME`='station" + Integer.toString(i) + "'" + " where `MAC`='" + MAC + "';";
            sst.execute(cmd);
            i = i+1;
        }

    }

    public HashMap<String,ArrayList<String>> IP_NAME_OTHER() throws SQLException {
        String MAC;
        String IP;
        String NN;
        String OI;
        ArrayList<String> x = new ArrayList<>();
        HashMap<String, ArrayList<String>> ip_cast = new HashMap<>();
        ResultSet rs = this.st.executeQuery("select MAC,IP,NICKNAME,OTHERIP from "+tab+"_device"+";");
        while (rs.next()) {
            MAC = rs.getString("MAC");
            IP = rs.getString("IP");
            NN = rs.getString("NICKNAME");
            OI = rs.getString("OTHERIP");
            x.add(IP);
            x.add(NN);
            x.add(OI);
            ip_cast.put(MAC, new ArrayList<>(x));
            x.clear();
        }
        return ip_cast;
    }

    public void close() throws SQLException {
        this.st.close();
        this.conn.close();
    }
}

