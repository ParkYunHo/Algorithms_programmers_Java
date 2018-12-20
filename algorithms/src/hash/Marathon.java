package hash;

import java.util.*;

public class Marathon {
	public static String marathon_method(String[] participant, String[] completion) {
		String result = "";																// var : 완주하지 못한 참가자를 저장할 변수
		HashMap<String, Integer> completion_hashMap = new HashMap<String, Integer>();	// var : 완주자 배열을 HashMap 형태로 저장할 변수
		
		int init_value = 0;		// var : 완주자 HashMap의 초기값 변수
		// 완주자 array를 HashMap으로 저장하는 부분
		for(String completion_item : completion) {
			int completion_value_increse_cnt = completion_hashMap.getOrDefault(completion_item, init_value)+1;
			completion_hashMap.put(completion_item, completion_value_increse_cnt);
		}
		
		int completion_value_min_cnt = 0;	// var : 완주자 동명이인의 최소갯수를 저장할 변수
		// 참가자 인원 중 완주자 목록에 없는 인원을 가려내기 위한 부분
		for(String participant_item : participant) {
			// 완주자 HashMap에 참가자 이름이 있을 경우
			if(completion_hashMap.get(participant_item) != null) {
				int completion_value_decrese_cnt = completion_hashMap.get(participant_item)-1;	// var : 동명이인 완주자의 갯수를 저장하는 변수
																								//       (참가자 이름이 완주자 HashMap에 있으므로 '1'을 감소)
				// 동명이인 완주자 개수가 최소개수보다 적을 경우
				if(completion_value_decrese_cnt < completion_value_min_cnt) {
					result = participant_item;
					break;
				// 동명이인 완주자 개수가 최소개수보다 많을 경우 
				}else {
					// 완주자 HashMap에서 동명이인 이름을 Key로 가지있는 값의 value를 '1'을 감소시킨 동명이인 완주자 개수값으로 변경
					completion_hashMap.put(participant_item, completion_value_decrese_cnt);	
				}
			// 완주자 HashMap에 참가자 이름이 없을 경우
			}else {
				result = participant_item;
				break;
			}
		}
		return result;
	}
}
