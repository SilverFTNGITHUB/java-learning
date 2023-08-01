package com.pineftn.filestream.file;

import java.io.File;

public class FileTest1 {
    public static void main(String[] args){
        // 创建一个File对象，指代某个文件
        // 绝对路径
        File file1 = new File("E:\\Code\\Java\\hellojava\\testme.txt");
        System.out.println(file1.exists() + "," + file1.length());
        // 相对路径（直接在当前工作目录（默认为当前项目）下寻找文件）
        System.out.println(System.getProperty("user.dir"));
        File file2 = new File("src\\main\\resources\\testfile.txt");
        System.out.println(file2.exists() + "," + file2.length());
    }
}
