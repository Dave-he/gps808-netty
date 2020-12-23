package com.mapbim.gps.gpssocket.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.mapbim.gps.gpssocket.entity.data.GPSData;
import com.mapbim.gps.gpssocket.mapper.GPSDataMapper;

import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Service
@Log
public class GPSDataService extends BaseIService<GPSDataMapper, GPSData> {

    private ServerSocket serverSocket;

    public void startServerSocket(int port){
        try{
            int count = 0;
            serverSocket = new ServerSocket(port);
            log.info("socket start on port: " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket,this);
                serverThread.start();
                count ++;
                log.info("the client num is:" + count);
                InetAddress address = socket.getInetAddress();
                log.info("the IP of this client is: " + address.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stopServerSocket(){
        if (serverSocket != null){
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
