package dfs_and_bfs.조합_구하기;

import java.util.*;

public class Main {
	static int[] answers;
	static boolean[] visitedNum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		final int n = sc.nextInt();
		final int r = sc.nextInt();
		answers = new int[r];
		visitedNum = new boolean[n + 1];
		
		main.myDfs(n, r, 0);
	}
	
	private void myDfs(final int n, final int r, final int depth) {
		if (depth - 2 >= 0 && answers[depth - 1] < answers[depth - 2]) {
			return;
		}
		if (r == depth) {
			for (int x : answers) {
				System.out.print(x + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = depth + 1; i <= n; i++) {
			if (!visitedNum[i]) {
				visitedNum[i] = true;
				answers[depth] = i;
				myDfs(n, r, depth + 1);
				visitedNum[i] = false;
			}
		}
	}
	
}
