package com.mapbim.gps.gpssocket.entity.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mapbim.gps.gpssocket.entity.UIDEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
* @Author heyongxian
* @Version v1.0
* @CreateTime 2020-12-24 13:37:13
*/
@EqualsAndHashCode(callSuper = false)
@Data
@TableName("gps_car_location")
@Table(name = "gps_car_location")
@org.hibernate.annotations.Table(appliesTo = "gps_car_location", comment = "gps推送车辆位置信息")
@Entity
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@AllArgsConstructor
@NoArgsConstructor
public class CarLocation extends UIDEntity {
    
    /**
     *
     */
    private static final long serialVersionUID = 6023426268415455722L;
    @ApiModelProperty(value = "终端Id")
    @Column(columnDefinition = "varchar(255) comment '终端Id'")
    private String terminalId;
    @ApiModelProperty(value = "车牌号")
    @Column(columnDefinition = "varchar(64) comment '车牌号'")
    private String licensePlate;
    
    @ApiModelProperty(value = "纬度")
    @Column(columnDefinition = "varchar(255) comment '纬度'")
    private String lat;

    @ApiModelProperty(value = "经度")
    @Column(columnDefinition = "varchar(255) comment '经度'")
    private String lng;
    
    @ApiModelProperty(value = "高度")
    @Column(columnDefinition = "varchar(255) comment '高度'")
    private String height;

    @ApiModelProperty(value = "速度")
    @Column(columnDefinition = "varchar(255) comment '速度'")
    private String speed;

    @ApiModelProperty(value = "方向")
    @Column(columnDefinition = "varchar(255) comment '方向'")
    private String direction;

    @ApiModelProperty(value = "数据采集时间")
    @Column(columnDefinition = "varchar(255) comment '数据采集时间'")
    private String time;

    @ApiModelProperty(value = "系统接收数据时间")
    @Column(columnDefinition = "datetime comment '系统接收数据时间'")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date receiveDate = new Date();
}
