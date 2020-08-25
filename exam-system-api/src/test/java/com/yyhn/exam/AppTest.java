package com.yyhn.exam;

import static org.junit.Assert.assertTrue;

import com.yyhn.exam.common.RandomMaxMin;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        List list = new ArrayList();
        for(int i=0;i<=10;i++){
            int a = RandomMaxMin.getRandomMaxMin(4, 0, list);
            list.add(a);
            System.out.println(a);
        }
    }
}
