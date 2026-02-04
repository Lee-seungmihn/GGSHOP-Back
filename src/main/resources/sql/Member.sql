# use GGSHOP;


create table tbl_member
( #회원
    #
    id              bigint unsigned auto_increment primary key,
    member_email    varchar(255) not null,
    member_password varchar(255) not null,
    member_name     varchar(255) not null,
    member_address  varchar(255) not null,
    member_filter   enum ('individual', 'company') default 'individual',
    member_status   enum ('enable', 'disable')     default 'enable',
    created_date    datetime                       default current_timestamp(),
    updated_date    datetime                       default current_timestamp()
    #
);

create table tbl_member_follow
( #회원 팔로우/팔로잉
    #
    id           bigint unsigned auto_increment primary key,
    follower_id  bigint unsigned not null,
    following_id bigint unsigned not null,
    constraint fk_follower_member_id foreign key (follower_id) references tbl_member (id),
    constraint fk_following_member_id foreign key (following_id) references tbl_member (id),
    created_date datetime default current_timestamp(),
    updated_date datetime default current_timestamp()
    #
);

create table tbl_member_notification
( #게시 알림
    #
    id                     bigint unsigned auto_increment primary key,
    notification_member_id bigint unsigned not null,
    constraint fk_member_id foreign key (notification_member_id) references tbl_member (id),
    #
);


create table tbl_member_pick
( #인기 추천
    #


    #
);

create table tbl_member_wish
( #회원 위시리스트
#
    board_id bigint unsigned not null,
    constraint fk_wish_board_id foreign key (board_id) references tbl_board (id)
#
);
#
create table tbl_board
( #거래 게시글
#
    id              bigint unsigned auto_increment primary key,
    title           varchar(255)    not null,
    content         text            not null,
    board_filter    enum ('all', '구매', '판매')   default 'all',
    board_status    enum ('enable', 'disable') default 'enable',
    created_date    datetime                   default current_timestamp(),
    updated_date    datetime                   default current_timestamp(),
    board_member_id bigint unsigned not null,
    constraint fk_board_member_id foreign key (board_member_id) references tbl_member (id)
#
);

create table tbl_board_hash
( #거래 해시태그
    id            bigint unsigned auto_increment primary key,
    hash_board_id bigint unsigned not null,
    constraint fk_hash_board_id foreign key (hash_board_id) references tbl_board (id)
#
);
create table tbl_board_payment
( #개인간거래내역
#
    id                bigint unsigned auto_increment primary key,
    payment_status    enum ('enable', 'disable') default 'enable',
    created_date      datetime                   default current_timestamp(),
    updated_date      datetime                   default current_timestamp(),
    payment_member_id bigint unsigned not null,
    constraint fk_payment_member_id foreign key (payment_member_id) references tbl_member (id),
    payment_board_id  bigint unsigned not null,
    constraint fk_payment_board_id foreign key (payment_board_id) references tbl_board (id)


);
#
create table tbl_car
( #자동차
#
    id              bigint unsigned auto_increment primary key,
    owner_name      varchar(255)    not null,
    owner_birthdate varchar(255)    not null,
    plate_number    varchar(255)    not null,
    energy_gauge    varchar(255)    not null,
    car_status      enum ('enable', 'disable') default 'enable',
    car_filter      enum ('양방향', '일반')         default '일반',
    created_date    datetime                   default current_timestamp(),
    updated_date    datetime                   default current_timestamp(),
    car_member_id   bigint unsigned not null,
    constraint fk_car_member_id foreign key (car_member_id) references tbl_member (id)

);
#
create table tbl_cpo
( #기업(회사)
#
    id bigint unsigned auto_increment primary key,
    charger
        cpo_ev_charger_id bigint unsigned not null,
    constraint fk_cpo_ev_charger_id foreign key (cpo_ev_charger_id) references tbl_member (id)

);


#

create table tbl_ev_charger
( #EV충전기
#
    id                 bigint unsigned auto_increment primary key,
    ev_charger_address varchar(255)    not null,
    ev_charger_status  enum ('enable', 'disable') default 'enable',
    created_date       datetime                   default current_timestamp(),
    updated_date       datetime                   default current_timestamp(),
    cpo_id             bigint unsigned not null,
    constraint fk_cpo_ev_charger_id foreign key (cpo_id) references tbl_cpo (id)
);
#
create table tbl_cpo_employee
(#wlr
#
    id                 bigint unsigned auto_increment primary key,
    cpo_employee_email varchar(255) not null ,
    ev_charger_address varchar(255)    not null,
    cpo_employee_status  enum ('enable', 'disable') default 'enable',
    created_date       datetime                   default current_timestamp(),
    updated_date       datetime                   default current_timestamp(),
    cpo_id             bigint unsigned not null,
    constraint fk_cpo_ev_charger_id foreign key (cpo_id) references tbl_cpo (id)
);

create table tbl_admin#기업관리자
#
create table tbl_v_to_g_payment;
#VtoG거래내역
#

#
create table tbl_review;
#리뷰
#

#
create table tbl_comment
( #댓글
#
    id                bigint unsigned auto_increment primary key,
    comment_status    enum ('enable', 'disable') default 'enable',

    created_date      datetime                   default current_timestamp(),
    updated_date      datetime                   default current_timestamp(),
    comment_board_id  bigint unsigned not null,
    constraint fk_comment_board_id foreign key (comment_board_id) references tbl_board (id),
    comment_member_id bigint unsigned not null,
    constraint fk_comment_member_id foreign key (comment_member_id) references tbl_member (id)
#
);
#
create table tbl_file;
#이미지
#
