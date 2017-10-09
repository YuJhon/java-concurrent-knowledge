package com.jhon.rain.countdown;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * <p>功能描述</br> 系统启动的检查工具 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName AppStartUtil
 * @date 2017/10/9 14:22
 */
public class AppStartUtil {

	private AppStartUtil() {
	}

	private static class StartHolder {
		private final static AppStartUtil INSTANCE = new AppStartUtil();
	}

	public static AppStartUtil getInstance() {
		return StartHolder.INSTANCE;
	}

	private static List<BaseOuterSysChecker> checkers = new ArrayList<>();

	private static CountDownLatch latch;

	/**
	 * 执行检查的处理
	 * @return
	 * @throws InterruptedException
	 */
	public boolean checkProcess() throws InterruptedException {

		latch = new CountDownLatch(2);

		checkers.add(new UserSystem(latch));
		checkers.add(new OrderSystem(latch));

		Executor executors = Executors.newFixedThreadPool(checkers.size());

		for (final BaseOuterSysChecker checker : checkers) {
			executors.execute(checker);
		}

		latch.await();

		for (final BaseOuterSysChecker checker : checkers) {
			if(!checker.isSysStatus()){
				return false;
			}
		}
		return true;
	}
}
