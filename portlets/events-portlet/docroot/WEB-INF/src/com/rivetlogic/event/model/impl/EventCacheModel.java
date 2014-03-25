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

import com.rivetlogic.event.model.Event;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Event in entity cache.
 *
 * @author juancarrillo
 * @see Event
 * @generated
 */
public class EventCacheModel implements CacheModel<Event>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", location=");
		sb.append(location);
		sb.append(", description=");
		sb.append(description);
		sb.append(", eventDate=");
		sb.append(eventDate);
		sb.append(", privateEvent=");
		sb.append(privateEvent);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Event toEntityModel() {
		EventImpl eventImpl = new EventImpl();

		if (uuid == null) {
			eventImpl.setUuid(StringPool.BLANK);
		}
		else {
			eventImpl.setUuid(uuid);
		}

		eventImpl.setEventId(eventId);
		eventImpl.setGroupId(groupId);
		eventImpl.setCompanyId(companyId);
		eventImpl.setUserId(userId);

		if (name == null) {
			eventImpl.setName(StringPool.BLANK);
		}
		else {
			eventImpl.setName(name);
		}

		if (location == null) {
			eventImpl.setLocation(StringPool.BLANK);
		}
		else {
			eventImpl.setLocation(location);
		}

		if (description == null) {
			eventImpl.setDescription(StringPool.BLANK);
		}
		else {
			eventImpl.setDescription(description);
		}

		if (eventDate == Long.MIN_VALUE) {
			eventImpl.setEventDate(null);
		}
		else {
			eventImpl.setEventDate(new Date(eventDate));
		}

		eventImpl.setPrivateEvent(privateEvent);

		eventImpl.resetOriginalValues();

		return eventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		eventId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		name = objectInput.readUTF();
		location = objectInput.readUTF();
		description = objectInput.readUTF();
		eventDate = objectInput.readLong();
		privateEvent = objectInput.readBoolean();
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

		objectOutput.writeLong(eventId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(eventDate);
		objectOutput.writeBoolean(privateEvent);
	}

	public String uuid;
	public long eventId;
	public long groupId;
	public long companyId;
	public long userId;
	public String name;
	public String location;
	public String description;
	public long eventDate;
	public boolean privateEvent;
}