package com.naive.tutorial;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/12/4
 * Description:
 */
public class ZeroOnePack {

    private Integer number;

    private Integer capacity;

    private Integer weight[];

    private Integer value[];

    private Integer v[][];

    private Integer path[][];

    public ZeroOnePack(Integer number, Integer capacity, Integer[] weight, Integer[] value) {
        this.number = number;
        this.capacity = capacity;
        this.weight = weight;
        this.value = value;
        this.v = new Integer[number + 1][capacity + 1];
        this.path = new Integer[number + 1][capacity + 1];
    }

    public void handle() {
        for (int i = 0; i <= number; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i <= capacity; i++) {
            v[0][i] = 0;
        }
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weight[i] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    int currentValue = value[i] + v[i - 1][j - weight[i]];
                    int originMaxValue = v[i - 1][j];
                    if (currentValue > originMaxValue) {
                        v[i][j] = currentValue;
                        path[i][j] = 1;
                    } else {
                        v[i][j] = originMaxValue;
                    }
                }
            }
        }
        int j = capacity;
        int i = number;
        while (i > 0) {
            if (path[i][j] != null) {
                System.out.println("第" + i + "件物品加进去了");
                j = capacity - weight[i];
            }
            i--;
        }
        System.out.println("总价值为:" + v[number][capacity]);
    }

    public static void main(String[] args) {
        int number = 3;
        int capacity = 4;
        Integer[] value = new Integer[]{0, 1500, 3000, 2000};
        Integer[] weight = new Integer[]{0, 1, 4, 3};
        ZeroOnePack zeroOnePack = new ZeroOnePack(number, capacity, weight, value);
        zeroOnePack.handle();
    }

}
