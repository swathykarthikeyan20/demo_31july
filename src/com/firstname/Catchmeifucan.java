package com.firstname;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Catchmeifucan{
public static void main(String[] args) {
 Scanner a = new Scanner(System.in);
 System.out.println("Enter the input string");
 String inputStr = a.nextLine();
 List<String> outputList = new ArrayList<>();
 Implementation impl = new Implementation();
 outputList = impl.numberCheck(inputStr);
 System.out.println(outputList);

 System.out.println("Enter the file path");
 String inputPath = a.nextLine();
 String fileCheckOutpiut = impl.fileCheck(inputPath);
 System.out.println(fileCheckOutpiut);
}
}
class Implementation{
public String fileCheck(String inputPath) {
 try {
 File file = new File(inputPath);
 if(file.exists()) {
 return "File Found";
 }else {
 throw new FileNotFoundException();
 }
 } catch (FileNotFoundException e) {
 e.printStackTrace();
 return e.getMessage();
 }
}
public List<String> numberCheck(String inputStr) {
 String a = null;
 List<String> chars = new ArrayList<>();
 ;
 for (int i = 0; i < inputStr.length(); i++) {
 try {
 if (Character.isDigit(inputStr.charAt(i))) {
 chars.add(String.valueOf(inputStr.charAt(i)));
 } else {
 throw new NumberFormatException();
 }
 } catch (NumberFormatException e) {
 a = "For input string " + '"' + inputStr.charAt(i) + '"';
 chars.add(a);
 }
 }
 return chars;
}
}