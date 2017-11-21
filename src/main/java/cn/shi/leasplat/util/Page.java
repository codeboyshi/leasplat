package cn.shi.leasplat.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title:        Page
 * 
 * @Description   分页实体
 * 
 * @author        石强
 * 
 * @Time          2017.2.2
 * 
 * @version       1.0
 * 
 */
public class Page<T> {
	/**
	 * 正序
	 */
	public static final String ASC = "asc";
	
	/**
	 * 倒序
	 */
	public static final String DESC = "desc";
	/**
	 * 页码
	 */
	private Integer pageNo = 1;
	
	/**
	 * 每页显示条数
	 */
	private Integer pageSize = -1;
	
	/**
	 * 总数
	 */
	private Integer totalCount = 0;
	
	/**
	 * 第几条开始查询-查询时用到
	 */
	private Integer limit = 0;

	/**
	 * 每次查几条-查询时用到
	 */
	private Integer offset = 0;
	
	/**
	 * 共多少页
	 */
	private Integer pa = 0;
	
	/**
	 * 实体
	 */
	private List<T> result = new ArrayList<T>();
	
	
	public Page(Integer pageNo, Integer pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.limit = (this.pageNo-1)*this.pageSize;
		this.offset = pageSize;
	}

	public Page(List<T> result) {
		this.result = result;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		
		if (this.totalCount < 0) {
	    	return;
	    }

	    int count = this.totalCount / this.pageSize;
	    if (this.totalCount % this.pageSize > 0) {
	    	++count;
	    }
	    this.pa = count;
	}
	
	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public Integer getPa() {
		
		return pa;
	}

	public void setPa(Integer pa) {
		this.pa = pa;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", limit=" + limit
				+ ", offset=" + offset + ", pa=" + pa + ", result=" + result + "]";
	}

}
