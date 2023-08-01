package com.pineftn.communication.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) {
        // constructor
        // DatagramSocket serverSocket = new DatagramSocket(指定 端口的端口号);
        try (
                DatagramSocket serverSocket = new DatagramSocket(6666);
        ) {
            System.out.println("receiver started!");
            //创建用来收信的（空）DatagramPacket
            byte[] buffer = new byte[1024 * 64];//64kb
            DatagramPacket dataPacket = new DatagramPacket(buffer, buffer.length);
            //收信
            // 阻塞等待直到接收到一个数据包，接收一个数据包之后向下进行
            // （所以如果要收多次信需要循环）
            serverSocket.receive(dataPacket);
            //打印接收数据
            int len = dataPacket.getLength();//实际接收到的数据的长度
            String receiveStr = new String(buffer, 0, len);
            System.out.println(receiveStr);
        } catch (Exception e) {

        }
    }
}
