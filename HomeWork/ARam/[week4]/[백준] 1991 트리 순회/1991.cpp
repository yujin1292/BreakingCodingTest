#include <iostream>

using namespace std;

typedef struct node {
	char lChild = '.';
	char rChild = '.';
};

node G[26];

void preOrder(char start) {
	if (start == '.')
		return;
	cout << start;

	preOrder(G[start - 'A'].lChild);
	preOrder(G[start - 'A'].rChild);
}

void inOrder(char start) {
	if (start == '.')
		return;
	
	inOrder(G[start - 'A'].lChild);
	cout << start;
	inOrder(G[start - 'A'].rChild);
}

void postOrder(char start) {
	if (start == '.')
		return;

	postOrder(G[start - 'A'].lChild);
	postOrder(G[start - 'A'].rChild);
	cout << start;
}

int main() {
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		char cur, lchild, rchild;
		cin >> cur >> lchild >> rchild;
		G[cur - 'A'].lChild = lchild;
		G[cur - 'A'].rChild = rchild;
	}

	preOrder('A');
	cout << endl;
	inOrder('A');
	cout << endl;
	postOrder('A');

	return 0;
}