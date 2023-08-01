package com.pineftn.filestream.file;

import java.io.File;
import java.io.IOException;

//改变某resouces//FileEx目录下所有txt文件的序号，从19开始，如1-a --> 19-a
public class FileExercise {
    public static void main(String args[]) throws IOException {
        File folder = new File("src\\main\\resources\\FileEx");
//        deleteAllFiles(folder);
//        createFiles(folder);
        rename(folder);
    }

    public static void rename(File folder) {
        File[] files = folder.listFiles();
        for (File file : files) {
            String name = file.getName();
            String type = name.substring(name.lastIndexOf("."));
            if (type.equals(".txt")) {
                int newIndex = Integer.parseInt(name.substring(0,name.indexOf("-"))) + 18;
                String nameNoIndex = name.substring(name.indexOf("-"));
                System.out.println("rename ori name = " + file.getName());
                File renamedFile = new File(folder.getPath() + "\\" + newIndex + nameNoIndex);
                System.out.println("rename new name = " + renamedFile.getName() + ", result = " + file.renameTo(renamedFile));
            }
        }
    }

    public static void deleteAllFiles(File folder) {
        File[] files = folder.listFiles();
        for (File file : files) {
            file.delete();
        }
        System.out.println("Deleted all files under folder path = " + folder.getPath());

    }

    public static void createFiles(File folder) throws IOException {
        for (int i = 0; i <= 5; i++) {
            String newName = (i + 1) + "-" + (char) ('a' + i);
            File file = new File(folder.getPath() + "\\" + newName + ".txt");
            System.out.println(file.getName() + " create result = " + file.createNewFile());
        }
    }
}
