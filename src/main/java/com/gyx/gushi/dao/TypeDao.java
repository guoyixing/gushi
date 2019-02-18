package com.gyx.gushi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gyx.gushi.pojo.Type;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface TypeDao extends JpaRepository<Type,String>,JpaSpecificationExecutor<Type>{
	
}
