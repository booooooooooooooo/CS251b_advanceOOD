
class Server1  {
    void serviceA() { }
	void serviceB() { }
	void serviceM() { }
	void serviceN() { }
}

class Server2   {
    void serviceC() { }
	void serviceD() { }
}

class Server3   {
    void serviceE() { }
	void serviceF() { }
}

class Dispatcher  {
	Server1 server1 = new Server1();
	Server2 server2 = new Server2();
	Server3 server3 = new Server3();
	void serviceAB() { server1.serviceA(); server1.serviceB();}
	void serviceAC() { server1.serviceA(); server2.serviceC(); }
	void serviceCF() { server2.serviceC(); server3.serviceF(); }
	void serviceX() { System.out.println("not available"); }
}

public class Client {
	Dispatcher d = new Dispatcher();
	void operation1() {
		d.serviceAB();
		d.serviceAC();
	}
	void operation2() {
		d.serviceAB();
		d.serviceX();
	}
	void operation3() {
		d.serviceAC();
		d.serviceX();
	}

}
