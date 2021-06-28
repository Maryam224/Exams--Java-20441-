package Poly2020A87;

public class B extends A {
	private String _st;
	public B() {
		_st="B";
	}
	public B(String st,int val) {
		super(val);
		_st=st;
	}
	public String getSt() {
		return _st;
	}
	public boolean equals(Object other) {
		System.out.println("BObject");
		if(other instanceof B)
			return (_st.equals(((B)other)._st)&&getVal()==((B)other).getVal());
		return false;
	}
	public boolean equals(A other) {
		System.out.println("BA");
		if(other instanceof B)
			return (_st.equals(((B)other)._st)&&getVal()==((B)other).getVal());
		return false;
		
	}
	public boolean equals(B other) {
		System.out.println("BB");
		return (_st.equals(other._st)&&getVal()==other.getVal());
	}
	
	

}
