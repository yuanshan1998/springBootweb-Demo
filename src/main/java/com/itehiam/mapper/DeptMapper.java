package com.itehiam.mapper;

import com.itehiam.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yishun
 * @create 2023-05-04-14:52
 */
@Mapper
public interface DeptMapper {

@Select("select id,name,create_time,update_time from dept")
    List<Dept> list();
   @Delete("delete from dept where id=#{id}")
    void deleteById(Integer id);
    @Insert("insert into dept (name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

}
