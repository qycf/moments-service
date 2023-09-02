package com.qu2u.moments.mapper;

import com.qu2u.moments.entity.Images;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author qiuyue
* @description 针对表【images】的数据库操作Mapper
* @createDate 2023-08-30 09:45:33
* @Entity com.qu2u.moments.entity.Images
*/
public interface ImagesMapper extends BaseMapper<Images> {


    List<String> groupByDate();

}




