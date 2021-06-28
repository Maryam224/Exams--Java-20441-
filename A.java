package Poly2020A87;

public class A {
	private int _val;
	public A() {
		_val=1;
	}
	public A(int val) {
		_val=val;
	}
	public int getVal() {
		return _val;
	}
	public boolean equals(Object other) {
		System.out.println("AObject");
		if(other instanceof A)
			return (_val==((A)other)._val);
		return false;
	}
	//----------------------------------------

}
