import javax.swing.*;
import java.util.List;

public class ListNode<T> {
    T val;
    public ListNode(T val) {
        this.val = val;
    }
    public ListNode<T> next;
}
