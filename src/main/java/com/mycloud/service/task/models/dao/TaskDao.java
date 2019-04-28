package com.mycloud.service.task.models.dao;
import com.mycloud.service.task.models.domain.vo.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDao {
    /**
     * @// TODO: 2018/6/5 查询任务
     * @return
     */
    List<TaskEntity> findTaskList(TaskEntity taskEntity);
}