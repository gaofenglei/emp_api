package com.gfl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gfl.bean.DataTable;
import com.gfl.bean.po.Emp;
import com.gfl.bean.vo.EmpVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpVoDao extends BaseMapper<EmpVo> {
    Long queryEmpCount();

    List<EmpVo> queryEmpList(DataTable<EmpVo> dataTable);

    EmpVo  queryisEmpName(@Param("deptId") Integer deptId,@Param("empName") String empName);

    List<Emp> queryEmpAll();
}
