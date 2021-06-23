import java.util.HashSet;
import java.util.Set;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/6/23
 * Description:数组中重复的数字
 */
public class Question2 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer i : nums) {
            if(set.contains(i)) {
                return i;
            }
            set.add(i);
        }
        return -1;
    }
}
