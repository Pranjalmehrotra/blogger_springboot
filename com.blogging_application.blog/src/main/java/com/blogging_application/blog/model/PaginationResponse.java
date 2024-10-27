package com.blogging_application.blog.model;

import java.util.List;

public class PaginationResponse {
	
	private List<PostModel>postModelList;
	private Integer pageNumber;
	private Integer pageSize;
	private long totalElements;
	private Integer totalPages;
	private boolean isLastPage;

	
	public List<PostModel> getPostModelList() {
		return postModelList;
	}
	public void setPostModelList(List<PostModel> postModelList) {
		this.postModelList = postModelList;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public PaginationResponse(List<PostModel> postModelList, Integer pageNumber, Integer pageSize,
			long totalElements, Integer totalPages, boolean isLastPage) {
		super();
		this.postModelList = postModelList;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.isLastPage = isLastPage;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public PaginationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	
	public boolean isLastPage() {
		return isLastPage;
	}
	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
	
	
	
	

}
