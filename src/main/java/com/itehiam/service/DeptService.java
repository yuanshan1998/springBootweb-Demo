package com.itehiam.service;

import com.itehiam.pojo.Dept;

import java.util.List;

/**
 * @author yishun
 * @create 2023-05-04-14:52
 */
public interface DeptService {
    List<Dept>list();

    void  delete(Integer id);

    void  add(Dept dept);
}
