package gson;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/3/30
 * Description:
 */
public class GsonCreateSample {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("王小二");
        student.setAge(25);
        student.setBirthday("1994-01-01");
        student.setCreateTime(new Date());
        student.setCollege("蓝翔");
        student.setMajor(new ArrayList<String>(){{add("理发");add("挖掘机");}});
        student.setHasGirlFirend(false);
        student.setCar(null);
        student.setHouse(null);
        student.setComment("王小二的信息");
        student.setIgnore("ignore");
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
            public String translateName(Field field) {
                if(field.getName().equals("name")) {
                    return "NAME";
                }
                return field.getName();
            }
        });
        Gson gson = gsonBuilder.create();
        System.out.println(gson.toJson(student));
    }
}
