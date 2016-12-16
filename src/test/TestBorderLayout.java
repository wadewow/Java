package test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by wade on 2016/12/14.
 */
public class TestBorderLayout extends JFrame {

    JPanel j_N = new JPanel();
    JPanel j_S = new JPanel();
    JPanel j_W = new JPanel();
    JPanel j_E = new JPanel();
    JPanel j_C = new JPanel();

    public TestBorderLayout(){

        j_N.setBackground(Color.red);
        j_S.setBackground(Color.yellow);
        j_W.setBackground(Color.blue);
        j_E.setBackground(Color.green);
        j_C.setBackground(Color.pink);


        BorderLayout borderLayout = new BorderLayout(20,10);
        this.setLayout(borderLayout);

        this.add(BorderLayout.NORTH,j_N);
        this.add(BorderLayout.EAST,j_E);
        this.add(BorderLayout.SOUTH,j_S);
        this.add(BorderLayout.WEST,j_W);
        this.add(BorderLayout.CENTER,j_C);

        this.setSize(700,700);
        this.setVisible(true);
    }

    public static void main(String[] args){

        new TestBorderLayout();
    }
}
