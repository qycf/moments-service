package com.qu2u.moments.service;

import com.qu2u.moments.domain.ImagesGroup;
import com.qu2u.moments.entity.Images;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

/**
* @author qiuyue
* @description 针对表【images】的数据库操作Service
* @createDate 2023-08-30 09:45:33
*/
public interface ImagesService extends IService<Images> {

    List<Images> uploadImages(MultipartFile[] images);

    List<ImagesGroup> groupByDate();

}
