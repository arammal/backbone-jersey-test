package com.tuto.dto;

public class PetDTO {
	private int id;
	private String name;
	private int age;
	private String comments;
	
	public PetDTO() {
	}
	
	public PetDTO(int id, String name, int age, String comments) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.comments = comments;
	}
	

	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getComments() {
		return comments;
	}
	

	public void setId(int id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		PetDTO other = (PetDTO) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
