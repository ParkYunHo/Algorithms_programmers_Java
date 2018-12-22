package hash;

import java.util.*;

public class Spy {
	public static int spy_method(String[][] clothes) {
		int answer = 1;			// var : ���䰪�� ������ ����
		
		HashMap<String, List<String>> clothes_hashMap = new HashMap<String, List<String>>();	// var : clothes ���߹迭�� ������ HashMap ����
		List<String> clothes_category_list = new ArrayList<String>();							// var : clothes ���߹迭�� ī�װ��� ������ ����Ʈ ����
		List<String> clothes_name_list = null;													// var : clothes ���߹迭�� �ǻ��̸��� ������ ����Ʈ ����
		
		String clothes_name = "";			// var : �ǻ� �̸��� ������ ����
		String clothes_category = "";		// var : �ǻ� ī�װ��� ������ ����
		
		// clothes ���߹迭�� HashMap ������ ���� ī�װ��� ���� chaining ���� �����ϴ� �κ� 
		for(String[] clothes_item : clothes) {
			clothes_name = clothes_item[0];			
			clothes_category = clothes_item[1];
			
			// ī�װ� ����Ʈ�� ����� ī�װ����� ���ԵǾ� �ִ� ��� (ī�װ��� �ߺ��Ǿ� �ִ� ���)
			if(clothes_category_list.contains(clothes_category)) {
				// �ǻ��̸� ����Ʈ�� ����� HashMap�������� �������� �κ�
				clothes_name_list = clothes_hashMap.get(clothes_category);
			// ī�װ� ����Ʈ�� ����� ī�װ����� ���ԵǾ� ���� ���� ��� (ī�װ��� �ߺ����� �ʴ� ���)
			}else {
				clothes_name_list = new ArrayList<String>();
				// ī�װ� ����Ʈ�� ����� ī�װ� ���� �����ϴ� �κ�
				clothes_category_list.add(clothes_category);
			}
			// HashMap�� ������ �ǻ��̸� ����Ʈ�� ����� �ǻ��̸��� �����ϴ� �κ�
			clothes_name_list.add(clothes_name);
			// HashMap ������ ����� ī�װ��� ����� �ǻ��̸��� ������ �̸� ����Ʈ�� �����ϴ� �κ�
			clothes_hashMap.put(clothes_category, clothes_name_list);
		}
		
		// ī�װ� ����Ʈ�� ���̸�ŭ Ȯ������ ���ϴ� �κ�
		for(String category_list_item : clothes_category_list) {
			answer *= (clothes_hashMap.get(category_list_item).size()+1);	
		}
		
		// ���� : CategoryA(3), CategoryB(5)�� ��� Ȯ���� = (3+1)*(5+1)-1
		return answer-1;
	}
}
