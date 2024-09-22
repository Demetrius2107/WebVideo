package org.hua.tiktok.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiniu.storage.model.FileInfo;
import org.hua.tiktok.config.LocalCache;
import org.hua.tiktok.config.QiNiuConfig;
import org.hua.tiktok.entity.File;
import org.hua.tiktok.exception.BaseException;
import org.hua.tiktok.mapper.FileMapper;
import org.hua.tiktok.service.FileService;
import org.hua.tiktok.service.QiNiuFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

    @Autowired
    private QiNiuFileService qiNiuFileService;

    @Override
    public Long save(String fileKey, Long userId) {
        final FileInfo videoFileInfo = qiNiuFileService.getFileInfo(fileKey);
        if (videoFileInfo == null) {
            throw new IllegalArgumentException("参数不正确");
        }

        final File videoFile = new File();
        //提取MIME类型
        String type = videoFileInfo.mimeType;
        videoFile.setFileKey(fileKey);
        videoFile.setFormat(type);
        videoFile.setType(type.contains("video") ? "视频" : "图片");
        videoFile.setUserId(userId);
        videoFile.setSize(videoFileInfo.fsize);
        //调用MP ServiceImpl方法将videoFile对象保存到数据库中
        save(videoFile);
        return videoFile.getId();
    }

    @Override
    public Long generatePhoto(Long fieldId, Long userId) {
        final File file = getById(fieldId);
        final String fileKey = file.getFileKey() + "?vframe/jpg/offset/1";
        final File fileInfo = new File();
        fileInfo.setFileKey(fileKey);
        fileInfo.setFormat("image/**");
        fileInfo.setType("图片");
        fileInfo.setUserId(userId);
        //mp save
        save(fileInfo);
        //返回唯一标识符 方便后续操作和引用
        return fileInfo.getId();
    }

    @Override
    public File getFileTrustUrl(Long fileId) {
        File file = getById(fileId);
        if (Objects.isNull(file)) {
            throw new BaseException("未找到该文件");
        }
        //生成UUID
        final String s = UUID.randomUUID().toString();
        //存储UUID到本地缓存中
        LocalCache.put(s, true);
        //构建url
        String url = QiNiuConfig.CNAME + "/" + file.getFileKey();

        if (url.contains("?")) {
            url = url + "&uuid=" + s;
        } else {
            url = url + "?uuid=" + s;
        }
        //保存url
        file.setFileKey(url);
        return file;
    }
}
