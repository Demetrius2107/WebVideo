package org.hua.tiktok.service.video.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hua.tiktok.entity.video.VideoStar;
import org.hua.tiktok.mapper.video.VideoStarMapper;
import org.hua.tiktok.service.video.VideoStarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoStarServiceImpl extends ServiceImpl<VideoStarMapper, VideoStar> implements VideoStarService {
    @Override
    public boolean starVideo(VideoStar videoStar) {
        return false;
    }

    @Override
    public List<Long> getStarUserIds(Long videoId) {
        return null;
    }

    @Override
    public Boolean starState(Long videoId, Long userId) {
        return null;
    }
}
