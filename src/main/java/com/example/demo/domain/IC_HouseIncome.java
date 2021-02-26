package com.example.demo.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/*
 * @Author: LX
 * @Date: 2021/2/25
 **/
@Data
public class IC_HouseIncome {

    @ExcelProperty("房屋")
    private String assetName;

    @ExcelProperty("2020年租金")
    private String rent = "0";

    @ExcelProperty("不含税收入")
    private String rentExcludingTax = "0";

    @ExcelProperty("税金")
    private String tax = "0";
}
