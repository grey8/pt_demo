package main.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by magenta9 on 2017/2/13.
 */
public class PublicUtil {
    public static String getProjectPath() {
        String nowPath = "";
        nowPath = System.getProperty("user.dir") + "/";
        return nowPath;
    }

    public static String getIp() {
        String ip = "";
        try {
            InetAddress inet = InetAddress.getLocalHost();
            ip = inet.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }

    public static boolean isJsonRequest(HttpServletRequest request) {
        return true;
    }
}
