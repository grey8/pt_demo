package main.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by magenta9 on 2017/2/13.
 */
public class ConfigUtil {
    static String conName = "baseConfig.properties";
    static {
        try {
            InputStream in = ConfigUtil.class.getClass().getClassLoader().getResourceAsStream(conName);
            Properties prop = new Properties();
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
