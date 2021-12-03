package com.stepyen.demo.base.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * date：2020-03-30
 * author：stepyen
 * description：集合工具类
 */
public class CollectionUtil {


    public static boolean isEmpty(Collection collection) {
        if (null == collection || collection.isEmpty()) {
            return true;
        }

        return false;
    }

    public static boolean isNoEmpty(Collection collection) {
        if (null != collection && !collection.isEmpty()) {
            return true;
        }

        return false;
    }

    private static final Integer INTEGER_ONE = 1;

    @SuppressWarnings("rawtypes")
    public static boolean isEqualCollection(Collection a, Collection b) {
        // size是最简单的相等条件
        if (a == null || b == null) {
            return false;
        }
        if (a.size() != b.size()) {
            return false;
        }
        Map mapa = getCardinalityMap(a);
        Map mapb = getCardinalityMap(b);

        // 转换map后，能去掉重复的，这时候size就是非重复项，也是先决条件
        if (mapa.size() != mapb.size()) {
            return false;
        }
        Iterator it = mapa.keySet().iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            // 查询同一个obj，首先两边都要有，而且还要校验重复个数，就是map.value
            if (getFreq(obj, mapa) != getFreq(obj, mapb)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 以obj为key，可以防止重复，如果重复就value++
     * 这样实际上记录了元素以及出现的次数
     */
    public static Map getCardinalityMap(Collection coll) {
        Map count = new HashMap();
        for (Iterator it = coll.iterator(); it.hasNext(); ) {
            Object obj = it.next();
            Integer c = (Integer) count.get(obj);
            if (c == null) {
                count.put(obj, INTEGER_ONE);
            } else {
                count.put(obj, new Integer(c.intValue() + 1));
            }
        }
        return count;
    }

    private static final int getFreq(Object obj, Map freqMap) {
        Integer count = (Integer) freqMap.get(obj);
        if (count != null) {
            return count.intValue();
        }
        return 0;
    }

    /**
     * 检查下标边界
     *
     * @param collection
     * @param index
     * @return
     */
    public static boolean checkIndex(Collection collection, int index) {
        if (null == collection || collection.isEmpty()) {
            return false;
        }

        if (-1 < index && index < collection.size()) {
            return true;
        }

        return false;

    }
}
