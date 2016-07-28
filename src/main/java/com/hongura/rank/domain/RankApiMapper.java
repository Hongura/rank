package com.hongura.rank.domain;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by hongura on 2016-07-26.
 */
@Mapper
public interface RankApiMapper {
    List<RankApi> getRankList();
}
