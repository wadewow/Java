package test;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by wade on 2016/12/12.
 */
public class MyFrame extends JFrame{

        int count;
        JPanel jp;
        JLabel jl;
        JButton jb;
        JButton jbb;
        String string = "";
    public MyFrame(){
        count = 0;
        jl  = new JLabel("您还没点击呢！");
        jb = new JButton("我是第一个按钮");
        jbb = new JButton("我是第二个按钮");
        jp = new JPanel();
        //this.setBounds(900,700,500,300);
        jp.add(jb);
        jp.add(jbb);
        jp.add(jl);
        this.add(jp);
        this.setTitle("到底行不行啊！");
        this.setSize(500,300);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
                System.exit(0);
                }
                });

        jb.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             jl.setText("第一个按钮按下");
                }
                });
        jbb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl.setText("第二个按钮按下");
            }
        });

        }

    public static void main(String[] args){
        new MyFrame();
    }
}

