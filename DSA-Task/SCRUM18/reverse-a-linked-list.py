class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head):
        prev_node = None
        current_node = head
        while current_node is not None:
            next_node = current_node.next
            current_node.next = prev_node
            prev_node = current_node
            current_node = next_node
        return prev_node

if __name__ == "__main__":
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4,ListNode(5)))))

    solution = Solution()
    reversed_head = solution.reverseList(head)

    # Function to print the reversed list
    def print_list(head):
        current = head
        while current:
            print(current.val, end=" ")
            current = current.next

    print("Reversed List:")
    print_list(reversed_head)
