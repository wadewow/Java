package INTERNET;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

            //读取资源内容
            //url.openStream()方法可以读取资源流，但是其返回的是字节流。由于页面中可能有中文字符
            //所以使用InputStreamReader 封装成为字符流
            InputStreamReader isr = new InputStreamReader(url.openStream());
            BufferedReader br = new BufferedReader(isr);   //进一步优化为字符缓冲流这样读取速度就很快了
            String line;
            while ((line = br.readLine()) != null){   //按行读取方式读取
                System.out.println(line);
            }
            isr.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
