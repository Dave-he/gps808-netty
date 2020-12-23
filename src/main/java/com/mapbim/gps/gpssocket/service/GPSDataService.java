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

    //0100002D013202012211000200000000373138303100000000000000000000000000000000000000003133323032303101BADA524D323231315F

    // 0100 00 2D 0 13202012211 00 02 00 0000 0037313830310 0000000000000000000000000000 000000000003133323032303101 BA DA524D 32323131 5F
    //  0000 0000 0 010 1101
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
