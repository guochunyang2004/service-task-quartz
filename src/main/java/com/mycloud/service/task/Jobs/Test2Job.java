package com.mycloud.service.task.Jobs;

import com.mycloud.service.task.models.domain.vo.TaskEntity;
import com.mycloud.service.task.models.service.ITaskService;
import com.mycloud.service.task.models.service.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

//@DisallowConcurrentExecution//第一个任务执行完成后才会执行第二个任务
@Slf4j
@Component
public class Test2Job extends QuartzJobBean {
    @Autowired
    ITestService testService;
    @Autowired
    ITaskService taskService;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("任务开始");
        try {
            System.out.println(testService.test());
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setJobName("testJob");
            taskEntity.setJobGroup("测试组");
            List<TaskEntity> list = taskService.findTaskList(taskEntity);
            list.forEach(e->{
                System.out.print("JobName:");
                System.out.println(e.getJobName());
            });

        }
        catch (Exception ex){
            log.error("test()",ex);
        }
        System.out.println("任务结束");
    }
}
