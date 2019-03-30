package com.dbtest.dao;

import org.apache.ibatis.annotations.Param;
import java.util.*;

public interface Mapper {

	//public String get_notice(@Param("register") String reg_id);
	public List<Map> get_notice();
	public List<Map> get_news();
	public List<Map> get_event();
	
}
