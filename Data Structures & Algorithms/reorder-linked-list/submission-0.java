/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for singly-linked list.
  * public class ListNode {
   *     int val;
    *     ListNode next;
     *     ListNode() {}
      *     ListNode(int val) { this.val = val; }
       *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        * }
         */
         class Solution {
             public void reorderList(ListNode head) {
                     if(head==null)  return;
                             ListNode fast =head;
                                     ListNode slow =head;

                                             while(fast!=null && fast.next!=null){
                                                         slow =slow.next;
                                                                     fast = fast.next.next;
                                                                             }

                                                                                     ListNode prev = null,temp = null;

                                                                                             while(slow!=null){
                                                                                                         temp = slow.next;
                                                                                                                     slow.next = prev;
                                                                                                                                 prev = slow;
                                                                                                                                             slow = temp;
                                                                                                                                                     }
                                                                                                                                                             ListNode first =head,second = prev;

                                                                                                                                                                     while(second.next!=null){
                                                                                                                                                                                 ListNode t1 = null, t2 = null;

                                                                                                                                                                                             t1=first.next;
                                                                                                                                                                                                         t2=second.next;

                                                                                                                                                                                                                     first.next = second;
                                                                                                                                                                                                                                 first = t1;

                                                                                                                                                                                                                                             second.next = t1;
                                                                                                                                                                                                                                                         second =t2;

                                                                                                                                                                                                                                                                 }
                                                                                                                                                                                                                                                                     }
                                                                                                                                                                                                                                                                     }
