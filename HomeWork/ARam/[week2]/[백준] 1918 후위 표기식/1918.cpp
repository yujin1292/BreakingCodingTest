#include <iostream>
#include <string>
#include <stack>
using namespace std;

stack<char> stk;

int getPriority(char c) {
	if (c == '+' || c == '-')
		return 1;
	else if (c == '*' || c == '/')
		return 2;
}

string postfix(string s) {
	string res = "";
	for (int i = 0; i < s.length(); i++) {
		if (s[i] >= 'A' && s[i] <= 'Z') { // 피연산자
			res += s[i];
		}
		else if (s[i] == '(') {
			stk.push(s[i]);
		}
		else if (s[i] == ')') {
			while (!stk.empty()) {
				if (stk.top() == '(') {
					stk.pop();
					break;
				}
				res += stk.top();
				stk.pop();
			}
		}
		else { // 연산자
			if (s[i] == '*' || s[i] == '/') {
				while (!stk.empty() && stk.top() != '(' && (getPriority(stk.top()) >= getPriority(s[i]))) {
					res += stk.top();
					stk.pop();
				}
				stk.push(s[i]);
			}
			else if (s[i] == '+' || s[i] == '-') {
				while (!stk.empty() && stk.top() != '(' && (getPriority(stk.top()) >= getPriority(s[i]))) {
					res += stk.top();
					stk.pop();
				}
				stk.push(s[i]);
			}
		}
	}

	while (!stk.empty()) {
		res += stk.top();
		stk.pop();
	}

	return res;
}

int main() {
	string s;
	cin >> s;

	cout << postfix(s);


	return 0;
}