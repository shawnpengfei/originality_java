package com.ssy.app.controller;


import com.ssy.app.enity.SeeImg;
import com.ssy.app.service.SeeImgService;
import com.ssy.app.vo.JsonBean;
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
@Api(produces = "看图界面添加图片的入口",tags = "看图",value = "添加图片")
public class SeeImgController {

    @Autowired
    private SeeImgService sImgService;

    @PostMapping("/addImgs")
    @CrossOrigin
    @ApiOperation(notes = "add图片入口",tags = {"图片添加"},value = "addImg")
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
                        String path = "/imgsss";

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


}
