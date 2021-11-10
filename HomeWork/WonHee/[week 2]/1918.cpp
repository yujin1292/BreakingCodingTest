#include <iostream>
#include <string>
#include <stack>
#include <cctype>

using namespace std;

string str;
stack<char> s;

int main() {

	cin >> str;
	
	for (int i = 0; i < str.size(); i++) {
		if (isalpha(str[i]) != 0) {
			cout << str[i];
		}
		else {
			if (str[i] == '(')
				s.push(str[i]);
			else if (str[i] == '+' || str[i] == '-') {
				while (!s.empty() && s.top() != '(') {
					cout << s.top();
					s.pop();
				}
				s.push(str[i]);
			}
			else if (str[i] == '*' || str[i] == '/') {
				while (!s.empty() && (s.top() == '*'||s.top()=='/')) {
					cout << s.top();
					s.pop();
				}
				s.push(str[i]);
			}
			else if (str[i] == ')') {
				while (s.top() != '(') {
					cout << s.top();
					s.pop();
				}
				if (s.top() == '(')
					s.pop();
			}
		}
	}
	while (!s.empty()) {
		cout << s.top();
		s.pop();
	}
	system("pause");
	return 0;
}