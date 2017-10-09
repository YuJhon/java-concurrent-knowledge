package com.jhon.rain.semaphore;

import java.util.concurrent.Semaphore;

/**
 * <p>功能描述</br> 上班中程序猿上厕所竞争坑位  </p>
 * <p>
 *   程序猿0占用一个厕所坑位...
 *	 程序猿1占用一个厕所坑位...
 *	 程序猿2占用一个厕所坑位...
 *	 程序猿3占用一个厕所坑位...
 *	 程序猿4占用一个厕所坑位...
 *	 程序猿0释放一个厕所坑位...
 *	 程序猿1释放一个厕所坑位...
 *	 程序猿5占用一个厕所坑位...
 *	 程序猿6占用一个厕所坑位...
 *	 程序猿2释放一个厕所坑位...
 *	 程序猿7占用一个厕所坑位...
 *	 程序猿3释放一个厕所坑位...
 *	 程序猿8占用一个厕所坑位...
 *	 程序猿4释放一个厕所坑位...
 *	 程序猿9占用一个厕所坑位...
 *	 程序猿5释放一个厕所坑位...
 *	 程序猿7释放一个厕所坑位...
 *	 程序猿6释放一个厕所坑位...
 *	 程序猿8释放一个厕所坑位...
 *	 程序猿9释放一个厕所坑位...
 * </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName Working
 * @date 2017/10/9 16:30
 */
public class Working {

	private static final Integer PROGRAMMER_COUNT = 10;

	private static final Integer WASHROOM_COUNT = 5;

	public static void main(String[] args) throws Exception {
		Semaphore semaphore = new Semaphore(WASHROOM_COUNT);
		for (int i = 0; i < PROGRAMMER_COUNT; i++) {
			new Programmer(i, semaphore).start();
		}
	}
}