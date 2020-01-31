package com.kelebujiabing.commonmaven.exception;

/**
 * 自定义异常:用来封装哪些可显示给用户看的异常信息:比如说  :用户名不可为空
 */
public class DisplayableException extends RuntimeException {

    public DisplayableException(String errorMsg){
        super(errorMsg);
    }


}
