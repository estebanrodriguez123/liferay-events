/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.event.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Participant}.
 * </p>
 *
 * @author juancarrillo
 * @see Participant
 * @generated
 */
public class ParticipantWrapper implements Participant,
	ModelWrapper<Participant> {
	public ParticipantWrapper(Participant participant) {
		_participant = participant;
	}

	@Override
	public Class<?> getModelClass() {
		return Participant.class;
	}

	@Override
	public String getModelClassName() {
		return Participant.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("participantId", getParticipantId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("eventId", getEventId());
		attributes.put("fullName", getFullName());
		attributes.put("email", getEmail());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("companyName", getCompanyName());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long participantId = (Long)attributes.get("participantId");

		if (participantId != null) {
			setParticipantId(participantId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this participant.
	*
	* @return the primary key of this participant
	*/
	@Override
	public long getPrimaryKey() {
		return _participant.getPrimaryKey();
	}

	/**
	* Sets the primary key of this participant.
	*
	* @param primaryKey the primary key of this participant
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_participant.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this participant.
	*
	* @return the uuid of this participant
	*/
	@Override
	public java.lang.String getUuid() {
		return _participant.getUuid();
	}

	/**
	* Sets the uuid of this participant.
	*
	* @param uuid the uuid of this participant
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_participant.setUuid(uuid);
	}

	/**
	* Returns the participant ID of this participant.
	*
	* @return the participant ID of this participant
	*/
	@Override
	public long getParticipantId() {
		return _participant.getParticipantId();
	}

	/**
	* Sets the participant ID of this participant.
	*
	* @param participantId the participant ID of this participant
	*/
	@Override
	public void setParticipantId(long participantId) {
		_participant.setParticipantId(participantId);
	}

	/**
	* Returns the company ID of this participant.
	*
	* @return the company ID of this participant
	*/
	@Override
	public long getCompanyId() {
		return _participant.getCompanyId();
	}

	/**
	* Sets the company ID of this participant.
	*
	* @param companyId the company ID of this participant
	*/
	@Override
	public void setCompanyId(long companyId) {
		_participant.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this participant.
	*
	* @return the group ID of this participant
	*/
	@Override
	public long getGroupId() {
		return _participant.getGroupId();
	}

	/**
	* Sets the group ID of this participant.
	*
	* @param groupId the group ID of this participant
	*/
	@Override
	public void setGroupId(long groupId) {
		_participant.setGroupId(groupId);
	}

	/**
	* Returns the event ID of this participant.
	*
	* @return the event ID of this participant
	*/
	@Override
	public long getEventId() {
		return _participant.getEventId();
	}

	/**
	* Sets the event ID of this participant.
	*
	* @param eventId the event ID of this participant
	*/
	@Override
	public void setEventId(long eventId) {
		_participant.setEventId(eventId);
	}

	/**
	* Returns the full name of this participant.
	*
	* @return the full name of this participant
	*/
	@Override
	public java.lang.String getFullName() {
		return _participant.getFullName();
	}

	/**
	* Sets the full name of this participant.
	*
	* @param fullName the full name of this participant
	*/
	@Override
	public void setFullName(java.lang.String fullName) {
		_participant.setFullName(fullName);
	}

	/**
	* Returns the email of this participant.
	*
	* @return the email of this participant
	*/
	@Override
	public java.lang.String getEmail() {
		return _participant.getEmail();
	}

	/**
	* Sets the email of this participant.
	*
	* @param email the email of this participant
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_participant.setEmail(email);
	}

	/**
	* Returns the phone number of this participant.
	*
	* @return the phone number of this participant
	*/
	@Override
	public java.lang.String getPhoneNumber() {
		return _participant.getPhoneNumber();
	}

	/**
	* Sets the phone number of this participant.
	*
	* @param phoneNumber the phone number of this participant
	*/
	@Override
	public void setPhoneNumber(java.lang.String phoneNumber) {
		_participant.setPhoneNumber(phoneNumber);
	}

	/**
	* Returns the company name of this participant.
	*
	* @return the company name of this participant
	*/
	@Override
	public java.lang.String getCompanyName() {
		return _participant.getCompanyName();
	}

	/**
	* Sets the company name of this participant.
	*
	* @param companyName the company name of this participant
	*/
	@Override
	public void setCompanyName(java.lang.String companyName) {
		_participant.setCompanyName(companyName);
	}

	/**
	* Returns the status of this participant.
	*
	* @return the status of this participant
	*/
	@Override
	public int getStatus() {
		return _participant.getStatus();
	}

	/**
	* Sets the status of this participant.
	*
	* @param status the status of this participant
	*/
	@Override
	public void setStatus(int status) {
		_participant.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _participant.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_participant.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _participant.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_participant.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _participant.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _participant.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_participant.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _participant.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_participant.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_participant.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_participant.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ParticipantWrapper((Participant)_participant.clone());
	}

	@Override
	public int compareTo(com.rivetlogic.event.model.Participant participant) {
		return _participant.compareTo(participant);
	}

	@Override
	public int hashCode() {
		return _participant.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.event.model.Participant> toCacheModel() {
		return _participant.toCacheModel();
	}

	@Override
	public com.rivetlogic.event.model.Participant toEscapedModel() {
		return new ParticipantWrapper(_participant.toEscapedModel());
	}

	@Override
	public com.rivetlogic.event.model.Participant toUnescapedModel() {
		return new ParticipantWrapper(_participant.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _participant.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _participant.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_participant.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ParticipantWrapper)) {
			return false;
		}

		ParticipantWrapper participantWrapper = (ParticipantWrapper)obj;

		if (Validator.equals(_participant, participantWrapper._participant)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Participant getWrappedParticipant() {
		return _participant;
	}

	@Override
	public Participant getWrappedModel() {
		return _participant;
	}

	@Override
	public void resetOriginalValues() {
		_participant.resetOriginalValues();
	}

	private Participant _participant;
}