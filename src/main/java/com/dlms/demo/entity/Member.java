package com.dlms.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Member {

    @Id
    private Long id;
    
    private String name;
    
    private String contactInfo;
    
    @OneToMany(mappedBy = "member")
    private List<Borrow> borrowingHistory;
    
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public List<Borrow> getBorrowingHistory() {
		return borrowingHistory;
	}

	public void setBorrowingHistory(List<Borrow> borrowingHistory) {
		this.borrowingHistory = borrowingHistory;
	}
    
    
}
