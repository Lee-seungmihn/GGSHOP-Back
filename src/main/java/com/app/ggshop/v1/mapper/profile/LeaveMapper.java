package com.app.ggshop.v1.mapper.profile;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LeaveMapper {
    public void deleteMember(Long id);
}
