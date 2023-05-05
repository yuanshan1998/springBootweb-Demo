package com.itehiam.controller;

import com.itehiam.pojo.Emp;
import com.itehiam.pojo.PageBean;
import com.itehiam.pojo.Result;
import com.itehiam.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * @author yishun
 * @create 2023-05-04-14:56
 */
@Service
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {

        log.info("分页查询，参数：{},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    @PostMapping
    /*
    * @RequestBody: 用于接收前端传递给后端的json字符串中的数据的(请求体中的数据的);
    *              GET方式无请求体，所以使用@RequestBody接收数据时，前端不能使用GET方式提交数据;
    *             @RequestBody接收数据时，要求请求的Content-Type为application/json;
    *            使用@RequestBody接收数据时，必须使用POST方式提交数据，因为@RequestBody接收数据时，需要将数据封装到请求体中，GET方式没有请求体;
    *
     */
    public Result save(@RequestBody Emp emp) {  //添加员工
        //记录日志
        log.info("新增员工, emp:{}", emp);
        //调用业务层新增功能
        empService.save(emp);
        //响应
        return Result.success();
    }
}
