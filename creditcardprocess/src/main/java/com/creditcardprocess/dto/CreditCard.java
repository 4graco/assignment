package com.creditcardprocess.dto;

import java.util.Date;

public class CreditCard {
	/*
	 * This class represents a credit card.
	 */
	private int ID;
	private String number;
	private int securityCode;
	private Date expirationDate;
	private String ownerName;
	private int ownerZipCode;
	private CreditCardStatus status;

	public CreditCard() {

	}

	public CreditCard(CreditCardBuilder builder) {
		ID = builder.ID;
		this.number = builder.number;
		this.securityCode = builder.securityCode;
		this.expirationDate = builder.expirationDate;
		this.ownerName = builder.ownerName;
		this.ownerZipCode = builder.ownerZipCode;
		this.status = builder.status;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getOwnerZipCode() {
		return ownerZipCode;
	}

	public void setOwnerZipCode(int ownerZipCode) {
		this.ownerZipCode = ownerZipCode;
	}

	public CreditCardStatus getStatus() {
		return status;
	}

	public void setStatus(CreditCardStatus status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result
				+ ((expirationDate == null) ? 0 : expirationDate.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result
				+ ((ownerName == null) ? 0 : ownerName.hashCode());
		result = prime * result + ownerZipCode;
		result = prime * result + securityCode;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		CreditCard other = (CreditCard) obj;
		if (ID != other.ID)
			return false;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (ownerName == null) {
			if (other.ownerName != null)
				return false;
		} else if (!ownerName.equals(other.ownerName))
			return false;
		if (ownerZipCode != other.ownerZipCode)
			return false;
		if (securityCode != other.securityCode)
			return false;
		if (status != other.status)
			return false;
		return true;
	}



	public static class CreditCardBuilder {
		private int ID;
		private String number;
		private int securityCode;
		private Date expirationDate;
		private String ownerName;
		private int ownerZipCode;
		private CreditCardStatus status;

		public CreditCardBuilder ID(int ID) {
			this.ID = ID;
			return this;
		}

		public CreditCardBuilder number(String number) {
			this.number = number;
			return this;
		}

		public CreditCardBuilder securityCode(int securityCode) {
			this.securityCode = securityCode;
			return this;
		}

		public CreditCardBuilder expirationDate(Date expirationDate) {
			this.expirationDate = expirationDate;
			return this;
		}

		public CreditCardBuilder ownerName(String ownerName) {
			this.ownerName = ownerName;
			return this;
		}

		public CreditCardBuilder ownerZipCode(int ownerZipCode) {
			this.ownerZipCode = ownerZipCode;
			return this;
		}

		public CreditCardBuilder status(CreditCardStatus status) {
			this.status = status;
			return this;
		}

		public CreditCard build() {
			return new CreditCard(this);
		}
	}

}
