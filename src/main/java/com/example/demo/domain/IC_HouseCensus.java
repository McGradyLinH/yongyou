package com.example.demo.domain;

import lombok.Data;

/*
 * @Author: LX
 * @Date: 2021/2/26
 **/
@Data
public class IC_HouseCensus {
    private String companyCode;
    private String companyName;
    private String oldValue;
    private String depreciationAmountOfAll;
    private String netValue;
    private String rent;
}
