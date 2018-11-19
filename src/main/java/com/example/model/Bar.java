package com.example.model;

public class Bar {
	
	private String foo;

	private String bar;

	public Bar() {
	}

	public Bar(String foo, String bar) {
		this.foo = foo;
		this.bar = bar;
	}

	public String getFoo() {
		return this.foo;
	}

	public void setFoo(String foo) {
		this.foo = foo;
	}

	public String getBar() {
		return this.bar;
	}

	public void setBar(String bar) {
		this.bar = bar;
	}

	@Override
	public String toString() {
		return "Bar [foo=" + this.foo + ", bar=" + this.bar + "]";
	}

}
