package com.gfl.bean.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_leader")
public class Leader {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("leaderName")
    private String leaderName;
    @TableField("deptId")
    private Integer deptId;

}
