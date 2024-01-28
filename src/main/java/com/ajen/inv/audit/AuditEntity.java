package com.ajen.inv.audit;

import java.util.Date;

import com.ajen.inv.common.Constants;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
/**
 * 
 * 
 * @author ajenk
 */
@MappedSuperclass
public class AuditEntity {
	
	@Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdAt;

    @Column(name = "created_by")
    protected String createdBy;

    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastUpdated;
    
    //Handle LifeCycle 
    /**
     * 
     * Sets the default creator to Admin until users and security is implemented
     * @author ajenk
     */
    @PrePersist
    protected void onCreate() {
    	Date now = new Date();
    	
        this.createdAt = now;// Set createdAt to current date/time on persist
        this.lastUpdated = now;
        
        if (this.createdBy == null || this.createdBy.trim().isEmpty()) {
            this.createdBy = getDefaultCreatedBy(); // Set a default value for createdBy
        }
    }

    /**
     * This method is used to define the default creator of new items until users and security is implemented
     * @return
     * @author ajenk
     */
    private String getDefaultCreatedBy() {
        // Default value for createdBy
        return Constants.ADMIN; // You can change this to any default string you prefer
    }


	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	
    
}
