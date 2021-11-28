#include <iostream>
#include <vector>

using namespace std;

vector<char> v;

int main() {
	int N;

	cin >> N;

	for (int i = 0; i < N; i++) {
		char temp;
		cin >> temp;
		v.push_back(temp);
	}

	for (int i = 0; i < (1 << N); i++) {
		for (int j = 0; j < N; j++) {
			if (i&(1 << j))
				cout << v[j] << " ";
		}
		cout << "\n";
	}
	system("pause");
	return 0;
}