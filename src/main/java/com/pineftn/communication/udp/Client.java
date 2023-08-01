package com.pineftn.communication.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/*
DatagramSocket-端口
DatagramPacket-数据包
 */
public class Client {
    public static void main(String[] args) {
        //constructor
        // 建立发信/收信端口 DatagramSocket socket = new DatagramSocket()
        try (
                DatagramSocket clientSocket = new DatagramSocket()
        ) {
            //封装数据包
            byte[] bytes = "hello UDP".getBytes();
            // new DatagramPacket(info, info length, dest address, dest port);
            DatagramPacket dataPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 6666);
            //发送数据包
            clientSocket.send(dataPacket);
            System.out.println("Client message sent!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
