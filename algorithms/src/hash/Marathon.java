package hash;

import java.util.*;

public class Marathon {
	public static String marathon_method(String[] participant, String[] completion) {
		String result = "";																// var : �������� ���� �����ڸ� ������ ����
		HashMap<String, Integer> completion_hashMap = new HashMap<String, Integer>();	// var : ������ �迭�� HashMap ���·� ������ ����
		
		int init_value = 0;		// var : ������ HashMap�� �ʱⰪ ����
		// ������ array�� HashMap���� �����ϴ� �κ�
		for(String completion_item : completion) {
			int completion_value_increse_cnt = completion_hashMap.getOrDefault(completion_item, init_value)+1;
			completion_hashMap.put(completion_item, completion_value_increse_cnt);
		}
		
		int completion_value_min_cnt = 0;	// var : ������ ���������� �ּҰ����� ������ ����
		// ������ �ο� �� ������ ��Ͽ� ���� �ο��� �������� ���� �κ�
		for(String participant_item : participant) {
			// ������ HashMap�� ������ �̸��� ���� ���
			if(completion_hashMap.get(participant_item) != null) {
				int completion_value_decrese_cnt = completion_hashMap.get(participant_item)-1;	// var : �������� �������� ������ �����ϴ� ����
																								//       (������ �̸��� ������ HashMap�� �����Ƿ� '1'�� ����)
				// �������� ������ ������ �ּҰ������� ���� ���
				if(completion_value_decrese_cnt < completion_value_min_cnt) {
					result = participant_item;
					break;
				// �������� ������ ������ �ּҰ������� ���� ��� 
				}else {
					// ������ HashMap���� �������� �̸��� Key�� �����ִ� ���� value�� '1'�� ���ҽ�Ų �������� ������ ���������� ����
					completion_hashMap.put(participant_item, completion_value_decrese_cnt);	
				}
			// ������ HashMap�� ������ �̸��� ���� ���
			}else {
				result = participant_item;
				break;
			}
		}
		return result;
	}
}
