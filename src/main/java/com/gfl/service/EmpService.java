package com.gfl.service;

import com.gfl.bean.DataTable;
import com.gfl.bean.po.Dept;
import com.gfl.bean.po.Emp;
import com.gfl.bean.po.Job;
import com.gfl.bean.po.Leader;
import com.gfl.bean.vo.EmpVo;

import java.util.List;

public interface EmpService {
    
    void queryEmp(DataTable<EmpVo> dataTable);

    List<Job> queryJobList();

    List<Dept> queryDeptList();

    List<Leader> queryLeaderList(Integer deptId);

    void addEmp(Emp emp);

    EmpVo queryisEmpName(Integer deptId, String empName);
}
