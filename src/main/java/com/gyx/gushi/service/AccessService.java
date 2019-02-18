package com.gyx.gushi.service;

import com.gyx.gushi.dao.AccessDao;
import com.gyx.gushi.pojo.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class AccessService {

	@Autowired
	private AccessDao accessDao;


	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Access> findAll() {
		return accessDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Access> findSearch(Map whereMap, int page, int size) {
		Specification<Access> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return accessDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Access> findSearch(Map whereMap) {
		Specification<Access> specification = createSpecification(whereMap);
		return accessDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Access findById(String id) {
		return accessDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param access
	 */
	public void add(Access access) {
		accessDao.save(access);
	}

	/**
	 * 修改
	 * @param access
	 */
	public void update(Access access) {
		accessDao.save(access);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		accessDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Access> createSpecification(Map searchMap) {

		return new Specification<Access>() {

			@Override
			public Predicate toPredicate(Root<Access> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("ip")!=null && !"".equals(searchMap.get("ip"))) {
                	predicateList.add(cb.like(root.get("ip").as(String.class), "%"+(String)searchMap.get("ip")+"%"));
                }
                // 
                if (searchMap.get("access_story")!=null && !"".equals(searchMap.get("access_story"))) {
                	predicateList.add(cb.like(root.get("access_story").as(String.class), "%"+(String)searchMap.get("access_story")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
