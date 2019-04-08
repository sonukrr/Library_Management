package com.libraryManagement.model;

public class AllBookDetails {


	private Books book; 
	private String authorName;
	public AllBookDetails(Books book, String authorName) {
		super();
		this.book = book;
		this.authorName = authorName;
	}
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
		result = prime * result + ((book == null) ? 0 : book.hashCode());
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
		AllBookDetails other = (AllBookDetails) obj;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.equals(other.authorName))
			return false;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AllBookDetails [book=" + book + ", authorName=" + authorName + "]";
	}
	
	
}
