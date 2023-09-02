package com.qu2u.moments.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qu2u.moments.domain.ImagesGroup;
import com.qu2u.moments.entity.Images;
import com.qu2u.moments.service.ImagesService;
import com.qu2u.moments.mapper.ImagesMapper;
import com.qu2u.moments.utils.CosUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qiuyue
 * @description 针对表【images】的数据库操作Service实现
 * @createDate 2023-08-30 09:45:33
 */
@Service
public class ImagesServiceImpl extends ServiceImpl<ImagesMapper, Images>
        implements ImagesService {


    @Resource
    private ImagesMapper imagesMapper;

    @Override
    public List<Images> uploadImages(MultipartFile[] images) {
        Date date = DateUtil.date();
        int year = DateUtil.year(date);
        int month = DateUtil.month(date) + 1;
        int day = DateUtil.dayOfMonth(date);
        String path = year + "/" + month + "/" + day + "/";
        List<Images> imagesList = new ArrayList<>();
        for (MultipartFile image : images) {
            String url = CosUtils.uploadFile(image, path);
            Images image_entity = new Images();
            image_entity.setUrl(url);
            this.save(image_entity);
            imagesList.add(image_entity);
        }
        return imagesList;
    }

    @Override
    public List<ImagesGroup> groupByDate() {
//       对照片根据日期进行分组
        List<String> dateGroups = imagesMapper.groupByDate();

        List<ImagesGroup> imagesGroups = new ArrayList<>();

//        HashMap<String, List<Images>> stringListHashMap = new HashMap<>();
        for (String creation : dateGroups) {
            LambdaQueryWrapper<Images> imagesLambdaQueryWrapper = new LambdaQueryWrapper<>();
            imagesLambdaQueryWrapper.apply("DATE(create_time) = '" + creation + "'");
//            根据日期查询照片列表
            List<Images> imagesList = this.list(imagesLambdaQueryWrapper);

            ImagesGroup imagesGroup = new ImagesGroup();
            imagesGroup.setCreationDate(creation);
            imagesGroup.setImagesList(imagesList);
            imagesGroups.add(imagesGroup);
        }
        return imagesGroups;
    }
}




