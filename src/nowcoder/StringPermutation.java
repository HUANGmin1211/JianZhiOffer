package nowcoder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
 * */
public class StringPermutation{

    public ArrayList<String> Permutation(String str) {

        ArrayList<String> list = new ArrayList<>();

        if (str == null)
            return list;

        char [] arr = str.toCharArray();
        press(arr, 0, list);

        Collections.sort(list);
        return list;
    }

    private void press(char[] arr, int i, ArrayList<String> list) {
        if (i == arr.length-1){
            StringBuilder sb = new StringBuilder();

            for (char c : arr)
                sb.append(c);

            list.add(sb.toString());
        }

        for (int index = i; index < arr.length; index++){
            char [] newArr = new char[arr.length];

            for (int j = 0; j < arr.length; j++){
                newArr[j] = arr[j];
            }

            swap(newArr,index,i);

            press(newArr, i+1, list);
        }


    }

    private void swap(char[] newArr, int index, int i) {
        char c = newArr[index];
        newArr[index] = newArr[i];
        newArr[i] = c;
    }

    @Test
    public void test(){
        String s = "aab";
        ArrayList<String> list = Permutation(s);
        for (String str : list)
            System.out.println(str);
    }


}

