#include <iostream>
#include <string>
#include <stack>

using namespace std;

int T;

string solve(string str) {
	stack<char> s;
	for (int j = 0; j < str.length(); j++) {
		if (str[j] == '(')
			s.push(str[j]);
		else {
			if (s.empty()) {
				return "NO";
			}
			if (s.top() == '(') {
				s.pop();
			}
		}
	}

	if (s.empty())
		return "YES";
	else
		return "NO";
}

int main(void) {
	cin >> T;

	for (int i = 0; i < T; i++) {
		string s;
		cin >> s;
		cout << solve(s) << "\n";
	}

	return 0;
}