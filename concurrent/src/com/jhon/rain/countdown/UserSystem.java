package com.jhon.rain.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * <p>功能描述</br> 用户系统检查 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName UserSystem
 * @date 2017/10/9 14:14
 */
public class UserSystem extends BaseOuterSysChecker {

	public UserSystem(CountDownLatch latch) {
		super(latch, "UserSystem");
	}

	@Override
	boolean varifySystem() {
		System.out.println("Process Checking " + this.getSysId());
		boolean result = false;
		try {
			Thread.sleep(6000);
			result = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
}
