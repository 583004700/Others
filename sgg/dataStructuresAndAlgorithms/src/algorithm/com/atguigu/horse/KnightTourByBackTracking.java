package algorithm.com.atguigu.horse;

import java.util.*;

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

	private Map<String, Set<String>> canMap = new HashMap<String,Set<String>>();

	/**
	 * 定义key的生成规则
	 */
	public String getKey(int x,int y){
		return x+","+y;
	}

	/**
	 * 构造函数，初始化棋盘和起点
	 * 
	 * @param n            棋盘的大小
	 * @param sourceRow    起点的行索引
	 * @param sourceColumn 起点的列索引
	 */
	int lastX = -1;
	int lastY = -1;
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
		for (int x = 0; x < chessboard.length; x++) {
			for(int y = 0; y < chessboard[0].length; y++){
				Set<String> set = new HashSet<String>();
				for (int m = 0; m < xMove.length; m++) {
					int nextX = x + xMove[m];
					int nextY = y + yMove[m];
					if (isSafe(nextX, nextY)) {
						//表明x,y 坐标能到达哪些坐标
						set.add(getKey(nextX,nextY));
					}
				}
				canMap.put(getKey(x,y),set);
			}
		}
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
		int oldLastX = lastX;
		int oldLastY = lastY;
		if(lastX!=-1){
			//移除当前能走的路径 从上一个顶点来的
			canMap.get(getKey(x,y)).remove(getKey(lastX,lastY));
		}
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
		}else {
			String key = getKey(x, y);
			Set<String> s = canMap.get(key);
			for (String xy : s) {
				String[] newXy = xy.split(",");
				int row = Integer.valueOf(newXy[0]);
				int col = Integer.valueOf(newXy[1]);
				lastX = x;
				lastY = y;
				soveKT(row, col, step + 1);
			}
		}
		lastX = oldLastX;
		lastY = oldLastY;
		chessboard[x][y] = -1;
		canMap.get(getKey(x,y)).add(getKey(lastX,lastX));
	}
}
