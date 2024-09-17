package org.hua.tiktok.entity.video;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hua.tiktok.config.QiNiuConfig;
import org.hua.tiktok.entity.BaseEntity;
import org.hua.tiktok.entity.vo.UserVO;
import org.springframework.util.ObjectUtils;

import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class Video extends BaseEntity {

    private static final long serialVersionUID = 1L;

    //YV ID 以 YV+UUID
    private String yv;

    @NotBlank(message = "标题不能为空")
    private String title;

    private String description;

    private Long url;

    private Long userId;

    private Long cover;

    /**
     * 公开/私密 ： 0 ： 公开 1 私密 默认为0
     */
    private Boolean open;

    private Integer auditStatus;

    private String msg;

    private Boolean auditQueueStatus;

    private Long startCount;

    private Long shareCount;

    private Long historyCount;

    private Long favoritesCount;

    //视频时长
    private String duration;

    //视频分类
    @TableField(exist = false)
    private String videoType;

    private String labelNames;

    private Long typeId;

    //关联用户
    @TableField(exist = false)
    private UserVO user;

    //关联分类名称
    @TableField(exist = false)
    private String typeName;

    //是否点赞
    @TableField(exist = false)
    private Boolean star;

    //是否收藏
    @TableField(exist = false)
    private Boolean favorites;

    // 是否关注
    @TableField(exist = false)
    private Boolean follow;

    // 用户昵称
    @TableField(exist = false)
    private String userName;

    // 审核状态名称
    @TableField(exist = false)
    private String auditStateName;

    // 是否公开
    @TableField(exist = false)
    private String openName;

    public List<String> buildLabel(){
        if (ObjectUtils.isEmpty(this.labelNames)) return Collections.EMPTY_LIST;
        return Arrays.asList(this.labelNames.split(","));
    }

    // 和get方法分开，避免发生歧义
    public String buildVideoUrl(){
        return QiNiuConfig.CNAME + "/" + this.url;
    }

    public String buildCoverUrl(){
        return QiNiuConfig.CNAME + "/" + this.cover;
    }


}
