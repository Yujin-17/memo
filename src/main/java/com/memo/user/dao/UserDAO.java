package com.memo.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.memo.user.model.User;

@Repository
public interface UserDAO {
	public boolean existUserByLoginId(String loginId);
	
	public User selectUserByLoginIdAndPassword(
			@Param("loginId") String loginId, 
			@Param("password") String password);
	
	public int insertUser(
			@Param("loginId") String loginId, 
			@Param("password") String password, 
			@Param("name") String name, 
			@Param("email") String email);
}
