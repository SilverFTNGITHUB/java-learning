package com.pineftn.filestream.stream;

import java.io.*;

public class TryCatchFinally {
    public static void main(String[] args)  {
/*        try{
            System.out.println("try");
            Exception e = new Exception();
            throw e;
            //System.out.println("2");
        } catch(Exception e) {
            System.out.println("catch");
            //e.printStackTrace();
        } finally{
            //不管try中的程序 正常执行/出现异常，都会执行finally区（除非JVM终止）
            System.out.println("finally");
        }
    }
*/
        //copy file的 释放资源的 标准写法
        InputStream iStream = null;//令finally能搞到try中的变量的标准写法
        OutputStream oStream = null;
        try {
            iStream = new FileInputStream("src\\main\\resources\\fish.png");
            oStream = new FileOutputStream("src\\main\\resources\\streamEx\\copyFish.png");
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = iStream.read(buffer)) != -1) {
                oStream.write(buffer, 0, len);
            }
            System.out.println("copy finished!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(iStream != null) iStream.close();//防止try中new FileInputStream之前就出错，iStream还是null
            } catch (IOException e) { // .close()的IO Exception
                throw new RuntimeException(e);
            }
            try {
                if(oStream != null) oStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
