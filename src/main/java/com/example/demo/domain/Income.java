package com.example.demo.domain;

import lombok.Data;

import java.util.Date;

/*
 * @Author: LX
 * @Date: 2021/2/23
 **/
@Data
public class Income {
    private Date dbill_date;
    private String cdigest;
    private Double mc;
    private String citemname;
}
