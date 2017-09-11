#include"play_chess.h"

void main()
{
	play_chess a;
	int n,m;

	cout << "请选择先手还是后手:0.先手 1.后手" << endl;
	cin >> n;
	cout << "请选择执X棋还是O棋(0.X 1.O)" << endl;
	cin >> m;
	cout << "下子方法，输入几行几列。" << endl;

	if(n == 0)
	{
		a.play(m);
	}
	if(n == 1)
	{
		a.anticipate(m);
		a.play(m);
	}
}