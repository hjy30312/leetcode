/**
 * X星球特别讲究秩序，所有道路都是单行线。
 一个甲壳虫车队，共16辆车，按照编号先后发车，夹在其它车流中，缓缓前行。

 路边有个死胡同，只能容一辆车通过，是临时的检查站，如图所示。
 X星球太死板，要求每辆路过的车必须进入检查站，也可能不检查就放行，也可能仔细检查。
 如果车辆进入检查站和离开的次序可以任意交错。那么，该车队再次上路后，可能的次序有多少种？

 为了方便起见，假设检查站可容纳任意数量的汽车。
 显然，如果车队只有1辆车，可能次序1种；2辆车可能次序2种；3辆车可能次序5种
 * @author hjy
 * @create 2018/05/23
 **/
public class Main {
	/**
	 *
	 * @param in 进的
	 * @param out 出的
	 */
	public static int stack(int in, int out) {
		if (in == 0) {
			return 1;
		}
		if (out == 0) {
			return stack(in-1,1);
		}
		//进检查 和 不进检查 两种情况
		return stack(in-1,out+1)+stack(in,out-1);

	}
	public static void main(String[] args) {
		System.out.println(stack(16, 0));
	}




}
