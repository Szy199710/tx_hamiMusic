package cn.tx.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件文件的工具类
 */
public class PropUtil {


    public static String read(String key){
        Properties properties=new Properties();
        InputStream inputStream = PropUtil.class.getClassLoader().getResourceAsStream("sys.properties");
        String value=null;
        try {
            properties.load(inputStream);
            value=properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
