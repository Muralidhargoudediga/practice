package org.mge.general;

public class RobotPosition {

	public static void main(String[] args) {
		//N=0, E=1, S=2, W=3
		int dir = 2;
		int x = 0, y = 0;
		String s = "LRLBRRLFLLRBBRLFRL";
		
		for(int i = 0; i< s.length(); i++) {
			if(s.charAt(i) == 'L') {
				dir = (dir - 1 + 4) % 4;
			} else if(s.charAt(i) == 'R') {
				dir = (dir + 1) % 4;
			} else if(s.charAt(i) == 'B') {
				dir = (dir + 2) % 4;
			} else if(s.charAt(i) == 'F') {
				if(dir == 0) {
					y++;
				} else if(dir == 1) {
					x++;
				} else if(dir == 2) {
					y--;
				} else if(dir == 3) {
					x--;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(x == 0 && y == 0){
			sb.append("Same position, ");
		} 
		
		if(x < 0) {
			sb.append((-1 * x) + " step(s) right, ");
		}
		
		if(x > 0) {
			sb.append(x + " step(s) left, ");
		}
		
		if(y < 0) {
			sb.append((-1 * y) + " step(s) straight, ");
		}
		
		if(y > 0) {
			sb.append(y + " step(s) back ");
		}
		 System.out.println(sb);

	}

}
