package com.qu2u.moments.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.qu2u.moments.domain.PageResult;
import com.qu2u.moments.domain.Response;
import com.qu2u.moments.entity.Moments;
import com.qu2u.moments.service.MomentsService;
import com.qu2u.moments.vo.MomentsVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@RestController
@RequestMapping("/moments")
public class MomentsController {

    @Resource
    private MomentsService momentsService;

    @GetMapping("/list")
    public Response<PageResult<Moments>> list(@RequestParam int page, @RequestParam int size) {
        boolean isLogin = StpUtil.isLogin();
        PageResult<Moments> momentsVOS = momentsService.selectMomentsList(isLogin, page, size);
        return Response.success(momentsVOS);
    }

    @PostMapping
    public Object newMoments(@RequestBody Moments moments){
        momentsService.save(moments);
        return moments;
    }


}
