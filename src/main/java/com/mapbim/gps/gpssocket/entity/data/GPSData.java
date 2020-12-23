package com.mapbim.gps.gpssocket.entity.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mapbim.gps.gpssocket.entity.UIDEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * heyx
 */
@EqualsAndHashCode(callSuper = false)
@Data
@TableName("gps_data")
@Table(name = "gps_data")
@org.hibernate.annotations.Table(appliesTo = "gps_data", comment = "接收数据")
@Entity
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class GPSData extends UIDEntity{

    private static final long serialVersionUID = 423153219735635101L;

    @ApiModelProperty(value = "测点编号")
    @Column(columnDefinition = "varchar(64) comment '测点编号'")
    private String sensorCode;

    @Lob
    @ApiModelProperty(value = "测量值")
    @Column(columnDefinition = "varchar(255) comment '测量值'")
    private String value;

    @ApiModelProperty(value = "测量值状态")
    @Column(columnDefinition = "varchar(255) comment '测量值状态'")
    private String status;

    @ApiModelProperty(value = "多值详细测量值状态")
    @Column(columnDefinition = "varchar(255) comment '多值详细测量值状态'")
    private String valueStatus;

    @ApiModelProperty(value = "采集数据时间")
    @Column(columnDefinition = "datetime comment '采集数据时间'")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date createDate;

    @ApiModelProperty(value = "系统接收数据时间")
    @Column(columnDefinition = "datetime comment '系统接收数据时间'")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date receiveDate = new Date();
}