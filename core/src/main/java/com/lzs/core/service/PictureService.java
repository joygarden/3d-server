package com.lzs.core.service;

import com.lzs.core.entity.Picture;
import com.lzs.core.entity.User;
import com.lzs.core.support.BaseService;
import com.lzs.core.support.Constant;
import com.lzs.core.support.Page;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 5/29/14.
 *
 * @author liaozhisong.
 */
@Service
public class PictureService extends BaseService<Picture> {

    /**
     * 添加图片
     *
     * @param picture
     */
    public void addPicture(Picture picture) {
        User user = find(User.class, picture.getUser().getId());
        picture.setUser(user);
        addObject(picture);
    }


    /**
     * 保存图片
     *
     * @param file
     * @return
     * @throws IOException
     */
    public String writeFile(MultipartFile file) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String saveFileName = sdf.format(new Date()) + "-" + file.getOriginalFilename();
        String path = Constant.getSavePath() + saveFileName;
        File saveFile = new File(path);
        FileUtils.writeByteArrayToFile(saveFile, file.getBytes());
        return saveFileName;
    }

    /**
     * 查询图片列表
     *
     * @return
     */
    public Page<Picture> listPicture(Page page, String title, Long userId) {
        String jql = "from Picture p where p.deleted=0 ";
        Map<String, Object> param = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(title)) {
            jql += "and p.title like :title ";
            param.put("title", "%" + title + "%");
        }
        if (userId != null) {
            jql += "and p.user.id=:uid ";
            param.put("uid", userId);
        }
        jql += "order by createDate desc";
        Page<Picture> result = pagedQuery(jql, page, param);
        return result;
    }
}
