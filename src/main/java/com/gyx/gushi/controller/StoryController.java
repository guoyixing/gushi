package com.gyx.gushi.controller;

import com.gyx.gushi.pojo.Body;
import com.gyx.gushi.pojo.Setting;
import com.gyx.gushi.pojo.Story;
import com.gyx.gushi.pojo.Type;
import com.gyx.gushi.service.BodyService;
import com.gyx.gushi.service.SettingService;
import com.gyx.gushi.service.StoryService;
import com.gyx.gushi.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    private TypeService typeService;
    @Autowired
    public BodyService bodyService;


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
    public ModelAndView list(@PathVariable String type
            , @RequestParam(defaultValue = "1") int page
            , @RequestParam(defaultValue = "10") int size) {
        ModelAndView mv = new ModelAndView("list");
        Page<Story> stories = storyService.getStoryByTypePage(type, page, size);
        Type storyType = typeService.getByTypeName(type);
        mv.addObject("stories", stories.getContent());
        mv.addObject("totalPages", stories.getTotalPages());
        mv.addObject("page", page);
        mv.addObject("type", storyType);
        return mv;
    }

    /**
     * 阅读故事
     */
    @RequestMapping(value = "/readStory/{id}", method = RequestMethod.GET)
    public ModelAndView readStory(@PathVariable long id) {
        ModelAndView mv = new ModelAndView("readStory");
        Story story = storyService.getById(id);
        Body body = bodyService.getByStoryBodyId(story.getStoryBodyId());
        mv.addObject("story", story);
        mv.addObject("body", body);
        return mv;
    }
}
