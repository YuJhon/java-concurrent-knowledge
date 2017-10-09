package com.jhon.rain.cyclebarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <p>功能描述</br> 程序员处理特定的模块 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName Programmer
 * @date 2017/10/9 15:36
 */
public class Programmer extends Thread {

	private String moduleName;

	private String programmerName;

	private CyclicBarrier cyclicBarrier;

	private int needTime;

	public Programmer(String moduleName, String programmerName, int needTime, CyclicBarrier barrier) {
		this.moduleName = moduleName;
		this.programmerName = programmerName;
		this.needTime = needTime;
		this.cyclicBarrier = barrier;
	}

	@Override
	public void run() {
		System.out.println("程序猿："+programmerName+",[协同任务]"+moduleName+" 开始执行。。。");
		try {
			Thread.sleep(needTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("程序猿："+programmerName+",[协同任务]"+moduleName+" 执行结束。。。耗时(ms)"+needTime+",通知Barrier.");
		try {
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
