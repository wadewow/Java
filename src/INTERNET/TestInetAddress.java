package INTERNET;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by wade on 2016/12/16.
 */
public class TestInetAddress {

    public static void main(String[] args){

        try {

            InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
            System.out.println("返回主机的域名个IP地址："+inetAddress);

            InetAddress[] inetAddressesall = InetAddress.getAllByName("www.insta360.com");
            System.out.println("返回所有的域名和地址：");
            for (InetAddress s : inetAddressesall){
                //多个ip地址对应一个域名，说明insta360官网做了负载均衡
                System.out.println(s);
            }

            InetAddress inetAddresslocal = InetAddress.getLocalHost();
            System.out.println("本机的IP地址："+inetAddresslocal);

            byte[] bytes = {14,119,125,23};
            InetAddress inetAddress2 = InetAddress.getByAddress(bytes);
            System.out.println(inetAddress2);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
