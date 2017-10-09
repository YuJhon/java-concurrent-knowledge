package com.jhon.rain.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * <p>功能描述</br> CountDownLatch并发类的案例 </p>
 * <p>
 * 1.解释一下CountDownLatch概念?
 *   CountDownLatch是通过一个计数器来实现的，计数器的初始值为线程的数量。
 *   每当一个线程完成了自己的任务后，计数器的值就会减1。
 *   当计数器值到达0时，它表示所有的线程已经完成了任务，然后在闭锁上等待的线程就可以恢复执行任务。
 *
 * 2.CountDownLatch 和 CyclicBarrier的不同之处?
 *  2.1 CountDownLatch减计数，CyclicBarrier加计数
 *
 *  2.2 CountDownLatch是一次性的，CyclicBarrier可以重用
 *
 *  2.3 CountDownLatch强调的是一个线程（或多个）需要等待另外的n个线程干完某件事情之后才能继续执行
 *    [
 *     A synchronization aid that allows one or more threads to wait until
 *     a set of operations being performed in other threads completes.
 *    ]
 *  2.4 CyclicBarrier强调的是n个线程，大家相互等待，只要有一个没完成，所有人都得等着
 *    [
 *      A synchronization aid that allows a set of threads to all wait for
 *      each other to reach a common barrier point.  CyclicBarriers are
 *      useful in programs involving a fixed sized party of threads that
 *      must occasionally wait for each other. The barrier is called
 *      <em>cyclic</em> because it can be re-used after the waiting threads
 *      are released.
 *    ]
 *
 * 3.给出一些CountDownLatch使用的例子?
 *
 * 4.CountDownLatch 类中主要的方法?
 *   countDown();
 *   await(); 调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
 *   await(long timeout, TimeUnit unit); 和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
 * </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName BaseOuterSysChecker
 * @date 2017/10/9 11:24
 */
public abstract class BaseOuterSysChecker implements Runnable {

	private CountDownLatch startLatch;

	private String sysId;

	private boolean sysStatus;

	public BaseOuterSysChecker(CountDownLatch startLatch, String sysId) {
		this.startLatch = startLatch;
		this.sysId = sysId;
		this.sysStatus = Boolean.FALSE;
	}

	public String getSysId() {
		return sysId;
	}

	public boolean isSysStatus() {
		return sysStatus;
	}

	@Override
	public void run() {
		try {
			sysStatus = varifySystem();
		} catch (Throwable t) {
			t.printStackTrace(System.err);
			sysStatus = false;
		} finally {
			if (startLatch != null) {
				startLatch.countDown();
			}
		}
	}

	/**
	 * 检查系统
	 *
	 * @return
	 */
	abstract boolean varifySystem();
}
