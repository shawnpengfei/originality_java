package com.ssy.app.dao;

import com.ssy.app.enity.ArtComment;

public interface ArtCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArtComment record);

    int insertSelective(ArtComment record);

    ArtComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArtComment record);

    int updateByPrimaryKey(ArtComment record);

    long selectCountByUid(long uid);
}