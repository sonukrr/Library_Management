package com.libraryManagement.model;

import java.sql.Date;
import java.time.LocalDate;

public class Books {

	private int booksIsbn;
	private String name;
	private LocalDate pubDate;
	private int quantity;
	
	public Books(int bookISBN, String name, LocalDate pubDate, int quantity) {
		super();
		this.booksIsbn = bookISBN;
		this.name = name;
		this.pubDate = pubDate;
		this.quantity = quantity;
	}

	public int getBooksIsbn() {
		return booksIsbn;
	}

	public void setBooksIsbn(int booksIsbn) {
		this.booksIsbn = booksIsbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getPubDate() {
		return pubDate;
	}

	public void setPubDate(LocalDate pubDate) {
		this.pubDate = pubDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + booksIsbn;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pubDate == null) ? 0 : pubDate.hashCode());
		result = prime * result + quantity;
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
		Books other = (Books) obj;
		if (booksIsbn != other.booksIsbn)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pubDate == null) {
			if (other.pubDate != null)
				return false;
		} else if (!pubDate.equals(other.pubDate))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Books [booksIsbn=" + booksIsbn + ", name=" + name + ", pubDate=" + pubDate + ", quantity=" + quantity
				+ "]";
	}
	
	
	
}
