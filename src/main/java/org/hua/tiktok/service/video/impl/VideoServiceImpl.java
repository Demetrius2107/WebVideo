package org.hua.tiktok.service.video.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hua.tiktok.entity.video.Video;
import org.hua.tiktok.entity.video.VideoShare;
import org.hua.tiktok.entity.vo.BasePage;
import org.hua.tiktok.entity.vo.HotVideo;
import org.hua.tiktok.mapper.video.VideoMapper;
import org.hua.tiktok.service.video.VideoService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {
    @Override
    public Video getVideoById(Long id, Long userId) {
        return null;
    }

    @Override
    public void publishVideo(Video video) {

    }

    @Override
    public void deleteVideo(Long id) {

    }

    @Override
    public Collection<Video> pushVideos(Long userId) {
        return null;
    }

    @Override
    public Collection<Video> getVideoByTypeId(Long typeId) {
        return null;
    }

    @Override
    public IPage<Video> searchVideo(String search, BasePage basePage, Long userId) {
        return null;
    }

    @Override
    public void auditProcess(Video video) {

    }

    @Override
    public boolean startVideo(Long videoId) {
        return false;
    }

    @Override
    public boolean shareVideo(VideoShare videoShare) {
        return false;
    }

    @Override
    public void historyVideo(Long videoId, Long userId) throws Exception {

    }

    @Override
    public boolean favoritesVideo(Long fId, Long vId) {
        return false;
    }

    @Override
    public LinkedHashMap<String, List<Video>> getHistory(BasePage basePage) {
        return null;
    }

    @Override
    public Collection<Video> listVideoByFavorites(Long favortiesId) {
        return null;
    }

    @Override
    public Collection<HotVideo> hotRank() {
        return null;
    }

    @Override
    public Collection<Video> listSimilarVideo(Video video) {
        return null;
    }

    @Override
    public IPage<Video> listByUserIdOpenVideo(Long userId, BasePage basePage) {
        return null;
    }

    @Override
    public String getAuditQueueState() {
        return null;
    }

    @Override
    public List<Video> selectNDaysAgeVideo(long id, int days, int limit) {
        return null;
    }

    @Override
    public Collection<Video> listHostVideo() {
        return null;
    }

    @Override
    public Collection<Video> followFeed(Long userId, Long lastTime) {
        return null;
    }

    @Override
    public void initFollowFeed(Long userId) {

    }

    @Override
    public IPage<Video> listByUserIdVideo(BasePage basePage, Long userId) {
        return null;
    }

    @Override
    public Collection<Long> listVideoIdByUserId(Long userId) {
        return null;
    }

    @Override
    public void violations(Long id) {

    }
}
