package main.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by magenta9 on 2017/2/13.
 */
public class PathUtil {
    public static String getPicturePath(String pathType, String pathCategory) {
        String strResult = "";
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        StringBuffer strBuf = new StringBuffer();
        if("visit".equals(pathType)) {

        } else if ("save".equals(pathType)) {
            String projectPath = PublicUtil.getProjectPath().replace("\\\\", "/");
            projectPath = splitString(projectPath, "bin/");
            strBuf.append(projectPath);
            strBuf.append("webapp/ROOT");
        }

        strResult = strBuf.toString();
        return strResult;
    }

    private static String splitString(String str, String param) {
        String result = str;
        if(str.contains(param)) {
            int start = str.indexOf(param);
            result = str.substring(0, start);
        }
        return result;
    }
}
