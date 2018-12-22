package hash;

import java.util.*;

public class Spy {
	public static int spy_method(String[][] clothes) {
		int answer = 1;			// var : 정답값을 저장할 변수
		
		HashMap<String, List<String>> clothes_hashMap = new HashMap<String, List<String>>();	// var : clothes 이중배열을 저장할 HashMap 변수
		List<String> clothes_category_list = new ArrayList<String>();							// var : clothes 이중배열의 카테고리를 저장할 리스트 변수
		List<String> clothes_name_list = null;													// var : clothes 이중배열의 의상이름을 저장할 리스트 변수
		
		String clothes_name = "";			// var : 의상 이름을 저장할 변수
		String clothes_category = "";		// var : 의상 카테고리를 저장할 변수
		
		// clothes 이중배열을 HashMap 변수로 같은 카테고리에 대해 chaining 시켜 저장하는 부분 
		for(String[] clothes_item : clothes) {
			clothes_name = clothes_item[0];			
			clothes_category = clothes_item[1];
			
			// 카테고리 리스트에 요소의 카테고리값이 포함되어 있는 경우 (카테고리가 중복되어 있는 경우)
			if(clothes_category_list.contains(clothes_category)) {
				// 의상이름 리스트를 저장된 HashMap변수에서 가져오는 부분
				clothes_name_list = clothes_hashMap.get(clothes_category);
			// 카테고리 리스트에 요소의 카테고리값이 포함되어 있지 않은 경우 (카테고리가 중복되지 않는 경우)
			}else {
				clothes_name_list = new ArrayList<String>();
				// 카테고리 리스트에 요소의 카테고리 값을 저장하는 부분
				clothes_category_list.add(clothes_category);
			}
			// HashMap에 저장할 의상이름 리스트에 요소의 의상이름을 저장하는 부분
			clothes_name_list.add(clothes_name);
			// HashMap 변수에 요소의 카테고리와 요소의 의상이름을 저장한 이름 리스트를 저장하는 부분
			clothes_hashMap.put(clothes_category, clothes_name_list);
		}
		
		// 카테고리 리스트의 길이만큼 확률값을 구하는 부분
		for(String category_list_item : clothes_category_list) {
			answer *= (clothes_hashMap.get(category_list_item).size()+1);	
		}
		
		// 공식 : CategoryA(3), CategoryB(5)인 경우 확률값 = (3+1)*(5+1)-1
		return answer-1;
	}
}
