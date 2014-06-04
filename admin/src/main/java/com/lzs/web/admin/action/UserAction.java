package com.lzs.web.admin.action;

import com.lzs.core.entity.User;
import com.lzs.core.service.UserService;
import com.lzs.core.support.BaseAction;
import com.lzs.core.support.Page;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by liaozhisong on 3/22/14.
 */
@Controller
@RequestMapping("/user")
public class UserAction extends BaseAction {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        Subject user = SecurityUtils.getSubject();
        Object obj = user.getPrincipal();
        if (obj != null) return "redirect:list";
        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User currUser) {
        return "redirect:login?username=" + currUser.getUsername();
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Page page, String keyword, Model model) {
        Page<User> result = userService.listUser(page, keyword);
        model.addAttribute("page", result);
        return "user/list";
    }

    @RequestMapping(value = "del", method = RequestMethod.POST)
    public String del(Long id) {
        userService.deleteObjectById(id);
        return "redirect:list";
    }

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String welcome() {
        return "user/welcome";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "user/register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user) {
        user.setRoles("user");
        userService.addUser(user);
        SecurityUtils.getSubject().logout();
        return "redirect:login";
    }

    @RequestMapping(value = "unauthorized", method = RequestMethod.GET)
    public String unauthorized() {
        return "user/unauthorized";
    }
}
