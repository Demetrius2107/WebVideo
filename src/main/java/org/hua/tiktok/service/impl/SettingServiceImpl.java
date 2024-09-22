package org.hua.tiktok.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hua.tiktok.entity.Setting;
import org.hua.tiktok.mapper.SettingMapper;
import org.hua.tiktok.service.SettingService;
import org.springframework.stereotype.Service;

@Service
public class SettingServiceImpl extends ServiceImpl<SettingMapper, Setting> implements SettingService {
}
