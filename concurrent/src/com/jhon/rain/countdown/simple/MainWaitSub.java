package com.jhon.rain.countdown.simple;

import java.util.concurrent.CountDownLatch;

/**
 * <p>功能描述</br> 主任务等待子任务完成之后才能完成 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName MainWaitSub
 * @date 2017/10/9 11:57
 */
public class MainWaitSub {

	public static void main(String[] args) throws Exception {
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(5);

		for (int i = 0; i < 5; i++) {
			new Thread(new Worker(startSignal, doneSignal)).start();
		}
		doneSignal.await();
		System.out.println("Sub Worker Is Done All Task...");
		new Thread(() -> {
			startSignal.countDown();
		}).start();
		startSignal.await();
		System.out.println("Main Task Is Starting Process...");
		System.out.println("Main Task Is Finished...");
	}


	static class Worker implements Runnable {

		private final CountDownLatch startSignal;

		private final CountDownLatch doneSignal;

		public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
			this.startSignal = startSignal;
			this.doneSignal = doneSignal;
		}

		@Override
		public void run() {
			System.out.println("ThreadName=" + Thread.currentThread().getName() + " Process Finished !");
			doneSignal.countDown();
		}
	}

}
