package application.models;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import application.models.status.OrderStatus;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="employee_id")
	private User employee;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="item_id")
	private Item item;

	private int quantity;
	private Float total;
	private String justification;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="facility_id")
	private Facility facility;

	private String room;

	@Column(name="created_date")
	private Date createdDate;

	@Column(name="executed_date")
	private Date executedDate;

	@Column(name="expected_delivery_date")
	private Date expectedDeliveryDate;

	@Column(name="received_date")
	private Date receivedDate;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="vendor_id")
	private Vendor vendor;

	@Column(name="tracking_number")
	private String trackingNumber;


	@Column(name="status")
	private String status;

	//private String status;

	public boolean isEditableByUser(User user) {
		OrderStatus statusObject = OrderStatus.getStatusObject(status);
		return statusObject.canBeEditedByUser(this, user);
	}

	public boolean isCancelableByUser(User user) {
		OrderStatus statusObject = OrderStatus.getStatusObject(status);
		return statusObject.canBeCanceledByUser(this, user);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getEmployee() {
		return employee;
	}
	public void setEmployee(User employee) {
		this.employee = employee;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public float getTotal() {
		if (total == null) {
			total = 0.0f;
		}
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public Facility getFacility() {
		return facility;
	}
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getExecutedDate() {
		return executedDate;
	}
	public void setExecutedDate(Date executedDate) {
		this.executedDate = executedDate;
	}
	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}
	public String getExpectedDeliveryString() {
		if (expectedDeliveryDate == null) return "";
		return new SimpleDateFormat("dd/MM/yyyy").format(expectedDeliveryDate);
	}
	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}
	public Date getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getFirstName() {
		String firstName = getEmployee().getFirstName();

		return firstName;
	}

	public String getLastName() {

		String lastName = getEmployee().getLastName();

		return lastName;
	}

	public String getreviewOrder() {
		return justification;
	}




}
