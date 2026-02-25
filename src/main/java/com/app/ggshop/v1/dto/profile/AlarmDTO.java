package com.app.ggshop.v1.dto.profile;

import com.app.ggshop.v1.common.enumeration.AlarmStatus;
import com.app.ggshop.v1.domain.*;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
public class AlarmDTO {
    private Long memberId;
    private Long wishId;
    private AlarmStatus wishStatus;
    private Long reviewId;
    private AlarmStatus reviewStatus;
    private Long followId;
    private AlarmStatus followStatus;
    private Long commentId;
    private AlarmStatus commentStatus;
    private Long boardId;
    private AlarmStatus boardStatus;

    public BoardAlarmVO toBoardAlarmVO() {
        return BoardAlarmVO
            .builder()
            .id(boardId)
            .status(boardStatus)
            .memberId(this.memberId)
            .build();
    }
    public CommentAlarmVO toCommentAlarmVO() {
        return CommentAlarmVO
            .builder()
            .id(commentId)
            .status(commentStatus)
            .memberId(this.memberId)
            .build();
    }
    public FollowAlarmVO toFollowAlarmVO() {
        return FollowAlarmVO
            .builder()
            .id(followId)
            .status(followStatus)
            .memberId(this.memberId)
            .build();
    }
    public ReviewAlarmVO toReviewAlarmVO() {
        return ReviewAlarmVO
            .builder()
            .id(reviewId)
            .status(reviewStatus)
            .memberId(this.memberId)
            .build();
    }
    public WishAlarmVO toWishAlarmVO() {
        return WishAlarmVO
            .builder()
            .id(wishId)
            .status(wishStatus)
            .memberId(this.memberId)
            .build();
    }
}
