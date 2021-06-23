package gson;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/3/30
 * Description:
 */
@Data
public class Student {
    private String name;
    private Integer age;
    private String birthday;
    private String college;
    private List<String> major;
    private boolean hasGirlFirend;
    private Object car;
    private Object house;
    private String comment;
    private Date createTime;

    private transient String ignore;
}
