package Music;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by wade on 2016/12/20.
 */
public class Music extends JFrame {

    JPanel controlerPanel = null;                //顶部控制面板
    JPanel songListPanel = null;                //显示面板
    JButton lastButton = null;                 //上一首
    JButton startButton = null;               //开始暂停
    JButton nextButton = null;               //下一首
    JTextArea displayArea = null;           //显示区域
    JScrollPane jScrollPane = null;        //滚动
    JButton openfolderButton = null;

    public Music(){

        //按钮控制面板部分
        lastButton = new JButton("LAST");
        startButton = new JButton("START/PAUSE");
        nextButton = new JButton("NEXT");
        controlerPanel = new JPanel();
        controlerPanel.add(lastButton);
        controlerPanel.add(startButton);
        controlerPanel.add(nextButton);

        //音乐列表
        displayArea = new JTextArea(24,24);
        jScrollPane = new JScrollPane(displayArea);
        songListPanel = new JPanel();
        songListPanel.add(jScrollPane);

        //添加音乐按钮
        openfolderButton = new JButton("OPEN");

        //ALL
        this.setLayout(new BorderLayout(0,5));
        this.add(BorderLayout.NORTH,controlerPanel);
        this.add(BorderLayout.CENTER,songListPanel);
        this.add(BorderLayout.SOUTH,openfolderButton);

        this.setTitle("MUSIC PLAYER");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dimension = tk.getScreenSize();
        int width = dimension.width;
        int height = dimension.height;
        this.setBounds(width/4,height/4,width/6,height/2);
        this.setVisible(true);

        //窗口监听器
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //OPEN按钮的监听器
        openfolderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public static void main(String[] args){

        new Music();
    }
}
