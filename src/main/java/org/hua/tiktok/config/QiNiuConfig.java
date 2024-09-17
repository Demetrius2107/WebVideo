package org.hua.tiktok.config;

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

    public static final String fops = "avthumb/mp4";

}
