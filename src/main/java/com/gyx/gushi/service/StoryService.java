package com.gyx.gushi.service;

import com.gyx.gushi.dao.StoryDao;
import com.gyx.gushi.pojo.Story;
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
public class StoryService {

	@Autowired
	private StoryDao storyDao;


	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Story> findAll() {
		return storyDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Story> findSearch(Map whereMap, int page, int size) {
		Specification<Story> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return storyDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Story> findSearch(Map whereMap) {
		Specification<Story> specification = createSpecification(whereMap);
		return storyDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Story findById(String id) {
		return storyDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param story
	 */
	public void add(Story story) {
		storyDao.save(story);
	}

	/**
	 * 修改
	 * @param story
	 */
	public void update(Story story) {
		storyDao.save(story);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		storyDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Story> createSpecification(Map searchMap) {

		return new Specification<Story>() {

			@Override
			public Predicate toPredicate(Root<Story> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
                // 
                if (searchMap.get("story_type")!=null && !"".equals(searchMap.get("story_type"))) {
                	predicateList.add(cb.like(root.get("story_type").as(String.class), "%"+(String)searchMap.get("story_type")+"%"));
                }
                // 
                if (searchMap.get("story_image")!=null && !"".equals(searchMap.get("story_image"))) {
                	predicateList.add(cb.like(root.get("story_image").as(String.class), "%"+(String)searchMap.get("story_image")+"%"));
                }
                // 
                if (searchMap.get("story_profile")!=null && !"".equals(searchMap.get("story_profile"))) {
                	predicateList.add(cb.like(root.get("story_profile").as(String.class), "%"+(String)searchMap.get("story_profile")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

	public List<Story> getNewStoryTop(int top) {
		return storyDao.findTopOrderByCreateDate(top);
	}
}
