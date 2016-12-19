package INTERNET.Chat_Project;

import java.io.*;
import java.net.Socket;

/**
 * Created by wade on 2016/12/19.
 */
public class Client {

    public static void main(String[] args){
        try {
            System.out.println("客户端启动");
            Socket socket = new Socket("127.0.0.1",1027); //客户端与服务端建立了连接
            new SendThread(socket).start();
            new GetThread(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SendThread extends Thread{

    private Socket socket;
    public SendThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStreamWriter Osw = new OutputStreamWriter(socket.getOutputStream());
            //一般输入流可以使用缓冲方法
            BufferedReader Keyboard_input = new BufferedReader(new InputStreamReader(System.in));

            while (true){
                String infomation  = Keyboard_input.readLine();
                Osw.write(infomation+"\n");
                Osw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class GetThread extends Thread{

    private Socket socket;
    public GetThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader getinformation = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                String information = getinformation.readLine();
                System.out.println(information);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
