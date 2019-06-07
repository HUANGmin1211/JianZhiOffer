package nowcoder;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianDataStream {

    PriorityQueue<Integer> maxQ = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    PriorityQueue<Integer> minQ = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });

    public void Insert(Integer num) {
        if (maxQ.size() == 0 && minQ.size() == 0) {
            maxQ.add(num);
        } else if (maxQ.size() == minQ.size()) {
            if (num > minQ.peek()) {
                maxQ.add(minQ.poll());
                minQ.add(num);
            } else {
                maxQ.add(num);
            }
        } else {
            if (num > maxQ.peek()) {
                minQ.add(num);
            } else {
                minQ.add(maxQ.poll());
                maxQ.add(num);
            }
        }
    }

    public Double GetMedian() {
        if (maxQ.size() == minQ.size())
            return (maxQ.peek() + minQ.peek()) / 2.0;
        else
            return maxQ.peek() * 1.0;
    }

    @Test
    public void test() {
        Insert(5);
        System.out.println(GetMedian());
        Insert(2);
        System.out.println(GetMedian());
        Insert(3);
        System.out.println(GetMedian());
        Insert(4);
        System.out.println(GetMedian());
        Insert(1);
        System.out.println(GetMedian());
        Insert(6);
        System.out.println(GetMedian());
        Insert(7);
        System.out.println(GetMedian());
        Insert(0);
        System.out.println(GetMedian());
    }
}
