package entities;

import java.util.ArrayList;

import org.joda.time.LocalDate;

public class Invoice {

	private long invoiceId;
	private LocalDate issueDate;
	private Invoice_Status status;
	private Invoice_PaymentMethod paymentMethod;
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

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public Invoice_Status getStatus() {
		return status;
	}

	public void setStatus(Invoice_Status status) {
		this.status = status;
	}

	public Invoice_PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Invoice_PaymentMethod paymentMethod) {
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
