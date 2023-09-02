package com.qu2u.moments.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.qu2u.moments.domain.MomentsVO;
import com.qu2u.moments.domain.PageResult;
import com.qu2u.moments.domain.Response;
import com.qu2u.moments.entity.Moments;
import com.qu2u.moments.service.MomentsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/moments")
public class MomentsController {

    @Resource
    private MomentsService momentsService;


    @GetMapping
    public Response<Moments> getMoments(@RequestParam int id) {
        Moments moments = momentsService.getById(id);
        if (moments == null) {
            return Response.error(404, "动态不存在");
        }
        return Response.success(moments);
    }

    @DeleteMapping("/ban")
    public Response<Object> banMoments(@RequestParam int id,@RequestParam int status) {
//        LambdaQueryWrapper<Moments> momentsLambdaQueryWrapper = new up<>();
        LambdaUpdateWrapper<Moments> momentsLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        momentsLambdaUpdateWrapper.eq(Moments::getId, id)
                .set(Moments::getIsPublish, status);
        boolean isUpdate = momentsService.update(momentsLambdaUpdateWrapper);
        if (isUpdate) {
            return Response.success();
        }
        return Response.error(500, "冻结失败");
    }

    @GetMapping("/list")
    public Response<PageResult<MomentsVO>> list(@RequestParam int page, @RequestParam int size) {
        boolean isLogin = StpUtil.isLogin();
        PageResult<MomentsVO> momentsVOS = momentsService.selectMomentsList(isLogin, page, size);
        return Response.success(momentsVOS);
    }

    @PostMapping
    public Response<Object> newOrUpdateMoments(@RequestBody Moments moments) {
        boolean isSave = momentsService.saveOrUpdate(moments);
        if (isSave) {
            return Response.success(moments);
        }
        return Response.error(500, "编辑失败");
    }
}
