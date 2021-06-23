package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/3/30
 * Description:
 */
public class GsonReadSample {
    public static void main(String[] args) {
        String content = "{\n" +
                "  \"NAME\": \"王小二\",\n" +
                "  \"age\": 25,\n" +
                "  \"birthday\": \"1994-01-01\",\n" +
                "  \"college\": \"蓝翔\",\n" +
                "  \"major\": [\n" +
                "    \"理发\",\n" +
                "    \"挖掘机\"\n" +
                "  ],\n" +
                "  \"hasGirlFirend\": false,\n" +
                "  \"comment\": \"王小二的信息\",\n" +
                "  \"createTime\": \"1994-01-01\"\n" +
                "}";
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Student student = gson.fromJson(content, Student.class);
        System.out.println(student);
        System.out.println(student.getMajor());
        System.out.println(student.getMajor().getClass());
    }
}
