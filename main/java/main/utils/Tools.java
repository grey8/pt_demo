package main.utils;

import java.io.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.SimpleTimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by magenta9 on 2017/2/13.
 */
public class Tools {

    public static int getRandomNum() {
        Random r = new Random();
        return r.nextInt(900000) + 100000;
    }

    public static boolean notEmpty(String s) {
        return s!= null && !"".equals(s) && !"null".equals(s);
    }

    public static boolean isEmpty(String s) {
        return s==null || "".equals(s) || "null".equals(s);
    }

    public static String[] str2StrArray(String str, String splitRegex) {
        if(isEmpty(str)) {
            return null;
        }
        return str.split(splitRegex);
    }

    public static String[] str2StrArray(String str) {
        return str2StrArray(str, "\\s*");
    }

    public static String date2Str(Date date) {
        return date2Str(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String date2Str(Date date, String format) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }
        return null;
    }

    public static Date str2Date(String date) {
        if(notEmpty(date)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Date();
        }
        return null;
    }

    public static String getTimes(String strDate) {
        String resultTimes = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now;

        try {
            now = new Date();
            Date date = sdf.parse(strDate);
            long times = now.getTime() - date.getTime();
            long day = times / (24*60*60*1000);
            long hour = times / (60*60*1000) - day * 24;
            long minute = times / (60 * 1000) - day * 24 * 60 - hour * 60;
            long second = times / 1000 - day * 24 * 60 * 60 - hour * 3600 - minute * 60;

            StringBuffer strBuf = new StringBuffer();
            if(hour > 0) {
                strBuf.append(hour + "小时前");
            } else if(minute > 0) {
                strBuf.append(minute + "分钟前");
            } else if(second > 0) {
                strBuf.append(second + "秒前");
            }

            resultTimes = strBuf.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultTimes;
    }

    public static void writeFile(String fileP, String content) {
        String filePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource("")) + "../../";
        filePath = (filePath.trim() + fileP.trim()).substring(6).trim();
        if(filePath.indexOf(":") != 1) {
            filePath = File.separator + filePath;
        }
        try {
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(filePath), "utf-8");
            BufferedWriter writer = new BufferedWriter(write);
            writer.write(content);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static boolean checkMobileNumber(String mobileNumber) {
        boolean flag = false;
        try {
            String check = "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(mobileNumber);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static String readTxtFile(String fileP) {
        try {
            String filePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))+"../../";
            filePath = filePath.replaceAll("file:", "");
            filePath = filePath.replaceAll("%20", " ");
            filePath = filePath.trim() + fileP.trim();
            if(filePath.indexOf(":") != 1) {
                filePath = File.separator + filePath;
            }
            String encoding = "utf-8";
            File file = new File(filePath);
            if(file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    return lineTxt;
                }
                read.close();
            } else {
                System.out.println("cannot find the file,查看文件路径：" + filePath);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
