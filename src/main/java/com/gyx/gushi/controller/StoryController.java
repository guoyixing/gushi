package com.gyx.gushi.controller;

import com.gyx.gushi.pojo.Setting;
import com.gyx.gushi.pojo.Story;
import com.gyx.gushi.service.SettingService;
import com.gyx.gushi.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 控制器层
 *
 * @author Administrator
 */
@Controller
public class StoryController {

    @Autowired
    private SettingService settingService;
    @Autowired
    private StoryService storyService;


    /**
     * 首页访问
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        //获取轮播图
        List<Setting> carousels = settingService.getCarousel();
        //获取最新的10个故事
        List<Story> newStories = storyService.getNewStoryTop(10);
        mv.addObject("newStories", newStories);
        mv.addObject("carousels", carousels);
        return mv;
    }

    /**
     * 故事列表
     */
    @RequestMapping(value = "/list/{type}", method = RequestMethod.GET)
    public ModelAndView list(@PathVariable String type) {
        ModelAndView mv = new ModelAndView("list");
        return mv;
    }
}
