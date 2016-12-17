package INTERNET;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wade on 2016/12/17.
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        Socket socket = null;
        int count = 1;
        try {
            server = new ServerSocket(1024);
            while (true){
                System.out.println("正在等待第"+count+"客户端连接......");
                socket = server.accept();
                System.out.println("第"+count+"个客户端连接成功了");
                System.out.println("**************************");

                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
                outputStreamWriter.write("[系统消息：欢迎您上线哦！]"+"您是第"+count+"位用户。");

                outputStreamWriter.close();  //关闭流，方便客户端去读取流
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
