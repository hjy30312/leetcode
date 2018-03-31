import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


/*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 
******************************开始写代码******************************/
    static Integer solve(int[] num, int m) {
        Integer ans = 0;
        if (m == 1) {
            for (int i = 0; i < num.length; i++) {
                if (ans < num[i]) ans = num[i];
            }
            return ans;
        }

        for (int j = 0; j < m; j++) {
            ans += num[j];
        }
        if (m == num.length) {
            return ans;
        }

        int ww = 0;
        for (int i = m; i <= num.length; i++) {
            if (ans < ans - num[ww]  + num[m] ){
                ans = ans - num[ww]  + num[m];
            }
            ww++;
        }
        return ans;
    }
/******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Integer res;
            
        int _num_size = 0;
        _num_size = Integer.parseInt(in.nextLine().trim());
        int[] _num = new int[_num_size];
        int _num_item;
        for(int _num_i = 0; _num_i < _num_size; _num_i++) {
            _num_item = Integer.parseInt(in.nextLine().trim());
            _num[_num_i] = _num_item;
        }

        Integer _m;
        _m = Integer.parseInt(in.nextLine().trim());
  
        res = solve(_num, _m);
        System.out.println(String.valueOf(res));    

    }
}
