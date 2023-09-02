package com.firstname;

import java.util.HashSet;
import java.util.Set;

class Sourcess {
    public Set<Integer> subtract(Set<Integer> a, Set<Integer> b) {
        a.removeAll(b);
        return a;
    }

    public Set<Integer> union(Set<Integer> a, Set<Integer> b) {
        Set<Integer> unionSet = new HashSet<>(a);
        unionSet.addAll(b);
        return unionSet;
    }

    public Set<Integer> intersect(Set<Integer> a, Set<Integer> b) {
        Set<Integer> intersectionSet = new HashSet<>(a);
        intersectionSet.retainAll(b);
        return intersectionSet;
    }
}

public class Setoperation {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(5);
        set1.add(6);
        set1.add(7);
        set1.add(8);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(9);
        set2.add(3);
        set2.add(7);

        Sourcess source = new Sourcess();

        Set<Integer> subtractedSet = source.subtract(set1, set2);
        System.out.println(subtractedSet);

        Set<Integer> unionSet = source.union(set1, set2);
        System.out.println(unionSet);

        Set<Integer> intersectionSet = source.intersect(set1, set2);
        System.out.println(intersectionSet);
    }
}