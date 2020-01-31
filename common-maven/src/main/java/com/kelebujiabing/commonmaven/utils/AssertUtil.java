package com.kelebujiabing.commonmaven.utils;

import com.kelebujiabing.commonmaven.exception.DisplayableException;
import org.springframework.util.StringUtils;

//断言工具
public class AssertUtil {

    /**
     * 判断空
     * @param object
     * @param message
     */
    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new DisplayableException(message);
        }
        if(object instanceof  String){
            if(!StringUtils.hasLength((String)object)){
                throw new DisplayableException(message);
            }
        }
    }

    /**
     * 如果是true直接抛出异常
     * @param isTrue
     * @param message
     */
    public static void isTrue(boolean isTrue,String message ){
        if(isTrue){
            throw new DisplayableException(message);
        }
    }

    /**
     * 如果是0直接抛出异常
     * @param isTrue
     * @param message
     */
    public static void isZero(boolean isTrue,String message ){
        if(isTrue){
            throw new DisplayableException(message);
        }
    }


}
