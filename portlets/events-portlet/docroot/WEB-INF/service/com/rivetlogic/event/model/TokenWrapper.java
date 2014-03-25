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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Token}.
 * </p>
 *
 * @author juancarrillo
 * @see Token
 * @generated
 */
public class TokenWrapper implements Token, ModelWrapper<Token> {
	public TokenWrapper(Token token) {
		_token = token;
	}

	@Override
	public Class<?> getModelClass() {
		return Token.class;
	}

	@Override
	public String getModelClassName() {
		return Token.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("tokenId", getTokenId());
		attributes.put("participantId", getParticipantId());
		attributes.put("expiredDate", getExpiredDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long tokenId = (Long)attributes.get("tokenId");

		if (tokenId != null) {
			setTokenId(tokenId);
		}

		Long participantId = (Long)attributes.get("participantId");

		if (participantId != null) {
			setParticipantId(participantId);
		}

		Date expiredDate = (Date)attributes.get("expiredDate");

		if (expiredDate != null) {
			setExpiredDate(expiredDate);
		}
	}

	/**
	* Returns the primary key of this token.
	*
	* @return the primary key of this token
	*/
	@Override
	public long getPrimaryKey() {
		return _token.getPrimaryKey();
	}

	/**
	* Sets the primary key of this token.
	*
	* @param primaryKey the primary key of this token
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_token.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this token.
	*
	* @return the uuid of this token
	*/
	@Override
	public java.lang.String getUuid() {
		return _token.getUuid();
	}

	/**
	* Sets the uuid of this token.
	*
	* @param uuid the uuid of this token
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_token.setUuid(uuid);
	}

	/**
	* Returns the token ID of this token.
	*
	* @return the token ID of this token
	*/
	@Override
	public long getTokenId() {
		return _token.getTokenId();
	}

	/**
	* Sets the token ID of this token.
	*
	* @param tokenId the token ID of this token
	*/
	@Override
	public void setTokenId(long tokenId) {
		_token.setTokenId(tokenId);
	}

	/**
	* Returns the participant ID of this token.
	*
	* @return the participant ID of this token
	*/
	@Override
	public long getParticipantId() {
		return _token.getParticipantId();
	}

	/**
	* Sets the participant ID of this token.
	*
	* @param participantId the participant ID of this token
	*/
	@Override
	public void setParticipantId(long participantId) {
		_token.setParticipantId(participantId);
	}

	/**
	* Returns the expired date of this token.
	*
	* @return the expired date of this token
	*/
	@Override
	public java.util.Date getExpiredDate() {
		return _token.getExpiredDate();
	}

	/**
	* Sets the expired date of this token.
	*
	* @param expiredDate the expired date of this token
	*/
	@Override
	public void setExpiredDate(java.util.Date expiredDate) {
		_token.setExpiredDate(expiredDate);
	}

	@Override
	public boolean isNew() {
		return _token.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_token.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _token.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_token.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _token.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _token.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_token.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _token.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_token.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_token.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_token.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TokenWrapper((Token)_token.clone());
	}

	@Override
	public int compareTo(com.rivetlogic.event.model.Token token) {
		return _token.compareTo(token);
	}

	@Override
	public int hashCode() {
		return _token.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.event.model.Token> toCacheModel() {
		return _token.toCacheModel();
	}

	@Override
	public com.rivetlogic.event.model.Token toEscapedModel() {
		return new TokenWrapper(_token.toEscapedModel());
	}

	@Override
	public com.rivetlogic.event.model.Token toUnescapedModel() {
		return new TokenWrapper(_token.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _token.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _token.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_token.persist();
	}

	@Override
	public boolean isExpired() {
		return _token.isExpired();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TokenWrapper)) {
			return false;
		}

		TokenWrapper tokenWrapper = (TokenWrapper)obj;

		if (Validator.equals(_token, tokenWrapper._token)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Token getWrappedToken() {
		return _token;
	}

	@Override
	public Token getWrappedModel() {
		return _token;
	}

	@Override
	public void resetOriginalValues() {
		_token.resetOriginalValues();
	}

	private Token _token;
}