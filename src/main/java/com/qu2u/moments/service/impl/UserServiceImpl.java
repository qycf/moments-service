package com.qu2u.moments.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qu2u.moments.entity.User;
import com.qu2u.moments.service.UserService;
import com.qu2u.moments.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author qiuyue
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-09-11 15:08:58
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




