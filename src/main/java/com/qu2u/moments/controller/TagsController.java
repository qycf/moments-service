package com.qu2u.moments.controller;


import com.qu2u.moments.domain.Response;
import com.qu2u.moments.entity.Tags;
import com.qu2u.moments.service.TagsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagsController {

    @Resource
    private TagsService tagsService;

    @GetMapping("/list")
    public Response<List<Tags>> getTags() {
        List<Tags> list = tagsService.list();
        return Response.success(list);
    }

}
