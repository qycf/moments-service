package com.qu2u.moments.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageResult<T> {

    private List<T> rows;//当前页结果
    private long total;//总记录数
    private long page;//当前页
    private long size;//页面大小
    private long totalPage;//总页数

}
