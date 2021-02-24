package com.example.demo.controller;

import com.example.demo.domain.Income;
import com.example.demo.service.YongyouService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: LX
 * @Date: 2021/2/23
 **/
@RestController
@RequestMapping("/yongyou")
public class YongyouController {

    @Autowired
    private YongyouService yongyouService;

    @GetMapping
    public Map<String,Object> getAll(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Income> incomes = yongyouService.selectAllIncome();
        PageInfo<Income> p = new PageInfo<>(incomes);
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("data",p.getList());
        resMap.put("totalCount",p.getTotal());
        return resMap;
    }
}
