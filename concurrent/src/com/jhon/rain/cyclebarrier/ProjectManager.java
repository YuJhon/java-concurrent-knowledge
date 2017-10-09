package com.jhon.rain.cyclebarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * <p>功能描述</br> 项目经理分配任务 </p>
 * <p>Result</p>
 * <p>
 * 程序猿：ProgrammA,[协同任务]用户管理 开始执行。。。
 * 程序猿：ProgrammB,[协同任务]订单管理 开始执行。。。
 * 程序猿：ProgrammC,[协同任务]支付管理 开始执行。。。
 * 程序猿：ProgrammB,[协同任务]订单管理 执行结束。。。耗时(ms)1000,通知Barrier.
 * 程序猿：ProgrammA,[协同任务]用户管理 执行结束。。。耗时(ms)2000,通知Barrier.
 * 程序猿：ProgrammC,[协同任务]支付管理 执行结束。。。耗时(ms)3000,通知Barrier.
 * We are finished this project,Cheer Up!
 * <p>
 * </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName ProjectManager
 * @date 2017/10/9 15:43
 */
public class ProjectManager {

	public static void main(String[] args) throws Exception {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new CelebrationTime());
		new Programmer("用户管理", "ProgrammA", 2000, cyclicBarrier).start();
		new Programmer("订单管理", "ProgrammB", 1000, cyclicBarrier).start();
		new Programmer("支付管理", "ProgrammC", 3000, cyclicBarrier).start();
	}
}
