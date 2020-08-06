package com.yyhn.exam.common;

import java.util.List;
import java.util.Random;

public class RandomMaxMin {
    /**
     * 根据传入的最大值，最小值生成一个在list集合中不存在的数字
     * @param max
     * @param min
     * @param idList
     * @return
     */
    public static Integer getRandomMaxMin(Integer max, Integer min, List<Integer> idList){
        Random random = new  Random();
        int result = random.nextInt(max) % (max-min+1) + min;
        for(Integer id : idList){
            if(result == id){
                result = random.nextInt(max) % (max-id+1) + id;
            }
        }
        return result;
    }
}
