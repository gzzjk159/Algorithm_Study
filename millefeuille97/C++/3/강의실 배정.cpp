#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;
struct node { int s, t; };
node lecture[200000];

bool compare(node a, node b) {
	return (a.s == b.s) ? a.t < b.t : a.s < b.s;
}

int main() {
	int n;

	ios_base::sync_with_stdio(0);	// ����� �ӵ� �⼧
	cin.tie(0); cout.tie(0);	// cin, cout ���ΰ� Ǯ� ���� ���� ����
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> lecture[i].s >> lecture[i].t;
	}

	sort(lecture, lecture + n, compare);

	priority_queue<int, vector<int>, greater<int>> q;	// �켱���� ���� ���ĵǴ� �켱���� ť
	q.push(lecture[0].t);

	for (int i = 1; i < n; i++) {
		int s = lecture[i].s, t = lecture[i].t;
		int now = q.top();		// �� �ð��� ���� �� ���� ��ȯ

		if (now > s) {//��ġ�°�� 
			q.push(t);
		}
		else {
			q.pop();
			q.push(t);
		}
	}
	cout << q.size();

	return 0;
}