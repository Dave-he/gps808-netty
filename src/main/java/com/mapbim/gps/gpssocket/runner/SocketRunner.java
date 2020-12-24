package com.mapbim.gps.gpssocket.runner;

import com.mapbim.gps.gpssocket.service.GPSDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class SocketRunner implements ApplicationRunner {
    
    @Value("${socket.enabled}")
    private boolean enabled;

    @Autowired
    GPSDataService gpsDataService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(enabled){
            gpsDataService.startServerSocket(18885);
        }
        
    }
}
