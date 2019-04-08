package com.libraryManagement.model;

public class BooksAuthor {

	private int authorId;
	private int booksIsbn;
	
	public BooksAuthor(int authorId, int booksIsbn) {
		super();
		this.authorId = authorId;
		this.booksIsbn = booksIsbn;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
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
		result = prime * result + authorId;
		result = prime * result + booksIsbn;
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
		BooksAuthor other = (BooksAuthor) obj;
		if (authorId != other.authorId)
			return false;
		if (booksIsbn != other.booksIsbn)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BooksAuthor [authorId=" + authorId + ", booksIsbn=" + booksIsbn + "]";
	}
	
	
	
}
