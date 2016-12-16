package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wade on 2016/12/14.
 */
public class TestCardLayout extends JFrame{

    //两个面板
    JPanel jPanel_Flow = new JPanel();
    JPanel jPanel_Card = new JPanel();

    //三个按钮，三张Label用来添加图片
    JButton jb1 = new JButton("按钮1");
    JButton jb2 = new JButton("按钮2");
    JButton jb3 = new JButton("按钮3");

    JLabel jl1 = new JLabel(new ImageIcon("/Users/wade/Desktop/Snip20161214_6.png"));
    JLabel jl2 = new JLabel(new ImageIcon("/Users/wade/Desktop/Snip20161214_7.png"));
    JLabel jl3 = new JLabel(new ImageIcon("/Users/wade/Desktop/Snip20161214_3.png"));

    //构造函数
    public TestCardLayout(){

        this.setSize(900,700);
        this.setVisible(true);

        //顶部面板设置
        jPanel_Flow.setLayout(new FlowLayout());
        jPanel_Flow.add(jb1);
        jPanel_Flow.add(jb2);
        jPanel_Flow.add(jb3);

        //底部面板设置
        jPanel_Card.setLayout(new CardLayout());
        jPanel_Card.add("Picture_1",jl1);
        jPanel_Card.add("Picture_2",jl2);
        jPanel_Card.add("Picture_3",jl3);

        //设置总体网格布局
        this.setLayout(new BorderLayout(2,1));
        this.add(BorderLayout.NORTH,jPanel_Flow);
        this.add(BorderLayout.CENTER,jPanel_Card);

        //给按钮添加监听器
        jb1.addActionListener(new MyActionListener());
        jb2.addActionListener(new MyActionListener());
        jb3.addActionListener(new MyActionListener());
    }


    /**
     * 按钮监控类
     */

    class MyActionListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == jb1){
                //首先获得jPanel_Card这个面板的布局管理器，然后强转成CardLayout类，并调用show方法，
                // 其中父组件就是这个面板（因为我们要调用的Label是放在这个面板当中的），
                // 后面的名字显示的是要切换的Label的名字（String类型）
                ((CardLayout)jPanel_Card.getLayout()).show(jPanel_Card,"Picture_1");
            }else if (e.getSource() == jb2){
                ((CardLayout)jPanel_Card.getLayout()).show(jPanel_Card,"Picture_2");
            }else {
                ((CardLayout)jPanel_Card.getLayout()).show(jPanel_Card,"Picture_3");
            }
        }
    }
    /**
     * 主方法
     */
    public static void main(String[] args){

        new TestCardLayout();
    }
}
