/**
 *
 *
 * 打靶

 小明参加X星球的打靶比赛。
 比赛使用电子感应计分系统。其中有一局，小明得了96分。

 这局小明共打了6发子弹，没有脱靶。
 但望远镜看过去，只有3个弹孔。
 显然，有些子弹准确地穿过了前边的弹孔。

 不同环数得分是这样设置的：
 1,2,3,5,10,20,25,50

 那么小明的6发子弹得分都是多少呢？有哪些可能情况呢？
 * @author hjy
 * @create 2018/05/22
 **/
public class Main
{
	/**
	 *
	 * @param ta 数组
	 * @param da
	 * @param k 0 数组所在位置
	 * @param ho 洞 3
	 * @param bu 打的次数 6
	 * @param sc 分数 96
	 */
	static void f(int[] ta, int[] da, int k, int ho, int bu, int sc)
	{
		if(ho<0 || bu<0 || sc<0) return;
		if(k==ta.length){
			if(ho>0 || bu>0 || sc>0) return;
			for(int i=0; i<da.length; i++){
				for(int j=0; j<da[i]; j++)
					System.out.print(ta[i] + " ");
			}
			System.out.println();
			return;
		}

		for(int i=0; i<=bu; i++){
			da[k] = i;
			f(ta, da, k+1,  ho- ((i ==0)?0:1) , bu-i, sc-ta[k]*i);   // 填空位置
		}

		da[k] = 0;
	}

	public static void main(String[] args)
	{
		int[] ta = {1,2,3,5,10,20,25,50};
		int[] da = new int[8];
		f(ta, da, 0, 3, 6, 96);

	}
}
