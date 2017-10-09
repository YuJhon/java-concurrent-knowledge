package com.jhon.rain.cyclebarrier;

/**
 * <p>功能描述</br> 庆祝时刻 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName CelebrationTime
 * @date 2017/10/9 15:35
 */
public class CelebrationTime implements Runnable {

	@Override
	public void run() {
		System.out.println("PM：We are finished this project,Cheer Up!");
	}
}
