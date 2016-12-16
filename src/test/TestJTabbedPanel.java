package test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by wade on 2016/12/14.
 */
public class TestJTabbedPanel {

    public static void main(String[] args){

        new MyFramess();
    }
}

class MyFramess extends JFrame{

    JPanel jp = new JPanel();   //总面板
    JPanel jp1 = new JPanel();   //选项卡要用到的面板
    JPanel jp2 = new JPanel();   //选项卡要用到的面板
    JTabbedPane jtp = new JTabbedPane();


    public MyFramess(){

        //给面板1添加一些按钮
        jp1.add(new JButton("按钮1"));
        jp1.add(new JButton("按钮2"));
        jp1.add(new JButton("按钮3"));

        //给面板2添加一些文字
        jp2.add(new Label("wade"));
        jp2.add(new Label("kobe"));
        jp2.add(new Label("Tim"));

        //在选项卡中添加一些组件，这里把面板1和面板2添加到选项卡中
        jtp.add("一些按钮",jp1);
        jtp.add("一些标签",jp2);
        jtp.add("什么都没有",null);   //添加了一个什么都没有的选项
        jp.add(jtp);     //将选项卡添加到总面板中
        this.add(jp);

        this.setSize(500,300);
        this.setVisible(true);

    }

}