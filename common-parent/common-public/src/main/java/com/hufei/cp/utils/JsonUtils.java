package com.hufei.cp.utils;


import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * <p> json工具类 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/9 12:23
 */
@Slf4j
public class JsonUtils {

    /**
     * 将json字符串转换成Map集合,  现在可以通过fastjson替换，方法：JSON.parseObject(jsonStr,Map.class);
     * @param jsonStr json字符串
     * @return 返回map
     */
    public static Map<String, Object> jsonStrToMap(String jsonStr) {
        Map<String, Object> map = null;
        try {
            if (StringUtils.isNoneBlank(jsonStr)) {
                JSONObject jsonObject = JSONObject.fromObject(jsonStr);
                if (jsonObject != null) {
                    map = new HashMap<>(jsonObject.size());
                    for (Iterator<?> iter = jsonObject.keys(); iter.hasNext();) {
                        String key = (String) iter.next();
                        String value = jsonObject.get(key).toString();
                        map.put(key, value);
                    }
                }
            }
        } catch (Exception e) {
            log.error("json转换Map异常", e);
        }
        return map;
    }

    /**
     * 将json字符串转换成List<Map<K, V>>集合necessary
     * @param jsonStr json字符串
     * @return 返回list
     */
    public static List<Map<String, Object>> jsonStrToList(String jsonStr) {
        List<Map<String, Object>> rsList = null;
        try {
            if (StringUtils.isNoneBlank(jsonStr)) {
                JSONArray jsonArray = JSONArray.fromObject(jsonStr);
                if (jsonArray != null) {
                    rsList = new ArrayList<>();
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Map<String, Object> map = new HashMap<>(jsonObject.size());
                        for (Iterator<?> iter = jsonObject.keys(); iter.hasNext();) {
                            String key = (String) iter.next();
                            String value = jsonObject.get(key).toString();
                            map.put(key, value);
                        }
                        rsList.add(map);
                    }
                }
            }
        } catch (Exception e) {
            log.error("json转换Map异常", e);
        }
        return rsList;
    }

}
