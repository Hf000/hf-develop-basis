package com.hufei.cp.utils;

import com.hufei.cp.constants.CpConstant;
import org.apache.commons.lang3.StringUtils;

/**
 * <p> el表达式工具类 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/10 8:31
 */
public class ElUtil {

    /**
     * 判断是否是el表达式
     * @param param 入参
     * @return 返回
     */
    public static boolean judgmentEl(String param) {
        if (StringUtils.isNotBlank(param)) {
            return StringUtils.startsWith(param, CpConstant.DOLLAR_SIGN_BEFORE_BIG_PARANTHESES) && StringUtils.endsWith(param, CpConstant.AFTER_BIG_PARANTHESES);
        }
        return false;
    }

    /**
     * 替换El表达式符号
     * @param param 入参
     * @return 返回
     */
    public static String replaceEl(String param) {
        if (StringUtils.isNotBlank(param)) {
            if (StringUtils.contains(param, CpConstant.DOLLAR_SIGN) ) {
                param = StringUtils.replace(param, CpConstant.DOLLAR_SIGN, "");
            }
            if (StringUtils.contains(param, CpConstant.BEFORE_BIG_PARANTHESES) ) {
                param = StringUtils.replace(param, CpConstant.BEFORE_BIG_PARANTHESES, "");
            }
            if (StringUtils.contains(param, CpConstant.AFTER_BIG_PARANTHESES)) {
                param = StringUtils.replace(param, CpConstant.AFTER_BIG_PARANTHESES, "");
            }
        }
        return param;
    }

}
