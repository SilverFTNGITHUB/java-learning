package com.pineftn.filestream.stream;

import java.io.*;
/*
try (定义资源1; 定义资源2;...) {
} catch (Exception e) {
}
//JVM自动释放try(这里定义的资源)
*/

public class TryCatchResources {
    public static void main(String[] args) {
        try (
                InputStream iStream = new FileInputStream("src\\main\\resources\\fish.png");
                OutputStream oStream = new FileOutputStream("src\\main\\resources\\streamEx\\copyFish.png");
        ) {
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = iStream.read(buffer)) != -1) {
                oStream.write(buffer, 0, len);
            }
            System.out.println("copy finished!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
