package com.qu2u.moments.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.qu2u.moments.domain.PageResult;
import com.qu2u.moments.domain.Response;
import com.qu2u.moments.service.MomentsService;
import com.qu2u.moments.vo.MomentsVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/moments")
public class MomentsController {

    @Resource
    private MomentsService momentsService;

    @GetMapping("/list")
    public Response<PageResult<MomentsVO>> list(@RequestParam int page, @RequestParam int size) {
        boolean isLogin = StpUtil.isLogin();
        PageResult<MomentsVO> momentsVOS = momentsService.selectMomentsList(isLogin, page, size);
        return Response.success(momentsVOS);
    }

}
