package com.eagle.cloud.route.utils;

import java.util.Random;

/**
 * @Author:FWJ
 * @Date:2019-12-25
 * @Description:IntelliJ IDEA
 * @version:1.0
 */
public class randomByWeightUtil {

    /**
     * 根据权重获取序号
     *
     * @param weights
     * @return
     */
    public static int RandomByWeight(int[][] weights) {
        Random random = new Random();
        int weightSum = 0;
        for (int i = 0; i < weights.length; i++) {
            weightSum += weights[i][1]*1000;//注意这一步至关重要 10000是精度 这个值越大精度越高 这里取10的倍数 因为倍数不变
        }
        //总的权重中生成一个随机数
        int number_rand = random.nextInt(weightSum);
        int sum_temp = 0;
        //循环数组 判断生成的随机数是否小于等于当前权重是就返回序号 否则加上当前的权重继续循环
        for (int i = 0; i < weights.length; i++) {
            sum_temp += weights[i][1]*1000;
            if (number_rand <= sum_temp) {
                return weights[i][0];
            }
        }
        return -1;
    }
}
