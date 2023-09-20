package com.qu2u.moments.controller;


import com.qu2u.moments.domain.ImagesGroup;
import com.qu2u.moments.domain.Response;
import com.qu2u.moments.entity.Images;
import com.qu2u.moments.service.ImagesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/images")
public class ImagesController {

    @Resource
    private ImagesService imagesService;

    @GetMapping
    public Response<List<ImagesGroup>> getImages() {
        List<ImagesGroup> imagesGroups = imagesService.groupByDate();
        return Response.success(imagesGroups);
    }

    @PostMapping("/upload")
    public Response<List<Images>> uploadImageUrl(@RequestParam String[] urls) {
        List<Images> imagesList = new ArrayList<>();

        for (String url : urls) {
            Images images = new Images();
            images.setUrl(url);
            imagesService.save(images);
            imagesList.add(images);
        }

        return Response.success(imagesList);
    }

}
