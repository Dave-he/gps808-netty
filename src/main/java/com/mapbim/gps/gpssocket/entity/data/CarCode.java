package com.mapbim.gps.gpssocket.entity.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mapbim.gps.gpssocket.entity.UIDEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* @Author heyongxian
* @Version v1.0
* @CreateTime 2020-12-24 09:23:58
*/
@EqualsAndHashCode(callSuper = false)
@Data
@TableName("gps_car_code")
@Table(name = "gps_car_code")
@org.hibernate.annotations.Table(appliesTo = "gps_car_code", comment = "gps推送车辆鉴权码")
@Entity
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class CarCode extends UIDEntity{
    /**
     *
     */
    private static final long serialVersionUID = -3423536784572200631L;

    @ApiModelProperty(value = "车牌号")
    @Column(columnDefinition = "varchar(64) comment '车牌号'")
    private String licensePlate;
    
    @ApiModelProperty(value = "鉴权码")
    @Column(columnDefinition = "varchar(255) comment '鉴权码'")
    private String code;

    @ApiModelProperty(value = "终端号")
    @Column(columnDefinition = "varchar(64) comment '终端号'")
    private String terminalId;
}
