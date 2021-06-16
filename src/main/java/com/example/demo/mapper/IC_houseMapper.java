package com.example.demo.mapper;

import com.example.demo.domain.IC_House;
import com.example.demo.domain.IC_HouseDetail;
import com.example.demo.domain.IC_HouseIncome;
import com.example.demo.domain.IC_HouseContract;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IC_houseMapper {

    int batchInsertHouse(List<IC_House> list);

    List<IC_House> selectHouseByCompanyCode(Integer companyCode);

    int batchUpdateHouse(IC_HouseIncome houseIncome);

    int batchInsertHouseDetail(List<IC_HouseDetail> list);

    IC_HouseDetail queryDetailByDetailId(Integer detailId);

    int insertContract(IC_HouseContract contract);

    IC_HouseContract selectContractByHoseId(Integer houseId);

    int updateHouseCode(IC_House ic_house);
}
