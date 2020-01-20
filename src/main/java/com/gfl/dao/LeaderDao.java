package com.gfl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gfl.bean.po.Leader;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LeaderDao extends BaseMapper<Leader> {
}
