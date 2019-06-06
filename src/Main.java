import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class Main {

    LinkedList<Character> list = new LinkedList<>();
    LinkedList<Character> setOnce = new LinkedList<>();
    LinkedList<Character> setMore = new LinkedList<>();

    public void Insert(char ch) {
        list.add(ch);
        if (!setMore.contains(ch) && !setOnce.contains(ch))
            setOnce.add(ch);
        else if (!setMore.contains(ch) && setOnce.contains(ch)) {
            int index = setOnce.indexOf(ch);
            setOnce.remove(index);
            setMore.add(ch);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (setOnce.size() != 0)
            return setOnce.get(0);
        else
            return '#';
    }

    @Test
    public void test() {
        Insert('g');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('g');
        System.out.println(FirstAppearingOnce());
        Insert('l');
        System.out.println(FirstAppearingOnce());
        Insert('e');
        System.out.println(FirstAppearingOnce());
    }



}