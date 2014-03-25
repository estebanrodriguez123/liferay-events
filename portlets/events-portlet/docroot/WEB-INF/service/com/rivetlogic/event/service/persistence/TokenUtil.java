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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rivetlogic.event.model.Token;

import java.util.List;

/**
 * The persistence utility for the token service. This utility wraps {@link TokenPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author juancarrillo
 * @see TokenPersistence
 * @see TokenPersistenceImpl
 * @generated
 */
public class TokenUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Token token) {
		getPersistence().clearCache(token);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Token> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Token> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Token> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Token update(Token token) throws SystemException {
		return getPersistence().update(token);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Token update(Token token, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(token, serviceContext);
	}

	/**
	* Returns all the tokens where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching tokens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.event.model.Token> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<com.rivetlogic.event.model.Token> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<com.rivetlogic.event.model.Token> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first token in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token
	* @throws com.rivetlogic.event.NoSuchTokenException if a matching token could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.event.model.Token findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTokenException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first token in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token, or <code>null</code> if a matching token could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.event.model.Token fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last token in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token
	* @throws com.rivetlogic.event.NoSuchTokenException if a matching token could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.event.model.Token findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTokenException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last token in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token, or <code>null</code> if a matching token could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.event.model.Token fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

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
	public static com.rivetlogic.event.model.Token[] findByUuid_PrevAndNext(
		long tokenId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTokenException {
		return getPersistence()
				   .findByUuid_PrevAndNext(tokenId, uuid, orderByComparator);
	}

	/**
	* Removes all the tokens where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of tokens where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching tokens
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the tokens where participantId = &#63;.
	*
	* @param participantId the participant ID
	* @return the matching tokens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.event.model.Token> findByParticipantId(
		long participantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParticipantId(participantId);
	}

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
	public static java.util.List<com.rivetlogic.event.model.Token> findByParticipantId(
		long participantId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParticipantId(participantId, start, end);
	}

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
	public static java.util.List<com.rivetlogic.event.model.Token> findByParticipantId(
		long participantId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParticipantId(participantId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first token in the ordered set where participantId = &#63;.
	*
	* @param participantId the participant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token
	* @throws com.rivetlogic.event.NoSuchTokenException if a matching token could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.event.model.Token findByParticipantId_First(
		long participantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTokenException {
		return getPersistence()
				   .findByParticipantId_First(participantId, orderByComparator);
	}

	/**
	* Returns the first token in the ordered set where participantId = &#63;.
	*
	* @param participantId the participant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token, or <code>null</code> if a matching token could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.event.model.Token fetchByParticipantId_First(
		long participantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParticipantId_First(participantId, orderByComparator);
	}

	/**
	* Returns the last token in the ordered set where participantId = &#63;.
	*
	* @param participantId the participant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token
	* @throws com.rivetlogic.event.NoSuchTokenException if a matching token could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.event.model.Token findByParticipantId_Last(
		long participantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTokenException {
		return getPersistence()
				   .findByParticipantId_Last(participantId, orderByComparator);
	}

	/**
	* Returns the last token in the ordered set where participantId = &#63;.
	*
	* @param participantId the participant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token, or <code>null</code> if a matching token could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.event.model.Token fetchByParticipantId_Last(
		long participantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParticipantId_Last(participantId, orderByComparator);
	}

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
	public static com.rivetlogic.event.model.Token[] findByParticipantId_PrevAndNext(
		long tokenId, long participantId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTokenException {
		return getPersistence()
				   .findByParticipantId_PrevAndNext(tokenId, participantId,
			orderByComparator);
	}

	/**
	* Removes all the tokens where participantId = &#63; from the database.
	*
	* @param participantId the participant ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParticipantId(long participantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParticipantId(participantId);
	}

	/**
	* Returns the number of tokens where participantId = &#63;.
	*
	* @param participantId the participant ID
	* @return the number of matching tokens
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParticipantId(long participantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParticipantId(participantId);
	}

	/**
	* Caches the token in the entity cache if it is enabled.
	*
	* @param token the token
	*/
	public static void cacheResult(com.rivetlogic.event.model.Token token) {
		getPersistence().cacheResult(token);
	}

	/**
	* Caches the tokens in the entity cache if it is enabled.
	*
	* @param tokens the tokens
	*/
	public static void cacheResult(
		java.util.List<com.rivetlogic.event.model.Token> tokens) {
		getPersistence().cacheResult(tokens);
	}

	/**
	* Creates a new token with the primary key. Does not add the token to the database.
	*
	* @param tokenId the primary key for the new token
	* @return the new token
	*/
	public static com.rivetlogic.event.model.Token create(long tokenId) {
		return getPersistence().create(tokenId);
	}

	/**
	* Removes the token with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tokenId the primary key of the token
	* @return the token that was removed
	* @throws com.rivetlogic.event.NoSuchTokenException if a token with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.event.model.Token remove(long tokenId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTokenException {
		return getPersistence().remove(tokenId);
	}

	public static com.rivetlogic.event.model.Token updateImpl(
		com.rivetlogic.event.model.Token token)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(token);
	}

	/**
	* Returns the token with the primary key or throws a {@link com.rivetlogic.event.NoSuchTokenException} if it could not be found.
	*
	* @param tokenId the primary key of the token
	* @return the token
	* @throws com.rivetlogic.event.NoSuchTokenException if a token with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.event.model.Token findByPrimaryKey(
		long tokenId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTokenException {
		return getPersistence().findByPrimaryKey(tokenId);
	}

	/**
	* Returns the token with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tokenId the primary key of the token
	* @return the token, or <code>null</code> if a token with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.event.model.Token fetchByPrimaryKey(
		long tokenId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tokenId);
	}

	/**
	* Returns all the tokens.
	*
	* @return the tokens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.event.model.Token> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.rivetlogic.event.model.Token> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.rivetlogic.event.model.Token> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tokens from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tokens.
	*
	* @return the number of tokens
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TokenPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TokenPersistence)PortletBeanLocatorUtil.locate(com.rivetlogic.event.service.ClpSerializer.getServletContextName(),
					TokenPersistence.class.getName());

			ReferenceRegistry.registerReference(TokenUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TokenPersistence persistence) {
	}

	private static TokenPersistence _persistence;
}