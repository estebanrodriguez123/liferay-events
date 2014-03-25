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

package com.rivetlogic.event.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rivetlogic.event.model.Participant;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Participant in entity cache.
 *
 * @author juancarrillo
 * @see Participant
 * @generated
 */
public class ParticipantCacheModel implements CacheModel<Participant>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", participantId=");
		sb.append(participantId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Participant toEntityModel() {
		ParticipantImpl participantImpl = new ParticipantImpl();

		if (uuid == null) {
			participantImpl.setUuid(StringPool.BLANK);
		}
		else {
			participantImpl.setUuid(uuid);
		}

		participantImpl.setParticipantId(participantId);
		participantImpl.setCompanyId(companyId);
		participantImpl.setGroupId(groupId);
		participantImpl.setEventId(eventId);

		if (fullName == null) {
			participantImpl.setFullName(StringPool.BLANK);
		}
		else {
			participantImpl.setFullName(fullName);
		}

		if (email == null) {
			participantImpl.setEmail(StringPool.BLANK);
		}
		else {
			participantImpl.setEmail(email);
		}

		if (phoneNumber == null) {
			participantImpl.setPhoneNumber(StringPool.BLANK);
		}
		else {
			participantImpl.setPhoneNumber(phoneNumber);
		}

		if (companyName == null) {
			participantImpl.setCompanyName(StringPool.BLANK);
		}
		else {
			participantImpl.setCompanyName(companyName);
		}

		participantImpl.setStatus(status);

		participantImpl.resetOriginalValues();

		return participantImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		participantId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		eventId = objectInput.readLong();
		fullName = objectInput.readUTF();
		email = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();
		companyName = objectInput.readUTF();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(participantId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(eventId);

		if (fullName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (phoneNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

		if (companyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyName);
		}

		objectOutput.writeInt(status);
	}

	public String uuid;
	public long participantId;
	public long companyId;
	public long groupId;
	public long eventId;
	public String fullName;
	public String email;
	public String phoneNumber;
	public String companyName;
	public int status;
}