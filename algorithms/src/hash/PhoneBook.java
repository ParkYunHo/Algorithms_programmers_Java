package hash;

import java.util.*;

public class PhoneBook {
	public static boolean phoneBook_method(String[] phone_book) {
		int phone_book_lens = phone_book.length;				// var : 전화번호부 배열의 길이를 저장하느 변수
		boolean answer = phone_book_lens > 1 ? true : false;	// var : Default값을 정하며, 배열의 길이가 1개 이하일 경우 false를 기본값으로 저장
		// 전화번호부 배열을 Sorting하여 전화번호 숫자가 순서대로 위치하도록 수정 (접두어만 확인하므로) 
		Arrays.sort(phone_book);							
		
		// 정렬된 배열에서 현재요소값과 다음요소값의 접두어 부분을 비교하는 부분
		for(int i=0; i<phone_book_lens-1; i++) {
			// 현재요소값의 길이가 다음요소값의 길이보다 길 경우에만 실행 
			if(phone_book[i].length() <= phone_book[i+1].length()) {
				// 현재요소값과 다음요소값이 같은지 비교하는 부분
				if(phone_book[i].equals(phone_book[i+1].substring(0, phone_book[i].length()))) {
					return false;
				}
			}
		}
        return answer;
    }
}

