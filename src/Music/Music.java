package Music;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

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
    JFileChooser chooser = null;

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
//                try {
//                    Desktop.getDesktop().open(new File("/Users/wade/Desktop/照片"));
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
                chooser = new JFileChooser("/Users/wade/Desktop/music");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("mp3","mp3");
                chooser.setFileFilter(filter);
                chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int returnVal = chooser.showOpenDialog(new Label("选择音乐"));
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                }
                displayArea.setText(displayArea.getText()+chooser.getSelectedFile().getName()+"\n");
            }
        });
    }
    public static void main(String[] args){

        new Music();
    }
}
