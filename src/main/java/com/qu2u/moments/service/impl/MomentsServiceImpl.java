package com.qu2u.moments.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qu2u.moments.domain.PageResult;
import com.qu2u.moments.entity.Moments;
import com.qu2u.moments.entity.Tags;
import com.qu2u.moments.mapper.TagsMapper;
import com.qu2u.moments.service.MomentsService;
import com.qu2u.moments.mapper.MomentsMapper;
import com.qu2u.moments.vo.MomentsVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qiuyue
 * @description 针对表【moments】的数据库操作Service实现
 * @createDate 2023-08-24 15:02:22
 */
@Service
public class MomentsServiceImpl extends ServiceImpl<MomentsMapper, Moments>
        implements MomentsService {


    @Resource
    private TagsMapper tagsMapper;

    @Override
    public PageResult<MomentsVO> selectMomentsList(boolean isLogin, int page, int size) {
        List<Moments> momentsList = new ArrayList<>();
        IPage<Moments> momentsPage = new Page<>(page, size);
        if (!isLogin) {
            LambdaQueryWrapper<Moments> isPublish = new LambdaQueryWrapper<Moments>().eq(Moments::getIsPublish, 1);
            momentsList = this.list(momentsPage, isPublish);
        } else {
            momentsList = this.list(momentsPage);
        }
        List<MomentsVO> momentsVOList = new ArrayList<>();
//        遍历momentsList
        for (Moments moments : momentsList) {
            List<Tags> tags = tagsMapper.selectMomentsTagsList(moments.getId());
            MomentsVO momentsVO = new MomentsVO();
            BeanUtil.copyProperties(moments, momentsVO);
            momentsVO.setTags(tags);
            momentsVOList.add(momentsVO);
        }

        PageResult<MomentsVO> momentsVOPageResult = new PageResult<>(momentsVOList, momentsPage.getTotal(), momentsPage.getCurrent(), momentsPage.getSize(), momentsPage.getPages());
        return momentsVOPageResult;
    }
}




