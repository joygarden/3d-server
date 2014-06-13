package com.lzs.core.service;

import com.lzs.core.entity.Album;
import com.lzs.core.entity.User;
import com.lzs.core.support.BaseService;
import com.lzs.core.support.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 6/11/14.
 *
 * @author liaozhisong.
 */
@Service
public class AlbumService extends BaseService<Album> {

    public void addAlbum(Album album) {
        User user = find(User.class, album.getUser().getId());
        album.setUser(user);
        addObject(album);
    }

    public Page<Album> listAlbum(Page page, String title,Long userId) {
        String jql = "from Album a where a.deleted=0 ";
        Map<String, Object> param = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(title)) {
            jql += "and a.title like :title ";
            param.put("title", "%" + title + "%");
        }
        if(userId!=null) {
            jql += "and a.user.id=:uid ";
            param.put("uid",userId);
        }
        jql += "order by createDate ";
        Page<Album> result = pagedQuery(jql, page, param);
        return result;
    }
}
