package com.lzs.core.service;


import com.lzs.core.entity.User;
import com.lzs.core.support.BaseService;
import com.lzs.core.support.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户管理类.
 */
@Service
public class UserService extends BaseService<User> {

    public void addUser(User user) {
        try {
            PasswordService passwordService = new DefaultPasswordService();
            user.setPassword(passwordService.encryptPassword(user.getPassword()));
            addObject(user);
        } catch (PersistenceException e) {
            throw new RuntimeException("用户名重复!");
        }
    }

    public Page<User> listUser(Page page, String username) {
        String jql = "from User where deleted=0 ";
        Map<String, Object> param = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(username)) {
            jql += "and username like :username ";
            param.put("username", "%" + username + "%");
        }
        jql += "order by id";
        return pagedQuery(jql, page, param);
    }
}
