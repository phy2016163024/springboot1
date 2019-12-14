package com.springboot.mapper;

import com.springboot.po.Clazz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface Clazzmapper {
    public List<Clazz>findAll();
}
