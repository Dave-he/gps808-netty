package com.mapbim.gps.gpssocket.service;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.io.Serializable;

/**
 * @author heyx
 * @date 3/31/2020 5:25 PM
 */
public abstract class BaseIService<M extends BaseMapper<T>,T> extends ServiceImpl<M, T> implements IService<T> {
    public T findById(Serializable id) {
        T t = getById(id);
        if (null == t){
            throw new IllegalArgumentException("找不到对应内容~");
        }
        return t;
    }
}
