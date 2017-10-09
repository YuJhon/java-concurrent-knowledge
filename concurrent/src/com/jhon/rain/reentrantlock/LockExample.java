package com.jhon.rain.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>功能描述</br> Lock/ReentrantLock 可重入示例 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName LockExample
 * @date 2017/10/9 19:15
 */
public class LockExample {

	private Lock lock = new ReentrantLock();

	public static void main(String[] args) throws Exception {
		new LockExample().methodA();
	}

	public synchronized void methodA() {
		lock.lock();
		try {
			System.out.println("MethodA Acquire ReentrantLock Running Code。。。");
			methodB();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public synchronized void methodB() {
		lock.lock();
		try {
			System.out.println("Call MethodB Through MethodA，Also Can Acquire ReentrantLock Runing Code。。。");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
