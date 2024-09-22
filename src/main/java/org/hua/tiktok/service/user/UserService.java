package org.hua.tiktok.service.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.hua.tiktok.entity.user.User;
import org.hua.tiktok.entity.video.Type;
import org.hua.tiktok.entity.vo.BasePage;
import org.hua.tiktok.entity.vo.RegisterVO;
import org.hua.tiktok.entity.vo.UserVO;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface UserService extends IService<User> {

    /**
     * 注册
     *
     * @param registerVO
     * @return
     * @throws Exception
     */
    boolean register(RegisterVO registerVO) throws Exception;

    /**
     * 获取用户信息
     * 1.用户基本信息
     * 2.关注数量
     * 3.粉丝数量
     *
     * @param userId 用户id
     * @return
     */
    UserVO getInfo(Long userId);

    /**
     * 获取关注
     *
     * @param userId
     * @param basePage
     * @return
     */
    Page<User> getFollows(Long userId, BasePage basePage);

    /**
     * 获取粉丝
     *
     * @param userId
     * @param basePage
     * @return
     */
    Page<User> getFans(Long userId, BasePage basePage);

    /**
     * 获取用户基本信息
     *
     * @param userIds
     * @return
     */
    List<User> list(Collection<Long> userIds);

    /**
     * 订阅分类
     *
     * @param typeIds
     */
    void subscribe(Set<Long> typeIds);

    /**
     * 获取订阅分类
     *
     * @param userId
     * @return
     */
    Collection<Type> listSubscribeType(Long userId);

    /**
     * 关注/取关
     *
     * @param followsUserId
     * @return
     */
    boolean follows(Long followsUserId);



}
