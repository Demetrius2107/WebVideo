package org.hua.tiktok.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.hua.tiktok.entity.Captcha;

import java.awt.image.BufferedImage;

/**
 * 系统验证码
 */
public interface CaptchaService  extends IService<Captcha> {

    BufferedImage gerCaptcha(String uuId);

    boolean validate(Captcha captcha) throws Exception;
}
