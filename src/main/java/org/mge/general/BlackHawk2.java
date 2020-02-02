package org.mge.general;

import java.util.Stack;

public class BlackHawk2 {
	public static void main(String[] args) {
		Stack<Character> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();
		
		String exp1 = "- ( b - c)";
		String exp = "a- (( b- c) - ( d-e))";
		
		for(int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			if(c == ')') {
				while(s1.peek() != '(' && !s1.isEmpty()) {
					s2.push(s1.pop());
				}
				s1.pop();
				if(!s1.isEmpty()) {
					char op = s1.peek();
					while(!s2.isEmpty()){
						char c1 = s2.pop();
						if(op == '-') {
							if(c1 == '+') {
								s1.push('-');
							} else if(c1 == '-') {
								s1.push('+');
							} else {
								s1.push(c1);
							}
						} else {
							s1.push(c1);
						}
					}
				}
			} else if(c != ' '){
				s1.push(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		if(!s1.isEmpty()) {
			while(!s1.isEmpty())
				sb.append(s1.pop());
			System.out.println(sb.reverse().toString());
		} else {
			while(!s2.isEmpty()) {
				sb.append(s2.pop());
			}
			System.out.println(sb);
		}
		
	}
}
