package com.dbtest.dao;

import org.apache.ibatis.annotations.Param;
import java.util.*;

public interface Mapper {

	//public String get_notice(@Param("register") String reg_id);
	public Map get_notice();
	public Map get_news();
	public Map get_event();
	
}
