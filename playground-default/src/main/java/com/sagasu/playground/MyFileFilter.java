package com.sagasu.playground;


import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileFilter;

public class MyFileFilter {
    public static void main(String[] args){
        // typical impelentation of interface by using anonymous class
        FileFilter ff = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".java");
            }
        };


        // Implementing interface by using lambda.
        FileFilter ff2 = (File file) -> file.getName().endsWith(".java");

        //A functional interface is an interface that has just one abstract method, and thus represents a single function contract.
        //If an interface has more than one method (it is not a funcitonal interface) and can not be implemented thru lambda.


        // Using a helper interface when interface has multiple methods, but it is passed in a method, so the statement above still holds.
        Component c = new Applet();
        c.addMouseListener((ClickedListener)(e)->System.out.println("Clicked !"));

    }
}

interface ClickedListener extends MouseListener
{
    @Override
    public default void mouseEntered(MouseEvent e) {}

    @Override
    public default void mouseExited(MouseEvent e) {}

    @Override
    public default void mousePressed(MouseEvent e) {}

    @Override
    public default void mouseReleased(MouseEvent e) {}
}
