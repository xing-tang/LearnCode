package com.open.library.util.ext;


import com.open.library.util.code.StringUtils;

/**
 * ParsesUtils
 *
 * @Description : 用来解析的工具类
 */
public class ParsesUtils {

    /**
     * 把字符串解析成 int, 若传入字符串为空或转换时异常则返回0
     *
     * @param str String
     * @return int
     */
    public static int parseInt(String str) {
        return parseInt(str, 0);
    }

    /**
     * 把字符串解析成 int, 若传入字符串为空或转换时异常则返回默认值
     *
     * @param str        String
     * @param defaultInt int
     * @return int
     */
    public static int parseInt(String str, int defaultInt) {
        int num = defaultInt;
        if (!StringUtils.isEmpty(str)) {
            try {
                num = Integer.parseInt(str.trim());
            } catch (NumberFormatException nfe) {
            } catch (Exception e) {
            }
        }
        return num;
    }

    /**
     * 把 long 解析成 int
     *
     * @param val long
     * @return int
     */
    public static int parseInt(long val) {
        return (Long.valueOf(val)).intValue();
    }

    /**
     * 把 float 解析成 int
     *
     * @param val float
     * @return int
     */
    public static int parseInt(float val) {
        return (Float.valueOf(val)).intValue();
    }

    /**
     * 把 double 解析成 int
     *
     * @param val double
     * @return int
     */
    public static int parseInt(double val) {
        return (Double.valueOf(val)).intValue();
    }
}
