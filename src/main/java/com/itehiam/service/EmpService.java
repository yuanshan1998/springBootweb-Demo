package com.itehiam.service;

import com.itehiam.pojo.Emp;
import com.itehiam.pojo.PageBean;
import org.apache.ibatis.annotations.Insert;

import java.time.LocalDate;

/**
 * @author yishun
 * @create 2023-05-04-14:54
 */
public interface EmpService {

    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime});")
    void  save (Emp emp);
}
