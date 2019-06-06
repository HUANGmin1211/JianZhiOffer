package nowcoder;

import org.junit.Test;

/**
 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 '.' 匹配任意单个字符;'*' 匹配零个或多个前面的元素。
 s 可能为空，且只包含从 a-z 的小写字母;p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。

 s = ""
 p = "。"
 输出: false

 s = ""
 p = ".*"
 输出: true
 */
public class Regex {
    public static boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        return press(s, 0, p, 0);
    }

    private static boolean press(String s, int i, String p, int j) {

        if (i == s.length() && j == p.length())
            return true;

        if (i < s.length() && j == p.length())
            return false;

        // 下面全是j没到底的情况
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            if (i < s.length() && (s.charAt(i) == p.charAt(j) || (p.charAt(j) == '.'))) { // i没到底
                return press(s, i, p, j + 2)  // 一个都没匹配到
                        || press(s, i + 1, p, j + 2) // 只匹配到了一个
                        || press(s, i + 1, p, j);  // 至少匹配到了一个
            } else {
                return press(s, i, p, j + 2); // i到底了j没到底，或者i没到底只是p的*匹配的是0个字符
            }
        }

        if (i < s.length() && (s.charAt(i) == p.charAt(j) || (p.charAt(j) == '.'))) { // 只有i < s.length()，才能进行i+1传递
            return press(s, i + 1, p, j + 1);
        }

        return false;  // i到底了但是j的下一位不是*
    }
}