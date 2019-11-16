/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        int jinwei = 0;
        while (l1 != null || l2 != null) {
            int digit1 = 0;
            int digit2 = 0;
            boolean isL1Over = (l1 == null);
            boolean isL2Over = (l2 == null);
            if (l1 != null) {
                digit1 = l1.val;
            }
            if (l2 != null) {
                digit2 = l2.val;
            }
            
            int digit = (digit1 + digit2 + jinwei) % 10;
            System.out.println(digit);
            ListNode newNode = new ListNode(digit);
            result.next = newNode;
            result = result.next;
            
            
            if (digit1 + digit2 + jinwei>= 10) {
                jinwei = 1;
            } else {
                jinwei = 0;
            }
            l1 = isL1Over ? null : l1.next; 
            l2 = isL2Over ? null : l2.next; 
            if ((isL1Over || isL2Over) && (! (isL1Over && isL2Over)) && (jinwei == 0)) { 
                result.next = (isL1Over ? l2 : l1); 
                break; 
            } 
            
        }
        if (jinwei == 1) {
            ListNode newNode = new ListNode(1);
            result.next = newNode;
            result = result.next;
        }
        return dummy.next;
    }
}