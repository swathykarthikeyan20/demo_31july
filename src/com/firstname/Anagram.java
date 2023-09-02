package com.firstname;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Sourcet {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        // Count the occurrences of characters in string p
        Map<Character, Integer> charCountP = new HashMap<>();
        for (char c : p.toCharArray()) {
            charCountP.put(c, charCountP.getOrDefault(c, 0) + 1);
        }

        int count = 0; // Counter for the number of different characters
        int start = 0;
        int end = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            // If the character exists in p, decrement its count in the map
            if (charCountP.containsKey(c)) {
                charCountP.put(c, charCountP.get(c) - 1);
                // If the count becomes zero, it means we have encountered all occurrences of that character in p
                if (charCountP.get(c) == 0) {
                    count++;
                }
            }
            end++;

            // If all different characters in p are found in the current window
            while (count == charCountP.size()) {
                // If the window size is equal to p length, it's an anagram, add the start index to the result list
                if (end - start == p.length()) {
                    result.add(start);
                }
                char startChar = s.charAt(start);
                // If the character exists in p, increment its count in the map
                if (charCountP.containsKey(startChar)) {
                    charCountP.put(startChar, charCountP.get(startChar) + 1);
                    // If the count becomes one, it means we need to find the next occurrence of that character
                    if (charCountP.get(startChar) == 1) {
                        count--;
                    }
                }
                start++;
            }
        }

        return result;
    }
}

public class Anagram {
    public static void main(String[] args) {
        Sourcet source = new Sourcet();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = source.findAnagrams(s, p);
        System.out.println(result);
    }
}