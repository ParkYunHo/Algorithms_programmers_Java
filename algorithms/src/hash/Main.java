package hash;

import java.util.*;
import hash.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*// 1. Marathon 문제 
		String participant[] = {"mislav", "stanko", "mislav", "ana"};
		String completion[] = {"stanko", "ana", "mislav"};
//		String participant[] = {"marina", "josipa", "nikola", "vinko", "filipa"};
//		String completion[] = {"josipa", "filipa", "marina", "nikola"};
		
//		String participant[] = new String[100000];
//		String completion[] = new String[99999];
//		
//		for(int i=0; i<33333; i++) {
//			participant[i] = "A";
//			completion[i] = "A";
//		}
//		for(int i=33333; i<66666; i++) {
//			participant[i] = "B";
//			completion[i] = "B";
//		}
//		for(int i=66666; i<99999; i++) {
//			participant[i] = "C";
//			completion[i] = "C";
//		}
//		
////		for(int i=0; i<9999; i++) {
////			participant[i] = "A";
////			completion[i] = "A";
////		}
//		participant[99999] = "D";
		
		System.out.println(Marathon.marathon_method(participant, completion));*/
		
		
		
		// 2. 전화번호 목록
		String[] phone_book = {"12", "123", "1235", "567" ,"88"};
//		String[] phone_book = {"119", "97674223", "1195524421"};
//		String[] phone_book = {"12", "34", "56"};
		
		System.out.println(PhoneBook.phoneBook_method(phone_book));
	}

}
