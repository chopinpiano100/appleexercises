package com.appleinterview.exercises;

/**
 * Created by jinlingkwang on 8/28/16.
 */
public class StringProblem {
    public String replaceString(String str, String replacement) {
        if (str == null || str.equals("")) return null;
        str.replaceAll(str, "");
        return str;
    }
}
