package com.qu2u.moments.mapper;

import com.qu2u.moments.entity.Tags;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author qiuyue
* @description 针对表【tags】的数据库操作Mapper
* @createDate 2023-08-24 17:20:19
* @Entity com.qu2u.moments.entity.Tags
*/
public interface TagsMapper extends BaseMapper<Tags> {

    List<Tags> selectMomentsTagsList(Integer id);
}




