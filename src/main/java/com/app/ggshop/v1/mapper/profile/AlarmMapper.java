package com.app.ggshop.v1.mapper.profile;

import com.app.ggshop.v1.domain.*;
import com.app.ggshop.v1.dto.profile.AlarmDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AlarmMapper {
    public Optional<AlarmDTO> selectWishAlarm(Long memberId);
    public Optional<AlarmDTO> selectReviewAlarm(Long memberId);
    public Optional<AlarmDTO> selectFollowAlarm(Long memberId);
    public Optional<AlarmDTO> selectCommentAlarm(Long memberId);
    public Optional<AlarmDTO> selectBoardAlarm(Long memberId);
    public void insertWishAlarm(WishAlarmVO wishAlarmVO);
    public void insertReviewAlarm(ReviewAlarmVO reviewAlarmVO);
    public void insertFollowAlarm(FollowAlarmVO followAlarmVO);
    public void insertCommentAlarm(CommentAlarmVO commentAlarmVO);
    public void insertBoardAlarm(BoardAlarmVO boardAlarmVO);
    public void updateWishAlarm(WishAlarmVO wishAlarmVO);
    public void updateReviewAlarm(ReviewAlarmVO reviewAlarmVO);
    public void updateFollowAlarm(FollowAlarmVO followAlarmVO);
    public void updateCommentAlarm(CommentAlarmVO commentAlarmVO); // VO 타입 확인 필요
    public void updateBoardAlarm(BoardAlarmVO boardAlarmVO);
}
