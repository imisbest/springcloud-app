package com.csw.dao;

import com.csw.entity.Product_info;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

@CacheNamespace
public interface IntoDao extends Mapper<Product_info>, DeleteByIdListMapper<Product_info, String> {

}
