package stack;

import java.util.*;

public class IronStick {
	public static int ironStick_method(String arrangement) {
		int answer = 0;										// var : 짤려진 쇠막대기의 총 개수를 저장할 변수
		int arrangement_lens = arrangement.length();		// var : arrangement 문자열의 길어 (char 개수)
		int ary_stack[] = new int[arrangement_lens/2];		// var : arrangement의 '('를 stack형식으로 저장할 배열 변수
		final int init_cnt = 0;								// var : 배열의 초기값을 저장하는 변수
		int top_idx = 0;									// var : 배열을 stack처럼 쓰기위해 top 인덱스를 저장할 변수
		char arrangement_char;								// var : arrangement의 각 char를 저장할 변수
		char arrangement_char_prev;							// var : arrangement의 이전 인덱스 char를 저장할 변수
		
		for(int i=0; i<arrangement_lens;i++) {
			// arrangement의 현재 인덱스의 char 저장
			arrangement_char = arrangement.charAt(i);
			// 현재 char가 '('인 경우
			if(arrangement_char == '(') {
				// stack처럼 사용할 배열에 초기값 저장
				ary_stack[top_idx++] = init_cnt;
			// 현재 char가 ')'인 경우
			}else if(arrangement_char == ')') {
				// arrangement의 이전 인덱스의 char 저장
				arrangement_char_prev = arrangement.charAt(i-1);
				// 이전 인덱스의 char가 '('인 경우
				if(arrangement_char_prev == '(') {
					// top인덱스를 감소
					top_idx--;
					// stack 배열의 모든 값을 1씩 증가시킴
					for(int j=0; j < top_idx; j++) {
						ary_stack[j] = ary_stack[j]+1;
					}
				// 이전 인덱스의 char가 '('인 경우
				}else if(arrangement_char_prev == ')') {
					// stack 배열의 top 부분의 값을 answer에 저장
					answer += ary_stack[--top_idx]+1;
				}
			}
		}
		
		return answer;
	}
	
	public static int ironStick_method2(String arrangement) {
		int answer = 0;												// var : 짤려진 쇠막대기의 총 개수를 저장할 변수
		Stack<Integer> arrangement_stack = new Stack<Integer>();	// var : arrangement의 '('문자에 해당하는 인덱스를 저장하는 Stack
		char arrangement_char;										// var : arrangement의 각 char를 저장할 변수
		char arrangement_char_prev;									// var : arrangement의 이전 인덱스 char를 저장할 변수
		
		for(int i=0; i<arrangement.length(); i++) {
			// arrangement의 현재 인덱스의 char 저장
			arrangement_char = arrangement.charAt(i);
			if(arrangement_char == '(') {
				// stack에 현재 인덱스를 저장
				arrangement_stack.push(i);
			}else if(arrangement_char == ')') {
				// arrangement의 이전 인덱스의 char 저장
				arrangement_char_prev = arrangement.charAt(i-1);
				// 이전 인덱스의 char가 '('인 경우
				if(arrangement_char_prev == '(') {
					arrangement_stack.pop();
					// 정답값에 스택의 길이를 저장 (쇠막대의 왼쪽 부분만 저장)
					answer += arrangement_stack.size();
				// 이전 인덱스의 char가 ')'인 경우
				}else if(arrangement_char_prev == ')') {
					arrangement_stack.pop();
					// 정답값에 '1'을 저장 (쇠막대의 오른쪽 부분을 저장)
					answer += 1;
				}
			}
		}
		
		return answer;
	}
}
