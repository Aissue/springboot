package com.aissue.springboot.service.impl;

import com.aissue.springboot.service.BaseJob;
import org.apache.commons.lang.time.DateFormatUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class NewJob implements BaseJob {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("NewJob..."+ DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
    }
}
