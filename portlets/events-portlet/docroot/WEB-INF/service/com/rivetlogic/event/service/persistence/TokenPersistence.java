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

package com.rivetlogic.event.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.rivetlogic.event.model.Token;

/**
 * The persistence interface for the token service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author juancarrillo
 * @see TokenPersistenceImpl
 * @see TokenUtil
 * @generated
 */
public interface TokenPersistence extends BasePersistence<Token> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TokenUtil} to access the token persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tokens where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching tokens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Token> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tokens where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.TokenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of tokens
	* @param end the upper bound of the range of tokens (not inclusive)
	* @return the range of matching tokens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Token> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tokens where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.TokenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of tokens
	* @param end the upper bound of the range of tokens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tokens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Token> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first token in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token
	* @throws com.rivetlogic.event.NoSuchTokenException if a matching token could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Token findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTokenException;

	/**
	* Returns the first token in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token, or <code>null</code> if a matching token could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Token fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last token in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token
	* @throws com.rivetlogic.event.NoSuchTokenException if a matching token could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Token findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTokenException;

	/**
	* Returns the last token in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token, or <code>null</code> if a matching token could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Token fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tokens before and after the current token in the ordered set where uuid = &#63;.
	*
	* @param tokenId the primary key of the current token
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token
	* @throws com.rivetlogic.event.NoSuchTokenException if a token with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Token[] findByUuid_PrevAndNext(
		long tokenId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTokenException;

	/**
	* Removes all the tokens where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tokens where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching tokens
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tokens where participantId = &#63;.
	*
	* @param participantId the participant ID
	* @return the matching tokens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Token> findByParticipantId(
		long participantId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tokens where participantId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.TokenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param participantId the participant ID
	* @param start the lower bound of the range of tokens
	* @param end the upper bound of the range of tokens (not inclusive)
	* @return the range of matching tokens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Token> findByParticipantId(
		long participantId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tokens where participantId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.TokenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param participantId the participant ID
	* @param start the lower bound of the range of tokens
	* @param end the upper bound of the range of tokens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tokens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Token> findByParticipantId(
		long participantId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first token in the ordered set where participantId = &#63;.
	*
	* @param participantId the participant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token
	* @throws com.rivetlogic.event.NoSuchTokenException if a matching token could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Token findByParticipantId_First(
		long participantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTokenException;

	/**
	* Returns the first token in the ordered set where participantId = &#63;.
	*
	* @param participantId the participant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token, or <code>null</code> if a matching token could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Token fetchByParticipantId_First(
		long participantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last token in the ordered set where participantId = &#63;.
	*
	* @param participantId the participant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token
	* @throws com.rivetlogic.event.NoSuchTokenException if a matching token could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Token findByParticipantId_Last(
		long participantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTokenException;

	/**
	* Returns the last token in the ordered set where participantId = &#63;.
	*
	* @param participantId the participant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token, or <code>null</code> if a matching token could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Token fetchByParticipantId_Last(
		long participantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tokens before and after the current token in the ordered set where participantId = &#63;.
	*
	* @param tokenId the primary key of the current token
	* @param participantId the participant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token
	* @throws com.rivetlogic.event.NoSuchTokenException if a token with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Token[] findByParticipantId_PrevAndNext(
		long tokenId, long participantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTokenException;

	/**
	* Removes all the tokens where participantId = &#63; from the database.
	*
	* @param participantId the participant ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParticipantId(long participantId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tokens where participantId = &#63;.
	*
	* @param participantId the participant ID
	* @return the number of matching tokens
	* @throws SystemException if a system exception occurred
	*/
	public int countByParticipantId(long participantId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the token in the entity cache if it is enabled.
	*
	* @param token the token
	*/
	public void cacheResult(com.rivetlogic.event.model.Token token);

	/**
	* Caches the tokens in the entity cache if it is enabled.
	*
	* @param tokens the tokens
	*/
	public void cacheResult(
		java.util.List<com.rivetlogic.event.model.Token> tokens);

	/**
	* Creates a new token with the primary key. Does not add the token to the database.
	*
	* @param tokenId the primary key for the new token
	* @return the new token
	*/
	public com.rivetlogic.event.model.Token create(long tokenId);

	/**
	* Removes the token with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tokenId the primary key of the token
	* @return the token that was removed
	* @throws com.rivetlogic.event.NoSuchTokenException if a token with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Token remove(long tokenId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTokenException;

	public com.rivetlogic.event.model.Token updateImpl(
		com.rivetlogic.event.model.Token token)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the token with the primary key or throws a {@link com.rivetlogic.event.NoSuchTokenException} if it could not be found.
	*
	* @param tokenId the primary key of the token
	* @return the token
	* @throws com.rivetlogic.event.NoSuchTokenException if a token with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Token findByPrimaryKey(long tokenId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTokenException;

	/**
	* Returns the token with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tokenId the primary key of the token
	* @return the token, or <code>null</code> if a token with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Token fetchByPrimaryKey(long tokenId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tokens.
	*
	* @return the tokens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Token> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tokens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.TokenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tokens
	* @param end the upper bound of the range of tokens (not inclusive)
	* @return the range of tokens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Token> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tokens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.TokenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tokens
	* @param end the upper bound of the range of tokens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tokens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Token> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tokens from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tokens.
	*
	* @return the number of tokens
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}