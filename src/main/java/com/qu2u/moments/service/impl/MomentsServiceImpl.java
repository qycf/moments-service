package com.qu2u.moments.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qu2u.moments.domain.MomentsVO;
import com.qu2u.moments.domain.PageResult;
import com.qu2u.moments.entity.Images;
import com.qu2u.moments.entity.Moments;
import com.qu2u.moments.service.ImagesService;
import com.qu2u.moments.service.MomentsService;
import com.qu2u.moments.mapper.MomentsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qiuyue
 * @description 针对表【moments】的数据库操作Service实现
 * @createDate 2023-08-24 15:02:22
 */
@Service
public class MomentsServiceImpl extends ServiceImpl<MomentsMapper, Moments>
        implements MomentsService {

    @Resource
    private ImagesService imagesService;


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

        List<MomentsVO> momentsVOList = momentsList.stream()
                .map(moments -> {
                    MomentsVO momentsVO = new MomentsVO();
                    BeanUtil.copyProperties(moments, momentsVO, "images");
                    String images_ids_str = moments.getImages();
                    if (images_ids_str == null || images_ids_str.equals("")) {
                        return momentsVO;
                    }

                    List<String> images_ids = Arrays.asList(images_ids_str.split(","));
                    List<Integer> result = images_ids.stream().map(Integer::parseInt).collect(Collectors.toList());
                    List<Images> imagesList = imagesService.listByIds(result);
                    momentsVO.setImages(imagesList);

                    return momentsVO;
                })
                .collect(Collectors.toList());


        PageResult<MomentsVO> momentsVOPageResult = new PageResult<>(momentsVOList, momentsPage.getTotal(), momentsPage.getCurrent(), momentsPage.getSize(), momentsPage.getPages());
        return momentsVOPageResult;
    }

}




