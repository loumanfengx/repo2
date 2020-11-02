package com.buba.bigdata.service.impl;

import com.buba.bigdata.mapper.UserMapper;
import com.buba.bigdata.pojo.Page;
import com.buba.bigdata.pojo.Params;
import com.buba.bigdata.pojo.User;
import com.buba.bigdata.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @Author: Kang Jianhang
 * @Date: 2020/7/23 15:13
 * @Version: v1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 查询
     */
    public PageInfo<User> finds(Page page) {
        //引入PageHelper分页插件
        PageHelper.startPage(page.getFromPage(), page.getPageLimit());
        List<User> userList = userMapper.finds();
        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        //封装了详细的分页信息，包括我们查询出来的数据，传入连续显示的页数
        PageInfo pageInfo = new PageInfo(userList);
        //用PageInfo对结果进行包装
        return pageInfo;
    }

}
