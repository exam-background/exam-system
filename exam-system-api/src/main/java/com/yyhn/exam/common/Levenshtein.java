package com.yyhn.exam.common;

public class Levenshtein {
    private static int compare(String str, String target)
    {
        int d[][];              // 矩阵
        int n = str.length();
        int m = target.length();
        int i;                  // 遍历str的
        int j;                  // 遍历target的
        char ch1;               // str的
        char ch2;               // target的
        int temp;               // 记录相同字符,在某个矩阵位置值的增量,不是0就是1
        if (n == 0) { return m; }
        if (m == 0) { return n; }
        d = new int[n + 1][m + 1];
        for (i = 0; i <= n; i++)
        {                       // 初始化第一列
            d[i][0] = i;
        }

        for (j = 0; j <= m; j++)
        {                       // 初始化第一行
            d[0][j] = j;
        }

        for (i = 1; i <= n; i++)
        {                       // 遍历str
            ch1 = str.charAt(i - 1);
            // 去匹配target
            for (j = 1; j <= m; j++)
            {
                ch2 = target.charAt(j - 1);
                if (ch1 == ch2 || ch1 == ch2+32 || ch1+32 == ch2)
                {
                    temp = 0;
                } else
                {
                    temp = 1;
                }
                // 左边+1,上边+1, 左上角+temp取最小
                d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + temp);
            }
        }
        return d[n][m];
    }

    private static int min(int one, int two, int three)
    {
        return (one = one < two ? one : two) < three ? one : three;
    }

    /**
     * 获取两字符串的相似度
     */

    public static float getSimilarityRatio(String str, String target)
    {
        return 1 - (float) compare(str, target) / Math.max(str.length(), target.length());
    }

//    public static void main(String[] args)
//    {
//        Levenshtein lt = new Levenshtein();
//        String str0 = "SSM指的是Spring，SpringMVC，Mybatis组成";
//        String target0 = "SSM是Spring，SpringMVC";
//        System.out.println("similarityRatio_0=" + lt.getSimilarityRatio(str0, target0));
//
//        String str = "SSM指的是Spring，SpringMVC，Mybatis组成";
//        String target = "SSM指的是Spring，SpringMVC组成";
//        System.out.println("similarityRatio=" + lt.getSimilarityRatio(str, target));
//
//        String str1 = "SSM指的是Spring，SpringMVC，Mybatis组成";
//        String target1 = "SSM指的是Spring组成";
//        System.out.println("similarityRatio_1=" + lt.getSimilarityRatio(str1, target1));
//
//        String str2 = "SSM指的是Spring，SpringMVC，Mybatis组成";
//        String target2 = "SSM指的是SpringBoot";
//        System.out.println("similarityRatio_2=" + lt.getSimilarityRatio(str2, target2));
//    }
}
