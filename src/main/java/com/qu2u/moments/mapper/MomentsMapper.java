package com.qu2u.moments.mapper;

import com.qu2u.moments.entity.Moments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author qiuyue
 * @description 针对表【moments】的数据库操作Mapper
 * @createDate 2023-08-24 15:02:22
 * @Entity com.qu2u.moments.entity.Moments
 */
public interface MomentsMapper extends BaseMapper<Moments> {

    List<Object> selectMomentsList();

}




