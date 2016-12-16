package INTERNET;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by wade on 2016/12/16.
 */
public class TestURL {

    public static void main(String[] args){

        try {
            URL url = new URL("http://www.insta360.com/product/insta360-air/");
            System.out.println("查看一下地址的主机："+url.getHost());
            System.out.println("查看一下端口："+url.getPort());
            System.out.println("查看一下协议："+url.getProtocol());
            System.out.println("查看一下路径："+url.getPath());
            System.out.println("查看一下文件名："+url.getFile());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
