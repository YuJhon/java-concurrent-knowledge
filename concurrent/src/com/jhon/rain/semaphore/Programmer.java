package com.jhon.rain.semaphore;

import java.util.concurrent.Semaphore;

/**
 * <p>功能描述</br> 程序猿 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName Programmer
 * @date 2017/10/9 16:30
 */
public class Programmer extends Thread {

	private int num;

	private Semaphore semaphore;

	public Programmer(int num, Semaphore semaphore) {
		this.num = num;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			semaphore.acquire();
			System.out.println("程序猿" + this.num + "占用一个厕所坑位...");
			Thread.sleep(2000);
			System.out.println("程序猿" + this.num + "释放一个厕所坑位...");
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
