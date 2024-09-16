package org.hua.tiktok.entity.response;

import lombok.Data;
import lombok.ToString;
import org.hua.tiktok.entity.task.VideoTask;

/**
 * 封装视频审核返回结果
 */
@Data
@ToString
public class VideoAuditResponse {

    private AuditResponse videoAuditResponse;

    private AuditResponse imageAuditResponse;

    private AuditResponse textAuditResponse;

    private VideoTask videoTask;

}
