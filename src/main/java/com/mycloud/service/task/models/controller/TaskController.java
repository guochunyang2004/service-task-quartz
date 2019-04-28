package com.mycloud.service.task.models.controller;

import com.mycloud.service.task.models.domain.vo.TaskEntity;
import com.mycloud.service.task.models.service.impl.TaskServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lensen
 * @desc
 * @since 2018/8/8 13:36
 */
@Api("定时任务")
@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @ApiOperation(value = "添加", notes = "添加notes")
    @PostMapping(value = "/add")
    public ResponseEntity addTask(@RequestBody TaskEntity taskEntity) {
        return taskService.addTask(taskEntity) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "更新", notes = "更新notes")
    @PostMapping(value = "/update")
    public ResponseEntity updateTask(@RequestBody TaskEntity taskEntity) {
        return taskService.updateTask(taskEntity) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "查询", notes = "查询notes")
    @PostMapping(value = "/queryJob")
    public ResponseEntity queryJob(TaskEntity taskEntity) {
        List<TaskEntity> taskEntities = taskService.findTaskList(taskEntity);
        return taskEntities.size() == 0 ? new ResponseEntity("Not Exist!", HttpStatus.OK) : new ResponseEntity(taskEntities, HttpStatus.OK);
    }

    @ApiOperation(value = "删除", notes = "删除notes")
    @PostMapping(value = "/delete")
    public ResponseEntity deleteTask(@RequestBody TaskEntity taskEntity) {
        boolean flag = taskService.deleteTask(taskEntity);
        return flag ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "暂停", notes = "暂停notes")
    @PostMapping(value = "/pause")
    public ResponseEntity pauseTask(@RequestBody TaskEntity taskEntity) {
        boolean flag = taskService.pauseTask(taskEntity);
        return flag ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "重启", notes = "重启notes")
    @PostMapping(value = "/resume")
    public ResponseEntity resumeTask(@RequestBody TaskEntity taskEntity) {
        boolean flag = taskService.resumeTask(taskEntity);
        return flag ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}