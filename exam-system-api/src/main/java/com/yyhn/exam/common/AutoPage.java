package com.yyhn.exam.common;

import java.io.Serializable;
import java.util.List;

public class AutoPage<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final int defaultPage = 1;// 默认页
	private int previousPage;// 上一页
	private int nextPage;// 下一页
	private int currentPage; // 当前页
	private int firstPage;// 首页
	private int lastPage;// 尾页
	private List<T> list;// 数据
	private boolean hasPreviousPage;// 是否有上一页
	private boolean hasNextPage;// 是否有上一页
	private int pageSize;// 每页显示多少记录数
	private int totalPage;// 总页数
	private int recordTotal;// 总记录数


	/**
	 *  传入参数，list,currentPage
	 * @param list 查询的数据
	 * @param currentPage 当前页
	 */
	public AutoPage(List<T> list, int currentPage) {
		this(list,currentPage,8);
	}


	/**
	 *  传入参数，list,currentPage,pageSize
	 * @param list 查询的数据
	 * @param currentPage 当前页
	 * @param pageSize 每页显示数
	 */
	public AutoPage(List<T> list, int currentPage, int pageSize) {
		if(currentPage<=1) currentPage=1;
//		System.out.println("每页显示数：=====》"+pageSize);
		int totalPage = list.size() % pageSize == 0 ? list.size() / pageSize : list.size() / pageSize + 1;
		int recordTotal = list.size();
		boolean hasNextPage = currentPage + 1 >= totalPage ? false : true;
		boolean hasPreviousPage = currentPage - 1 < 1 ? false : true;
		this.currentPage = currentPage < totalPage ? currentPage : totalPage;
		try {
			this.list = list.subList((this.currentPage-1) * pageSize, this.currentPage * pageSize);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
//			throw new RuntimeException("数组越界或者参数异常====>"+e.getMessage());
			this.list = list.subList((this.currentPage-1) * pageSize, list.size());
		}
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.recordTotal = recordTotal;
		this.firstPage = AutoPage.defaultPage;
		this.lastPage = totalPage;
		this.hasPreviousPage = hasPreviousPage;
		this.hasNextPage = hasNextPage;
		this.nextPage = this.currentPage + 1 >=this.lastPage ? this.lastPage : this.currentPage + 1 ;
		this.previousPage = this.currentPage - 1 <= this.firstPage ? this.firstPage : this.currentPage-1;

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static int getDefaultpage() {
		return defaultPage;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public List<T> getList() {
		return list;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public int getPageSize() {
		return pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}

	public int getRecordTotal() {
		return recordTotal;
	}

	// 默认为第一页
	public int getDefaultPage() {
		return defaultPage;
	}


	public AutoPage() {

	}





}
