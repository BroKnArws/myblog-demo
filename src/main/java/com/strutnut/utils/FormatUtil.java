package com.strutnut.utils;


/**
 * 用于格式规划的工具类
 *
 * @author Strutnut
 */
public class FormatUtil {

    /**
     * @param words 需要被检验是否为空的词
     * @return 是否存在空
     */
    public static boolean hasStringNull(String... words) {
        for (String word : words) {
            if (word == null) {
                return true;
            }
        }
        return false;
    }
}
