package com.firstname;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class ExceptionChecks {
    public ArrayList<String> numberCheck(String str) {
        ArrayList<String> result = new ArrayList<>();
        for (char c : str.toCharArray()) {
            try {
                int num = Integer.parseInt(String.valueOf(c));
                result.add(String.valueOf(num));
            } catch (NumberFormatException e) {
                result.add(e.getMessage());
            }
        }
        return result;
    }

    public String fileCheck(String filename) {
        try {
            File file = new File(filename);
            if (file.exists()) {
                return "File Found";
            } else {
                throw new FileNotFoundException("File not found: " + filename);
            }
        } catch (FileNotFoundException e) {
            return e.getMessage();
        }
    }
}

public class Checkfile {
    public static void main(String[] args) {
        ExceptionChecks exceptionCheck = new ExceptionChecks();
        
        // Test numberCheck method
        String str = "10ASD";
        ArrayList<String> numbersList = exceptionCheck.numberCheck(str);
        System.out.println("Number Check: " + numbersList);

        // Test fileCheck method
        String filename = "abc.txt";
        String fileCheckResult = exceptionCheck.fileCheck(filename);
        System.out.println("File Check: " + fileCheckResult);
    }
}