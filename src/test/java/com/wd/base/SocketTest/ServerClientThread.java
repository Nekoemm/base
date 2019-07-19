package com.wd.base.SocketTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClientThread extends Thread {
    private Socket client;
    private Server server;

    public ServerClientThread(Server server,Socket client){
        this.server = server;
        this.client = client;
    }
    @Override
    public void run() {
        try {
            InputStream is = client.getInputStream();
            OutputStream os = client.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(os));
            String readStr = null;
            while ((readStr = reader.readLine()) != null) {
                server.sendAllClient(readStr);
//                System.out.print(readStr);
//                writer.println("read" + readStr + "successed");
//                writer.flush();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
