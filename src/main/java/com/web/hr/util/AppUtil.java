package com.web.hr.util;

import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * Application common class
 */
public class AppUtil
{
    /**
     *
     * @param messageSource
     * @param key message key
     * @param param replace words
     * @return message
     */
    public static String getMessage(MessageSource messageSource,String key,Object... param){

        return messageSource.getMessage(key,param, Locale.ENGLISH);
    }
}
