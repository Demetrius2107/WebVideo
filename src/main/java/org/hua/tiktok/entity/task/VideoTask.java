package org.hua.tiktok.entity.task;

import lombok.Data;
import org.hua.tiktok.entity.video.Video;

/**
 * 封装发布视频任务
 */
@Data
public class VideoTask {

    //新视频
    private Video video;

    //老视频
    private Video oldVideo;

    //是否是新增
    private Boolean isAdd;

    //老状态 0 公开 1 私密
    private Boolean oldState;

    //新状态
    private Boolean newState;
}
