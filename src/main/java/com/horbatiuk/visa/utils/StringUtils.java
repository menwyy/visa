package com.horbatiuk.visa.utils;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Created by Andrey on 17.08.2016.
 */
public class StringUtils {

    public static boolean isNotNull(String s) {
        return s != null;
    }

    public static boolean isNotEmpty(String s) {
        return !s.isEmpty();
    }

    public static boolean isEmail(String s) throws NullPointerException, IllegalArgumentException{
        ExceptionUtils.checkStringOnNull(s);
        ExceptionUtils.checkStringOnEmpty(s);

        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(s);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

}
