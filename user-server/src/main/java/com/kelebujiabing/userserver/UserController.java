package com.kelebujiabing.userserver;

import com.kelebujiabing.commonmaven.exception.DisplayableException;
import com.kelebujiabing.commonmaven.utils.JSONObject;
import com.kelebujiabing.userapi.domain.User;
import com.kelebujiabing.userserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private IUserService userService;


    /**
     * 注册
     * @param user
     * @return
     */
    public JSONObject UserRegister(User user) {
        JSONObject jsonObject = new JSONObject();
        try {
            User userToken = userService.UserRegister(user);
            jsonObject.setObject(userToken);
        } catch (DisplayableException d) {
            jsonObject.setMessage(d.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.setMessage("系统繁忙...");
        }
        return jsonObject;
    }



    /**
     * 重新获取token
     * @param user
     * @return
     */
    public JSONObject reloadToekn(HttpServletRequest request, User user) {
        JSONObject jsonObject = new JSONObject();
        try {
            User userToken = userService.reloadVerification(user,request);
            jsonObject.setObject(userToken);
        } catch (DisplayableException d) {
            jsonObject.setMessage(d.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.setMessage("系统繁忙...");
        }
        return jsonObject;
    }







}
