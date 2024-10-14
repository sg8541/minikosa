package com.kosa.mini.service.admin;

import mybatis.dao.ExMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ExServiceImpl implements ExService{

    @Autowired
    ExMapper dao;
}
