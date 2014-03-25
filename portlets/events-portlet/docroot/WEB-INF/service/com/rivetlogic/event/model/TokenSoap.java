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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author juancarrillo
 * @generated
 */
public class TokenSoap implements Serializable {
	public static TokenSoap toSoapModel(Token model) {
		TokenSoap soapModel = new TokenSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTokenId(model.getTokenId());
		soapModel.setParticipantId(model.getParticipantId());
		soapModel.setExpiredDate(model.getExpiredDate());

		return soapModel;
	}

	public static TokenSoap[] toSoapModels(Token[] models) {
		TokenSoap[] soapModels = new TokenSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TokenSoap[][] toSoapModels(Token[][] models) {
		TokenSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TokenSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TokenSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TokenSoap[] toSoapModels(List<Token> models) {
		List<TokenSoap> soapModels = new ArrayList<TokenSoap>(models.size());

		for (Token model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TokenSoap[soapModels.size()]);
	}

	public TokenSoap() {
	}

	public long getPrimaryKey() {
		return _tokenId;
	}

	public void setPrimaryKey(long pk) {
		setTokenId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTokenId() {
		return _tokenId;
	}

	public void setTokenId(long tokenId) {
		_tokenId = tokenId;
	}

	public long getParticipantId() {
		return _participantId;
	}

	public void setParticipantId(long participantId) {
		_participantId = participantId;
	}

	public Date getExpiredDate() {
		return _expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		_expiredDate = expiredDate;
	}

	private String _uuid;
	private long _tokenId;
	private long _participantId;
	private Date _expiredDate;
}