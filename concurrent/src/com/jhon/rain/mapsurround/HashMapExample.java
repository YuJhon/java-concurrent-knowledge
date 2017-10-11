package com.jhon.rain.mapsurround;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>功能描述</br> JDK 8中 Map的遍历 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName HashMapExample
 * @date 2017/10/11 11:41
 */
public class HashMapExample {

	public static void main(String[] args) throws Exception {
		Map<String, Integer> items = new HashMap<>();
		items.put("ItemA", 10);
		items.put("ItemB", 20);
		items.put("ItemC", 30);
		items.put("ItemD", 40);
		items.put("ItemE", 50);
		items.put("ItemF", 60);

		items.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));

		items.forEach((k, v) -> {
			System.out.println("Item : " + k + " Count : " + v);
			if ("ItemE".equals(k)) {
				System.out.println("Hello E");
			}
		});
	}
}
