package com.pineftn.communication.http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) throws IOException {
        // 监听指定Server端口
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running...");

        // 建立多条通道
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("connect from" + socket.getRemoteSocketAddress());

            // 开启线程，处理该通道内的传信
            Thread connection = new ConnectionHandler(socket);
            connection.start();

        }
    }
}

class ConnectionHandler extends Thread {
    Socket socket;//connection的server端socket

    ConnectionHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    /**
     * 处理一条通道内的传信（）多条信息
     */
    public void run() {
        try (
                // 输入管道 输入流
                InputStream inputStream = this.socket.getInputStream();
                // 输出管道 输出流
                OutputStream outputStream = this.socket.getOutputStream();
        ) {
            // 处理信息
            handleIOStream(inputStream, outputStream);
        } catch (IOException e) {
            // socket is not connected
            try {
                this.socket.close();
            } catch (IOException ex) {
                // errors when closing
            }
            System.out.println("Client disconnected.");
        }

    }

    private void handleIOStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        // 对输入输出流进行包装 PINEQ 为什么？
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));


        /*
        HTTP请求标准格式-请求行（标准请求格式中的第一行）
        <请求方法> <请求URI> <HTTP协议版本>
        比如：
        GET / HTTP/1.
        意味着：
        请求方法-GET（根目录）
        请求URI-/
        HTTP协议版本-HTTP/1.
         */

        // 读取HTTP请求
        // Request Line
        boolean isRequestOK = false;
        String firstLine = bufferedReader.readLine();
        if (firstLine.startsWith("GET / HTTP/1.")) {
            // 判断请求是否是一个格式合法的GET请求
            isRequestOK = true;
        }

        // Request Headers
        while (true) {
            String reqHeader = bufferedReader.readLine();
            if (reqHeader.isEmpty()) {
                // Request Headers和Request Body（如果有的话）之间有一个空行作为分隔
                // 不管有没有Request Body， Request Header后面都会有个空行作为结束
                break;
            }
            System.out.println(reqHeader);
        }
        System.out.println(isRequestOK ? "Response OK" : "Response ERROR");

        if (!isRequestOK) {
            // Response with 404 NOT FOUND
            // Response Line
            bufferedWriter.write("HTTP/1.0 404 NOT FOUND\r\n");
            // Response Headers
            bufferedWriter.write("Content-Length: 0\r\n");
            // Headres和Body之间的空行
            bufferedWriter.write("\r\n");
            bufferedWriter.flush();
        } else {
            // 这里做请求正确时服务端要做的事情

            String data = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <title>Simple HTML Page</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <h1>Hello, World!</h1>\n" +
                    "    <p>This is a simple HTML page.</p>\n" +
                    "</body>\n" +
                    "</html>\n";
            // Response with 200 OK & information
            // Response Line
            bufferedWriter.write("HTTP/1.0 200 OK\r\n");
            // Response Headers
            bufferedWriter.write("Connection: keep-alive\r\n");
            bufferedWriter.write("Content-Type: text/html\r\n");
            bufferedWriter.write("Content-Length: " + data.length() + "\r\n");
            // Headres和Body之间的空行
            bufferedWriter.write("\r\n");
            // Response Body
            bufferedWriter.write(data);
            bufferedWriter.flush();
        }
    }

}