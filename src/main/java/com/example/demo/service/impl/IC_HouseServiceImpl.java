package com.example.demo.service.impl;

import com.example.demo.domain.IC_House;
import com.example.demo.domain.IC_HouseDetail;
import com.example.demo.domain.IC_HouseIncome;
import com.example.demo.domain.IC_HouseContract;
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

    @Override
    public int batchInsertHouseDetail(List<IC_HouseDetail> list) {
        return mapper.batchInsertHouseDetail(list);
    }

    @Override
    public IC_HouseDetail queryDetailByDetailId(Integer detailId) {
        return mapper.queryDetailByDetailId(detailId);
    }

    @Override
    public int insertContract(IC_HouseContract contract) {
        return mapper.insertContract(contract);
    }

    @Override
    public IC_HouseContract selectContractByHoseId(Integer houseId) {
        return mapper.selectContractByHoseId(houseId);
    }

    @Override
    public int updateHouseCode(IC_House ic_house) {
        return mapper.updateHouseCode(ic_house);
    }
}
