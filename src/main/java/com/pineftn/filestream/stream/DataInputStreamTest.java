package com.pineftn.filestream.stream;

import java.io.DataInputStream;
import java.io.FileInputStream;

/*
读取特殊类型的数据
 */

public class DataInputStreamTest {
    public static void main(String[] args) {
        // constructor 使用数据输入流包装低级输入流（比如字节输入流）
        // DataInputStream(InputStream in)
        try (
                DataInputStream iDataStream = new DataInputStream(
                        new FileInputStream("src\\main\\resources\\streamEx\\dataStream.txt"))
        ) {
            //读取时要和写入时的格式对应
            /*
            //带类型的
                oDataStream.writeInt('a');
                oDataStream.writeDouble(1.5);
                oDataStream.writeBoolean(true);
                oDataStream.writeUTF("我是中文aaa中文结束");
                //也支持和OutputStream一样的不带类型的.write()
                oDataStream.write('a');
             */
            int i = iDataStream.readInt();
            double d = iDataStream.readDouble();
            boolean b = iDataStream.readBoolean();
            String str = iDataStream.readUTF();
            int bt = iDataStream.read();
            System.out.println(i + "\r\n" + d + "\r\n" + b + "\r\n" + str + "\r\n" + bt);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
