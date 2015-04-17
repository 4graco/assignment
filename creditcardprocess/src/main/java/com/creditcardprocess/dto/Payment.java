package com.creditcardprocess.dto;

import java.util.Date;

public class Payment {
	private int ID;
	private double amount;
	private Date date;
	private PaymentStatus status;
	private int foreignKeyToCreditCard;

	public Payment() {
	}

	public Payment(PaymentBuilder builder) {
		this.ID = builder.ID;
		this.amount = builder.amount;
		this.date = builder.date;
		this.status = builder.status;
		this.foreignKeyToCreditCard = builder.foreignKeyToCreditCard;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public int getForeignKeyToCreditCard() {
		return foreignKeyToCreditCard;
	}

	public void setForeignKeyToCreditCard(int foreignKeyToCreditCard) {
		this.foreignKeyToCreditCard = foreignKeyToCreditCard;
	}

	public static class PaymentBuilder {
		private int ID;
		private int amount;
		private Date date;
		private PaymentStatus status;
		private int foreignKeyToCreditCard;

		public PaymentBuilder ID(int ID) {
			this.ID = ID;
			return this;
		}

		public PaymentBuilder amount(int amount) {
			this.amount = amount;
			return this;
		}

		public PaymentBuilder date(Date date) {
			this.date = date;
			return this;
		}

		public PaymentBuilder status(PaymentStatus status) {
			this.status = status;
			return this;
		}

		public PaymentBuilder foreignKeyToCreditCard(int foreignKeyToCreditCard) {
			this.foreignKeyToCreditCard = foreignKeyToCreditCard;
			return this;
		}

		public Payment build() {
			return new Payment(this);
		}
	}

}
