package com.aliyun.iotlearn.common.bean;

import java.util.List;

/**
 * @Author 安悟
 * @Date 2018/7/9 上午11:30
 */
public class Page<T> {
	public Page(int currentPage, int pageSize) {
		setCurrentPage(currentPage);
		setPageSize(pageSize);
	}

	private static int DEFAULT_PAGE_SIZE = 10;	// 默认每页显示10条记录

	private static int DEFAULT_PAGE_INDEX_SIZE = 8;	// 默认显示8页
	/**
	 * 查询结果
	 */
	private List<T> data;
	/**
	 * 总记录数
	 */
	private long totalRecords;
	/**
	 * 每页显示记录数
	 */
	private int pageSize = DEFAULT_PAGE_SIZE;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 当前页
	 */
	private int currentPage = 1;

	/**
	 * 分页页码开始索引
	 */
	private int pageStartIndex;
	/**
	 * 分页页码结束索引
	 */
	private int pageEndIndex;
	/**
	 * 分页页码长度
	 */
	private int pageIndexSize = DEFAULT_PAGE_INDEX_SIZE;

	/**
	 * 获取记录开始索引
	 * @return
	 */
	public int getFirstIndex() {
		return (this.currentPage - 1) * this.pageSize;
	}

	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public long getTotalRecords() {
		return totalRecords;
	}
	/**
	 * 设置总记录数
	 * @param totalRecords
	 */
	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;

		// 计算总页数
		int totalPage = (int)((totalRecords % this.pageSize == 0) ? (totalRecords / this.pageSize) : (totalRecords / this.pageSize + 1));
		setTotalPage(totalPage);

		// 计算页码开始索引和结束索引
		if (totalPage <= pageIndexSize) {
			setPageStartIndex(1);
			setPageEndIndex(totalPage);
			return;
		}
		int before = (pageIndexSize - 1) / 2;
		int after = pageIndexSize - before -1;
		int start = currentPage - before;

		if (start <= 0) {
			setPageStartIndex(1);
			setPageEndIndex(pageIndexSize);
			return;
		}

		int end = currentPage + after;
		if (end >= totalPage) {
			setPageEndIndex(totalPage);
			setPageStartIndex(totalPage - pageIndexSize + 1);
			return;
		}

		setPageStartIndex(start);
		setPageEndIndex(end);
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if (pageSize > 0) {
			this.pageSize = pageSize;
		}
	}
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * 设置总页数
	 * @param totalPage
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		if (currentPage > 0) {
			this.currentPage = currentPage;
		}
	}

	public static int getDefaultPageSize() {
		return DEFAULT_PAGE_SIZE;
	}

	public static void setDefaultPageSize(int defaultPageSize) {
		DEFAULT_PAGE_SIZE = defaultPageSize;
	}

	public int getPageStartIndex() {
		return pageStartIndex;
	}

	private void setPageStartIndex(int pageStartIndex) {
		this.pageStartIndex = pageStartIndex;
	}

	public int getPageEndIndex() {
		return pageEndIndex;
	}

	private void setPageEndIndex(int pageEndIndex) {
		this.pageEndIndex = pageEndIndex;
	}

	public int getPageIndexSize() {
		return pageIndexSize;
	}

	public void setPageIndexSize(int pageIndexSize) {
		this.pageIndexSize = pageIndexSize;
	}
}
