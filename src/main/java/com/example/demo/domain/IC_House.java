package com.example.demo.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/*
 * @Author: LX
 * @Date: 2021/2/24
 **/
@Data
public class IC_House {
    private Integer id;

    @ExcelProperty("卡片编号")
    private String cardCode;

    @ExcelProperty("资产编号")
    private String assetCode;

    @ExcelProperty("资产名称")
    private String assetName;

    @ExcelProperty("原值")
    private String oldValue;

    @ExcelProperty("本月计提折旧额")
    private String depreciationAmountOfMonth;

    @ExcelProperty("本年折旧")
    private String depreciationAmountOfYear;

    @ExcelProperty("累计折旧")
    private String depreciationAmountOfAll;

    @ExcelProperty("'净值")
    private String netValue;

    private Integer companyCode;

    private IC_HouseIncome ic_houseIncome;
    /**
     * 详细信息id
     */
    private Integer detailId;

    //折旧率
    private String depreciationAmountRate;

    private String housecode;

    private boolean editFlag;

}
