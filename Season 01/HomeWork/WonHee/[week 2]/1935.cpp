#include <iostream>
#include <String>
#include <stack>
#include <cctype>

using namespace std;

int N;
string str;
int num[26];
stack<double> s;

int main() {
	cin >> N;
	cin >> str;

	for (int i = 0; i < N; i++) {
		cin >> num[i];
	}

	for (int i = 0; i < str.size(); i++) {
		double a, b;

		if (isalpha(str[i]) != 0) {
			s.push(num[str[i]-'A']);
		}
		else {
			if (str[i] == '*') {
				a = s.top();
				s.pop();
				b = s.top();
				s.pop();
				s.push(b*a);
			}
			if (str[i] == '/') {
				a = s.top();
				s.pop();
				b = s.top();
				s.pop();
				s.push(b / a);
			}
			if (str[i] == '+') {
				a = s.top();
				s.pop();
				b = s.top();
				s.pop();
				s.push(b + a);
			}
			if (str[i] == '-') {
				a = s.top();
				s.pop();
				b = s.top();
				s.pop();
				s.push(b - a);
			}
		}
	}

	cout << fixed;
	cout.precision(2);
	cout << s.top();

	system("pause");
	return 0;
}