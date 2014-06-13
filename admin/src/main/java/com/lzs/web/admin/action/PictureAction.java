package com.lzs.web.admin.action;

import com.lzs.core.entity.Picture;
import com.lzs.core.entity.User;
import com.lzs.core.service.PictureService;
import com.lzs.core.support.BaseAction;
import com.lzs.core.support.Page;
import com.lzs.core.support.ShiroDbRealm;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

/**
 * Description Add Comment Here <br/>
 * Date 2014/05/29 16:09 <br/>
 *
 * @author liaozhisong
 * @version V1.0
 */
@Controller
@RequestMapping("/picture")
public class PictureAction extends BaseAction {

    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Page page, String keyword, Model model) {
        Page<Picture> result = pictureService.listPicture(page, keyword, null,null);
        model.addAttribute("page", result);
        return "picture/list";
    }

    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public String upload() {
        return "picture/upload";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(Picture picture) throws IOException {
        logger.info(picture.getTitle());
        String url = pictureService.writeFile(picture.getFile());
        picture.setUrl(url);
        ShiroDbRealm.ShiroUser shiroUser = (ShiroDbRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
        User user = new User();
        user.setId(shiroUser.getId());
        picture.setUser(user);
        pictureService.addPicture(picture);
        return "redirect:list";
    }

    @RequestMapping(value = "del", method = RequestMethod.POST)
    public String del(Long id) {
        pictureService.deleteObjectById(id);
        return "redirect:list";
    }

}
