package com.gfl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gfl.bean.po.Job;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JobDao extends BaseMapper<Job> {
}
