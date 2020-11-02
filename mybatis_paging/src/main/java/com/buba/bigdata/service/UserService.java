package com.buba.bigdata.service;

import com.buba.bigdata.pojo.Page;
import com.buba.bigdata.pojo.Params;
import com.buba.bigdata.pojo.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Author: Kang Jianhang
 * @Date: 2020/7/23 15:13
 * @Version: v1.0
 */
public interface UserService {
    /**
       * 分页查询
       * @param page 分页参数 fromPage（页码），pageLimit（每页查询数目）
       * @return
       */
    public PageInfo<User> finds(Page page);

}
