package tdd.pratice.service;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AlgorithmPractice {

    public List<String> fizzBuzz(int n) {
        List<String> answer = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            answer.add(i % 3 == 0 ? i % 5 == 0 ? "FizzBuzz" : "Fizz" : i % 5 == 0 ? "Buzz" : String.valueOf(i));
        }
        return answer;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return root.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode insertBeforeHead(int new_int, ListNode head) {
            ListNode new_node = new ListNode(new_int);
            if (head == null) {
                return new_node;
            }
            new_node.next = head;
            head = new_node;
            return head;
        }

        ListNode insertAfterHead(int new_int, ListNode head) {
            ListNode new_node = new ListNode(new_int);
            if (head == null) {
                return new_node;
            }
            new_node.next = head.next;
            head.next = new_node;
            return head;
        }

        ListNode append(int new_int, ListNode head) {
            ListNode new_node = new ListNode(new_int);
            if (head == null) {
                return new_node;
            }
            new_node.next = null;
            ListNode lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = new_node;
            return head;
        }

        void printListNode() {
            ListNode tmp = this;
            System.out.println(tmp.val);
            while (tmp.next != null) {
                tmp = tmp.next;
                System.out.println(tmp.val);
            }
        }

        boolean isEqualTo(ListNode comapreListNode) {
            ListNode tmp = this;
            ListNode tmpCompare = comapreListNode;
            while (tmp != null && tmpCompare != null) {

                if (tmp.val != tmpCompare.val) {
                    return false;
                }
                tmp = tmp.next;
                tmpCompare = tmpCompare.next;
            }
            return (tmp == null && tmpCompare == null);
        }
    }

    //    translate two-char string into char
    public int romanToInt(String roman) {
        roman = roman.replace("IV", "a");
        roman = roman.replace("IX", "b");
        roman = roman.replace("XL", "c");
        roman = roman.replace("XC", "d");
        roman = roman.replace("CD", "e");
        roman = roman.replace("CM", "f");
//        get value from dictionary
        int res = 0;
        for (int i = 0; i < roman.length(); i++) {
            res += getValue(roman.charAt(i));
        }
        return res;
    }

    public int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            case 'a':
                return 4;
            case 'b':
                return 9;
            case 'c':
                return 40;
            case 'd':
                return 90;
            case 'e':
                return 400;
            case 'f':
                return 900;
            default:
                return 0;
        }
    }

}
