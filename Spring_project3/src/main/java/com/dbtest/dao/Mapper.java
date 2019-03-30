package com.dbtest.dao;

import org.apache.ibatis.annotations.Param;

public interface Mapper {

	public String get_notice(@Param("register") String reg_id);
	
}
