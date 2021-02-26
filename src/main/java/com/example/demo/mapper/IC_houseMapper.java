package com.example.demo.mapper;

import com.example.demo.domain.IC_House;
import com.example.demo.domain.IC_HouseIncome;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IC_houseMapper {

    int batchInsertHouse(List<IC_House> list);

    List<IC_House> selectHouseByCompanyCode(Integer companyCode);

    int batchUpdateHouse(IC_HouseIncome houseIncome);
}
