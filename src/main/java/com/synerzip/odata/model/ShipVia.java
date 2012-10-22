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
@Table(name = "SHIP_VIA")
public class ShipVia implements Serializable {

	private static final long serialVersionUID = 8866668670602364276L;

	/** Field mapping. */
	@Id
	@Basic(optional = false)
	@Column(name = "SHIPPER_ID", nullable = false)
	private BigDecimal shipperId;

	/** Field mapping. */
	@Basic(optional = false)
	@Column(name = "SHIPPER_NAME", length = 30)
	private String shipperName;

	/**
	 * Return the type of this class. Useful for when dealing with proxies.
	 * 
	 * @return Defining class.
	 */
	@Transient
	public Class<?> getClassType() {
		return ShipVia.class;
	}

	/**
	 * @return the shipperId
	 */
	public BigDecimal getShipperId() {
		return shipperId;
	}

	/**
	 * @param shipperId
	 *            the shipperId to set
	 */
	public void setShipperId(BigDecimal shipperId) {
		this.shipperId = shipperId;
	}

	/**
	 * @return the shipperName
	 */
	public String getShipperName() {
		return shipperName;
	}

	/**
	 * @param shipperName
	 *            the shipperName to set
	 */
	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
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
				+ ((shipperId == null) ? 0 : shipperId.hashCode());
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
		if (!(obj instanceof ShipVia)) {
			return false;
		}
		ShipVia other = (ShipVia) obj;
		if (shipperId == null) {
			if (other.shipperId != null) {
				return false;
			}
		} else if (!shipperId.equals(other.shipperId)) {
			return false;
		}
		if (shipperName == null) {
			if (other.shipperName != null) {
				return false;
			}
		} else if (!shipperName.equals(other.shipperName)) {
			return false;
		}
		return true;
	}

}
