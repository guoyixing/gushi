package com.gyx.gushi.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gyx.gushi.pojo.Story;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface StoryDao extends JpaRepository<Story, String>, JpaSpecificationExecutor<Story> {
    @Query(value = "SELECT * FROM story ORDER BY create_date DESC limit ?1 ", nativeQuery = true)
    List<Story> findTopOrderByCreateDate(int top);

    Page<Story> findByStoryTypeOrderByCreateDateDesc(String type, Pageable pageable);

    Story findById(Long id);
}
