package com.pineftn.filestream.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamTest2 {
    public static void main(String[] args) throws IOException {
        InputStream iStream = new FileInputStream("src\\main\\resources\\FileEx\\helloStream.txt");
        byte[] buffer = new byte[10];
        int len = 0;
        String readByte = "";
        while((len = iStream.read(buffer)) != -1) {
            readByte = new String(buffer, 0, len);
            System.out.print(readByte);
        }
    }
}
