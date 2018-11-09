package corejavademo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

	public static void main(String args[]) {
		
		BigDecimal decimal = new BigDecimal("1");
		decimal = decimal.add(new BigDecimal(10));
		decimal = decimal.add(null == null ? new BigDecimal(10) : new BigDecimal(0));
		
		System.out.println(decimal.doubleValue());
		
		
//		List<Integer> list = new ArrayList<Integer>();
//		List<Integer> list2 = new ArrayList<Integer>();
//		for (int i = 1; i <= 100; i++) {
//			list.add(i);
//			list2.add(i + 100);
//		}
//
//		List<Integer> result = list.stream().limit(10)
//				.collect(Collectors.toList());
//		System.out.println("c :  " + list.stream().count());
//
//		for (Integer r : result) {
//			System.out.println("r :  " + r);
//		}
	}
}
