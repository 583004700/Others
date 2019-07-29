package algorithm.com.atguigu.horse;

import java.util.Arrays;

/**
 * 	使用回溯法(暴力匹配法)解决 骑士的周游问题。
 * @author Administrator
 *
 */
public class KnightTourByBackTracking {
	private int N;
	private int[][] chessboard;
	private int sourceRow;
	private int sourceColumn;
	// 【注意】 xMove 和 yMove 是固定的，因为骑士固定是走日。所以理论上，最多只能有 8 种走法。
	//       这两个数组的组合顺序，影响着遍历的顺序。
	private int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
	private int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

	/**
	 * 构造函数，初始化棋盘和起点
	 * 
	 * @param n            棋盘的大小
	 * @param sourceRow    起点的行索引
	 * @param sourceColumn 起点的列索引
	 */
	public KnightTourByBackTracking(int n, int sourceRow, int sourceColumn) {
		if (n < 4) {
			throw new RuntimeException("棋盘大小不能小于 4 * 4");
		}
		if (sourceRow < 0 || sourceColumn < 0) {
			throw new RuntimeException("sourceRow 和 sourceColumn 不能小于零！");
		}

		N = n;
		this.sourceRow = sourceRow;
		this.sourceColumn = sourceColumn;

		chessboard = new int[N][N];
		// 首先，我们让棋盘的全部元素都初始化成 -1, 表示这个位置没有遍历过
		for (int i = 0; i < chessboard.length; i++) {
			Arrays.fill(chessboard[i], -1);
		}
		// 把起始点位置的元素置为 0 , 表示这个点已经遍历过，是第 0 个遍历的点
		chessboard[sourceRow][sourceColumn] = 0;
	}

	/**
	 * 指定的索引是否安全，如果不越界我们就认为是安全的
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isSafe(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	/**
	 * 指定索引的元素是否是遍历过, 如果没有遍历过，那么这个索引对应的元素值是 -1
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isEmpty(int x, int y) {
		return chessboard[x][y] == -1;
	}

	long start = 0;
	public void soveKT() {
		start = System.currentTimeMillis();
		soveKT(sourceRow, sourceColumn, 0);
	}

	int count = 0;

	private void soveKT(int x, int y, int step) {
		chessboard[x][y] = step;
		if (step == N * N - 1) {
			System.out.println("已经找到"+(++count)+"种解！");
			for (int i = 0; i < chessboard.length; i++) {
				for (int j = 0; j < chessboard[i].length; j++) {
					System.out.print(chessboard[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.println("耗时：" + (System.currentTimeMillis() - start) + "毫秒");
		}
		int nextX = -1;
		int nextY = -1;
		// 然后，我们就要找点 (x, y) 旁边的全部有效点, 进行遍历
		for (int i = 0; i < xMove.length; i++) {
			nextX = x + xMove[i];
			nextY = y + yMove[i];
			// 当然，(x, y) 旁边的 8 个点不一定存在，就算存在，也不一定是空的，所以我们需要先判断一下
			if (isSafe(nextX, nextY) && isEmpty(nextX, nextY)) {
				soveKT(nextX, nextY, step + 1);
			}
		}
		chessboard[x][y] = -1;
		// 如果所有的相邻点都尝试过了，还是不行，我们就返回 false ， 说明此路不通
	}
}
