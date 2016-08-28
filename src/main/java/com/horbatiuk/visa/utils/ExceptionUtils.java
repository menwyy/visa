package com.horbatiuk.visa.utils;

/**
 * Created by Andrey on 25.08.2016.
 */
public class ExceptionUtils {

    //String exceptions

    public static void checkStringWithExceptions(String s) throws NullPointerException, IllegalArgumentException{
        checkStringOnNull(s);
        checkStringOnEmpty(s);
    }

    public static void checkStringOnNull(String s) throws NullPointerException {
        if (!StringUtils.isNotNull(s)) {
            throw new NullPointerException("The value of string parameter is null. Change it!");
        }

    }

    public static void checkStringOnEmpty(String s) throws IllegalArgumentException {
        if (!StringUtils.isNotEmpty(s)) {
            throw new IllegalArgumentException("Your string parameter is empty. The value is ''");
        }
    }

    public static void checkStringIsEmail(String s) throws IllegalArgumentException{
        if(!StringUtils.isEmail(s)){
            throw new IllegalArgumentException("Your string is not an email!");
        }
    }

    //Object exceptions

    public static void checkObjectOnNull (Object object){
        if (!ObjectUtils.isNotNull(object)){
            throw new NullPointerException("The link on object is null");
        }
    }

    //Numbers exceptions

    public static void checkLongIsLong(Long num){
        if(!NumUtils.isLong(num)){
            throw new IllegalArgumentException("Value is not Long type.");
        }
    }

    public static void checkIntIsInt(int num){
        if(!NumUtils.isInt(num)){
            throw new IllegalArgumentException("Value is not int type.");
        }
    }
}
