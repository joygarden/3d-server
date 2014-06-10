package com.lzs.mobile.rest.action;

import com.lzs.core.entity.Album;
import com.lzs.core.entity.Picture;
import com.lzs.core.entity.User;
import com.lzs.core.service.PictureService;
import com.lzs.core.support.BaseAction;
import com.lzs.core.support.Page;
import com.lzs.mobile.rest.req.PicDetailReq;
import com.lzs.mobile.rest.req.PicListReq;
import com.lzs.mobile.rest.req.PicUploadReq;
import com.lzs.mobile.rest.resp.PicDetailResp;
import com.lzs.mobile.rest.resp.PicUploadResp;
import com.lzs.mobile.rest.resp.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Description Add Comment Here <br/>
 * Date 2014/05/30 13:41 <br/>
 *
 * @author liaozhisong
 * @version V1.0
 */
@RestController
@RequestMapping("/rest/picture")
public class PictureAction extends BaseAction {

    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Result upload(PicUploadReq req) {
        Result result = new Result();
        try {
            String url = pictureService.writeFile(req.getPicData());
            Picture picture = new Picture();
            picture.setUrl(url);
            User user = new User();
            user.setId(req.getUserId());
            picture.setUser(user);
            Album album = new Album();
            album.setId(req.getAlbumId());
            picture.setAlbum(album);
            picture.setFile(req.getPicData());
            picture.setTitle(req.getTitle());
            pictureService.addPicture(picture);
            PicUploadResp resp = new PicUploadResp();
            resp.setId(picture.getId());
            resp.setUserId(picture.getUser().getId());
            resp.setTitle(picture.getTitle());
            resp.setTime(picture.getCreateDate());
            resp.setPicUrl(picture.getFullPath());
            result.setData(resp);
            result.setCode(Result.OK);
        } catch (Exception e) {
            result.setCode(Result.ERROR);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("list")
    public Result list(PicListReq req) {
        Result result = new Result();
        Page page = new Page();
        page.setPageNo(req.getPageNo());
        page.setPageSize(req.getPageSize());
        List<Picture> list = pictureService.listPicture(page, null, req.getUserId(),req.getAlbumId()).getData();
        List<PicDetailResp> resp = new ArrayList<PicDetailResp>();
        for (Picture pic : list) {
            PicDetailResp dt = new PicDetailResp();
            dt.setId(pic.getId());
            dt.setUserId(pic.getUser().getId());
            dt.setTitle(pic.getTitle());
            dt.setTime(pic.getCreateDate());
            dt.setPicUrl(pic.getFullPath());
            resp.add(dt);
        }
        result.setCode(Result.OK);
        result.setData(resp);
        return result;
    }

    @RequestMapping("detail")
    public Result detail(PicDetailReq req) {
        Result result = new Result();
        result.setCode(Result.ERROR);
        try {
            Picture picture = pictureService.findById(req.getPicId());
            if (picture != null) {
                PicDetailResp resp = new PicDetailResp();
                resp.setId(picture.getId());
                resp.setUserId(picture.getUser().getId());
                resp.setTitle(picture.getTitle());
                resp.setTime(picture.getCreateDate());
                resp.setPicUrl(picture.getFullPath());
                result.setCode(Result.OK);
                result.setData(resp);
            } else {
                result.setMsg("图片未找到！");
            }
        } catch (Exception e) {
            logger.error("", e);
            result.setMsg(e.getMessage());
        }
        return result;
    }

}
