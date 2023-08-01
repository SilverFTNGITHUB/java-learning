package com.pineftn.filestream.stream;

import java.io.*;

/*
文件复制：
磁盘  --inputStream-->  内存  --OutputStream-->  磁盘
 */
public class CopyFile {
    public static void main(String[] args) throws IOException {
        InputStream iStream = new FileInputStream("src\\main\\resources\\fish.png");
        OutputStream oStream = new FileOutputStream("src\\main\\resources\\streamEx\\copyFish.png");
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = iStream.read(buffer)) != -1) {
            oStream.write(buffer, 0, len);
        }
        iStream.close();
        oStream.close();
        System.out.println("copy finished!");
    }
}
