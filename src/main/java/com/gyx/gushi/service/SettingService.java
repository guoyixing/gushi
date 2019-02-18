package com.gyx.gushi.service;

import com.gyx.gushi.dao.SettingDao;
import com.gyx.gushi.pojo.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class SettingService {

	@Autowired
	private SettingDao settingDao;


	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Setting> findAll() {
		return settingDao.findAll();
	}

	public List<Setting> getCarousel() {
		return settingDao.findBySettingType("carousel");
	}
}
