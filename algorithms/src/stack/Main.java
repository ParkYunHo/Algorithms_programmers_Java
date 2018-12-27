package stack;

import stack.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*// 1. 쇠막대기
		String arrangement = "()(((()())(())()))(())";
//		System.out.println(IronStick.ironStick_method(arrangement));
		System.out.println(IronStick.ironStick_method2(arrangement));*/
		
		// 2. 프린터
		int priorities[] = {2, 1, 3, 2};
		int location = 2;
		System.out.println(Printer.printer_method(priorities, location));
	}
}
