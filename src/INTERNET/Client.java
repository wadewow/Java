package INTERNET;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by wade on 2016/12/17.
 */
public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",1024);
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String information;
            while ((information = bufferedReader.readLine()) != null){
                System.out.println(information);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            socket.close();
        }
    }
}
