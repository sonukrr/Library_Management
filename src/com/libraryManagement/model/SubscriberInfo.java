package com.libraryManagement.model;

public class SubscriberInfo {


	private Subscriber subscriber;
	private String booksIssued;
	public SubscriberInfo(Subscriber subscriber, String booksIssued) {
		super();
		this.subscriber = subscriber;
		this.booksIssued = booksIssued;
	}
	public Subscriber getSubscriber() {
		return subscriber;
	}
	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}
	public String getBooksIssued() {
		return booksIssued;
	}
	public void setBooksIssued(String booksIssued) {
		this.booksIssued = booksIssued;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((booksIssued == null) ? 0 : booksIssued.hashCode());
		result = prime * result + ((subscriber == null) ? 0 : subscriber.hashCode());
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
		SubscriberInfo other = (SubscriberInfo) obj;
		if (booksIssued == null) {
			if (other.booksIssued != null)
				return false;
		} else if (!booksIssued.equals(other.booksIssued))
			return false;
		if (subscriber == null) {
			if (other.subscriber != null)
				return false;
		} else if (!subscriber.equals(other.subscriber))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "subscriberInfo [subscriber=" + subscriber + ", booksIssued=" + booksIssued + "]";
	}
	
	
}
