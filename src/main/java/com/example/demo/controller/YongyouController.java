package com.example.demo.controller;

import com.example.demo.domain.Income;
import com.example.demo.service.YongyouService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

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
    public Map<String, Object> getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Income> incomes = yongyouService.selectAllIncome();
        PageInfo<Income> p = new PageInfo<>(incomes);
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("data", p.getList());
        resMap.put("totalCount", p.getTotal());
        return resMap;
    }

    @GetMapping("/getIncomeList")
    public Map<String, Object> getIncomeList() {
        Map<String, Object> resMap = new HashMap<>();
        List<Income> incomes = yongyouService.selectAllIncome();
        AtomicReference<Double> incomeAmount = new AtomicReference<>(0.0);
        AtomicReference<Double> incomeMonthAmount = new AtomicReference<>(0.0);
        String nowMonth = getMonthStr(new Date());
        incomes.forEach(income -> {
            incomeAmount.updateAndGet(v -> v + income.getMc());
            if (nowMonth.equals(getMonthStr(income.getDbill_date()))) {
                incomeMonthAmount.updateAndGet(v -> v + income.getMc());
            }
        });
        resMap.put("sumAmount",incomeAmount.get());
        resMap.put("nowMonthAmount",incomeMonthAmount.get());
        return resMap;
    }

    private static String getMonthStr(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        return df.format(date);
    }
}
