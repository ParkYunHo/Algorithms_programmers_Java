package hash;

import java.util.*;

public class PhoneBook {
	public static boolean phoneBook_method(String[] phone_book) {
		int phone_book_lens = phone_book.length;				// var : ��ȭ��ȣ�� �迭�� ���̸� �����ϴ� ����
		boolean answer = phone_book_lens > 1 ? true : false;	// var : Default���� ���ϸ�, �迭�� ���̰� 1�� ������ ��� false�� �⺻������ ����
		// ��ȭ��ȣ�� �迭�� Sorting�Ͽ� ��ȭ��ȣ ���ڰ� ������� ��ġ�ϵ��� ���� (���ξ Ȯ���ϹǷ�) 
		Arrays.sort(phone_book);							
		
		// ���ĵ� �迭���� �����Ұ��� ������Ұ��� ���ξ� �κ��� ���ϴ� �κ�
		for(int i=0; i<phone_book_lens-1; i++) {
			// �����Ұ��� ���̰� ������Ұ��� ���̺��� �� ��쿡�� ���� 
			if(phone_book[i].length() <= phone_book[i+1].length()) {
				// �����Ұ��� ������Ұ��� ������ ���ϴ� �κ�
				if(phone_book[i].equals(phone_book[i+1].substring(0, phone_book[i].length()))) {
					return false;
				}
			}
		}
        return answer;
    }
}

