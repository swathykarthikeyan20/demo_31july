package com.firstname;



import java.util.*;

class Source {
    public String printIndex(ArrayList<String> list, int ind) {
        if (ind >= 0 && ind < list.size()) {
            return list.get(ind);
        } else {
            return "Invalid index!";
        }
    }

    public ArrayList<String> addAfter(ArrayList<String> a, String m, String n) {
        int index = a.indexOf(m);
        if (index != -1) {
            a.add(index + 1, n);
        }
        return a;
    }

    public ArrayList<String> pickIndexAndAppend(ArrayList<String> p, int ind) {
        if (ind >= 0 && ind < p.size()) {
            String pickedElement = p.get(ind);
            p.remove(ind);
            p.add(pickedElement);
        }
        return p;
    }
}

public class Tvshow {
    public static void main(String[] args) {
        Source source = new Source();
        ArrayList<String> tvShows = new ArrayList<>();
        tvShows.add("Breaking Bad");
        tvShows.add("Young Sheldon");
        tvShows.add("Friends");
        tvShows.add("Sherlock");
        tvShows.add("Stranger Things");

        String showAtIndex = source.printIndex(tvShows, 2);
        System.out.println(showAtIndex);

        ArrayList<String> tvShowsAfterAddition = source.addAfter(tvShows, "Young Sheldon", "Mr. Robot");
        System.out.println(tvShowsAfterAddition);

        ArrayList<String> tvShowsAfterPickAndAppend = source.pickIndexAndAppend(tvShows, 2);
        System.out.println(tvShowsAfterPickAndAppend);
    }
}