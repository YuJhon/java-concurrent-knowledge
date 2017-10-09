package com.jhon.rain.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * <p>功能描述</br> 订单管理系统 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName OrderSystem
 * @date 2017/10/9 14:14
 */
public class OrderSystem extends BaseOuterSysChecker {

	public OrderSystem(CountDownLatch latch) {
		super(latch, "OrderSystem");
	}

	@Override
	boolean varifySystem() {
		System.out.println("Process Checking " + this.getSysId());
		boolean result = false;
		try {
			Thread.sleep(5000);
			result = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
}
