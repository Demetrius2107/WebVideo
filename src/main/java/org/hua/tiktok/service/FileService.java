package org.hua.tiktok.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.hua.tiktok.entity.File;


public interface FileService extends IService<File> {

    Long save(String fileKey,Long userId);

    /**
     * 根据视频ID 生成图片
     * @param fieldId
     * @param userId
     * @return
     */
    Long generatePhoto(Long fieldId,Long userId);

    /**
     * 获取文件的真实URL
     * @param fieldId 文件ID
     * @return
     */
    File getFileTrustUrl(Long fileId);
}
