package com.naive.tutorial.problem;

import com.jcraft.jsch.JSch;

import java.util.regex.Pattern;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/6/10
 * Description:
 */
public class StatLog {

    public static void main(String[] args) {
        String pattern = "work@.*:~/local/tomcat_js/logs/jump\\$";
        String str = "work@ad-js-online:~/local/tomcat_js/logs/jump$";
        if(Pattern.compile(pattern).matcher(str).matches()) {
            System.out.println("hahha");
        }
    }

}
