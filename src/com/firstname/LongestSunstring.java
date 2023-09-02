package com.firstname;

import java.util.HashSet;
import java.util.Set;

class Sources {
    public int lengthOfLongestSubstring(String s, Set<Character> set) {
        int maxLength = 0;
        int i = 0;
        int j = 0;

        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                maxLength = Math.max(maxLength, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return maxLength;
    }
}

public class LongestSunstring {
    public static void main(String[] args) {
        Sources source = new Sources();
        String inputString = "abcabcbb";
        Set<Character> charSet = new HashSet<>();
        int result = source.lengthOfLongestSubstring(inputString, charSet);
        System.out.println(result);
    }
}