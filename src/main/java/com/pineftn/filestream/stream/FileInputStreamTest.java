package com.pineftn.filestream.stream;

import java.io.*;

//文件字节输入流（内存<--磁盘）
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        File f = new File("src\\main\\resources\\FileEx\\helloStream.txt");
        System.out.println(f.exists() +", "+ f.length());
        //Constructor: 创建输入流管道
        //FileInputStream iStream = new FileInputStream(f);
        InputStream iStream = new FileInputStream(f);//用多态的方式来写

        //Method: int = iStream.read()
        System.out.println("Method: read():");
        int iByte = 0;//在循环外面定义比较有效率
        while((iByte = iStream.read()) != -1) {
            System.out.print((char)iByte);//(char)int，将数字转换为对应ascii码的char
        }
//        System.out.println("read one byte = "+iStream.read());
//
//        byte[] buffer = new byte[10];
//        iStream.read(buffer);
//        System.out.println("read "+buffer.length+" bytes to buffer = " + buffer+", to String = "+buffer.toString());

    }
}
