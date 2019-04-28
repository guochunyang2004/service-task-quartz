package com.mycloud.service.task.Jobs;

import com.mycloud.service.task.models.service.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class TestJob extends QuartzJobBean {

    @Autowired
    ITestService testService;

//    @Override
//    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println(LocalDateTime.now().toString()+"这是一个测试任务的！");
//       try {
//           System.out.println(testService.test());
//       }
//       catch (Exception ex){
//           log.error("test()",ex);
//       }
//    }
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("任务开始");
        try {
            System.out.println(testService.test());
        }
        catch (Exception ex){
            log.error("test()",ex);
        }
        System.out.println("任务结束");
    }
}