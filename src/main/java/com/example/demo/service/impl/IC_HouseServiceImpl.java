package com.example.demo.service.impl;

import com.example.demo.domain.IC_House;
import com.example.demo.domain.IC_HouseIncome;
import com.example.demo.mapper.IC_houseMapper;
import com.example.demo.service.IC_HouseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/*
 * @Author: LX
 * @Date: 2021/2/25
 **/
@Service
public class IC_HouseServiceImpl implements IC_HouseService {
    @Resource
    IC_houseMapper mapper;

    @Override
    public List<IC_House> selectHouseByCompanyCode(Integer companyCode) {
        List<IC_House> ic_houses = mapper.selectHouseByCompanyCode(companyCode);
        ic_houses.forEach(ic_house -> {
            BigDecimal oldValue = new BigDecimal(ic_house.getOldValue());
            BigDecimal depreciationAmountOfAll = new BigDecimal(ic_house.getDepreciationAmountOfAll());
            ic_house.setDepreciationAmountRate(depreciationAmountOfAll.divide(oldValue,2, RoundingMode.HALF_UP).toString());
        });
        return ic_houses;
    }

    @Transactional
    @Override
    public int batchUpdateHouse(List<IC_HouseIncome> list) {
        list.forEach(mapper::batchUpdateHouse);
        return 1;
    }
}
