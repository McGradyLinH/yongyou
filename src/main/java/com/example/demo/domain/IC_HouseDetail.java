package com.example.demo.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author LX
 * @date 2021年3月8日15:26:34
 */
@Data
public class IC_HouseDetail {
    private Integer id;
    /**
     * 土地使用证号
     */
    @ExcelProperty("土地使用证号")
    private String tdsyzh;
    /**
     * 房屋所有权证号
     */
    @ExcelProperty("房屋所有权证号")
    private String fwsyqzh;
    /**
     *  购买合同编号
     */
    @ExcelProperty("购房合同编号")
    private String gmhtbh;
    /**
     *  区域
     */
    @ExcelProperty("区域")
    private String qy;
    /**
     *  房屋坐落
     */
    @ExcelProperty("房屋坐落")
    private String fwzl;
    /**
     *  购买日期
     */
    @ExcelProperty("资产登记日")
    private String gmrq;
    /**
     *  规划用途
     */
    @ExcelProperty("规划用途")
    private String ghyt;
    /**
     *  开发商
     */
    @ExcelProperty("开发商")
    private String kfs;
    /**
     *  总层数
     */
    @ExcelProperty("总层数")
    private String zcs;
    /**
     *  建筑面积（平方米 ）
     */
    @ExcelProperty("建筑面积（平方米 ）")
    private String jzmj;
    /**
     *  套内建筑面积（平方米）
     */
    @ExcelProperty("套内建筑面积（平方米）")
    private String tnjzmj;
    /**
     *  土地使用终止期
     */
    @ExcelProperty("土地使用终止期")
    private String tdsyzzq;
    /**
     *  使用权面积（平方米）
     */
    @ExcelProperty("使用权面积（平方米）")
    private String syqmj;

}
