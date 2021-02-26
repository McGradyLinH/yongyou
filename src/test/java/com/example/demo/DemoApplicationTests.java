package com.example.demo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.example.demo.domain.IC_House;
import com.example.demo.domain.IC_HouseIncome;
import com.example.demo.listener.IC_HouseIncomeListener;
import com.example.demo.listener.IC_HouseListener;
import com.example.demo.mapper.IC_houseMapper;
import com.example.demo.service.IC_HouseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    IC_houseMapper mapper;

    @Autowired
    IC_HouseService service;

    @Test
    void contextLoads() {
        String fileName = "C:\\Users\\Administrator\\Desktop\\20年房租收入.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, IC_HouseIncome.class, new IC_HouseIncomeListener(service)).sheet().doRead();
    }

    @Test
    void test1(){
        List<IC_House> ic_houses = mapper.selectHouseByCompanyCode(1);
        ic_houses.forEach(System.out::println);
    }

}
