# 14
create table tbl_car
( #자동차
    id               bigint unsigned auto_increment primary key,
    car_plate_number varchar(255)    null,
    car_energy_gauge varchar(255)    null,
    car_status       enum ('active', 'inactive') default 'active',
    car_filter       enum ('twoway', 'oneway')   default 'oneway',
    created_date     datetime                    default current_timestamp(),
    updated_date     datetime                    default current_timestamp(),
    car_member_id    bigint unsigned not null,
    constraint fk_car_member_id foreign key (car_member_id) references tbl_member (id)
);

DROP TABLE tbl_car;
SET foreign_key_checks = 1;
select * from tbl_car;
SELECT id FROM tbl_car;

