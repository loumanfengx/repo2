package com.buba.bigdata.controller;

import com.buba.bigdata.pojo.Page;
import com.buba.bigdata.pojo.Params;
import com.buba.bigdata.pojo.User;
import com.buba.bigdata.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: Kang Jianhang
 * @Date: 2020/7/23 15:10
 * @Version: v1.0
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    /*@RequestMapping("/user")
    public String findAll(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("users", userList);
        return "user/userlist";
    }*/
    /**
     * 用户首页，并且分页查询
     * @return
     */

    @RequestMapping("/user")
    @ResponseBody
    public Map<String, Object> index(HttpServletRequest req, HttpServletResponse resp, Page page, Model model){
        //接收页面传过来的查询页码
        String pages = req.getParameter("page");
        //接收页面传过来的每个页面显示的数据条数
        String limit = req.getParameter("limit");
        //存入查询的页码
        page.setFromPage(Integer.parseInt(pages));
        //存入每页显示的数据条数
        page.setPageLimit(Integer.parseInt(limit));
        //调用UserServiceImpl层finds方法并接收返回值
        PageInfo<User> userPageInfo = userService.finds(page);
        Map<String, Object> map = new HashMap<>();
        map.put("users", userPageInfo);
        map.put("status", 0);
        map.put("message", "");
        return map;

    }

}
