package com.jhon.rain.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>功能描述</br> Lock的使用场景 </p>
 * <p>
 *   case 1.reentrantLock.tryLock() : 如果已经被lock，则立即返回false不会等待，达到忽略操作的效果
 *   case 2.private Lock lock = new ReentrantLock(); // 默认为不公平锁
 *   case 3.private Lock lock = new ReentrantLock(true); // 公平锁形式
 *   case 4.lock.tryLock(2, TimeUnit.SECONDS); // 如果已经被lock，尝试等待2s，看是否可以获得锁，
 *          如果2s后仍然无法获得锁则返回false继续执行
 * </p>
 * @author jiangy19
 * @version v1.0
 * @FileName LockUseCase
 * @date 2017/10/9 19:33
 */
public class LockUseCase {

	private Lock reentrantLock = new ReentrantLock();

	public static void main(String[] args) throws Exception {

	}

	/**
	 * 逻辑处理
	 */
	public void logicalProcess() {
		if (reentrantLock.tryLock()) {
			try {
				reentrantLock.lock();
				/** Logical Process **/
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				reentrantLock.unlock();
			}
		}
	}
}
