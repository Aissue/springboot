package com.aissue.springboot.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtil {
    public static void submit(Thread thread){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(thread);
    }
}
