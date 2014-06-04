package com.lzs.mobile.rest.action;

import com.lzs.core.entity.User;
import com.lzs.core.service.UserService;
import com.lzs.core.support.BaseAction;
import com.lzs.mobile.rest.req.LoginReq;
import com.lzs.mobile.rest.req.RegisterReq;
import com.lzs.mobile.rest.resp.LoginResp;
import com.lzs.mobile.rest.resp.RegisterResp;
import com.lzs.mobile.rest.resp.Result;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NoResultException;

/**
 * Description Add Comment Here <br/>
 * Date 2014/05/30 13:41 <br/>
 *
 * @author liaozhisong
 * @version V1.0
 */
@RestController
@RequestMapping("/rest/user")
public class UserAction extends BaseAction {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public Result login(LoginReq req) {
        Result result = new Result();
        result.setCode(Result.ERROR);
        try {
            User user = userService.findUniqueBy("username", req.getNickName());
            PasswordService passwordService = new DefaultPasswordService();
            if (passwordService.passwordsMatch(req.getPassword(), user.getPassword())) {
                result.setCode(Result.OK);
                result.setMsg("登录成功！");
                LoginResp loginResp = new LoginResp();
                loginResp.setEmail(user.getEmail());
                loginResp.setMdn(user.getMdn());
                loginResp.setNickName(user.getUsername());
                loginResp.setUserId(user.getId());
                result.setData(loginResp);
            } else {
                result.setMsg("密码错误！");
            }
        } catch (NoResultException e) {
            result.setMsg("用户名不存在！");
            logger.error(e.getMessage(), e);
        } catch (Exception e) {
            result.setMsg("登录失败！");
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public Result register(RegisterReq registerReq) {
        Result result = new Result();
        result.setCode(Result.ERROR);
        try {
            User user = new User();
            user.setRoles("user");
            user.setMdn(registerReq.getMdn());
            user.setEmail(registerReq.getEmail());
            user.setAddress(registerReq.getAddress());
            user.setPassword(registerReq.getPassword());
            user.setUsername(registerReq.getNickName());
            userService.addUser(user);

            RegisterResp resp = new RegisterResp();
            resp.setEmail(user.getEmail());
            resp.setUserId(user.getId());
            resp.setMdn(user.getMdn());
            resp.setNickName(user.getUsername());

            result.setCode(Result.OK);
            result.setMsg("注册成功！");
            result.setData(resp);

        } catch (Exception e) {
            result.setMsg(e.getMessage());
        }
        return result;
    }


}
