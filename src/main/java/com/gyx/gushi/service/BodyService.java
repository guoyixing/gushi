package com.gyx.gushi.service;

import com.gyx.gushi.dao.BodyDao;
import com.gyx.gushi.pojo.Body;
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
public class BodyService {

	@Autowired
	private BodyDao bodyDao;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Body> findAll() {
		return bodyDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Body> findSearch(Map whereMap, int page, int size) {
		Specification<Body> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return bodyDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Body> findSearch(Map whereMap) {
		Specification<Body> specification = createSpecification(whereMap);
		return bodyDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Body findById(String id) {
		return bodyDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param body
	 */
	public void add(Body body) {
		bodyDao.save(body);
	}

	/**
	 * 修改
	 * @param body
	 */
	public void update(Body body) {
		bodyDao.save(body);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		bodyDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Body> createSpecification(Map searchMap) {

		return new Specification<Body>() {

			@Override
			public Predicate toPredicate(Root<Body> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("story_body")!=null && !"".equals(searchMap.get("story_body"))) {
                	predicateList.add(cb.like(root.get("story_body").as(String.class), "%"+(String)searchMap.get("story_body")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

	public Body getByStoryBodyId(Long storyBodyId) {
		return bodyDao.findById(storyBodyId);
	}
}
