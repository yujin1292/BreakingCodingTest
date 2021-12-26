#include <iostream>
#include <stack>
#include <vector>
#include <string>

using namespace std;

stack<double> s;
vector<double> v;

double calc(string pf) {
	int size = pf.length();
	int idx;
	double n1, n2;

	for (int i = 0; i < size; i++) {
		if (pf[i] >= 'A' && pf[i] <= 'Z') {
			idx = pf[i] - 'A';
			s.push(v[idx]);
		}
		else {
			n1 = s.top();
			s.pop();
			n2 = s.top();
			s.pop();
			if (pf[i] == '+') {
				s.push(n2 + n1);
			}
			else if (pf[i] == '*') {
				s.push(n2*n1);
			}
			else if (pf[i] == '/') {
				s.push(n2 / n1);
			}
			else if (pf[i] == '-')
				s.push(n2 - n1);
		}
	}
	return s.top();
}

int main() {
	int N;
	double num;
	string postfix;
	cin >> N >> postfix;

	for (int i = 0; i < N; i++) {
		cin >> num;
		v.push_back(num);
	}

	cout << fixed;
	cout.precision(2);
	cout << calc(postfix) << endl;

	return 0;
}