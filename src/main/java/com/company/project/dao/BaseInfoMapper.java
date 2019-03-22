package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.BaseInfo;
@org.apache.ibatis.annotations.Mapper
public interface BaseInfoMapper extends Mapper<BaseInfo> {

    int deleteByCreditCode(String credit_code);
}