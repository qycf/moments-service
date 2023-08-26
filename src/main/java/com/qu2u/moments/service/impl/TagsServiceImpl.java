package com.qu2u.moments.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qu2u.moments.entity.Tags;
import com.qu2u.moments.service.TagsService;
import com.qu2u.moments.mapper.TagsMapper;
import org.springframework.stereotype.Service;

/**
* @author qiuyue
* @description 针对表【tags】的数据库操作Service实现
* @createDate 2023-08-24 17:20:19
*/
@Service
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags>
    implements TagsService{

}




