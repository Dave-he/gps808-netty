package com.mapbim.gps.gpssocket.service;

import java.io.*;
import java.net.Socket;

import com.mapbim.gps.gpssocket.entity.data.GpsData;

/**
 * @description:
 * @author: heyx
 * @create: 2019-04-24 10:01
 * @email; 1064042411@qq.com
 */
public class ServerThread extends Thread{

    private Socket socket = null;

    private GPSDataService gpsDataService = null;

    public ServerThread(Socket socket, GPSDataService gpsDataService) {
        this.socket = socket;
        this.gpsDataService = gpsDataService;
    }

    @Override
    public void run() {
        PrintWriter pw = null;
        InputStreamReader isr = null;
        OutputStream os = null;
        BufferedReader br = null;
        String info = null;
        try {
            isr = new InputStreamReader(socket.getInputStream());
            br = new BufferedReader(isr);
            while ((info = br.readLine()) != null) {
                System.out.println(info);
                GpsData gpsData = new GpsData();
                gpsData.setValue(info);
                gpsData.setValueStatus("1");
                gpsDataService.save(gpsData);
            }
            socket.shutdownInput();

            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎您!");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != pw) {
                    pw.close();
                }
                if (null != os) {
                    os.close();
                }
                if (null != br) {
                    br.close();
                }

                if (null != socket) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
