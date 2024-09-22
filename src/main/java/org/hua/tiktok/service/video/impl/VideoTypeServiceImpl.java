package org.hua.tiktok.service.video.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hua.tiktok.entity.video.VideoType;
import org.hua.tiktok.mapper.video.VideoTypeMapper;
import org.hua.tiktok.service.video.VideoTypeService;
import org.springframework.stereotype.Service;

@Service
public class VideoTypeServiceImpl extends ServiceImpl<VideoTypeMapper, VideoType> implements VideoTypeService {
}
