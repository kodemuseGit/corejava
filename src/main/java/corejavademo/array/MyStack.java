package corejavademo.array;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyStack {
	public static void main(String args[]) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("a");
		List<String> newList = list.stream().map(a -> a.toLowerCase()).distinct().collect(Collectors.toList());
		for(String s : newList){
			System.out.println("S : " + s);	
		}
		
		list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("a");
		
		System.out.println("------------------------------------------------------------------");
		newList = list.stream().map(a -> a.toLowerCase()).skip(2).collect(Collectors.toList());
		for(String s : newList){
			System.out.println("SS : " + s);	
		}
		
		list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("a");
		
		System.out.println("------------------------------------------------------------------");
		Predicate<String> p = (a) -> a.equals("a");
		System.out.println(list.stream().allMatch(p));
//		p = (a) -> a.contains("a");
//		System.out.println(list.stream().noneMatch(p));
//		p = (a) -> a.contains("a");
		
		List<Integer> iList = new ArrayList<>();
		iList.add(30);
		iList.add(45);
		iList.add(55);
		iList.add(29);
		iList.add(33);
		iList.add(34);
		
		Predicate<Integer> gt20 = (i) -> i > 20;
		Predicate<Integer> gt30 = (i) -> i > 30;
		Predicate<Integer> gt40 = (i) -> i > 40;
		
		System.out.println("------------------------------------------------------------------");
		System.out.println("gt20 " + iList.stream().allMatch(gt20));
		System.out.println("gt20 " + iList.stream().allMatch(gt30));
		System.out.println("gt20 " + iList.stream().allMatch(gt40));
		
		System.out.println("------------------------------------------------------------------");
		System.out.println("gt20 " + iList.stream().anyMatch(gt20));
		System.out.println("gt20 " + iList.stream().anyMatch(gt30));
		System.out.println("gt20 " + iList.stream().anyMatch(gt40));
		
		
		System.out.println("------------------------------------------------------------------");
		System.out.println("gt20 " + iList.stream().noneMatch(gt20));
		System.out.println("gt20 " + iList.stream().noneMatch(gt30));
		System.out.println("gt20 " + iList.stream().noneMatch(gt40));
		
		System.out.println("------------------------------------------------------------------");
		System.out.println("a : " + iList.stream().findFirst());
		System.out.println("b : " + iList.stream().findAny()); 
		System.out.println("gt20 ");
		System.out.println("gt20 " + iList.stream().noneMatch(gt30));
		System.out.println("gt20 " + iList.stream().noneMatch(gt40));
		
		
	}
}
