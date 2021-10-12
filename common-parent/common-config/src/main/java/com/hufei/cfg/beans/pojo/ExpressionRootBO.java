package com.hufei.cfg.beans.pojo;

import java.util.Arrays;

/**
 * <p>  </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/12 10:40
 */
public class ExpressionRootBO {

    private final Object object;
    private final Object[] objects;

    public ExpressionRootBO(Object object, Object[] objects) {
        this.object = object;
        this.objects = objects;
    }

    public Object getObject() {
        return object;
    }

    public Object[] getObjects() {
        return objects;
    }

    @Override
    public String toString() {
        return "ExpressionRootBO{" +
                "object=" + object +
                ", objects=" + Arrays.toString(objects) +
                '}';
    }
}
