package com.example.demo.mapper;

import com.example.demo.domain.Income;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
 * @Author: LX
 * @Date: 2021/2/23
 **/
@Mapper
public interface YongyouMapper {
    List<Income> selectAllIncome();
}
