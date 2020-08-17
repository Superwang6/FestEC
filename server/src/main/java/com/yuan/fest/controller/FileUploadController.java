package com.yuan.fest.controller;

import com.yuan.fest.common.CommonResult;
import com.yuan.fest.common.ResultCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class FileUploadController {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    @RequestMapping("/upload")
    public CommonResult upload(MultipartFile uploadFile, HttpServletRequest req) {
        try {
            if ("".equals(uploadFile.getOriginalFilename()) || uploadFile.getOriginalFilename() == null) {
                return CommonResult.failed(ResultCode.PARAM_ERROR);
            }
            String filePath = uploadFile(uploadFile, req);
            if (filePath != "") {
                return CommonResult.success(filePath);
            } else {
                return CommonResult.failed(ResultCode.ERROR, "上传失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(ResultCode.EXCEPTION);
        }
    }

    /**
     * 上传文件
     *
     * @param uploadFile
     * @param req
     * @return
     */
    private String uploadFile(MultipartFile uploadFile, HttpServletRequest req) {
        String realPath = req.getServletContext().getRealPath("/");
        String contextPath = req.getContextPath();
        String format = sdf.format(new Date());
        File folder = new File(realPath + "/uploadFile/" + format);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        String filePath = "";
        try {
            uploadFile.transferTo(new File(folder, newName));
            filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + contextPath + "/uploadFile/" + format + "/" + newName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }

    @RequestMapping("/uploads")
    public CommonResult uploads(MultipartFile[] uploadFiles, HttpServletRequest req) {
        try {
            if (uploadFiles.length == 0) {
                return CommonResult.failed(ResultCode.PARAM_ERROR);
            }
            List<String> filePathList = new ArrayList<>();
            for (MultipartFile multipartFile : uploadFiles) {
                String filePath = uploadFile(multipartFile, req);
                filePathList.add(filePath);
            }
            if (filePathList.size() > 0) {
                return CommonResult.success(filePathList);
            } else {
                return CommonResult.failed(ResultCode.ERROR, "上传失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(ResultCode.EXCEPTION);
        }
    }
}
