package com.pineftn.filestream.stream;

import java.io.*;

public class DataOutputStreamTest {
    public static void main(String[] args) {
        // constructor 使用数据输出流包装低级输出流（比如字节输出流）
        // DataOutputStream(OutputStream out)
        try (
                DataOutputStream oDataStream = new DataOutputStream(
                        new FileOutputStream("src\\main\\resources\\streamEx\\dataStream.txt"))
        ) {
            //带类型的
            oDataStream.writeInt('a');
            oDataStream.writeDouble(1.5);
            oDataStream.writeBoolean(true);
            oDataStream.writeUTF("我是中文aaa中文结束");
            //也支持和OutputStream一样的不带类型的.write()
            oDataStream.write('a');
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
