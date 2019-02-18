package com.gyx.gushi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gyx.gushi.pojo.Access;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface AccessDao extends JpaRepository<Access,String>,JpaSpecificationExecutor<Access>{
	
}
