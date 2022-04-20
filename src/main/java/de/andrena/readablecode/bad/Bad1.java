package de.andrena.readablecode.bad;

public class Bad1 {

	private String label;

	public Bad1(String label) {
		this.label = label;
	}
	
	public void foo(Bad1 bad) {
		this.label = bad.label;
	}

	public String bar(Bad1 bad) {
		String label = bad.label;
		bad.label = this.label;
		return label;
	}

	public String label() {
		return label;
	}

}
