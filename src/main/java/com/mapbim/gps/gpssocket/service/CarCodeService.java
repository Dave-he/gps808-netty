package com.mapbim.gps.gpssocket.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.mapbim.gps.gpssocket.entity.data.CarCode;
import com.mapbim.gps.gpssocket.mapper.CarCodeMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Synchronized;

/**
* @Author heyongxian
* @Version v1.0
* @CreateTime 2020-12-24 13:57:57
*/
@Service
public class CarCodeService extends BaseIService<CarCodeMapper, CarCode> {

    private static String INIT_CODE = "000001";

	public CarCode getByTerminalId(String terminalId) {
        LambdaQueryWrapper<CarCode> queryWrapper = new LambdaQueryWrapper<CarCode>();
        if(StringUtils.isBlank(terminalId)){
            queryWrapper.eq(CarCode::getTerminalId, terminalId);
        }
        queryWrapper.orderByDesc(CarCode::getCode);
        List<CarCode> list = list(queryWrapper);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }else{
            return list.get(0);
        }
        
    }
    

    @Synchronized
    @Transactional
	public CarCode initCarCode(String terminalId, String carIdentifier) {
        CarCode lastCode = getByTerminalId("");
        CarCode carCode = new CarCode();
        carCode.setLicensePlate(carIdentifier);
        carCode.setTerminalId(terminalId);
        if(null != lastCode){
            carCode.setCode(String.format("%06d",Long.parseLong(lastCode.getCode()) + 1));
        }else{
            carCode.setCode(INIT_CODE);
        }
        save(carCode);
        return carCode;
	}
    
}
