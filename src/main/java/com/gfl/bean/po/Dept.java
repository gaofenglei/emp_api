package com.gfl.bean.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_dept")
public class Dept {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("deptName")
    private String deptName;
}
