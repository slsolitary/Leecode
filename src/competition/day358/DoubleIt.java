package competition.day358;

import java.util.List;

/**
 * @author heyao
 * @date 2023-08-13 10:46
 */
public class DoubleIt {
    public static void main(String[] args) {
        DoubleIt test = new DoubleIt();
        ListNode head = new ListNode();
        ListNode tmp = head;
        tmp.val = 1;
        tmp.next = new ListNode();
        tmp = tmp.next;
        tmp.val = 8;
        tmp.next = new ListNode();
        tmp = tmp.next;
        tmp.val = 9;
        tmp.next = new ListNode();
        tmp = tmp.next;
        tmp = null;
        test.doubleIt(head);
    }
    public ListNode doubleIt(ListNode head) {
        ListNode tmp = head;
        StringBuilder builder = new StringBuilder();
        while (tmp != null){
            builder.append(tmp.val);
            tmp = tmp.next;
        }
        String s = builder.reverse().toString();
        String ans = doubleString(s);
        tmp = new ListNode();
        head = tmp;
        for(int i = 0;i < ans.length();i++){
            if(i == ans.length()-1){
                tmp.val = ans.charAt(i)-'0';
                break;
            }
            tmp.val = ans.charAt(i)-'0';
            tmp.next = new ListNode();
            tmp = tmp.next;
        }
        tmp = null;
        return head;
    }

    public String doubleString(String s){
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for(int i = 0;i < s.length();i++){
            int a = s.charAt(i)-'0';
            int num = a * 2+carry;
            carry = num / 10;
            builder.append(num % 10);
        }
        if(carry > 0){
            builder.append(carry);
        }
        return builder.reverse().toString();
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
