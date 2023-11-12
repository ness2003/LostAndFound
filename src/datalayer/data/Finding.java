package datalayer.data;

import java.sql.Date;

public class Finding {
	private int id;
	private String name;
	private Date date;
	private String place;
	private String description;
	private String receiver;
	private String owner;
	private String status;
	private String category;
	
	public Finding() {

	}
	public static final Finding NULL_FINDING = new Finding() {
	};
	
	public Finding(int id, String name, Date date, String place, String description, String receiver, String owner,
			String status, String category) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.place = place;
		this.description = description;
		this.receiver = receiver;
		this.owner = owner;
		this.status = status;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


}
