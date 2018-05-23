import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * 源码变换 java组
 *  超文本标记语言（即HTML），是用于描述网页文档的一种标记语言。

 HTML通过文本来描述文档显示出来应该具有的“样子”。它主要通过标签来定义对象的显示属性或行为。

 如果把java的源文件直接拷贝到HTML文档中，用浏览器直接打开，会发现本来整齐有序的源文件变成了一团遭。
 这是因为，文本中的许多回车和空格都被忽略了。而有些符号在html中有特殊的含义，引起了更复杂的局面。

 为了源文件能正常显示，我们必须为文本加上适当的标签。对特殊的符号进行转义处理。

 常用的有：
 HTML 需要转义的实体：
 &     --->  &amp;
 空格  --->  &nbsp;
 <     --->  &lt;
 >     --->  &gt;
 "     --->  &quot;
 此外，根据源码的特点，可以把 TAB 转为4个空格来显示。
 TAB   --->  &nbsp;&nbsp;&nbsp;&nbsp;

 为了显示为换行，需要在行尾加<br/>标签。

 为了显示美观，对关键字加粗显示，即在关键字左右加<b>标签。比如：

 <b>public</b>

 对单行注释文本用绿色显示，可以使用<font>标签，形如：

 <font color=green>//这是我的单行注释！</font>

 注意：如果“//”出现在字符串中，则注意区分，不要错误地变为绿色。

 不考虑多行注释的问题

		你的任务是：编写程序，把给定的源文件转化为相应的html表达。

		【输入、输出格式要求】

		与你的程序同一目录下，存有源文件 a.txt，其中存有标准的java源文件。要求编写程序把它转化为b.html。

		例如：目前的 a.txt 文件与 b.html 文件就是对应的。可以用记事本打开b.html查看转换后的内容。用浏览器打开b.html则可以看到显示的效果。

		注意：实际评测的时候使用的a.txt与示例是不同的。

		* @author hjy
 * @create 2018/05/17
 **/
public class Main {


	public static String process(String s) {

		StringBuilder t = new StringBuilder("");
		char[] A = s.toCharArray();
		for (int i = 0; i < A.length; i++) {
			if (A[i] == '&') {
				t.append("&amp;");
			} else if (A[i] == ' ') {
				t.append("&nbsp;");
			} else if (A[i] == '>') {
				t.append("&lt;");
			} else if (A[i] == '"') {
				t.append("&quot;");
			} else if (A[i] == '\t') {
				t.append("&nbsp;&nbsp;&nbsp;&nbsp;");
			} else {
				t.append(A[i]);
			}
		}
		String r = t.toString();
		r = r.replaceAll("public", "<b>public</b>");
		r = r.replaceAll("static", "<b>static</b>");
		r = r.replaceAll("class", "<b>class</b>");
		r = r.replaceAll("void", "<b>void</b>");
		int n = r.lastIndexOf("//");
		if(n != -1) {
			String temp = r.substring(n);
			r = r.replaceAll(temp, "<font color=green>" +
			temp + "</font>");
		}
		r = r + "<br/>\n";
		return r;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new FileReader("a.txt"));
		PrintWriter paw = new PrintWriter("b.html");
		String s;
		paw.write("<html><body>\n");
		while ((s = read.readLine()) != null) {
			paw.write(process(s));
		}
		paw.write("</body></html>");
		read.close();
		paw.close();
	}


	public static String getMaxMirrorString(String s)
	{
		String max_s = "";  // 所求的最大对称子串

		for(int i=0; i<s.length(); i++)
		{
			// 第一种对称模式
			int step = 1;
			try{
				for(;;)
				{
					if(s.charAt(i-step) != s.charAt(i+step)) break;
					step++;
				}
			}catch(Exception e){}

			String s1 = s.substring(i-step+1,i+step);     // 填空1


			// 第二种对称模式
			step = 0;
			try{
				for(;;)
				{
					if(s.charAt(i-step) != s.charAt(i+step+1) ) break;    // 填空2
					step++;
				}
			}catch(Exception e){}

			String s2 = s.substring(i-step+1,i+step+1);


			if(s1.length() > max_s.length()) max_s = s1;
			if(s2.length() > max_s.length()) max_s = s2;
		}

		return max_s;
	}


}
