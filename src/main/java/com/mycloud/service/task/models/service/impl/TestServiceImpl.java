package com.mycloud.service.task.models.service.impl;

import com.mycloud.service.task.models.service.ITestService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TestServiceImpl implements ITestService {

    @Override
    public String test() {
        return "当前时间："+ LocalDateTime.now().toLocalTime();
    }
}
