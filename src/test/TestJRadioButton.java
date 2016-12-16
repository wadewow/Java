package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wade on 2016/12/13.
 */
public class TestJRadioButton {

    public static void main(String[] args){

        new JradioButton();
    }
}

class JradioButton extends JFrame implements ActionListener{

    JPanel jPanel = new JPanel();
    JLabel jLabel = new JLabel();
    JRadioButton jRadioButton1 = new JRadioButton("JAVA");
    JRadioButton jRadioButton2 = new JRadioButton("PHP");
    JRadioButton jRadioButton3 = new JRadioButton("C++");
    ButtonGroup buttonGroup = new ButtonGroup();
    public JradioButton(){

        this.setVisible(true);
        this.setSize(500,300);
        jPanel.add(jLabel);
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);
        jPanel.add(jRadioButton1);
        jPanel.add(jRadioButton2);
        jPanel.add(jRadioButton3);
        this.add(jPanel);

        //给按钮添加监听器
        jRadioButton1.addActionListener(this);
        jRadioButton2.addActionListener(this);
        jRadioButton3.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jLabel.setText(e.getActionCommand());
    }
}