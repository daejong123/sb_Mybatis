package com.daejong.controller;

import com.daejong.entity.HouseEntity;
import com.daejong.service.HouseService;
import com.daejong.utils.ResultVoUtil;
import com.daejong.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Daejong on 2017/10/14.
 */
//@RestController
@Controller
@RequestMapping(value = "/hc")
public class HouseController {

    @Autowired
    private HouseService houseService;

    /**
     * 给前端用的api
     * 测试指定低于某价格
     * 分页查询
     * 指定page
     * 指定count
     */
    @GetMapping(value = "/all/{price}/{page}/{count}")
    @ResponseBody
    public ResultVO getInfo(@PathVariable("price") String price, @PathVariable("page") Integer page, @PathVariable("count") Integer count) {
        //注意对pageHelper的定义必须写在select之前, 否则不起作用
        PageHelper.startPage(page, count);
        List<HouseEntity> houseEntityList = houseService.findLessThanPrice(new BigDecimal(price));
        PageInfo<HouseEntity> pageInfo = new PageInfo<>(houseEntityList);
        return ResultVoUtil.success(pageInfo.getList());
    }

    /**
     * 给前端用的api
     * 查询所有数据
     */
    @GetMapping(value = "/all")
    @ResponseBody
    public ResultVO getAll() {
        List<HouseEntity> houseEntityList = houseService.findAll();
        return ResultVoUtil.success(houseEntityList);
    }

    /**
     * 仅用来测试freemarker的hello.html
     */
    @GetMapping(value = "/hello")
    public String hello(Model model) {
        List<HouseEntity> all = houseService.findAll();
        model.addAttribute("list", all);
        return "hello";
    }

    /**
     * 给后台管理人员访问
     * 带分页查询功能的page.html
     */
    @GetMapping(value = "/page")
    public ModelAndView selectPageHelper(@RequestParam(value = "page", defaultValue = "1") Integer page, ModelAndView modelAndView) {
        PageHelper.startPage(page, 10);
        List<HouseEntity> houseEntityList = houseService.findAll();
        PageInfo<HouseEntity> pageInfo = new PageInfo<>(houseEntityList);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.addObject("list", houseEntityList);
        modelAndView.setViewName("page");
        return modelAndView;
    }
}
