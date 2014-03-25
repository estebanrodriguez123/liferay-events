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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author juancarrillo
 * @generated
 */
public class ParticipantSoap implements Serializable {
	public static ParticipantSoap toSoapModel(Participant model) {
		ParticipantSoap soapModel = new ParticipantSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setParticipantId(model.getParticipantId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setEventId(model.getEventId());
		soapModel.setFullName(model.getFullName());
		soapModel.setEmail(model.getEmail());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setCompanyName(model.getCompanyName());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ParticipantSoap[] toSoapModels(Participant[] models) {
		ParticipantSoap[] soapModels = new ParticipantSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ParticipantSoap[][] toSoapModels(Participant[][] models) {
		ParticipantSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ParticipantSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ParticipantSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ParticipantSoap[] toSoapModels(List<Participant> models) {
		List<ParticipantSoap> soapModels = new ArrayList<ParticipantSoap>(models.size());

		for (Participant model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ParticipantSoap[soapModels.size()]);
	}

	public ParticipantSoap() {
	}

	public long getPrimaryKey() {
		return _participantId;
	}

	public void setPrimaryKey(long pk) {
		setParticipantId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getParticipantId() {
		return _participantId;
	}

	public void setParticipantId(long participantId) {
		_participantId = participantId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getCompanyName() {
		return _companyName;
	}

	public void setCompanyName(String companyName) {
		_companyName = companyName;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private String _uuid;
	private long _participantId;
	private long _companyId;
	private long _groupId;
	private long _eventId;
	private String _fullName;
	private String _email;
	private String _phoneNumber;
	private String _companyName;
	private int _status;
}