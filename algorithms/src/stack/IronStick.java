package stack;

import java.util.*;

public class IronStick {
	public static int ironStick_method(String arrangement) {
		int answer = 0;										// var : ©���� �踷����� �� ������ ������ ����
		int arrangement_lens = arrangement.length();		// var : arrangement ���ڿ��� ��� (char ����)
		int ary_stack[] = new int[arrangement_lens/2];		// var : arrangement�� '('�� stack�������� ������ �迭 ����
		final int init_cnt = 0;								// var : �迭�� �ʱⰪ�� �����ϴ� ����
		int top_idx = 0;									// var : �迭�� stackó�� �������� top �ε����� ������ ����
		char arrangement_char;								// var : arrangement�� �� char�� ������ ����
		char arrangement_char_prev;							// var : arrangement�� ���� �ε��� char�� ������ ����
		
		for(int i=0; i<arrangement_lens;i++) {
			// arrangement�� ���� �ε����� char ����
			arrangement_char = arrangement.charAt(i);
			// ���� char�� '('�� ���
			if(arrangement_char == '(') {
				// stackó�� ����� �迭�� �ʱⰪ ����
				ary_stack[top_idx++] = init_cnt;
			// ���� char�� ')'�� ���
			}else if(arrangement_char == ')') {
				// arrangement�� ���� �ε����� char ����
				arrangement_char_prev = arrangement.charAt(i-1);
				// ���� �ε����� char�� '('�� ���
				if(arrangement_char_prev == '(') {
					// top�ε����� ����
					top_idx--;
					// stack �迭�� ��� ���� 1�� ������Ŵ
					for(int j=0; j < top_idx; j++) {
						ary_stack[j] = ary_stack[j]+1;
					}
				// ���� �ε����� char�� '('�� ���
				}else if(arrangement_char_prev == ')') {
					// stack �迭�� top �κ��� ���� answer�� ����
					answer += ary_stack[--top_idx]+1;
				}
			}
		}
		
		return answer;
	}
	
	public static int ironStick_method2(String arrangement) {
		int answer = 0;												// var : ©���� �踷����� �� ������ ������ ����
		Stack<Integer> arrangement_stack = new Stack<Integer>();	// var : arrangement�� '('���ڿ� �ش��ϴ� �ε����� �����ϴ� Stack
		char arrangement_char;										// var : arrangement�� �� char�� ������ ����
		char arrangement_char_prev;									// var : arrangement�� ���� �ε��� char�� ������ ����
		
		for(int i=0; i<arrangement.length(); i++) {
			// arrangement�� ���� �ε����� char ����
			arrangement_char = arrangement.charAt(i);
			if(arrangement_char == '(') {
				// stack�� ���� �ε����� ����
				arrangement_stack.push(i);
			}else if(arrangement_char == ')') {
				// arrangement�� ���� �ε����� char ����
				arrangement_char_prev = arrangement.charAt(i-1);
				// ���� �ε����� char�� '('�� ���
				if(arrangement_char_prev == '(') {
					arrangement_stack.pop();
					// ���䰪�� ������ ���̸� ���� (�踷���� ���� �κи� ����)
					answer += arrangement_stack.size();
				// ���� �ε����� char�� ')'�� ���
				}else if(arrangement_char_prev == ')') {
					arrangement_stack.pop();
					// ���䰪�� '1'�� ���� (�踷���� ������ �κ��� ����)
					answer += 1;
				}
			}
		}
		
		return answer;
	}
}
