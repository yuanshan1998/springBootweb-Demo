package com.itehiam.mapper;

import com.itehiam.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

/**
 * @author yishun
 * @create 2023-05-04-14:52
 */
@Mapper
public interface EmpMapper {
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    void insert(Emp emp);

}
