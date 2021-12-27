#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void swap(vector<int>& list, int a, int b) {
    int temp = list[a];
    list[a] = list[b];
    list[b] = temp;
}

void printVector(vector<int>& v) {
    for (auto e : v) {
        cout << e << "\t";
    }
    cout << endl << endl;
}

void bubbleSort(vector<int>& list) {
    int i, j;
    int n = list.size();

    // i : 탐색할 공간 --> (n-1) ~ 0 까지 반복
    // j : 하나씩 비교하기위한 index 

    for (i = n - 1; i > 0; i--) {
        for (j = 0; j < i; j++) {
            // j번째와 j+1번째의 요소가 크기 순이 아니면 교환
            if (!(list[j] <= list[j + 1])) {
                swap(list, j, j + 1);
            }
        }
    }
}

int getMinIndex(vector<int>& list, int start) {
    int minIndex = start;
    int minValue = 10001;

    for (int j = start; j < list.size(); j++) {
        if (minValue > list[j]) {
            minIndex = j;
            minValue = list[j];
        }
    }

    return minIndex;
}

void selectionSort(vector<int>& list) {

    int n = list.size();

    for (int i = 0; i < n - 1; i++) {
        // i ~ n-1 원소까지 최솟값인 idx Select
        int minIndex = getMinIndex(list, i);

        // i랑 최솟값 idx 변경
        if (i != minIndex) {
            swap(list, i, minIndex);
        }
    }
}

bool cmp(int left, int right) {
    return left > right;
}