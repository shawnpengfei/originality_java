package com.ssy.app.controller;


import com.ssy.app.enity.SeeImg;
import com.ssy.app.service.SeeImgService;
import com.ssy.app.vo.JsonBean;
import com.ssy.app.vo.PageBeanVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.File;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/seeImg")
@Api(produces = "看图功能总接口",value = "SeeImg")
public class SeeImgController {

    @Autowired
    private SeeImgService sImgService;

    @RequestMapping("/addImgs")
    @CrossOrigin
    @ApiOperation("图片添加接口")
    public JsonBean addImgs(HttpServletRequest request, HttpServletResponse response){

        JsonBean bean  = new JsonBean();

        DiskFileItemFactory factory = new DiskFileItemFactory();

        // 对上传的数据进行处理
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        SeeImg img = new SeeImg();
        // 判断表单enctype="multipart/form-data"
        if (ServletFileUpload.isMultipartContent(request)) {
            // 对提交的数据进行解析
            try {
                List<FileItem> list = fileUpload.parseRequest(request);
                for (FileItem fileItem : list) {

                    if (fileItem.isFormField()) {

                        BeanUtils.copyProperties(img, fileItem.getFieldName(), fileItem.getString("utf-8"));

                    } else {
                        // 获取文件名
                        String name = fileItem.getName();
                        // 将文件上传到服务器的D:/upload文件夹下
                        String path = "D:/upload";

                        // 如果路径不存在，创建
                        File file = new File(path);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        // 全球唯一id
                        String uuid = UUID.randomUUID().toString();
                        name = uuid + "_" + name;
                        // 根据路径和文件名创建对象
                        File newFile = new File(path, name);

                        // 保存文件
                        fileItem.write(newFile);
                        // 删除缓存中数据
                        fileItem.delete();

                        img.setDescr(name);

                    }
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

        }

        return sImgService.addSeeImgSelective(img);
    }


    @GetMapping("/showSeeImgAll")
    @CrossOrigin
    @ApiOperation("分页查看所有图片接口")
    public PageBeanVo showSeeImgAll(Integer page, Integer limit){
        PageBeanVo vo = new PageBeanVo();
        if( page != null && !page.equals("") && limit != null && !limit.equals("")){

            vo = sImgService.showImgAll(page, limit);

            return vo;
        } else{
            vo.setCode(-1);
            vo.setMsg("传入参数不合法");
            return vo;
        }


    }


    @GetMapping("/showSeeImgByClass")
    @CrossOrigin
    @ApiOperation("分类、分页查看图片接口")
    public PageBeanVo showSeeImgByClass(Long cid, Integer page, Integer limit ){
        PageBeanVo vo = new PageBeanVo();
        if(cid != null && !cid.equals("") &&  page != null && !page.equals("") &&  limit != null && !limit.equals("")){
            vo = sImgService.showSeeImgByClass(cid,page, limit);
            return vo;
        } else{
            vo.setCode(-1);
            vo.setMsg("传入参数不合法");
            return vo;
        }


    }

    /**
     *
     * @param uid
     *      当前登录用户的id
     * @param id
     *      收藏的图片的id
     * @param starsNum
     *      图片收藏的数量
     * @return
     */

    @GetMapping("/starImg")
    @CrossOrigin
    @ApiOperation("收藏图片接口")
    public JsonBean startImg(Long uid, Long id, Long starsNum){

        JsonBean bean  = new JsonBean();
        if(id != null && !id.equals("") && uid != null && !uid.equals("")){
            return  sImgService.starImg(uid, id, starsNum);
        }else{
            bean.setInfo("收藏失败");
            bean.setCode(-1);
            return bean;
        }

    }

    @GetMapping("/showMyStarImg")
    @CrossOrigin
    @ApiOperation("查看我收藏的图片接口")
    public PageBeanVo<SeeImg> showMyStarImg(Long uid,Integer page, Integer limit ){
        PageBeanVo vo = new PageBeanVo();
        if (uid != null && !uid.equals("") && page != null && !page.equals("") && limit != null && !limit.equals("")){
            vo = sImgService.showMystarImg(uid, page, limit);
            return vo;
        }else {
            vo.setCode(-1);
            vo.setMsg("传入参数不合法");
            return vo;
        }

    }
}
