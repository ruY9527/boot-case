package com.iyang.txlcn.order.provider;

import com.iyang.txlcn.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Yang
 * 当前服务 : txlcn-init
 * @date 2020/10/12 / 17:40
 */

@FeignClient("repprovider")
public interface RepositoryService {

    @PostMapping("/provider/repository/changecount.do")
    R change(@RequestParam int gid, @RequestParam int count);

}
