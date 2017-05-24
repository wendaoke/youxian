package com.very.youxian.constant;

public enum CommentType {
	DIAODIAN("钓点", 1), YUJUDIAN("渔具店", 2);

	private String name;
	private int index;

	private CommentType(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
