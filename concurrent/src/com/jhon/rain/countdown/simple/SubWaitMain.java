package com.jhon.rain.countdown.simple;

import java.util.concurrent.CountDownLatch;

/**
 * <p>功能描述</br> CountDownLatch简单使用案例[五个子任务必须要等主任务执行完才能执行] </p>
 * <p>
 *   CountDownLatch是通过一个计数器来实现的，计数器的初始值为线程的数量。
 *   每当一个线程完成了自己的任务后，计数器的值就会减1。
 *   当计数器值到达0时，它表示所有的线程已经完成了任务，然后在闭锁上等待的线程就可以恢复执行任务。
 * </p>
 * @author jiangy19
 * @version v1.0
 * @FileName SubWaitMain
 * @date 2017/10/9 11:36
 */
public class SubWaitMain {

	public static void main(String[] args) throws Exception {
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(5);

		/** 依次创建5个worker线程 **/
		for (int i=0; i<5;i++) {
			new Thread(new Worker(startSignal,doneSignal)).start();
		}

		System.out.println("SubWaitMain Is Doing Something.");
		Thread.sleep(5000);
		System.out.println("SubWaitMain Is Finished. Send Signal To Worker");
		startSignal.countDown();
		doneSignal.await();
		System.out.println("Woker Is Finished...");
	}

	/**
	 * Subworker Thread
	 **/
	static class Worker implements Runnable {

		private final CountDownLatch startSignal;

		private final CountDownLatch doneSignal;

		Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
			this.startSignal = startSignal;
			this.doneSignal = doneSignal;
		}

		@Override
		public void run() {
			try {
				startSignal.await();
				System.out.println(Thread.currentThread().getName()+" Working Starting ... ");
				/** 当前worker执行完毕，释放一个完成信号 **/
				doneSignal.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
