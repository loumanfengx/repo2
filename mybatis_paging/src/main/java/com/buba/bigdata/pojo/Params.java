package com.buba.bigdata.pojo;

/**
 * @ClassName: Params
 * @Description: TODO
 * @Author: Kang Jianhang
 * @Date: 2020/7/23 16:19
 * @Version: v1.0
 */

/**
 *
 * Params
 * @author krry
 * @version 1.0.0
 *
 */
public class Params {

    private Integer pageSize = 10;
    private Integer pageNo = 0;


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
