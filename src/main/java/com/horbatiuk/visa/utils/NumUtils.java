package com.horbatiuk.visa.utils;

/**
 * Created by Andrey on 27.08.2016.
 */
public class NumUtils {

    public static boolean isLong(Long num){
        try{
            Long.parseLong((""+num));
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isInt(int num){
        try{
            Integer.parseInt((""+num));
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
