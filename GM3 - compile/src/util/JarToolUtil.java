package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JarToolUtil {

    public static String getJarPath()
    {
        File file = getFile();
        if (file == null)
            return null;
        return file.getAbsolutePath();
    }

    public static String getJarDir()
    {
        File file = getFile();
        if (file == null)
            return null;
        return getFile().getParent();
    }

    public static String getJarName()
    {
        File file = getFile();
        if (file == null)
            return null;
        return getFile().getName();
    }

    private static File getFile()
    {

        String path = JarToolUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        try
        {
            path = java.net.URLDecoder.decode(path, "UTF-8");
        }
        catch (java.io.UnsupportedEncodingException e)
        {
            return null;
        }
        return new File(path);
    }

    public static List<String> getFile(String path) {
        File file = new File(path);
        File[] fileList = file.listFiles();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isFile()) {
                String fileName = fileList[i].getName();
                list.add(fileName);
            }
        }
        return list;
    }
    public String getPath()
    {
        String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        if(System.getProperty("os.name").contains("dows"))
        {
            path = path.substring(1,path.length());
        }
        if(path.contains("jar"))
        {
            path = path.substring(0,path.lastIndexOf("."));
            return path.substring(0,path.lastIndexOf("/"));
        }
        return path.replace("target/classes/", "");
    }

}
