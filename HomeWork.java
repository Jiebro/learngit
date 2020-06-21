package web;

public class HomeWork {

	public static void main(String[] args) {
		long num;
		Fibonacci fibo =new Fibonacci();
		for(int flag=1;flag<200;flag++) {
			num=fibo.of(flag);
			System.out.println(num);
		}
	}
}

class Fibonacci{
	public long of(int i) {
		int a=i;
		long fibo=0;
		if(a<=2) {
			return 1;
		}
		else {
			fibo+=of(a-1)+of(a-2);
			return fibo;
		}
	}
}
