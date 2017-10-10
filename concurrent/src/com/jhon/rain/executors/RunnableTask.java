package com.jhon.rain.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>功能描述</br> Executor的Runnable任务(Execute方法)，没有返回值</p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName RunnableTask
 * @date 2017/10/10 10:19
 */
public class RunnableTask {

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 5; i++) {
			executorService.execute(() -> {
				System.out.println("CurrentThread:" + Thread.currentThread().getName() + ",Execute Method.....");
			});
		}
		executorService.shutdown();
	}
}
