package com.dbtest.dao;

import org.apache.ibatis.annotations.Param;

public interface Mapper {

	public String memberId(@Param("num") String num);
	
}
