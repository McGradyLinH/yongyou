package com.example.demo.service;

import com.example.demo.domain.IC_House;
import com.example.demo.domain.IC_HouseDetail;
import com.example.demo.domain.IC_HouseIncome;
import com.example.demo.domain.IC_HouseContract;

import java.util.List;

/*
 * @Author: LX
 * @Date: 2021/2/25
 **/
public interface IC_HouseService {
    List<IC_House> selectHouseByCompanyCode(Integer companyCode);

    int batchUpdateHouse(List<IC_HouseIncome> list);

    int batchInsertHouseDetail(List<IC_HouseDetail> list);

    IC_HouseDetail queryDetailByDetailId(Integer detailId);

    int insertContract(IC_HouseContract contract);

    IC_HouseContract selectContractByHoseId(Integer houseId);

    int updateHouseCode(IC_House ic_house);
}
