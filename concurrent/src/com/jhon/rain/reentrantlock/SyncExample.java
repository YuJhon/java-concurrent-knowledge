package com.jhon.rain.reentrantlock;

/**
 * <p>功能描述</br> 内置锁演示可重入 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName SyncExample
 * @date 2017/10/9 19:14
 */
public class SyncExample {

	public static void main(String[] args) throws Exception {
		new SyncExample().methodA();
	}

	public synchronized void methodA() {
		System.out.println("MethodA Acquire 内置锁运行代码。。。");
		methodB();
	}

	public synchronized void methodB() {
		System.out.println("Call MethodB Through MethodA，Also Can Acquire 内置锁运行。。。");
	}
}
