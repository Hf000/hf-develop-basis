package com.hufei.cp.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> list集合工具类 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/9 12:23
 */
public class ListUtils {

    /**
     * 将Object对象转换成存储对应类型的List
     * @param obj   需要转换的对象
     * @param clazz 需要转换的类型
     * @param <T>   数据类型
     * @return 返回集合
     */
    public static <T> List<T> castList(Object obj, Class<T> clazz) {
        try {
            if (obj != null) {
                List<T> result = new ArrayList<T>();
                if(obj instanceof List<?>) {
                    for (Object o : (List<?>) obj) {
                        result.add(clazz.cast(o));
                    }
                    return result;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
