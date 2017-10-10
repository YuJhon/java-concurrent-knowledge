package com.jhon.rain.executors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>功能描述</br> 自定义线程池 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName CustomThreadPoolExecutor
 * @date 2017/10/10 9:34
 */
public class CustomThreadPoolExecutor {

	public static void main(String[] args) throws Exception {
		/** 创建等待队列 **/
		BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(20);
		/** 创建线程池，池中保存的线程数为3，允许最大的线程数为5 **/
		ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 50, TimeUnit.SECONDS, blockingQueue);
		/** 创建几个任务 **/
		Runnable runnable01 = new DemoThread();
		Runnable runnable02 = new DemoThread();
		Runnable runnable03 = new DemoThread();
		Runnable runnable04 = new DemoThread();
		Runnable runnable05 = new DemoThread();
		Runnable runnable06 = new DemoThread();
		Runnable runnable07 = new DemoThread();
		/** 执行 **/
		pool.execute(runnable01);
		pool.execute(runnable02);
		pool.execute(runnable03);
		pool.execute(runnable04);
		pool.execute(runnable05);
		pool.execute(runnable06);
		pool.execute(runnable07);

		/** 执行完成之后 **/
		pool.shutdown();
	}
}

/**
 * 自定义的线程接口
 */
class DemoThread implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "正在执行。。。");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
