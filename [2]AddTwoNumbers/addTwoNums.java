/*
*
* You are given two non-empty linked lists representing two non-negative integers.
* The digits are stored in reverse order and each of their nodes contain a single digit.
* Add the two numbers and return it as a linked list.
* You may assume the two numbers do not contain any leading zero, except the number 0 itself.
* Example:
* Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
* Output: 7 -> 0 -> 8
* Explanation: 342 + 465 = 807.
*
*/

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// three different situations

public class addTwoNums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {return l2;}
        if(l2 == null) {return l1;}

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(digit);
            current.next = newNode;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null && l2 == null) {
            int sum = l1.val + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(digit);
            current.next = newNode;
            current = current.next;
            l1 = l1.next;
        }

        while(l2 != null && l1 == null) {
            int sum = l2.val + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(digit);
            current.next = newNode;
            current = current.next;
            l2 = l2.next;
        }

        if(carry == 1) {current.next = new ListNode(carry);}
        return dummy.next;
    }
}