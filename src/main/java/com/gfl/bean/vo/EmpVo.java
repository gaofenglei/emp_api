package com.gfl.bean.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("t_emp")
public class EmpVo {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;//	int
    @TableField("empName")
    private String empName;
    @TableField("jobId")
    private Integer jobId;//	int
    @TableField("salary")
    private BigDecimal salary;//	bigint
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("entryTime")
    private Date entryTime;//	datetime
    @TableField("leaderId")
    private Integer leaderId;//	int
    @TableField("deptId")
    private Integer deptId;//	int
    private String jobName;
    private String deptName;
    private String leaderName;

}
