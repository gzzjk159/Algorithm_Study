#include <iostream> 
using namespace std;

int main(){
	int N;		// ���� ��
	int cnt = 0;	
	int score[100];	// ������ ����
	
	cin >> N; 
	
	for (int i = 0; i < N; i++) 
		cin >> score[i]; 
	
	for (int i = N - 1; i >= 1; i--) { 
		while (score[i] <= score[i - 1]) {
			score[i - 1] -= 1;
			cnt++;
		}
	} 
	
	cout << cnt;

	return 0;
}
