package com.gyx.gushi.service;

import com.gyx.gushi.dao.TypeDao;
import com.gyx.gushi.pojo.Type;
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
public class TypeService {

	@Autowired
	private TypeDao typeDao;


	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Type> findAll() {
		return typeDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Type> findSearch(Map whereMap, int page, int size) {
		Specification<Type> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return typeDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Type> findSearch(Map whereMap) {
		Specification<Type> specification = createSpecification(whereMap);
		return typeDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Type findById(String id) {
		return typeDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param type
	 */
	public void add(Type type) {
		typeDao.save(type);
	}

	/**
	 * 修改
	 * @param type
	 */
	public void update(Type type) {
		typeDao.save(type);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		typeDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Type> createSpecification(Map searchMap) {

		return new Specification<Type>() {

			@Override
			public Predicate toPredicate(Root<Type> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("type_name")!=null && !"".equals(searchMap.get("type_name"))) {
                	predicateList.add(cb.like(root.get("type_name").as(String.class), "%"+(String)searchMap.get("type_name")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

	public Type getByTypeName(String typeName) {
		return typeDao.findByTypeName(typeName);
	}
}
