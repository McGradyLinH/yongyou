package com.example.demo.service.impl;

import com.example.demo.domain.Income;
import com.example.demo.mapper.YongyouMapper;
import com.example.demo.service.YongyouService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 * @Author: LX
 * @Date: 2021/2/23
 **/
@Service
public class YongyouServiceImpl implements YongyouService {

    @Resource
    YongyouMapper mapper;

    @Override
    public List<Income> selectAllIncome() {
        return mapper.selectAllIncome();
    }
}
