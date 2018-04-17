package com.weiyeli.Nowcoder.Tencent;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 腾讯春招实习生笔试题3
 */
public class Main3 {

    static class Pair {
        int time;
        int level;

        public Pair(int time, int level) {
            this.time = time;
            this.level = level;
        }
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//
//        Pair[] machine = new Pair[n];
//        Pair[] task = new Pair[m];
//
//        for (int i = 0; i < n; i++) {
//            machine[i] = new Pair(in.nextInt(), in.nextInt());
//        }
//        for (int i = 0; i < m; i++) {
//            task[i] = new Pair(in.nextInt(), in.nextInt());
//        }
//        int[] cnt = new int[105];
//
        //sort
        Comparator<Pair> comparator = (a, b) -> {
            if (a.time == b.time) return b.level - a.level;
            else return b.time - a.time;
        };
//
//        Arrays.sort(machine, comparator);
//        Arrays.sort(task, comparator);
        Pair pair1 = new Pair(1,1);
        Pair pair2 = new Pair(1,2);
        Pair pair3 = new Pair(2,1);
        Pair pair4 = new Pair(2,2);
        Pair[] pairs = new Pair[4];
        pairs[0] = pair1;
        pairs[1] = pair2;
        pairs[2] = pair3;
        pairs[3] = pair4;
        Arrays.sort(pairs, comparator);
        for (int i = 0; i < 4; i++) {
            System.out.println(pairs[i].time + "---" + pairs[i].level);
        }
    }
}
