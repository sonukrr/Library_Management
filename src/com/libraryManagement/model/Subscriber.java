package com.libraryManagement.model;

public class Subscriber {
		
	private int subscriberId;
	private String subscriberName;
	private long phoneNumber;
	private String emailId;
	
	public Subscriber(int subscriberId, String subscriberName, long phoneNumber, String emailId) {
		super();
		this.subscriberId = subscriberId;
		this.subscriberName = subscriberName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}

	public int getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(int subscriberId) {
		this.subscriberId = subscriberId;
	}

	public String getSubscriberName() {
		return subscriberName;
	}

	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
		result = prime * result + subscriberId;
		result = prime * result + ((subscriberName == null) ? 0 : subscriberName.hashCode());
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
		Subscriber other = (Subscriber) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		if (subscriberId != other.subscriberId)
			return false;
		if (subscriberName == null) {
			if (other.subscriberName != null)
				return false;
		} else if (!subscriberName.equals(other.subscriberName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subscriber [subscriberId=" + subscriberId + ", subscriberName=" + subscriberName + ", phoneNumber="
				+ phoneNumber + ", emailId=" + emailId + "]";
	}
	
	
	
	
}
