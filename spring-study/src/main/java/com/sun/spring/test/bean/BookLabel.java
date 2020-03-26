package com.sun.spring.test.bean;

import org.springframework.stereotype.Component;

/**
 * 扫描到的bean没指定名字，则默认是类名首字母小写
 */
@Component
public class BookLabel {
	private int page;
	private int contents;
	private String remark;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getContents() {
		return contents;
	}

	public void setContents(int contents) {
		this.contents = contents;
	}
}
