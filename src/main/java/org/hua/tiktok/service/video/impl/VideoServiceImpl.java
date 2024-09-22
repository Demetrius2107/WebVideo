package org.hua.tiktok.service.video.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.hua.tiktok.entity.File;
import org.hua.tiktok.entity.user.User;
import org.hua.tiktok.entity.video.Video;
import org.hua.tiktok.entity.video.VideoShare;
import org.hua.tiktok.entity.vo.BasePage;
import org.hua.tiktok.entity.vo.HotVideo;
import org.hua.tiktok.exception.BaseException;
import org.hua.tiktok.mapper.video.VideoMapper;
import org.hua.tiktok.service.FileService;
import org.hua.tiktok.service.user.UserService;
import org.hua.tiktok.service.video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Autowired
    private FileService fileService;

    @Autowired
    private UserService userService;
    @Override
    public Video getVideoById(Long videoId, Long userId) {
        final Video video = this.getOne(new LambdaQueryWrapper<Video>().eq(Video::getId, videoId));
        if (video == null) throw new BaseException("指定视频不存在");

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

    public void setUserVOAndUrl(Collection<Video> videos) {
        if (!ObjectUtils.isEmpty(videos)) {
            Set<Long> userIds = new HashSet<>();
            final ArrayList<Long> fileIds = new ArrayList<>();
            for (Video video : videos) {
                userIds.add(video.getUserId());
                fileIds.add(video.getUrl());
                fileIds.add(video.getCover());
            }
            final Map<Long, File> fileMap  = fileService.listByIds(fileIds).stream().collect(Collectors.toMap(File::getId, Function.identity()));
            final Map<Long, User> userMap = userSer

        }
    }
}
