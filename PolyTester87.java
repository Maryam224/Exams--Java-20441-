package Poly2020A87;

public class PolyTester87 {
	public static void main(String[] args) {
		A a1=new A();
		A a2=new A(5);
		A ab=new B();
		B b1=new B("B",1);
		B b2=new B("B",5);
		A c=(A)b2;
		
		/*Q6*/if(ab.equals(b1)) System.out.println("6");
		/*Q10*/if(c.equals(a1)) System.out.println("10");
		if(c.equals(b2	)) System.out.println("yes");
		
	}

}
