
import sys

# 이진트리의 노드 개수, 노드/왼쪽자식/오른쪽 자식 주어짐
MAX = 26
N = int(sys.stdin.readline())
tree = {}

for _ in range(N):
    node, left, right = sys.stdin.readline().strip().split()
    tree[node] = [left,right]

def preOrder(Node):
    print(Node, end='')
    if tree[Node][0] !='.':
        preOrder(tree[Node][0])
    if tree[Node][1] !='.':
        preOrder(tree[Node][1])

def inOrder(Node):
    if tree[Node][0] !='.':
        inOrder(tree[Node][0])
    print(Node, end='')
    if tree[Node][1] !='.':
        inOrder(tree[Node][1])

def postOrder(Node):
    if tree[Node][0] !='.':
        postOrder(tree[Node][0])
    if tree[Node][1] !='.':
        postOrder(tree[Node][1])
    print(Node, end='')

preOrder('A') # 문제에서 노드 이름이 A부터 차례대로 매겨진다고 명시
print('')
inOrder('A')
print('')
postOrder('A')

# Class로 푸는 방법
# class Node:
#     def __init__(self, node, left, right):
#         self.node = node
#         self.left = left
#         self.right = right
#
#
# def preOrder(Node):
#     print(Node.node)
#     if Node.left!='.':
#         preOrder(tree[Node.left])
#     elif Node.right!='.':
#         preOrder(tree[Node.right])
#     else:
#         return


# for _ in range(MAX):
#     node, left, right = map(str, sys.stdin.readline().split())
#     tree[node] = Node(node, left, right)
#
# preOrder(tree['A'])