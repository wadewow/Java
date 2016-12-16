package test;

import Practice.Test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by wade on 2016/12/14.
 */
public class TestGridLayout extends JFrame{

    JPanel j1 = new JPanel();
    JPanel j2 = new JPanel();
    JPanel j3 = new JPanel();
    JPanel j4 = new JPanel();
    JPanel j5 = new JPanel();
    JPanel j6 = new JPanel();
    JPanel j7 = new JPanel();
    JPanel j8 = new JPanel();
    JPanel j9 = new JPanel();

    public TestGridLayout(){

        this.setSize(500,300);
        this.setVisible(true);

        GridLayout gridLayout = new GridLayout(3,3,10,10);
        this.setLayout(gridLayout);

        j1.setBackground(Color.red);
        j2.setBackground(Color.orange);
        j3.setBackground(Color.yellow);
        j4.setBackground(Color.green);
        j5.setBackground(Color.cyan);
        j6.setBackground(Color.blue);
        j7.setBackground(Color.pink);
        j8.setBackground(Color.white);
        j9.setBackground(Color.black);

        this.add(j1);
        this.add(j2);
        this.add(j3);
        this.add(j4);
        this.add(j5);
        this.add(j6);
        this.add(j7);
        this.add(j8);
        this.add(j9);

    }
    public static void main(String[] args){

        new TestGridLayout();
    }
}
