package com.ninegame.hot.page;

import java.util.List;

public class PageObject {

	private int pagePerSize;
	
	private int pageCurNum;
	
	private int totalSize;
	
	private int totalPages;
	
	private int curDataSize;
	
	private List<Object> dataList;


	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public List<Object> getDataList() {
		return dataList;
	}

	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurDataSize() {
		return curDataSize;
	}

	public void setCurDataSize(int curDataSize) {
		this.curDataSize = curDataSize;
	}

	public int getPagePerSize() {
		return pagePerSize;
	}

	public void setPagePerSize(int pagePerSize) {
		this.pagePerSize = pagePerSize;
	}

	public int getPageCurNum() {
		return pageCurNum;
	}

	public void setPageCurNum(int pageCurNum) {
		this.pageCurNum = pageCurNum;
	}
	
}
