package com.firstname;

import java.util.HashSet;
import java.util.Set;

class Sourced {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Set<String> transformations = new HashSet<>();
        for (String word : words) {
            StringBuilder morse = new StringBuilder();
            for (char c : word.toCharArray()) {
                morse.append(morseCodes[c - 'a']);
            }
            transformations.add(morse.toString());
        }

        return transformations.size();
    }
}

public class Encryption {
    public static void main(String[] args) {
        Sourced source = new Sourced();
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        int result = source.uniqueMorseRepresentations(words);
        System.out.println(result);
    }
}