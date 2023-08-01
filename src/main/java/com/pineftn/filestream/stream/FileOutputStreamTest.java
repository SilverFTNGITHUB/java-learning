package com.pineftn.filestream.stream;

import java.io.*;

/*
抽象-OutputStream
实现-FileOutputStream

 */
public class FileOutputStreamTest {
    private static FileOutputStream oStream;

    public static void main(String[] args) throws IOException {
        //Constructor: create stream tube
        // 覆盖管道，每次write时清空文件中的原有数据：FileOutputStream (File file)
        //FileOutputStream oStream = new FileOutputStream(new File("src\\main\\resources\\FileEx\\helloOutput.txt"));
        // 附加管道：每次write时再原有数据之后增加: FileOutputStream(File file, boolean append:true)
        FileOutputStream oStream = new FileOutputStream("src\\main\\resources\\FileEx\\helloOutput.txt", true);

        //Methods
        //write(int b)
        oStream.write('b');
        //write(byte[] b)
        String output = "hello";
        //String.getBytes() String->byte[]
        byte[] buffer = output.getBytes();
        oStream.write(buffer);
        //write(byte[] b, int offset, int len)
        String longOutput = "NoNoYesNoNo";
        buffer = longOutput.getBytes();
        oStream.write(buffer, 4, 3);

        //换行符
        /*
        \n 一些平台可用
        \r\n 通用
         */
        oStream.write("\r\n".getBytes());

        //chinese
        String chinOutput = "你好hello";
        buffer = chinOutput.getBytes();
        /*
        ASCII 中文两字节
        UTF-8 中文三字节（扩展b区后四字节）
        GBK 中文两字节
        UTF-16 中文两字节
         */
        oStream.write(buffer, 0, 2*3);

        oStream.close();
    }
}
