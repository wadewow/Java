package INTERNET.Chat_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by wade on 2016/12/20.
 */
public class Login extends JFrame {

    JLabel username = new JLabel("Username:");
    JTextField inputUsername = new JTextField(30);

    public Login(){

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int loginWidth = dimension.width;
        int loginHeight = dimension.height;
        this.setBounds(loginWidth/2,loginHeight/2,loginWidth/4,loginHeight/15);

        this.setTitle("登录");
        this.setLayout(new FlowLayout());
        this.add(username);
        this.add(inputUsername);
        this.setVisible(true);

        inputUsername.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Socket socket = new Socket("127.0.0.1",1027);
                    OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
                    osw.write(inputUsername.getText()+"\n"); //传名字
                    osw.flush();
                    new Client_Swing(socket,inputUsername.getText());
                    Login.this.dispose();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args){

        new Login();
    }
}
