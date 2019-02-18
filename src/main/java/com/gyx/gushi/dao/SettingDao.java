package com.gyx.gushi.dao;

import com.gyx.gushi.pojo.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface SettingDao extends JpaRepository<Setting,String>,JpaSpecificationExecutor<Setting>{
    List<Setting> findBySettingType(String type);
}
