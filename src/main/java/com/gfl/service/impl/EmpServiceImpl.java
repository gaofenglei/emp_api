package com.gfl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gfl.bean.DataTable;
import com.gfl.bean.po.Dept;
import com.gfl.bean.po.Emp;
import com.gfl.bean.po.Job;
import com.gfl.bean.po.Leader;
import com.gfl.bean.vo.EmpVo;
import com.gfl.dao.*;
import com.gfl.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpDao empDao;
    @Resource
    private EmpVoDao empVoDao;
    @Resource
    private JobDao jobDao;
    @Resource
    private DeptDao deptDao;
    @Resource
    private LeaderDao leaderDao;

    @Override
    public void queryEmp(DataTable<EmpVo> dataTable) {
        Long count=empVoDao.queryEmpCount();
        dataTable.setRecordsTotal(count);
        dataTable.setRecordsFiltered(count);
        List<EmpVo> empVoList=empVoDao.queryEmpList(dataTable);
        dataTable.setData(empVoList);
    }

    @Override
    public List<Job> queryJobList() {
        return jobDao.selectList(null);
    }

    @Override
    public List<Dept> queryDeptList() {
        return deptDao.selectList(null);
    }

    @Override
    public List<Leader> queryLeaderList(Integer deptId) {
        QueryWrapper<Leader> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("deptId",deptId);
        return leaderDao.selectList(queryWrapper);
    }

    @Override
    public void addEmp(Emp emp) {
        empDao.insert(emp);
    }

    @Override
    public EmpVo queryisEmpName(Integer deptId, String empName) {
        EmpVo empVo = empVoDao.queryisEmpName(deptId, empName);
        return empVo;
    }

    @Override
    public void deleteEmp(Integer id) {
        QueryWrapper<EmpVo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        empVoDao.delete(queryWrapper);
    }

    @Override
    public List<Emp> queryEmpAll() {
        return empVoDao.queryEmpAll();
    }

    @Override
    public Emp getEmpById(Integer id) {
        QueryWrapper<Emp> queryWrapper=new QueryWrapper<Emp>();
        queryWrapper.eq("id",id);
        return empDao.selectOne(queryWrapper);
    }

    @Override
    public void updateEmp(Emp emp) {
        empDao.updateById(emp);
    }

}
