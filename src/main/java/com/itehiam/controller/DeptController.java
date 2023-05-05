package com.itehiam.controller;

import com.itehiam.pojo.Dept;
import com.itehiam.pojo.Result;
import com.itehiam.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yishun
 * @create 2023-05-04-14:55
 */
@Slf4j
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping("/depts")
    public Result list(){
        log.info("查询部门有所数据");
        List<Dept>deptList=deptService.list();
        return Result.success(deptList);
    }
    @DeleteMapping("/depts/{id}")
    public  Result delete(@PathVariable Integer id){
        log.info("根据id删除部门");
        deptService.delete(id);
        return Result.success();
    }
    @PostMapping("/depts")
    public Result add(@RequestBody Dept  dept){
        log.info("添加部门成功");
        deptService.add(dept);
        return Result.success();
    }
}
