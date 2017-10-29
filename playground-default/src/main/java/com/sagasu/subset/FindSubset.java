package com.sagasu.subset;

import java.util.ArrayList;
import java.util.List;

public class FindSubset {
    public List<List<Integer>> find(int[] ar) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        find(ar, 0, new ArrayList<Integer>(), results);
        return results;
    }

    private void find(int[] ar, int index, List<Integer> current, List<List<Integer>> result) {
        if(index == ar.length){
            if(!current.isEmpty())
                result.add(new ArrayList<Integer>(current));
            return;
        }
        if(current.size() == ar.length)
            return;

        for(int i = 0; i < ar.length; i++){
            find(ar, index + 1, current, result);
            current.add(i);
            find(ar, index + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
