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

import com.rivetlogic.event.model.Token;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Token in entity cache.
 *
 * @author juancarrillo
 * @see Token
 * @generated
 */
public class TokenCacheModel implements CacheModel<Token>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", tokenId=");
		sb.append(tokenId);
		sb.append(", participantId=");
		sb.append(participantId);
		sb.append(", expiredDate=");
		sb.append(expiredDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Token toEntityModel() {
		TokenImpl tokenImpl = new TokenImpl();

		if (uuid == null) {
			tokenImpl.setUuid(StringPool.BLANK);
		}
		else {
			tokenImpl.setUuid(uuid);
		}

		tokenImpl.setTokenId(tokenId);
		tokenImpl.setParticipantId(participantId);

		if (expiredDate == Long.MIN_VALUE) {
			tokenImpl.setExpiredDate(null);
		}
		else {
			tokenImpl.setExpiredDate(new Date(expiredDate));
		}

		tokenImpl.resetOriginalValues();

		return tokenImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		tokenId = objectInput.readLong();
		participantId = objectInput.readLong();
		expiredDate = objectInput.readLong();
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

		objectOutput.writeLong(tokenId);
		objectOutput.writeLong(participantId);
		objectOutput.writeLong(expiredDate);
	}

	public String uuid;
	public long tokenId;
	public long participantId;
	public long expiredDate;
}