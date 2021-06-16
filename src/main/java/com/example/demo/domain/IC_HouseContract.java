package com.example.demo.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author LX
 * @date 2021/3/10
 */
@Data
public class IC_HouseContract {

    private Integer id;
    private Date expireDate;
    private String contractCode;
    private Integer houseId;

}
