package org.hua.tiktok.entity.vo;

import lombok.Data;
import org.springframework.util.ObjectUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Data
public class VideoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    // YV ID 以YV+UUID
    private String yv;

    @NotBlank(message = "url不能为空")
    private String url;

    private String cover;

    private Boolean open;

    private Long userId;

    //审核快慢速度 0 慢速 1快速
    private Boolean auditQueueStatus;

    //视频分类
    private String videoType;

    @NotBlank(message = "请添加标签")
    private String labelNames;

    @NotNull(message = "分类不能为空")
    private Long typeId;

    private Date gmtCreated;

    public List<String> buildLabel(){
        if(ObjectUtils.isEmpty(this.labelNames)) return Collections.EMPTY_LIST;
        return Arrays.asList(this.labelNames.split(","));
    }

    public String getVideoUrl(){

    }
}
