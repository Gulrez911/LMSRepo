package com.assessment.data;

import javax.persistence.Entity;

@Entity
public class FileStatus extends Base{

	
	String email;
	
	Boolean status;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
