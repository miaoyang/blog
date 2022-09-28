package com.ym.blog.api.vo.params;

import lombok.Data;

/**
 * @Author: Yangmiao
 * @Date: 2022/8/28 18:50
 * @Desc:
 */
@Data
public class PageParams {

    private int page = 1;

    private int pageSize = 10;

    private Long categoryId;

    private Long tagId;

    private String year;

    private String month;

    public String getMonth(){
        if (this.month != null && this.month.length() == 1){
            return "0"+this.month;
        }
        return this.month;
    }

}
