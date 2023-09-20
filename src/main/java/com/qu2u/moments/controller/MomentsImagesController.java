package com.qu2u.moments.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import com.qu2u.moments.domain.Response;
import com.qu2u.moments.entity.Images;
import com.qu2u.moments.service.ImagesService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/upload")
public class MomentsImagesController {


    @Resource
    private ImagesService imagesService;

    @PostMapping(value = "/image" )
    @SaCheckLogin
    public Response<List<Images>> uploadImage(@RequestPart("files") MultipartFile[] files){
//        List<Images> images = imagesService.uploadImages(files);
        for (MultipartFile file : files) {
            System.out.println(file.getOriginalFilename());
        }
        return Response.success(new ArrayList<>());
    }


}
