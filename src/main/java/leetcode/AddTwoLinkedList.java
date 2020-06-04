package leetcode;

public class AddTwoLinkedList {

	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {this.val = val;}
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(9, new ListNode(9))));

		ListNode n = addTwoNumbers(l1, l2);
		while(n!=null){
			System.out.println(n.val);
			n= n.next;
		}
		System.out.println("------------------");
		ListNode m = addTwoLists(l1, l2);
		while(m!=null){
			System.out.println(m.val);
			m= m.next;
		}
	}

	public static ListNode addTwoLists(ListNode l1, ListNode l2) {
		ListNode root = new ListNode();
		int carry = 0;
		ListNode curr1 = l1, curr2 = l2, curr = root;

		while (curr1 != null || curr2 != null) {
			int val1 = (curr1 != null)? curr1.val:0;
			int val2 = (curr2 != null)? curr2.val:0;
			int sum = val1 + val2 + carry;
			carry = sum/10;
			curr.next = new ListNode(sum%10);
			curr=curr.next;
			if(curr1!=null) curr1 = curr1.next;
			if(curr2!=null) curr2 = curr2.next;
		}
		if (carry>0){
				curr.next=new ListNode(carry);
		}
		return root.next;
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode root = null;
		ListNode prev = null;
		int carry = 0;
		ListNode curr1 = l1;
		ListNode curr2 = l2;
		while (true) {
			if (curr1 != null && curr2 != null) {
				int sum = curr1.val + curr2.val + carry;
				carry = 0;
				if (sum > 9) {
					sum = sum % 10;
					carry = 1;
				}
				ListNode node = new ListNode(sum);
				if (root == null) {
					root = node;
					prev= root;
				}
				else {
					prev.next = node;
					prev = node;
				}
				curr1 = curr1.next;
				curr2 = curr2.next;
			} else if (curr1 != null) {
				int sum = curr1.val + carry;
				carry = 0;
				if (sum > 9) {
					sum = sum % 10;
					carry = 1;
				}
				ListNode node = new ListNode(sum);
				if (root == null) {
					root = node;
					prev= root;
				}
				else {
					prev.next = node;
					prev = node;
				}
				curr1 = curr1.next;
			} else if (curr2 != null) {
				int sum = curr2.val + carry;
				carry = 0;
				if (sum > 9) {
					sum = sum % 10;
					carry = 1;
				}
				ListNode node = new ListNode(sum);
				if (root == null) {
					root = node;
					prev= root;
				}
				else {
					prev.next = node;
					prev = node;
				}
				curr2 = curr2.next;
			} else if (carry>0){
				prev.next=new ListNode(carry);
				carry=0;
			}
			else break;
		}
		return root;
	}
}
