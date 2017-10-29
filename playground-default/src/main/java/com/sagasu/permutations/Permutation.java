package com.sagasu.permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {
    public List<List<Integer>> perm(int[] ar) {
        List<Integer> l = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        perm(ar, 0, results, l);
        return results;
    }

    public void perm(int[] ar, int index, List<List<Integer>> results, List<Integer> current) {
        if(ar.length == index){
            List<Integer> al = new ArrayList<Integer>(current);
            results.add(al);
        }

        for(int i = 0; i < ar.length; i++){
            if(current.contains(ar[i]))
                continue;
            current.add(ar[i]);
            perm(ar, index +1, results, current);
            current.remove(current.size() - 1);
        }
    }
}
