package com.wd.base.SocketTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Server {

    private ServerSocket serverSocket;
    private Map<Integer,Socket> clientMap;
    private String path;

    public Server() throws IOException {
        serverSocket = new ServerSocket(8085);
        clientMap = new HashMap<>();
    }

    public void startServer() throws IOException {
        while(true) {
            Socket client = serverSocket.accept();
            clientMap.put(client.hashCode(),client);
            new ServerClientThread(this,client).start();
        }
    }
    public void sendAllClient(String msg) throws IOException {
        Iterator iterator = clientMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            Socket s = (Socket)entry.getValue();
            OutputStream os = s.getOutputStream();
            os.write(msg.getBytes());
        }
    }
}
