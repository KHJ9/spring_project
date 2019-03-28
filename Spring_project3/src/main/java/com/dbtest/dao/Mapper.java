package com.dbtest.dao;

import org.apache.ibatis.annotations.Param;

public interface Mapper {

	public String primary_num(@Param("reg_id") String reg_id);
	
}
