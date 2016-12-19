package INTERNET.Chat_Project;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wade on 2016/12/19.
 */
public class Server {

    public static List<Socket> sockets = new ArrayList<Socket>();

    public static void main(String[] args){

        try {
            System.out.println("服务器已经启动等待客户端连接......");
            ServerSocket serverSocket  = new ServerSocket(1027);
            while (true){
                Socket socket = serverSocket.accept();
                sockets.add(socket);
                System.out.println("客户端连接成功，目前在线人数"+sockets.size());
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread extends Thread{

    private Socket socketll;
    public ServerThread(Socket socket){
        this.socketll = socket;
    }

    @Override
    public void run() {
        try {
            //获得客户端的输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(socketll.getInputStream()));
            while (true){
                //读取客户端的输入流
                String contant = br.readLine();
                //将客户端发送过来的信息分发给每一个客户端
                for (Socket socket: Server.sockets){
                    if (socket != this.socketll){
                        OutputStreamWriter Osw = new OutputStreamWriter(socket.getOutputStream());
                        Osw.write(contant+"\n");
                        Osw.flush();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}