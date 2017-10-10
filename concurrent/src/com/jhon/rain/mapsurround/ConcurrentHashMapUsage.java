package com.jhon.rain.mapsurround;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>功能描述</br> ConcurrentHashMap的使用场景&注意事项 </p>
 * <p>
 *   [1].Concurrency is tricky
 *   [2].putIfAbsent is tricky to use correctly
 *   [3].engineers at Google got it wrong more than 10% of the time
 *   [4].Unless you need to ensure a single value, just use get followed by put if not found
 *   [5].If you need to ensure a single unique value shared by all threads, use putIfAbsent and Check return value
 * </p>
 * @author jiangy19
 * @version v1.0
 * @FileName ConcurrentHashMapUsage
 * @date 2017/10/10 16:13
 */
public class ConcurrentHashMapUsage {

	public static void main(String[] args) throws Exception {
		Map<String, String> map = new ConcurrentHashMap<>();
		map.put("Jhon","Rain");
		String retVal = map.putIfAbsent("Rain","Jhon");
		System.out.println("retVal="+retVal);
		String retVal2 = map.putIfAbsent("Rain","JhonRain");
		System.out.println("retVal2="+retVal2);
		System.out.println(map.toString());
	}
}
