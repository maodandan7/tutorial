/**
 * User zhongmeng-lizhaohong
 * Date 2020/7/2
 * Description:
 */
public class Question3 {
    public String replaceSpace(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
