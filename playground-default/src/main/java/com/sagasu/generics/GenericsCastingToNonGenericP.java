package com.sagasu.generics;

import java.util.ArrayList;

public class GenericsCastingToNonGenericP {
    public static void main(){
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        // al.add(1.0); // this doesn't work and this is fine

        ArrayList duh = al;
        // al.add(1.0); //this doesn't work and this is good
    }
}
