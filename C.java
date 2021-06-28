package poly2021A;

public class C extends B {
	public int f(int x) {
		return _x-x;
	}
	public void f(A a) {
		if(a instanceof C) {
			_x=_x-a._x;
		}
		else super.f(a);
	}
	
	public void f(B b) {
		_x=_x+b._x;
	}
	
	public void f(C c) {
		_x=c._x+1;
	}

}
