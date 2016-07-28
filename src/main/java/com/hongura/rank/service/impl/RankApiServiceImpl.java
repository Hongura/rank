package com.hongura.rank.service.impl;

import com.hongura.rank.domain.RankApi;
import com.hongura.rank.domain.RankApiMapper;
import com.hongura.rank.service.RankApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hongura on 2016-07-26.
 */
@Service
public class RankApiServiceImpl implements RankApiService {

    @Autowired
    RankApiMapper rankApiMapper;
    @Override
    public List<RankApi> getRankList() {
        return rankApiMapper.getRankList();
    }
}
