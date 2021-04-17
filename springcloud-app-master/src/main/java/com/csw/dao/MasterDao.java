package com.csw.dao;

import com.csw.entity.Order_master;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

@CacheNamespace
public interface MasterDao extends Mapper<Order_master>, DeleteByIdListMapper<Order_master, String> {

}
