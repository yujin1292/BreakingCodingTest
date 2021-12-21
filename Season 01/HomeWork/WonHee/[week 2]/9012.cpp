#include <iostream>
#include <stack>
#include <string>

using namespace std;

int T;

bool vps(string str) {
	stack<char> s;

	for (int i = 0; i < str.length(); i++) {
		char c = str[i];

		if (c == '(') {
			s.push(c);
		}
		else if(c==')') {
			if (!s.empty()) {
				s.pop();
			}
			else {
				return false;
			}
		}
	}
	if (s.empty()) 
		return true;
	
	else
		return false;
	
}

int main() {
	cin >> T;
	string str;

	for (int i = 0; i < T; i++) {
		cin >> str;
		if (vps(str))
			cout << "YES"<<'\n';
		else
			cout << "NO"<<'\n';
	}

	system("pause");
	return 0;
}