package com.github.aaric.achieve.ueditor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * UEditor控制器
 *
 * @author Aaric, created on 2017-11-23T11:19.
 * @since 1.0-SNAPSHOT
 */
@RestController
@RequestMapping("/api/ueditor")
public class UEditorController {

    /**
     * UEditor配置全局变量
     */
    private static final String uploadActionName = "uploadFile";
    private static final String uploadFieldName = "uploadFile";
    private static final String uploadPathFormat = "/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}";
    private static final String listImagesActionName = "listImages";
    private static final String listFilesActionName = "listFiles";

    /**
     * UEditor配置信息
     *
     * @param action 请求方式名称
     * @return
     */
    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public Object config(@RequestParam("action") String action) {
        Map<String, Object> mapData = new HashMap<>();
        if ("config".equals(action)) {
            /* 上传图片配置项 */
            mapData.put("imageActionName", uploadActionName);  /* 执行上传图片的action名称 */
            mapData.put("imageFieldName", uploadFieldName);    /* 提交的图片表单名称 */
            mapData.put("imageMaxSize", "2048000");         /* 上传大小限制，单位B */
            mapData.put("imageAllowFiles", new String[]{".png", ".jpg", ".jpeg", ".gif", ".bmp"});/* 上传图片格式显示 */
            mapData.put("imageCompressEnable", true);       /* 是否压缩图片,默认是true */
            mapData.put("imageCompressBorder", 1600);       /* 图片压缩最长边限制 */
            mapData.put("imageInsertAlign", "none");        /* 插入的图片浮动方式 */
            mapData.put("imageUrlPrefix", "");              /* 图片访问路径前缀 */
            mapData.put("imagePathFormat", uploadPathFormat);/* 上传保存路径,可以自定义保存路径和文件名格式 */

            /* 涂鸦图片上传配置项 */
            mapData.put("scrawlActionName", uploadActionName); /* 执行上传涂鸦的action名称 */
            mapData.put("scrawlFieldName", uploadFieldName);   /* 提交的图片表单名称 */
            mapData.put("scrawlPathFormat", uploadPathFormat);/* 上传保存路径,可以自定义保存路径和文件名格式 */
            mapData.put("scrawlMaxSize", "2048000");        /* 上传大小限制，单位B */
            mapData.put("scrawlUrlPrefix", "");             /* 图片访问路径前缀 */
            mapData.put("scrawlInsertAlign", "none");       /* 插入的图片浮动方式 */

            /* 截图工具上传 */
            mapData.put("snapscreenActionName", uploadActionName);  /* 执行上传截图的action名称 */
            mapData.put("snapscreenFieldName", uploadFieldName);    /* 提交的图片表单名称 */
            mapData.put("snapscreenPathFormat", uploadPathFormat);  /* 上传保存路径,可以自定义保存路径和文件名格式 */
            mapData.put("snapscreenUrlPrefix", "");             /* 图片访问路径前缀 */
            mapData.put("snapscreenInsertAlign", "none");       /* 插入的图片浮动方式 */

            /* 抓取远程图片配置 */
            mapData.put("catcherLocalDomain", new String[]{"127.0.0.1", "localhost", "img.baidu.com"});
            mapData.put("catcherActionName", uploadActionName); /* 执行抓取远程图片的action名称 */
            mapData.put("catcherFieldName", uploadFieldName);   /* 提交的图片列表表单名称 */
            mapData.put("catcherPathFormat", uploadPathFormat); /* 上传保存路径,可以自定义保存路径和文件名格式 */
            mapData.put("catcherUrlPrefix", "");                /* 图片访问路径前缀 */
            mapData.put("catcherMaxSize", 2048000);             /* 上传大小限制，单位B */
            mapData.put("catcherAllowFiles", new String[]{".png", ".jpg", ".jpeg", ".gif", ".bmp"});/* 抓取图片格式显示 */

            /* 上传视频配置 */
            mapData.put("videoActionName", uploadActionName); /* 执行上传视频的action名称 */
            mapData.put("videoFieldName", uploadFieldName);/* 提交的视频表单名称 */
            mapData.put("videoPathFormat", uploadPathFormat);/* 上传保存路径,可以自定义保存路径和文件名格式 */
            mapData.put("videoUrlPrefix", "");/* 视频访问路径前缀 */
            mapData.put("videoMaxSize", 2048000);/* 上传大小限制，单位B，默认100MB */
            mapData.put("videoAllowFiles", new String[]{".flv", ".swf", ".mkv", ".avi", ".rm", ".rmvb", ".mpeg", ".mpg",
                    ".ogg", ".ogv", ".mov", ".wmv", ".mp4", ".webm", ".mp3", ".wav", ".mid"});/* 上传视频格式显示 */

            /* 上传文件配置 */
            mapData.put("fileActionName", uploadActionName);/* controller里,执行上传视频的action名称 */
            mapData.put("fileFieldName", uploadFieldName);  /* 提交的文件表单名称 */
            mapData.put("filePathFormat", uploadPathFormat);/* 上传保存路径,可以自定义保存路径和文件名格式 */
            mapData.put("fileUrlPrefix", "");       /* 文件访问路径前缀 */
            mapData.put("fileMaxSize", 2048000);    /* 上传大小限制，单位B，默认50MB */
            mapData.put("fileAllowFiles", new String[]{".png", ".jpg", ".jpeg", ".gif", ".bmp",
                    ".flv", ".swf", ".mkv", ".avi", ".rm", ".rmvb", ".mpeg", ".mpg",
                    ".ogg", ".ogv", ".mov", ".wmv", ".mp4", ".webm", ".mp3", ".wav", ".mid",
                    ".rar", ".zip", ".tar", ".gz", ".7z", ".bz2", ".cab", ".iso",
                    ".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx", ".pdf", ".txt", ".md", ".xml"});/* 上传文件格式显示 */

            /* 列出指定目录下的图片 */
            mapData.put("imageManagerActionName", listImagesActionName);/* 执行图片管理的action名称 */
            mapData.put("imageManagerListPath", "");/* 指定要列出图片的目录 */
            mapData.put("imageManagerListSize", 20);/* 每次列出文件数量 */
            mapData.put("imageManagerUrlPrefix", "");/* 图片访问路径前缀 */
            mapData.put("imageManagerInsertAlign", "none");/* 插入的图片浮动方式 */
            mapData.put("imageManagerAllowFiles", new String[]{".png", ".jpg", ".jpeg", ".gif", ".bmp"});/* 列出的文件类型 */

            /* 列出指定目录下的文件 */
            mapData.put("fileManagerActionName", listFilesActionName);/* 执行文件管理的action名称 */
            mapData.put("fileManagerListPath", "");/* 指定要列出文件的目录 */
            mapData.put("fileManagerUrlPrefix", "");/* 文件访问路径前缀 */
            mapData.put("fileManagerListSize", 20);/* 每次列出文件数量 */
            mapData.put("fileManagerAllowFiles", new String[]{".png", ".jpg", ".jpeg", ".gif", ".bmp",
                    ".flv", ".swf", ".mkv", ".avi", ".rm", ".rmvb", ".mpeg", ".mpg",
                    ".ogg", ".ogv", ".mov", ".wmv", ".mp4", ".webm", ".mp3", ".wav", ".mid",
                    ".rar", ".zip", ".tar", ".gz", ".7z", ".bz2", ".cab", ".iso",
                    ".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx", ".pdf", ".txt", ".md", ".xml"});/* 列出的文件类型 */

        } else if (listImagesActionName.equals(action)) {
            /* 请求图片列表 */
            // 请求状态
            mapData.put("state", "SUCCESS");
            // 空列表
            mapData.put("list", new String[]{});
            mapData.put("start", 0);
            mapData.put("total", 0);
        } else if (listFilesActionName.equals(action)) {
            /* 请求图片列表 */
            // 请求状态
            mapData.put("state", "SUCCESS");
            // 空列表
            mapData.put("list", new String[]{});
            mapData.put("start", 0);
            mapData.put("total", 0);
        }
        return mapData;
    }

    /**
     * UEditor上传文件
     *
     * @param action 请求方式名称
     * @param file   上传文件信息
     * @return
     */
    @RequestMapping(value = "/config", method = RequestMethod.POST)
    public Object config(@RequestParam("action") String action, @RequestParam(value = uploadFieldName, required = false) MultipartFile file) {
        Map<String, Object> mapData = new HashMap<>();
        if (uploadActionName.equals(action)) {
            /* 上传文件信息 */
            System.err.println(file.getOriginalFilename());
            // 请求状态
            mapData.put("state", "SUCCESS");
            // 图片或文件地址
            mapData.put("url", "https://www.baidu.com/img/baidu_jgylogo3.gif");
            // 标题
            mapData.put("title", file.getOriginalFilename());
            // 原始文件信息
            mapData.put("original", file.getOriginalFilename());
        }
        return mapData;
    }
}
