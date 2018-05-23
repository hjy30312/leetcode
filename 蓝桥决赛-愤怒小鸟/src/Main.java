/**
 *
 * @author hjy
 * @create 2018/05/19
 **/
public class Main {

	public static void main(String[] args) {

		double a=0, b = 1000;
		while (b>=1) {
			//a->b  b为2端的距离 (b/60)  60为鸟的速度加火车的速度
			b = b - 20 * (b/60);
			//b->a
			b = b - 20 * (b/60);
			a++;
		}
		System.out.println(a);
	}


}
