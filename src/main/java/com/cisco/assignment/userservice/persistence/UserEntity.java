package com.cisco.assignment.userservice.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Type;

import lombok.Data;

//@Data // lombok data annotation
@Entity
public class UserEntity {

	@Id
	@Generated(GenerationTime.ALWAYS)
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID userId;
	
	private String userName;

	private String emailAddress;
	
	private String preferredPhoneNumber;

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

    public String getUserName() {      
        return userName;
    }

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

    public String getPreferredPhoneNumber() {
		return preferredPhoneNumber;
	}

	public void setPreferredPhoneNumber(String preferredPhoneNumber) {
		this.preferredPhoneNumber = preferredPhoneNumber;
	}

}
