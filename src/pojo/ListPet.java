package pojo;

import java.util.List;

public class ListPet {
	private int id;
	private Category category;
	private String name;
	private List<String> photourls;
	private Tags tags;
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhotourls() {
		return photourls;
	}
	public void setPhotourls(List<String> photourls) {
		this.photourls = photourls;
	}
	public Tags getTags() {
		return tags;
	}
	public void setTags(Tags tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
