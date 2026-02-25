package com.app.ggshop.v1.service.profile;

import com.app.ggshop.v1.dto.profile.AddressDTO;
import com.app.ggshop.v1.dto.profile.AlarmDTO;
import com.app.ggshop.v1.repository.profile.AlarmDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class AlarmService {

    private final AlarmDAO alarmDAO;

    public void ConfirmAlarm(AlarmDTO alarmDTO) {
        Long memberId = alarmDTO.getMemberId();
        if (alarmDTO.getWishStatus() != null) {
            if(alarmDAO.findWishAlarm(memberId).isEmpty())
            {this.registerAlarm(alarmDTO);} else {this.updateAlarm(alarmDTO);}
        }
        if (alarmDTO.getBoardStatus() != null) {
            if(alarmDAO.findBoardAlarm(memberId).isEmpty())
            {this.registerAlarm(alarmDTO);} else {this.updateAlarm(alarmDTO);}
        }
        if (alarmDTO.getReviewStatus() != null) {
            if(alarmDAO.findReviewAlarm(memberId).isEmpty())
            {this.registerAlarm(alarmDTO);} else {this.updateAlarm(alarmDTO);}
        }
        if (alarmDTO.getCommentStatus() != null) {
            if(alarmDAO.findCommentAlarm(memberId).isEmpty())
            {this.registerAlarm(alarmDTO);} else {this.updateAlarm(alarmDTO);}
        }
        if (alarmDTO.getFollowStatus() != null) {
            if(alarmDAO.findFollowAlarm(memberId).isEmpty())
            {this.registerAlarm(alarmDTO);} else {this.updateAlarm(alarmDTO);}
        }
    }

    public void registerAlarm(AlarmDTO alarmDTO) {
        if (alarmDTO.getWishStatus() != null) {
            alarmDAO.saveWishAlarm(alarmDTO.toWishAlarmVO());
        }
        if (alarmDTO.getBoardStatus() != null) {
            alarmDAO.saveBoardAlarm(alarmDTO.toBoardAlarmVO());
        }
        if (alarmDTO.getReviewStatus() != null) {
            alarmDAO.saveReviewAlarm(alarmDTO.toReviewAlarmVO());
        }
        if (alarmDTO.getCommentStatus() != null) {
            alarmDAO.saveCommentAlarm(alarmDTO.toCommentAlarmVO());
        }
        if (alarmDTO.getFollowStatus() != null) {
            alarmDAO.saveFollowAlarm(alarmDTO.toFollowAlarmVO());
        }
    }

    public AlarmDTO getAlarmStatus(Long memberid) {
        AlarmDTO totalStatus = new AlarmDTO();
        totalStatus.setMemberId(memberid);
        alarmDAO.findWishAlarm(memberid).ifPresent(dto -> totalStatus.setWishStatus(dto.getWishStatus()));
        alarmDAO.findBoardAlarm(memberid).ifPresent(dto -> totalStatus.setBoardStatus(dto.getBoardStatus()));
        alarmDAO.findReviewAlarm(memberid).ifPresent(dto -> totalStatus.setReviewStatus(dto.getReviewStatus()));
        alarmDAO.findCommentAlarm(memberid).ifPresent(dto -> totalStatus.setCommentStatus(dto.getCommentStatus()));
        alarmDAO.findFollowAlarm(memberid).ifPresent(dto -> totalStatus.setFollowStatus(dto.getFollowStatus()));
        return totalStatus;
    }

    public void updateAlarm(AlarmDTO alarmDTO) {
        if (alarmDTO.getWishStatus() != null) {
            alarmDAO.changeWishAlarm(alarmDTO.toWishAlarmVO());
        }
        if (alarmDTO.getBoardStatus() != null) {
            alarmDAO.changeBoardAlarm(alarmDTO.toBoardAlarmVO());
        }
        if (alarmDTO.getReviewStatus() != null) {
            alarmDAO.changeReviewAlarm(alarmDTO.toReviewAlarmVO());
        }
        if (alarmDTO.getCommentStatus() != null) {
            alarmDAO.changeCommentAlarm(alarmDTO.toCommentAlarmVO());
        }
        if (alarmDTO.getFollowStatus() != null) {
            alarmDAO.changeFollowAlarm(alarmDTO.toFollowAlarmVO());
        }
    }
}