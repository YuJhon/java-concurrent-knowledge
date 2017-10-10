package com.jhon.rain.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * <p>功能描述</br> Executor的Callable任务(Submit方法)，有返回值，通过Future来获取</p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName CallableTask
 * @date 2017/10/10 10:19
 */
public class CallableTask {

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<Future<String>> futures = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			Callable<String> callable = () -> "【Client"+ random.nextInt(100)+"】This Is Labda Expression Demo With Callable!";
			Future<String> future = executorService.submit(callable);
			futures.add(future);
		}

		/** 遍历任务的结果 **/
		for (Future<String> fs : futures) {
			try {
				while (!fs.isDone());
				/** Future返回如果没有完成，则一直循环等待，直到Future返回完成 **/
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				executorService.shutdown();
			}
		}
	}
}
