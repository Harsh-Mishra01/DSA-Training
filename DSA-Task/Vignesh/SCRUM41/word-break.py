class TrieNode:
    def __init__(self, character):
        self.character = character
        self.children = [None] * 26
        self.is_end_of_word = False

class Solution:
    def __init__(self):
        self.root = TrieNode('\0')

    def insert_word(self, root, word):
        current_node = root
        for c in word:
            index = ord(c) - ord('a')
            if current_node.children[index] is None:
                current_node.children[index] = TrieNode(c)
            current_node = current_node.children[index]
        current_node.is_end_of_word = True

    def can_segment_string(self, root, s, start, memo):
        if start == len(s):
            return True

        if memo[start] != -1:
            return memo[start] == 1

        current_node = root
        for i in range(start, len(s)):
            index = ord(s[i]) - ord('a')
            if current_node.children[index] is None:
                memo[start] = 0
                return False
            current_node = current_node.children[index]
            if current_node.is_end_of_word and self.can_segment_string(root, s, i + 1, memo):
                memo[start] = 1
                return True
        memo[start] = 0
        return False

    def wordBreak(self, s, wordDict):
        for word in wordDict:
            self.insert_word(self.root, word)
        memo = [-1] * len(s)
        return self.can_segment_string(self.root, s, 0, memo)

s = "leetcode"
wordDict = ["leet", "code"]
sol = Solution()
print(sol.wordBreak(s, wordDict))
