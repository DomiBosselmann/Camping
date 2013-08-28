package Entities;

import java.util.ArrayList;
import java.util.Date;

public class Invoice {

	private long invoiceId;
	private Date issueDate;
	private String status;
	private String paymentMethod;
	private String note;
	private float price;
	private ArrayList<InvoiceItem> items;

	public Invoice() {
		super();
	}

	public long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long id) {
		this.invoiceId = id;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public ArrayList<InvoiceItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<InvoiceItem> items) {
		this.items = items;
	}

}
