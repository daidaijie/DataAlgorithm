package com.weiyeli.Nowcoder.Wangyi.Qiuzhao_2018;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 游历魔法王国
 */
public class MagicCity {

    static int x = 0;

    static class City {
        int step;
        City pre;
        ArrayList<City> list = new ArrayList();
    }

    //递归求解每个结点的深度
    private static void getstep(City city) {
        for (int i = 0; i < city.list.size(); i++) {
            city.list.get(i).step = city.step + 1;
            getstep(city.list.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int L = in.nextInt();
        City[] cities = new City[n];                                //从0开始到n均为城市
        for (int i = 1; i < n; i++)                                 //计数从1开始
        {
            int tmp = in.nextInt();                                 //i城市的上一个城市为tmp，tmp下属城市包含i
            if (cities[i] == null) cities[i] = new City();
            if (cities[tmp] == null) cities[tmp] = new City();
            cities[i].pre = cities[tmp];
            cities[tmp].list.add(cities[i]);
        }
        getstep(cities[0]);                                        //将每个结点的step标记。
        int max = 0;                                               //记录最长的那条链表
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].step > max) max = cities[i].step;
        }
        if (max >= L) {                                            //判断L是否能走到最常的链表处
            System.out.println(L + 1);
            return;
        }

        //如果走完max长度后，还有剩余的步数。
        int rest = (L - max) / 2;                                  //最多还能走的步数（包括返回）
        //可以很容易的证明，剩下未走过的城市，每多游玩一个城市，就需要花费两步。
        int x = n - max - 1;                                       //剩下未走过的城市个数
        if (rest >= x)
            System.out.println(n);
        else {
            System.out.println(max + 1 + rest);
        }
    }
}