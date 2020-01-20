package com.gfl.controller;

import com.gfl.bean.DataTable;
import com.gfl.bean.po.Dept;
import com.gfl.bean.po.Emp;
import com.gfl.bean.po.Job;
import com.gfl.bean.po.Leader;
import com.gfl.bean.vo.EmpVo;
import com.gfl.service.EmpService;
import com.gfl.utils.ResponseServer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("emp")
public class EmpController {

    @Resource
    private EmpService empService;

    @RequestMapping("queryEmp")
    public DataTable queryEmp(DataTable<EmpVo> dataTable){
        empService.queryEmp(dataTable);
        return dataTable;
    }

    @RequestMapping("toAddEmp")
    public Map<String,Object> toAddEmp(){
       Map<String,Object> map=new HashMap<>();
       List<Job> jobList= empService.queryJobList();
       List<Dept> deptList=  empService.queryDeptList();
       map.put("jobList",jobList);
       map.put("deptList",deptList);
       return map;
    }

    @RequestMapping("addEmp")
    public ResponseServer addEmp(Emp emp){
        empService.addEmp(emp);
        return ResponseServer.success();
    }


    @RequestMapping("isEmpName")
    public Map<String,Object> isEmpName(Integer deptId,String empName){
      Map<String,Object> map=new HashMap<>();
      EmpVo empVo= empService.queryisEmpName(deptId,empName);
      if(empVo!=null){
          map.put("code",false);
      }else{
          map.put("code",true);
      }
      return map;
    }


    @RequestMapping("changeLeader")
    public Map<String,Object> changeLeader(Integer deptId){
        Map<String,Object> map=new HashMap<>();
        List<Leader> leaderList=  empService.queryLeaderList(deptId);
        map.put("leaderList",leaderList);
        return map;
    }

}
