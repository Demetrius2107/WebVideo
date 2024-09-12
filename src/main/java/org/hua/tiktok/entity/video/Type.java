package org.hua.tiktok.entity.video;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hua.tiktok.entity.BaseEntity;

import java.util.Arrays;
import java.util.List;

/**
 * 分类,隐藏视频标签
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Type  extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private String description;

    private String icon;

    private Boolean open;

    private String labelNames;

    private Integer sort;

    @TableField(exist = false)
    private Boolean used;

    public List<String> buildLabel(){
        return Arrays.asList(labelNames.split(","));
    }

}
