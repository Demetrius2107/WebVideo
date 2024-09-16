package org.hua.tiktok.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统验证码
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Captcha implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "uuid为空")
    private String uuid;

    @NotBlank(message = "code为空")
    private String code;

    /**
     * 过期时间
     */
    private Date expireTime;

    @TableField(exist = false)
    @Email
    private String email;
}
