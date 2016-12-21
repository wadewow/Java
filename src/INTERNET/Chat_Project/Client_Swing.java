package INTERNET.Chat_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by wade on 2016/12/20.
 */
public class Client_Swing extends JFrame{

    JPanel textArea_Panel = null;
    JTextArea textArea = null;
    JPanel textField_Panel = null;
    JTextField textField = null;
    JScrollPane scroll = null;

    private Socket s = null;
    private String name = null;
    public Client_Swing(Socket s,String name){

        this.s = s;
        this.name = name;
        //显示聊天内容
        textArea_Panel = new JPanel();
        textArea = new JTextArea(20,30);
        scroll = new JScrollPane(textArea);     //直接将文本域当做参数传给滚动条面板
        textArea_Panel.add(scroll);

        //用于输入内容
        textField_Panel = new JPanel();
        textField = new JTextField(30);
        textField_Panel.add(textField);

        //整体布局使用BroadLayout
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER,textArea_Panel);
        this.add(BorderLayout.SOUTH,textField_Panel);

        //基本配置
        this.setVisible(true);
        this.setTitle(name);
        this.pack();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int width = dimension.width;
        int height = dimension.height;
        this.setLocation(width/2,height/3);

        //窗口监听器
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //输入栏监听器
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
                    String contant = textField.getText();
                    System.out.println(contant);
                    osw.write(contant+"\n");
                    osw.flush();
                    textField.setText("");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //启动"读取服务器信息的线程"
        new GetThreads().start();
    }
    /**
     * 读取服务器返回的信息
     */
    class GetThreads extends Thread{
        @Override
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                while (true){
                    String contant = br.readLine();
                    if (contant.equals("exit")){
                        Client_Swing.this.dispose();
                    }
                    textArea.setText(textArea.getText()+contant+"\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
