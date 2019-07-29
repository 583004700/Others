package algorithm.com.atguigu.horse;

import org.junit.Test;

public class KTTest {
	// 我们运气好，直接在 210 毫秒内就找到一种解！
	@Test
	public void test() {
		KnightTourByBackTracking kt = new KnightTourByBackTracking(8, 0, 0);
		kt.soveKT();
	}
	
	// 但是使用相同的遍历顺序，只是换了一下起点，程序却运行了将近 10 分钟都没有得出一种有效的解。
	@Test
	public void test2() {
		KnightTourByBackTracking kt = new KnightTourByBackTracking(8, 2, 2);
		kt.soveKT();
	}
	
	@Test
	public void test3() {
		KnightTourByBackTracking kt = new KnightTourByBackTracking(64, 36, 2);
		long start = System.currentTimeMillis();
		kt.soveKT();
		System.out.println("耗时：" + (System.currentTimeMillis() - start) + "毫秒");
	}
}
