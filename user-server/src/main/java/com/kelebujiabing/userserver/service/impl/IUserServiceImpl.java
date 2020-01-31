package com.kelebujiabing.userserver.service.impl;


import com.alibaba.fastjson.JSON;
import com.kelebujiabing.commonmaven.utils.AssertUtil;
import com.kelebujiabing.commonmaven.utils.JSONObject;
import com.kelebujiabing.commonmaven.utils.TokenUtils;
import com.kelebujiabing.userapi.domain.User;
import com.kelebujiabing.userserver.mapper.UserMapper;
import com.kelebujiabing.userserver.service.IUserService;
import com.kelebujiabing.utils.PasswordUtil;
import com.kelebujiabing.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.UUID;

@Service
@Transactional
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil ;

    public User UserRegister(User user) {
        JSONObject jsonObject = new JSONObject();
        AssertUtil.isNull(user.getPhone(),"手机号码为空");
        AssertUtil.isNull(user.getPassword(),"密码为空");
        //校验密码是否符合规则
        // TODO: 2020/1/6 0006
        //校验手机是否注册
        int count = userMapper.selectByPhone(user.getPhone());
        if (count != 0) {
            jsonObject.setMessage("手机号码已被注册");
        }
        //生成token和验证码
        //加密必要参数
        PasswordUtil.encrypt(user.getPhone(), PasswordUtil.DEFUALT_KEY, PasswordUtil.SALT);
        PasswordUtil.encrypt(user.getPassword(), PasswordUtil.DEFUALT_KEY, PasswordUtil.SALT);
        user.setLogout(2);
        userMapper.insert(user);
        //生产token和手机验证码
        HashMap<String, Object> map = new HashMap<>();
        String token = TokenUtils.getToken();
        User userToken = new User();
        userToken.setToken(token);
        userToken.setVerificationCode(token.substring(1,4));
        redisUtil.set(RedisUtil.PC_TOKEN_KEY+token, JSON.toJSON(userToken));
        // TODO: 2020/1/6 0006 发送短信验证码
        return userToken;
    }

    public User reloadVerification(User user, HttpServletRequest request) {
        String token = request.getHeader("token");
        AssertUtil.isNull(token,"用户异常请从新登录");
        String o = (String) redisUtil.get(RedisUtil.PC_TOKEN_KEY + token);
        User parse = (User) JSON.parse(o);
        String substring = UUID.randomUUID().toString().substring(1, 4);
        parse.setToken(substring);

        return null;
    }
}
