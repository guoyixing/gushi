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

	public List<Story> getNewStoryTop(int top) {
		return storyDao.findTopOrderByCreateDate(top);
	}

	public Page<Story> getStoryByTypePage(String type, int page, int size) {
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return storyDao.findByStoryTypeOrderByCreateDateDesc(type,pageRequest);
	}

	public Story getById(long id) {
		return storyDao.findById(id);
	}
}
