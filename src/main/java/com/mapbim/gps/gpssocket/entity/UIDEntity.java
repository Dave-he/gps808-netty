package com.mapbim.gps.gpssocket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author heyx
 * @date 4/20/2020 5:56 PM
 */
@Data
@MappedSuperclass
public class UIDEntity implements Serializable {
    private static final long serialVersionUID = 26348042086090392L;

    @ApiModelProperty("主键Id")
    @TableId(type = IdType.ASSIGN_UUID)
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", length = 64)
    private String id;
}
