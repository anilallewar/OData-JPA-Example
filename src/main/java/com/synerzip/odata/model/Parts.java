package com.synerzip.odata.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PARTS")
public class Parts {

	/** Field mapping. */
	@Id
	@Basic(optional = false)
	@Column(name = "PART_ID", nullable = false, length = 4)
	private String partId;

	/** Field mapping. */
	@Basic(optional = false)
	@Column(name = "PART_NAME", length = 255)
	private String partName;

	/** Field mapping. */
	@Basic(optional = false)
	@Column(name = "PART_COLOR", length = 30)
	private String partColor;

	/** Field mapping. */
	@Basic(optional = false)
	@Column(name = "PART_WEIGHT", length = 255)
	private String partWeight;

	/** Many-to-many mapping with additional columns in join table */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "part")
	private Set<SupplierParts> supplierParts = new HashSet<SupplierParts>();

	/**
	 * Return the type of this class. Useful for when dealing with proxies.
	 * 
	 * @return Defining class.
	 */
	@Transient
	public Class<?> getClassType() {
		return SupplierParts.class;
	}

	/**
	 * @return the partId
	 */
	public String getPartId() {
		return partId;
	}

	/**
	 * @param partId
	 *            the partId to set
	 */
	public void setPartId(String partId) {
		this.partId = partId;
	}

	/**
	 * @return the partName
	 */
	public String getPartName() {
		return partName;
	}

	/**
	 * @param partName
	 *            the partName to set
	 */
	public void setPartName(String partName) {
		this.partName = partName;
	}

	/**
	 * @return the partColor
	 */
	public String getPartColor() {
		return partColor;
	}

	/**
	 * @param partColor
	 *            the partColor to set
	 */
	public void setPartColor(String partColor) {
		this.partColor = partColor;
	}

	/**
	 * @return the partWeight
	 */
	public String getPartWeight() {
		return partWeight;
	}

	/**
	 * @param partWeight
	 *            the partWeight to set
	 */
	public void setPartWeight(String partWeight) {
		this.partWeight = partWeight;
	}

	/**
	 * @return the supplierParts
	 */
	public Set<SupplierParts> getSupplierParts() {
		return supplierParts;
	}

	/**
	 * @param supplierParts
	 *            the supplierParts to set
	 */
	public void setSupplierParts(Set<SupplierParts> supplierParts) {
		this.supplierParts = supplierParts;
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
				+ ((partColor == null) ? 0 : partColor.hashCode());
		result = prime * result + ((partId == null) ? 0 : partId.hashCode());
		result = prime * result
				+ ((partName == null) ? 0 : partName.hashCode());
		result = prime * result
				+ ((partWeight == null) ? 0 : partWeight.hashCode());
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
		if (!(obj instanceof Parts)) {
			return false;
		}
		Parts other = (Parts) obj;
		if (partColor == null) {
			if (other.partColor != null) {
				return false;
			}
		} else if (!partColor.equals(other.partColor)) {
			return false;
		}
		if (partId == null) {
			if (other.partId != null) {
				return false;
			}
		} else if (!partId.equals(other.partId)) {
			return false;
		}
		if (partName == null) {
			if (other.partName != null) {
				return false;
			}
		} else if (!partName.equals(other.partName)) {
			return false;
		}
		if (partWeight == null) {
			if (other.partWeight != null) {
				return false;
			}
		} else if (!partWeight.equals(other.partWeight)) {
			return false;
		}
		return true;
	}

}
