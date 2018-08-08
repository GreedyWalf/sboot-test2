package com.sboot.test11;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestTcpSocket {

}

/**
 * 服务端接收到客户端信息，将字符串转换为大写，再发送到客户端
 */
class UpperServer {
    public static final String SERVER_IP = "127.0.0.1";

    public static final int SERVER_PORT = 8888;

    //请求终结字符串
    public static final char REQUEST_END_CHAR = '#';

    private ServerSocket serverSocket;

    public void toUpperServer(String serverIp, int port) throws Exception {
        InetAddress inetAddress = InetAddress.getByName(serverIp);
        serverSocket = new ServerSocket(port, 5, inetAddress);
        System.out.println("服务端已启动。。。");
        while (true) {
            //服务端接收客户端发送的数据
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
//            int len = 0;
//            byte[] buff = new byte[1024];
//            len = inputStream.read(buff);
//            String receiveMsg = new String(buff, 0, len);
//            System.out.println("服务端接收：" + receiveMsg);
//            stringBuilder.append(receiveMsg);

            StringBuilder sb = new StringBuilder();
            for (int c = inputStream.read(); c != REQUEST_END_CHAR; c = inputStream.read()) {
                sb.append((char) c);
            }

            String receiveMsg = sb.toString();
            //将接收到数据，处理后发给客户端
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write((receiveMsg.toUpperCase() + REQUEST_END_CHAR).getBytes());
            outputStream.flush();
        }
    }

    public static void main(String[] args) throws Exception {
        UpperServer upperServer = new UpperServer();
        upperServer.toUpperServer(SERVER_IP, SERVER_PORT);
    }
}

class UpperClient {

    private Socket clientSocket;

    public String toUpperRemote(String serverIp, int port, String str) throws Exception {
        clientSocket = new Socket(serverIp, port);

        //客户端向服务端发送数据
        OutputStream outputStream = clientSocket.getOutputStream();
        outputStream.write(str.getBytes());

        //客户端接受服务端发送的数据
        InputStream inputStream = clientSocket.getInputStream();
//        int len = 0;
//        byte[] buff = new byte[1024];
//
//        //read()方法会阻塞，直到等到下次获取到数据为止，也就是说读取不到结束位
//        len = inputStream.read(buff);
//        String receiveMsg = new String(buff, 0, len);


        StringBuilder sb = new StringBuilder();
        int c = 0;
        while (UpperServer.REQUEST_END_CHAR != (c = inputStream.read())) {
            sb.append((char) c);
        }

        String receiveMsg = sb.toString();
        System.out.println("客户端接收:" + receiveMsg);
        return receiveMsg;
    }


    public static void main(String[] args) throws Exception {
        UpperClient client = new UpperClient();
        while (true) {
            //输入字符串
            System.out.println("请输入字符串，#结尾: ");
            Scanner scanner = new Scanner(System.in);
            String inputStr = scanner.next();

            String recvStr = client.toUpperRemote(UpperServer.SERVER_IP, UpperServer.SERVER_PORT, inputStr);
            System.out.println("收到:" + recvStr);
        }
    }

}
