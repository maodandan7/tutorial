import java.util.*;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/8/10
 * Description:矩阵中的路径
 */
public class Question10 {
    class Solution {
        public boolean exist(char[][] board, String word) {
            Map<String, List<String>> charLocationMap = new HashMap<>();
            Map<String, String> locationCharMap = new HashMap<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    List<String> locations = charLocationMap.getOrDefault(String.valueOf(board[i][j]), new ArrayList<>());
                    locations.add(i + "," + j);
                    charLocationMap.put(String.valueOf(board[i][j]), locations);
                    locationCharMap.put(i + "," + j, String.valueOf(board[i][j]));
                }
            }
            for (int i = 0; i < word.length(); i++) {
                String c = String.valueOf(word.charAt(i));
                List<String> locations = charLocationMap.get(c);
                for (String location : locations) {
                    int x = Integer.parseInt(location.split(",")[0]);
                    int y = Integer.parseInt(location.split(",")[1]);
                    String locationUp = x + "," + (y - 1);
                    String locationDown = x + "," + (y + 1);
                    String locationLeft = (x - 1) + "," + y;
                    String locationRight = (x + 1) + "," + y;
                    String charUp = locationCharMap.getOrDefault(locationUp, "");
                    String charDown = locationCharMap.getOrDefault(locationDown, "");
                    String charLeft = locationCharMap.getOrDefault(locationLeft, "");
                    String charRight = locationCharMap.getOrDefault(locationRight, "");
                }
            }
            return false;
        }
    }
}
