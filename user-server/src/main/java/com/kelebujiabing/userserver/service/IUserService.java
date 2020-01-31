package com.kelebujiabing.userserver.service;

import com.kelebujiabing.userapi.domain.User;

import javax.servlet.http.HttpServletRequest;

public interface  IUserService {


    /**注册用户
     * @param user
     * @return
     */
    User UserRegister(User user);

    User reloadVerification(User user, HttpServletRequest request);

}
