package com.sagasu.rotateArray;

import java.util.Arrays;

public class MyRotate {

    public void rotate(int[] ar, int k) {
        rotate(ar, 0, k-1);
        rotate(ar, k, ar.length - 1);
        rotate(ar, 0, ar.length - 1);
    }

    private void rotate(int[] ar, int start, int end) {
        for(int i = start; i <= (start + end) /2; i++){
            swap(ar, i, start + end - i);
        }
    }

    private void swap(int[] ar, int i, int j) {
        ar[i] = ar[i] + ar[j];
        ar[j] = ar[i] - ar[j];
        ar[i] = ar[i] - ar[j];
    }
}
