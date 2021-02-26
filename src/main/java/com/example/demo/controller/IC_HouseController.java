package com.example.demo.controller;

import com.example.demo.domain.IC_House;
import com.example.demo.domain.IC_HouseCensus;
import com.example.demo.service.IC_HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * @Author: LX
 * @Date: 2021/2/24
 **/
@RestController
@RequestMapping("/houses")
public class IC_HouseController {

    @Autowired
    private IC_HouseService houseService;

    @GetMapping("/{companyCode}")
    public List<IC_House> getHouses(@PathVariable Integer companyCode){
        return houseService.selectHouseByCompanyCode(companyCode);
    }

    /**
     * 每个公司的统计
     * @return
     */
    @GetMapping("/census")
    public List<IC_HouseCensus> census(){
        Map<String,Object> oldValueMap = new HashMap<>(4);
        Map<String,Object> depreciationAmountOfAllMap = new HashMap<>(4);
        Map<String,Object> rentMap = new HashMap<>(4);
        Map<String,Object> netValueMap = new HashMap<>(4);
        List<IC_House> ic_houses = houseService.selectHouseByCompanyCode(null);
        ic_houses.forEach(ic_house -> {
            //所有的原值
            oldValueMap.merge(ic_house.getCompanyCode().toString(),ic_house.getOldValue(), IC_HouseController::strAdd);
            depreciationAmountOfAllMap.merge(ic_house.getCompanyCode().toString(),ic_house.getDepreciationAmountOfAll(), IC_HouseController::strAdd);
            rentMap.merge(ic_house.getCompanyCode().toString(),ic_house.getIc_houseIncome().getRent(), IC_HouseController::strAdd);
            netValueMap.merge(ic_house.getCompanyCode().toString(),ic_house.getNetValue(), IC_HouseController::strAdd);
        });
        List<IC_HouseCensus> list = new ArrayList<>(4);
        oldValueMap.forEach((key,value) ->{
            IC_HouseCensus icHouseCensus = new IC_HouseCensus();
            icHouseCensus.setCompanyCode(key);
            icHouseCensus.setCompanyName(getCompanyName(key));
            icHouseCensus.setNetValue(netValueMap.get(key).toString());
            icHouseCensus.setDepreciationAmountOfAll(depreciationAmountOfAllMap.get(key).toString());
            icHouseCensus.setRent(rentMap.get(key).toString());
            icHouseCensus.setOldValue(oldValueMap.get(key).toString());
            list.add(icHouseCensus);
        });
        return list;
    }

    private static Object strAdd(Object o, Object o1) {
        return new BigDecimal(o.toString()).add(new BigDecimal(o1.toString())).toString();
    }

    private static String getCompanyName(String code){
        switch (code){
            case "1":
                return "慧鹰";
            case "2":
                return "隆信";
            case "3":
                return "捷创";
            case "4":
                return "博古";
            default:
                return "";
        }
    }
}
