package org.hua.tiktok.service.impl;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import org.hua.tiktok.config.QiNiuConfig;
import org.hua.tiktok.service.QiNiuFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class QiNiuFileServiceImpl implements QiNiuFileService {

    @Autowired
    private QiNiuConfig qiNiuConfig;

    @Override
    public String getToken() {
        return qiNiuConfig.videoUploadToken();
    }

    /**
     * 上传文件
     * @param file
     * @return
     */
    @Override
    public String uploadFile(File file) {
        Configuration cfg = new Configuration(Region.region2());
        UploadManager uploadManager = new UploadManager(cfg);
        try {
            Response response = uploadManager.put(file, null, qiNiuConfig.videoUploadToken());
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return putRet.key;
        } catch (QiniuException e) {
            e.printStackTrace();
            if (e.response != null) {
                System.err.println(e.response);
                try {
                    String body = e.response.toString();
                    System.err.println(body);
                } catch (Exception ignored) {

                }
            }
            return null;
        }
    }

    /**
     * 删除文件
     * @param url
     */
    @Override
    public void deleteFile(String url) {
        Configuration cfg = new Configuration(Region.region0());
        String bucket = qiNiuConfig.getBucketName();
        final Auth auth = qiNiuConfig.buildAuth();
        String key = url;
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucket, key);
        } catch (QiniuException e) {
            System.err.println(e.code());
            System.err.println(e.response.toString());
        }
    }

    /**
     * 获取文件信息
     *
     * @param url
     * @return
     */
    @Override
    public FileInfo getFileInfo(String url) {
        Configuration cfg = new Configuration(Region.region0());
        final Auth auth = qiNiuConfig.buildAuth();
        final String bucket = qiNiuConfig.getBucketName();
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            //保证类型安全
            FileInfo fileInfo = bucketManager.stat(bucket, url);
            return fileInfo;
        } catch (QiniuException e) {
            System.err.println(e.response.toString());
        }
        return null;
    }
}
