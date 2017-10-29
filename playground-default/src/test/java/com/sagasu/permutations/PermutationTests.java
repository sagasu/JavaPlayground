package com.sagasu.permutations;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PermutationTests {

    @Test
    public void perm_array_allPermutations(){
        Permutation p = new Permutation();
        int[] ar = new int[]{1,2,3,4};
        List<List<Integer>> results = p.perm(ar);

        System.out.println("println");
        for(int i = 0; i < results.size(); i++){
            for(int j = 0; j < results.get(i).size(); j++){
                System.out.print(results.get(i).get(j));
            }
            System.out.println();
        }
        System.out.println("done");

        Assert.assertEquals(24, results.size());
    }
}
