package com.gfl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gfl.bean.po.Emp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpDao extends BaseMapper<Emp> {
}
