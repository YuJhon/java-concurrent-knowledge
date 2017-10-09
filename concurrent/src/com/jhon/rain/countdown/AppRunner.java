package com.jhon.rain.countdown;

/**
 * <p>功能描述</br> 运行程序 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName AppRunner
 * @date 2017/10/9 14:34
 */
public class AppRunner {

	public static void main(String[] args) throws Exception {
		boolean result = false;
		try {
			result = AppStartUtil.getInstance().checkProcess();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Outer System !! Result was :: "+ result);
	}
}
