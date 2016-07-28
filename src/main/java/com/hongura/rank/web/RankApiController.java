package com.hongura.rank.web;

import com.hongura.rank.domain.RankApi;
import com.hongura.rank.service.RankApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by hongura on 2016-07-26.
 */
@Controller
public class RankApiController {

    @Autowired
    RankApiService rankApiService;

    @RequestMapping(value ="/api/v1/rank",method= RequestMethod.PUT)
    @ResponseBody
    public String set() {

        return "a";

    }

    @RequestMapping(value ="/api/v1/rank",method= RequestMethod.GET)
    @ResponseBody
    public String get() {
        List<RankApi> list = rankApiService.getRankList();
        return "a";

    }

}
