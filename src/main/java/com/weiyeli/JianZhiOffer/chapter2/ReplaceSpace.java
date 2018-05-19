package com.weiyeli.JianZhiOffer.chapter2;

/**
 * 替换空格
 */
public class ReplaceSpace {
    //String自带类方法
    public String replaceSpace(StringBuffer str) {
        return String.valueOf(str).replaceAll(" ", "%20");
    }
}
