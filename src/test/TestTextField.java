package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by wade on 2016/12/12.
 */


class TextFieldd extends JFrame{

    JTextField jf = new JTextField("我是一个文本框");
    JPanel jp = new JPanel();

    public TextFieldd(){
        this.setBounds(300,300,500,300);
        this.setVisible(true);
        jf.setBounds(10,10,50,50);
        jf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextFieldd.this.setTitle(jf.getText());
                jf.setText("");
                TextFieldd.this.repaint();
            }
        });
        jp.add(new JLabel("输入可以改标题哦"));
        jp.add(jf);
        this.add(jp);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

public class TestTextField {

    public static void main(String[] args){

        new TextFieldd();
    }
}