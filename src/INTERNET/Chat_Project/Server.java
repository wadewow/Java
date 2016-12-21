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
                Socket socket = serverSocket.accept();   //等待客户端连接
                sockets.add(socket);
                System.out.println("客户端连接成功，目前在线人数"+sockets.size());
                new ServerThread(socket).start();    //将socket对象传递给多线程
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread extends Thread{

    private Socket s;
    public ServerThread(Socket socket){
        this.s = socket;
    }

    @Override
    public void run() {
        try {
            //获得客户端的输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));   //当获得输入输出流的后就不用再次获取了
            //将登录信息分发给每一个在线的用户（除了自己）
            String username = br.readLine();          //如果有流就会读取，没有留的话就会阻塞
            for (Socket socket: Server.sockets){
                if (socket != this.s){
                    OutputStreamWriter Osw = new OutputStreamWriter(socket.getOutputStream());
                    Osw.write("[系统消息："+username+"]"+"登录"+"\n");
                    Osw.flush();
                }
            }
            while (true){
                //读取客户端的输入流
                System.out.println("来自客户端的流");
                String contant = br.readLine();        //如果有流就会读取，没有留的话就会阻塞（这TM非常重要）
                //将客户端发送过来的信息分发给每一个客户端
                for (Socket socket: Server.sockets){
                        OutputStreamWriter Osw = new OutputStreamWriter(socket.getOutputStream());
                        Osw.write(username+":"+contant+"\n");
                        Osw.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}