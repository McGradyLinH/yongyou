package com.example.demo.service;

import com.example.demo.domain.IC_House;
import com.example.demo.domain.IC_HouseIncome;

import java.util.List;

/*
 * @Author: LX
 * @Date: 2021/2/25
 **/
public interface IC_HouseService {
    List<IC_House> selectHouseByCompanyCode(Integer companyCode);

    int batchUpdateHouse(List<IC_HouseIncome> list);
}
