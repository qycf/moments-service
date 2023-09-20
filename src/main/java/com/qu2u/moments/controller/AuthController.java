package com.qu2u.moments.controller;


import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qu2u.moments.domain.LoginDTO;
import com.qu2u.moments.domain.Response;
import com.qu2u.moments.domain.UserVO;
import com.qu2u.moments.entity.User;
import com.qu2u.moments.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;


@RestController
@Api(tags = "登陆鉴权相关接口")
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation("登陆")
    public Response<?> login(@RequestBody LoginDTO loginDTO) {
        System.out.println(loginDTO);
        String password = DigestUtil.md5Hex(loginDTO.getPassword());
        LambdaQueryWrapper<User> userWrapper = new LambdaQueryWrapper<User>();
        String email = loginDTO.getEmail();

//        正则判断是否为邮箱
        if (!email.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")) {
            userWrapper.eq(User::getUsername, loginDTO.getEmail());
        } else {
            userWrapper.eq(User::getEmail, loginDTO.getEmail());
        }
        userWrapper.eq(User::getPassword, password);

        User one = userService.getOne(userWrapper);
        if (one == null) {
            return Response.error(400, "用户名/邮箱或密码错误");
        }

        StpUtil.login(one.getId());
        UserVO userVO = new UserVO();
        BeanUtil.copyProperties(one, userVO);
        HashMap<String, Object> userInfo = new HashMap<>();
        userInfo.put("userInfo", userVO);
        userInfo.put("Authorization", StpUtil.getTokenInfo().getTokenValue());

        return Response.success(userInfo);
    }

}
