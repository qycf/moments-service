package com.qu2u.moments.controller;


import com.qu2u.moments.domain.ImagesGroup;
import com.qu2u.moments.domain.Response;
import com.qu2u.moments.entity.Images;
import com.qu2u.moments.service.ImagesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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


}
