package com.tencentocr.tencent.util;

/**
 * Create by jiuyv on 2020/5/20
 */
public class StringUtils extends org.springframework.util.StringUtils {


    /**
     * 功能描述: <br>
     * 〈首字母变为大写〉
     * @Param: [word]
     * @Return: java.lang.String
     * @Author: songxinzhang
     * @Date: 2020/5/20 14:48
     */
    public static String upFistWord(String word){
        if(!StringUtils.isEmpty(word)){
            char[] words = word.toCharArray();
            words[0]=Character.toUpperCase(words[0]);
            return words.toString();
        }else{
            return word;
        }

    }

}
