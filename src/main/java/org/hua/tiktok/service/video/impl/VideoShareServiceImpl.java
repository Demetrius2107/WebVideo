package org.hua.tiktok.service.video.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hua.tiktok.entity.video.VideoShare;
import org.hua.tiktok.mapper.video.VideoShareMapper;
import org.hua.tiktok.service.video.VideoShareService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoShareServiceImpl extends ServiceImpl<VideoShareMapper, VideoShare> implements VideoShareService {
    @Override
    public boolean share(VideoShare videoShare) {
        return false;
    }

    @Override
    public List<Long> getShareUserId(Long videoId) {
        return null;
    }
}
