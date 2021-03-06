package com.eagle.cloud.route.config;

import com.eagle.cloud.route.service.ODMethorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Slf4j
@Component
public class ScheduledTask {

    @Autowired
    private ODMethorService ODMethorService;

////    @Scheduled(fixedRate = 1000 * 60 * 2)
//    @Async
//    @Scheduled(cron = "0 0/2 * * * ?")
//    public void twoTesk() {
//        log.info("每 2 分钟执行一次");
//        screenService.getGDReadInfo();
//        //计算section 时间和距离
//        screenService.getSectionCountInfo();
//    }

    @Async
    @Scheduled(cron = "*/10 * * * * ?")
    public void twoTesk() {
        log.info("每10s执行一次");
        ODMethorService.getODFromLS();
    }

}
