package com.libraryManagement.model;

import java.sql.Date;

public class BookIssued {
 
	private int issueId;
	private Date issueDate;
	private Date dueDate;
	private Date returnDate;
	private int subscribersId;
	private int booksIsbn;
	
	
	public BookIssued(int issueId, Date issueDate, Date dueDate, Date returnDate, int subscribersId,
			int booksIsbn) {
		super();
		this.issueId = issueId;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.subscribersId = subscribersId;
		this.booksIsbn = booksIsbn;
	}


	public int getIssueId() {
		return issueId;
	}


	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}


	public Date getIssueDate() {
		return issueDate;
	}


	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}


	public Date getDueDate() {
		return dueDate;
	}


	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


	public Date getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}


	public int getSubscribersId() {
		return subscribersId;
	}


	public void setSubscribersId(int subscribersId) {
		this.subscribersId = subscribersId;
	}


	public int getBooksIsbn() {
		return booksIsbn;
	}


	public void setBooksIsbn(int booksIsbn) {
		this.booksIsbn = booksIsbn;
	}


	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + booksIsbn;
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((issueDate == null) ? 0 : issueDate.hashCode());
		result = prime * result + issueId;
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		result = prime * result + subscribersId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookIssued other = (BookIssued) obj;
		if (booksIsbn != other.booksIsbn)
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (issueDate == null) {
			if (other.issueDate != null)
				return false;
		} else if (!issueDate.equals(other.issueDate))
			return false;
		if (issueId != other.issueId)
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		if (subscribersId != other.subscribersId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "BookIssued [issueId=" + issueId + ", issueDate=" + issueDate + ", dueDate=" + dueDate + ", returnDate="
				+ returnDate + ", subscribersId=" + subscribersId + ", booksIsbn=" + booksIsbn + "]";
	}
	
	
	
	

}
