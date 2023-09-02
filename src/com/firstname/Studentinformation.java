package com.firstname;
import java.util.ArrayList;

class Sourcee {
    public ArrayList<String> changeOccurrence(ArrayList<String> a, String m, String n) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals(m)) {
                a.set(i, n);
            }
        }
        return a;
    }

    public String listIndex(ArrayList<String> list) {
        return list.get(0);
    }

    public ArrayList<String> listAfter(ArrayList<String> a, String m, String n) {
        int index = a.indexOf(m);
        if (index != -1) {
            a.add(index + 1, n);
        }
        return a;
    }
}

public class Studentinformation {
    public static void main(String[] args) {
        Sourcee source = new Sourcee();
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        ArrayList<String> changedList = source.changeOccurrence(list, "C", "S");
        System.out.println(changedList);

        String elementAtIndex0 = source.listIndex(list);
        System.out.println(elementAtIndex0);

        ArrayList<String> listAfterAddition = source.listAfter(list, "C", "E");
        System.out.println(listAfterAddition);
    }
}