package com.lzs.mobile.rest.action;

import com.lzs.core.entity.Album;
import com.lzs.core.entity.Picture;
import com.lzs.core.entity.User;
import com.lzs.core.service.AlbumService;
import com.lzs.core.support.BaseAction;
import com.lzs.core.support.Page;
import com.lzs.mobile.rest.req.AlbumAddReq;
import com.lzs.mobile.rest.req.AlbumListReq;
import com.lzs.mobile.rest.resp.AlbumResp;
import com.lzs.mobile.rest.resp.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 6/11/14.
 *
 * @author liaozhisong.
 */
@RestController
@RequestMapping("/rest/album")
public class AlbumAction extends BaseAction {

    @Autowired
    private AlbumService albumService;

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Result add(AlbumAddReq req) {
        Result result = new Result();
        try {
            result.setCode(Result.OK);
            Album album = new Album();
            User user = new User();
            user.setId(req.getUserId());
            album.setUser(user);
            album.setTitle(req.getTitle());
            albumService.addAlbum(album);
            AlbumResp resp = new AlbumResp();
            resp.setTitle(album.getTitle());
            resp.setId(album.getId());
            resp.setTime(album.getCreateDate());
            result.setData(resp);
        } catch (Exception e) {
            logger.error("",e);
            result.setCode(Result.ERROR);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "del",method = RequestMethod.POST)
    public Result del(Long albumId) {
        Result result = new Result();
        try {
            result.setCode(Result.OK);
            Album album = albumService.findById(albumId);
            if(album.getPictures().isEmpty()) {
                albumService.deleteObject(album);
            } else {
                result.setCode(Result.ERROR);
                result.setMsg("请先删除相册下图片！");
            }
        } catch (Exception e) {
            logger.error("",e);
            result.setCode(Result.ERROR);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("list")
    public Result list(AlbumListReq req) {
        Result result = new Result();
        try {
            result.setCode(Result.OK);
            Page page = new Page();
            page.setPageNo(req.getPageNo());
            page.setPageSize(req.getPageSize());
            Page<Album> albumPage = albumService.listAlbum(page,null,req.getUserId());
            List<AlbumResp> respList = new ArrayList<AlbumResp>();
            for(Album a : albumPage.getData()) {
                AlbumResp resp = new AlbumResp();
                resp.setTime(a.getCreateDate());
                resp.setId(a.getId());
                resp.setTitle(a.getTitle());
                List<Picture> pictures = a.getPictures();
                if(!pictures.isEmpty()) {
                    resp.setPicUrl(pictures.get(0).getFullPath());
                }
                respList.add(resp);
            }
            result.setData(respList);
        } catch (Exception e) {
            logger.error("",e);
            result.setCode(Result.ERROR);
            result.setMsg(e.getMessage());
        }
        return result;
    }

}
