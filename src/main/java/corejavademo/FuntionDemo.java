package corejavademo;

public class FuntionDemo implements A, B {

	@Override
	public void show() {
		System.out.println("C");
	}

}

interface A {
	default void show() {
		System.out.println("A");
	}
	
	static void display(){
		System.out.println("AA");
	}
}

interface B {
	default public void show() {
		System.out.println("B");
	}
}

@FunctionalInterface
interface C {
	public void print();
}

@FunctionalInterface
interface D {
	public void print();
		
	default void show(){
		
	}
	
	static void display(){
		
	}
	
	static void display2(){
		
	}

}
