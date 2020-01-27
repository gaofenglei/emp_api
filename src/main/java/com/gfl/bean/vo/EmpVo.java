package com.gfl.bean.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gfl.excels.ExcelField;
import com.gfl.excels.ExcelTitle;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("t_emp")
@ExcelTitle(title = "员工信息")
public class EmpVo {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;//	int
    @ExcelField(fieldName = "员工名称")
    @TableField("empName")
    private String empName;
    @TableField("jobId")
    private Integer jobId;//	int
    @ExcelField(fieldName = "薪资")
    @TableField("salary")
    private BigDecimal salary;//	bigint
    @ExcelField(fieldName = "入职时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("entryTime")
    private Date entryTime;//	datetime
    @TableField("leaderId")
    private Integer leaderId;//	int
    @TableField("deptId")
    private Integer deptId;//	int
    @ExcelField(fieldName = "岗位名称")
    private String jobName;
    @ExcelField(fieldName = "部门名称")
    private String deptName;
    @ExcelField(fieldName = "领导名称")
    private String leaderName;

}
