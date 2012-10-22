package com.synerzip.odata.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Object mapping for hibernate-handled table: supplier_parts.
 * 
 * @author Anil Allewar
 */

@Entity
@Table(name = "supplier_parts")
public class SupplierParts implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -558893099L;

	/** primary key */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	/** Field mapping. */
	@Basic(optional = true)
	@Column(name = "QUANTITY")
	private BigDecimal quantity;
	
	/** Field mapping. */
	@Basic(optional = true)
	@Column(name = "shipper_id")
	private BigDecimal shipperId;
	
	/** Field mapping. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PART_ID")
	private Parts part;
	
	/** Field mapping. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPPLIER_ID")
	private Supplier supplier;

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
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the part
	 */
	public Parts getPart() {
		return part;
	}

	/**
	 * @param part
	 *            the part to set
	 */
	public void setPart(Parts part) {
		this.part = part;
	}

	/**
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier
	 *            the supplier to set
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	/**
	 * Return the value associated with the column: quantity.
	 * 
	 * @return A BigDecimal object (this.quantity)
	 */
	public BigDecimal getQuantity() {
		return this.quantity;

	}

	/**
	 * Set the value related to the column: quantity.
	 * 
	 * @param quantity
	 *            the quantity value you wish to set
	 */
	public void setQuantity(final BigDecimal quantity) {
		this.quantity = quantity;
	}

	/**
	 * Return the value associated with the column: shipperId.
	 * 
	 * @return A BigDecimal object (this.shipperId)
	 */
	public BigDecimal getShipperId() {
		return this.shipperId;

	}

	/**
	 * Set the value related to the column: shipperId.
	 * 
	 * @param shipperId
	 *            the shipperId value you wish to set
	 */
	public void setShipperId(final BigDecimal shipperId) {
		this.shipperId = shipperId;
	}

	/**
	 * Deep copy.
	 * 
	 * @return cloned object
	 * @throws CloneNotSupportedException
	 *             on error
	 */
	@Override
	public SupplierParts clone() throws CloneNotSupportedException {

		final SupplierParts copy = (SupplierParts) super.clone();

		copy.setId(this.getId());
		copy.setPart(this.part);
		copy.setSupplier(this.supplier);
		copy.setQuantity(this.getQuantity());
		copy.setShipperId(this.getShipperId());
		return copy;
	}

	/**
	 * Provides toString implementation.
	 * 
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("part: " + this.getPart() + ", ");
		sb.append("quantity: " + this.getQuantity() + ", ");
		sb.append("shipperId: " + this.getShipperId() + ", ");
		sb.append("supplier: " + this.getSupplier());
		return sb.toString();
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (!(obj instanceof SupplierParts)) {
			return false;
		}
		SupplierParts other = (SupplierParts) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (quantity == null) {
			if (other.quantity != null) {
				return false;
			}
		} else if (!quantity.equals(other.quantity)) {
			return false;
		}
		if (shipperId == null) {
			if (other.shipperId != null) {
				return false;
			}
		} else if (!shipperId.equals(other.shipperId)) {
			return false;
		}
		return true;
	}
}
