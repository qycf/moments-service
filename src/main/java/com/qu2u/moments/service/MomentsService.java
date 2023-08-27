package com.qu2u.moments.service;

import com.qu2u.moments.domain.PageResult;
import com.qu2u.moments.entity.Moments;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qu2u.moments.vo.MomentsVO;

import java.util.List;

/**
* @author qiuyue
* @description 针对表【moments】的数据库操作Service
* @createDate 2023-08-24 15:02:22
*/
public interface MomentsService extends IService<Moments> {

    PageResult<Moments> selectMomentsList(boolean isLogin, int page, int size);

}
