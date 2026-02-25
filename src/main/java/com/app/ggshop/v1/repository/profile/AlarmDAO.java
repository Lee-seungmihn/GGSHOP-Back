package com.app.ggshop.v1.repository.profile;

import com.app.ggshop.v1.domain.*;
import com.app.ggshop.v1.dto.profile.AlarmDTO;
import com.app.ggshop.v1.mapper.profile.AlarmMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AlarmDAO {
    private final AlarmMapper alarmMapper;

    // 알람관련 조회
    public Optional<AlarmDTO> findWishAlarm(Long memberId) { return alarmMapper.selectWishAlarm(memberId);}
    public Optional<AlarmDTO> findBoardAlarm(Long memberId) { return alarmMapper.selectBoardAlarm(memberId);}
    public Optional<AlarmDTO> findCommentAlarm(Long memberId) { return alarmMapper.selectCommentAlarm(memberId);}
    public Optional<AlarmDTO> findFollowAlarm(Long memberId) { return alarmMapper.selectFollowAlarm(memberId);}
    public Optional<AlarmDTO> findReviewAlarm(Long memberId) { return alarmMapper.selectReviewAlarm(memberId);}

    //  알람관련 등록
    public void saveWishAlarm(WishAlarmVO wishAlarmVO) { alarmMapper.insertWishAlarm(wishAlarmVO); }
    public void saveBoardAlarm(BoardAlarmVO boardAlarmVO) { alarmMapper.insertBoardAlarm(boardAlarmVO); }
    public void saveCommentAlarm(CommentAlarmVO commentAlarmVO) { alarmMapper.insertCommentAlarm(commentAlarmVO); }
    public void saveFollowAlarm(FollowAlarmVO followAlarmVO) { alarmMapper.insertFollowAlarm(followAlarmVO); }
    public void saveReviewAlarm(ReviewAlarmVO reviewAlarmVO) { alarmMapper.insertReviewAlarm(reviewAlarmVO); }

    //  알람관련 수정
    public void changeWishAlarm(WishAlarmVO wishAlarmVO) { alarmMapper.updateWishAlarm(wishAlarmVO); }
    public void changeBoardAlarm(BoardAlarmVO boardAlarmVO) { alarmMapper.updateBoardAlarm(boardAlarmVO); }
    public void changeCommentAlarm(CommentAlarmVO commentAlarmVO) { alarmMapper.updateCommentAlarm(commentAlarmVO); }
    public void changeFollowAlarm(FollowAlarmVO followAlarmVO) { alarmMapper.updateFollowAlarm(followAlarmVO); }
    public void changeReviewAlarm(ReviewAlarmVO reviewAlarmVO) { alarmMapper.updateReviewAlarm(reviewAlarmVO); }

}
