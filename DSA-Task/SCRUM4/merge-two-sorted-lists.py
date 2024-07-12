class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, a, b):
        if a and b:
            if a.val > b.val:
                a, b = b, a
            a.next = self.mergeTwoLists(a.next, b)
        return a or b

if __name__ == "__main__":
    #example linked lists
    list1 = ListNode(1, ListNode(3, ListNode(5)))
    list2 = ListNode(2, ListNode(4, ListNode(6)))

    solution = Solution()
    merged_list_head = solution.mergeTwoLists(list1, list2)

    # Function to print the merged list
    def print_list(head):
        current = head
        while current:
            print(current.val, end="  ")
            current = current.next


    print_list(merged_list_head)
