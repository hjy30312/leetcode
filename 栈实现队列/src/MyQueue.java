import java.util.Stack;

public class MyQueue {

    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public MyQueue() {

    }
    // 定义一个辅助函数来处理  当out为空，将in里面的数据挪到out中去
    private void transferIfEmpty() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        transferIfEmpty();
        return out.pop();
    }

    public int peek() {
        transferIfEmpty();
        return out.peek();
    }

    public boolean empty() {
        return in.empty() && out.empty();
    }


}
