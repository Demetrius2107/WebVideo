package org.hua.tiktok.config;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "qiniu.kodo")
public class QiNiuConfig {

    private String accessKey;

    private String secretKey;

    private String bucketName;

    public static final String CNAME = "";

    public static final String VIDEO_URL = "";

    public static final String IMAGE_URL = "";

    //七牛云持久化处理 Persistent Operation
    public static final String fops = "avthumb/mp4";

    public Auth buildAuth() {
        String accessKey = this.getAccessKey();
        String secretKey = this.getSecretKey();
        return Auth.create(accessKey, secretKey);
    }

    //上传token
    public String uploadToken(String type) {
        final Auth auth = buildAuth();
        return auth.uploadToken(bucketName, null, 300, new StringMap().put("mimeLimit", "video/*;image/*"));
    }

    //视频上传token
    public String videoUploadToken() {
        final Auth auth = buildAuth();
        return auth.uploadToken(bucketName, null, 300, new StringMap().put("mimeLimit", "video/*").putNotEmpty("persistentOps", fops));
    }

    //图片上传token
    public String imageUploadToken() {
        final Auth auth = buildAuth();
        return auth.uploadToken(bucketName, null, 300, new StringMap().put("mimeLimit", "image/*"));
    }

    //获取token
    public String getToken(String url, String method, String body, String contentType) {
        final Auth auth = buildAuth();
        return "QiNiu " + auth.signQiniuAuthorization(url, method, body == null ? null : body.getBytes(), contentType);
    }

}
