package test;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by wade on 2016/12/13.
 */
public class TestJComboBox {

    public static void main(String[] args){
        new MyFrames();
    }
}
 class MyFrames extends JFrame implements ItemListener{

    JPanel jPanel = new JPanel();
    JLabel jLabel = new JLabel("选择你的人生！");
    JComboBox jComboBox = new JComboBox();

    public MyFrames(){



        jComboBox.addItem("wade");
        jComboBox.addItem("kobe");
        jComboBox.addItem("Tim");
        jPanel.add(jComboBox);
        jPanel.add(jLabel);
        this.add(jPanel);
        this.setSize(500,300);
        this.setVisible(true);

        //添加监听器
        jComboBox.addItemListener(this);
    }

     @Override
     public void itemStateChanged(ItemEvent e) {

        jLabel.setText(e.getItem().toString());
     }
 }