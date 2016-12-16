package test;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by wade on 2016/12/13.
 */
public class TestJCheckBox {

    public static void main(String[] args){
        new Jcheckbox();
    }
}

class Jcheckbox extends JFrame{

    JPanel Jpanel = new JPanel();
    JLabel jLabel = new JLabel("选择什么语言呢？");
    JCheckBox jCheckBox1 = new JCheckBox("wade");
    JCheckBox jCheckBox2 = new JCheckBox("kobe");
    JCheckBox jCheckBox3 = new JCheckBox("Tim");

    public  Jcheckbox(){

        Jpanel.add(jLabel);
        Jpanel.add(jCheckBox1);
        Jpanel.add(jCheckBox2);
        Jpanel.add(jCheckBox3);
        this.add(Jpanel);
        this.setSize(500,300);
        this.setVisible(true);

        //添加监听器
        jCheckBox1.addItemListener(new MyitemStateChenged());
        jCheckBox2.addItemListener(new MyitemStateChenged());
        jCheckBox3.addItemListener(new MyitemStateChenged());

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    //实现自己的监听器

    class MyitemStateChenged implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox jck = (JCheckBox)e.getItem(); //获得触发事件的组件
            if (e.getStateChange() == ItemEvent.SELECTED){
                jLabel.setText(jLabel.getText()+jck.getText()+" ");
                System.out.println(jck);
            }
        }
    }
}
