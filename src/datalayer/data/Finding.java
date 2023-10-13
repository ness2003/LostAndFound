package datalayer.data;

public class Finding {
	private int id;
	private String name;
	private String description;
	private String date;
	private String place;
	private String category;

	public Finding(int id, String name, String description, String date, String place, String category) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.place = place;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	// Геттеры и сеттеры для полей
}
