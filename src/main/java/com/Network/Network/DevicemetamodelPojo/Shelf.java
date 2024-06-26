package com.Network.Network.DevicemetamodelPojo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Shelf implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String name;

	private int shelfPosition;

	private String operationalState;

	private String administrativeState;

	private String href;

	private String usageState;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "devicename", referencedColumnName = "devicename")
	private Device device;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "shelf_additional_attribute",
			joinColumns = @JoinColumn(name = "shelf_id"),
			inverseJoinColumns = @JoinColumn(name = "additional_attribute_id")
	)
	private List<AdditionalAttribute> additionalAttributes = new ArrayList<>();
	private String realtion;


	public Shelf(Long id, String name, int shelfPosition, String operationalState, String administrativeState, String href, String usageState, Device device, List<AdditionalAttribute> additionalAttributes, String realtion) {
		this.id = id;
		this.name = name;
		this.shelfPosition = shelfPosition;
		this.operationalState = operationalState;
		this.administrativeState = administrativeState;
		this.href = href;
		this.usageState = usageState;
		this.device = device;
		this.additionalAttributes = additionalAttributes;
		this.realtion = realtion;
	}

	public List<AdditionalAttribute> getAdditionalAttributes() {
		return additionalAttributes;
	}

	public void setAdditionalAttributes(List<AdditionalAttribute> additionalAttributes) {
		this.additionalAttributes = additionalAttributes;
	}

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

	public int getShelfPosition() {
		return shelfPosition;
	}

	public void setShelfPosition(int shelfPosition) {
		this.shelfPosition = shelfPosition;
	}

	public String getOperationalState() {
		return operationalState;
	}

	public void setOperationalState(String operationalState) {
		this.operationalState = operationalState;
	}

	public String getAdministrativeState() {
		return administrativeState;
	}

	public void setAdministrativeState(String administrativeState) {
		this.administrativeState = administrativeState;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getUsageState() {
		return usageState;
	}

	public void setUsageState(String usageState) {
		this.usageState = usageState;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public String getRealtion() {
		return realtion;
	}

	public void setRealtion(String realtion) {
		this.realtion = realtion;
	}

	public Shelf() {
	}
}
