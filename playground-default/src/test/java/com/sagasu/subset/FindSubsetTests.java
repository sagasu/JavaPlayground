package com.sagasu.subset;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FindSubsetTests {
    @Test
    public void find_array_allSubsets(){
        FindSubset fs = new FindSubset();
        int[] ar = new int[]{1,2,3};
        List<List<Integer>> ss = fs.find(ar);

        printList(ss);

        Assert.assertEquals(26, ss.size());
    }

    private void printList(List<List<Integer>> ss) {
        for(int i = 0; i < ss.size(); i++){
            for(int j = 0; j < ss.get(i).size(); j ++){
                System.out.print(ss.get(i).get(j));
            }
            System.out.println();
        }
    }
}
