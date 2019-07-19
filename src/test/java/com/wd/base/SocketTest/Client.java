package com.wd.base.SocketTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",8085);
        OutputStream os = s.getOutputStream();
        new ClientThread(s).start();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String msg = scanner.nextLine()+"\r\n";
            os.write(msg.getBytes());
        }

    }

    public static void client() throws IOException {
        Socket s = new Socket("127.0.0.1",8085);
        OutputStream os = s.getOutputStream();
        InputStream is = s.getInputStream();
        String msg = "Hello World \r\n";
        os.write(msg.getBytes());
        byte[] readByte = new byte[1024];
        int readlen = 0;
        while ( (readlen = is.read(readByte)) >0 ){
            System.out.print("received msg ====" + new String(readByte,0,readlen));
        }
        os.close();
        is.close();;
        s.close();
    }

    public static class ClientThread extends Thread{
        private Socket s;
        public ClientThread(Socket s){
            this.s=s;
        }

        @Override
        public void run() {
            try {
                InputStream is = s.getInputStream();
                byte[] readByte = new byte[1024];
                int readLen = 0;
                while ( (readLen = is.read(readByte)) >0 ){
                    System.out.print("received msg ====" + new String(readByte,0,readLen));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
