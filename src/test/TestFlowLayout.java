package test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by wade on 2016/12/14.
 */
public class TestFlowLayout extends JFrame {

    JPanel jPanel = new JPanel();
    public TestFlowLayout(){

        jPanel.add(new JButton("1"));
        jPanel.add(new JButton("快点我"));
        jPanel.add(new JButton("第二个按钮"));

        FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT);
        jPanel.setLayout(flowLayout);

        jPanel.setBackground(Color.green);
        this.add(jPanel);
        this.setSize(500,300);
        this.setVisible(true);
    }

    public static void main(String[] args){

        new TestFlowLayout();
    }
}
