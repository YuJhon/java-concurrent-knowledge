package com.jhon.rain.mapsurround;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>功能描述</br> 多线程并发的情况下，ConcurrentHashMap使用过程中存在的问题 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName ConcurrentHashMapProblem
 * @date 2017/10/10 18:51
 */
public class ConcurrentHashMapProblem {

	private final Map<String, Long> callCounter = new ConcurrentHashMap<>();

	/**
	 * 获取次数+1
	 *
	 * @param key
	 * @return
	 */
	public long increase(String key) {
		Long previousVal = callCounter.get(key);
		Long newVal = 1L;
		if (previousVal != null) {
			newVal = previousVal + 1;
		}
		callCounter.put(key, newVal);
		return newVal;
	}

	/**
	 * @param key
	 * @return
	 */
	public long increaseNew(String key) {
		Long previousVal, newVal;
		while (true) {
			previousVal = callCounter.get(key);
			if (previousVal == null) {
				newVal = 1L;
				/** 初始化成功，退出循环 **/
				if (callCounter.putIfAbsent(key, 1L) == null) {
					break;
				}
			} else {
				newVal = previousVal + 1;
				/** +1成功，退出循环 **/
				if (callCounter.replace(key, previousVal, newVal)) {
					/** 如果+1失败，说明其他线程已经修改过了旧值 **/
					break;
				}
			}
		}
		return newVal;
	}

	/**
	 * 获取次数
	 *
	 * @param key
	 * @return
	 */
	public Long getCallCount(String key) {
		return callCounter.get(key);
	}

	public static void main(String[] args) throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		final ConcurrentHashMapProblem instance = new ConcurrentHashMapProblem();
		int callTimes = 100000;
		final String key = "JhonRain";
		CountDownLatch latch = new CountDownLatch(callTimes);
		for (int i = 0; i < callTimes; i++) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
					//instance.increase(key);
					instance.increaseNew(key);
					latch.countDown();
				}
			});
		}

		try {
			latch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		executor.shutdown();
		System.out.println("调用次数：" + instance.getCallCount(key));
	}
}
