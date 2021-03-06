package com.gyx.gushi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gyx.gushi.pojo.Body;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface BodyDao extends JpaRepository<Body,String>,JpaSpecificationExecutor<Body>{
	Body findById(long id);
}
