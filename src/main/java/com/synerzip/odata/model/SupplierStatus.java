package com.synerzip.odata.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "STATUS")
public class SupplierStatus implements Serializable {

	private static final long serialVersionUID = 238437138417505082L;

	/** Field mapping. */
	@Id
	@Basic(optional = false)
	@Column(name = "STATUS_ID", nullable = false)
	private BigDecimal statusId;

	/** Field mapping. */
	@Basic(optional = false)
	@Column(name = "STATUS_NAME", length = 30)
	private String statusName;

	/**
	 * Return the type of this class. Useful for when dealing with proxies.
	 * 
	 * @return Defining class.
	 */
	@Transient
	public Class<?> getClassType() {
		return SupplierStatus.class;
	}

	/**
	 * @return the statusId
	 */
	public BigDecimal getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId
	 *            the statusId to set
	 */
	public void setStatusId(BigDecimal statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the statusName
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * @param statusName
	 *            the statusName to set
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((statusId == null) ? 0 : statusId.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof SupplierStatus)) {
			return false;
		}
		SupplierStatus other = (SupplierStatus) obj;
		if (statusId == null) {
			if (other.statusId != null) {
				return false;
			}
		} else if (!statusId.equals(other.statusId)) {
			return false;
		}
		if (statusName == null) {
			if (other.statusName != null) {
				return false;
			}
		} else if (!statusName.equals(other.statusName)) {
			return false;
		}
		return true;
	}

}
