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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rivetlogic.event.NoSuchTokenException;
import com.rivetlogic.event.model.Token;
import com.rivetlogic.event.model.impl.TokenImpl;
import com.rivetlogic.event.model.impl.TokenModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the token service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author juancarrillo
 * @see TokenPersistence
 * @see TokenUtil
 * @generated
 */
public class TokenPersistenceImpl extends BasePersistenceImpl<Token>
	implements TokenPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TokenUtil} to access the token persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TokenImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TokenModelImpl.ENTITY_CACHE_ENABLED,
			TokenModelImpl.FINDER_CACHE_ENABLED, TokenImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TokenModelImpl.ENTITY_CACHE_ENABLED,
			TokenModelImpl.FINDER_CACHE_ENABLED, TokenImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TokenModelImpl.ENTITY_CACHE_ENABLED,
			TokenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(TokenModelImpl.ENTITY_CACHE_ENABLED,
			TokenModelImpl.FINDER_CACHE_ENABLED, TokenImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(TokenModelImpl.ENTITY_CACHE_ENABLED,
			TokenModelImpl.FINDER_CACHE_ENABLED, TokenImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			TokenModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(TokenModelImpl.ENTITY_CACHE_ENABLED,
			TokenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the tokens where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching tokens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Token> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Token> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Token> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Token> list = (List<Token>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Token token : list) {
				if (!Validator.equals(uuid, token.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TOKEN_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TokenModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Token>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Token>(list);
				}
				else {
					list = (List<Token>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Token findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTokenException, SystemException {
		Token token = fetchByUuid_First(uuid, orderByComparator);

		if (token != null) {
			return token;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTokenException(msg.toString());
	}

	/**
	 * Returns the first token in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token, or <code>null</code> if a matching token could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Token fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Token> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Token findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTokenException, SystemException {
		Token token = fetchByUuid_Last(uuid, orderByComparator);

		if (token != null) {
			return token;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTokenException(msg.toString());
	}

	/**
	 * Returns the last token in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token, or <code>null</code> if a matching token could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Token fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Token> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Token[] findByUuid_PrevAndNext(long tokenId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTokenException, SystemException {
		Token token = findByPrimaryKey(tokenId);

		Session session = null;

		try {
			session = openSession();

			Token[] array = new TokenImpl[3];

			array[0] = getByUuid_PrevAndNext(session, token, uuid,
					orderByComparator, true);

			array[1] = token;

			array[2] = getByUuid_PrevAndNext(session, token, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Token getByUuid_PrevAndNext(Session session, Token token,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOKEN_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TokenModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(token);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Token> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tokens where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Token token : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(token);
		}
	}

	/**
	 * Returns the number of tokens where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching tokens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOKEN_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "token.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "token.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(token.uuid IS NULL OR token.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARTICIPANTID =
		new FinderPath(TokenModelImpl.ENTITY_CACHE_ENABLED,
			TokenModelImpl.FINDER_CACHE_ENABLED, TokenImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParticipantId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTICIPANTID =
		new FinderPath(TokenModelImpl.ENTITY_CACHE_ENABLED,
			TokenModelImpl.FINDER_CACHE_ENABLED, TokenImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParticipantId",
			new String[] { Long.class.getName() },
			TokenModelImpl.PARTICIPANTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARTICIPANTID = new FinderPath(TokenModelImpl.ENTITY_CACHE_ENABLED,
			TokenModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParticipantId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tokens where participantId = &#63;.
	 *
	 * @param participantId the participant ID
	 * @return the matching tokens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Token> findByParticipantId(long participantId)
		throws SystemException {
		return findByParticipantId(participantId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Token> findByParticipantId(long participantId, int start,
		int end) throws SystemException {
		return findByParticipantId(participantId, start, end, null);
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
	@Override
	public List<Token> findByParticipantId(long participantId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTICIPANTID;
			finderArgs = new Object[] { participantId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARTICIPANTID;
			finderArgs = new Object[] {
					participantId,
					
					start, end, orderByComparator
				};
		}

		List<Token> list = (List<Token>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Token token : list) {
				if ((participantId != token.getParticipantId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TOKEN_WHERE);

			query.append(_FINDER_COLUMN_PARTICIPANTID_PARTICIPANTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TokenModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(participantId);

				if (!pagination) {
					list = (List<Token>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Token>(list);
				}
				else {
					list = (List<Token>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Token findByParticipantId_First(long participantId,
		OrderByComparator orderByComparator)
		throws NoSuchTokenException, SystemException {
		Token token = fetchByParticipantId_First(participantId,
				orderByComparator);

		if (token != null) {
			return token;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("participantId=");
		msg.append(participantId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTokenException(msg.toString());
	}

	/**
	 * Returns the first token in the ordered set where participantId = &#63;.
	 *
	 * @param participantId the participant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token, or <code>null</code> if a matching token could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Token fetchByParticipantId_First(long participantId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Token> list = findByParticipantId(participantId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Token findByParticipantId_Last(long participantId,
		OrderByComparator orderByComparator)
		throws NoSuchTokenException, SystemException {
		Token token = fetchByParticipantId_Last(participantId, orderByComparator);

		if (token != null) {
			return token;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("participantId=");
		msg.append(participantId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTokenException(msg.toString());
	}

	/**
	 * Returns the last token in the ordered set where participantId = &#63;.
	 *
	 * @param participantId the participant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token, or <code>null</code> if a matching token could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Token fetchByParticipantId_Last(long participantId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByParticipantId(participantId);

		if (count == 0) {
			return null;
		}

		List<Token> list = findByParticipantId(participantId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Token[] findByParticipantId_PrevAndNext(long tokenId,
		long participantId, OrderByComparator orderByComparator)
		throws NoSuchTokenException, SystemException {
		Token token = findByPrimaryKey(tokenId);

		Session session = null;

		try {
			session = openSession();

			Token[] array = new TokenImpl[3];

			array[0] = getByParticipantId_PrevAndNext(session, token,
					participantId, orderByComparator, true);

			array[1] = token;

			array[2] = getByParticipantId_PrevAndNext(session, token,
					participantId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Token getByParticipantId_PrevAndNext(Session session,
		Token token, long participantId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOKEN_WHERE);

		query.append(_FINDER_COLUMN_PARTICIPANTID_PARTICIPANTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TokenModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(participantId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(token);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Token> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tokens where participantId = &#63; from the database.
	 *
	 * @param participantId the participant ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParticipantId(long participantId)
		throws SystemException {
		for (Token token : findByParticipantId(participantId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(token);
		}
	}

	/**
	 * Returns the number of tokens where participantId = &#63;.
	 *
	 * @param participantId the participant ID
	 * @return the number of matching tokens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParticipantId(long participantId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARTICIPANTID;

		Object[] finderArgs = new Object[] { participantId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOKEN_WHERE);

			query.append(_FINDER_COLUMN_PARTICIPANTID_PARTICIPANTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(participantId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PARTICIPANTID_PARTICIPANTID_2 = "token.participantId = ?";

	public TokenPersistenceImpl() {
		setModelClass(Token.class);
	}

	/**
	 * Caches the token in the entity cache if it is enabled.
	 *
	 * @param token the token
	 */
	@Override
	public void cacheResult(Token token) {
		EntityCacheUtil.putResult(TokenModelImpl.ENTITY_CACHE_ENABLED,
			TokenImpl.class, token.getPrimaryKey(), token);

		token.resetOriginalValues();
	}

	/**
	 * Caches the tokens in the entity cache if it is enabled.
	 *
	 * @param tokens the tokens
	 */
	@Override
	public void cacheResult(List<Token> tokens) {
		for (Token token : tokens) {
			if (EntityCacheUtil.getResult(TokenModelImpl.ENTITY_CACHE_ENABLED,
						TokenImpl.class, token.getPrimaryKey()) == null) {
				cacheResult(token);
			}
			else {
				token.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tokens.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TokenImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TokenImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the token.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Token token) {
		EntityCacheUtil.removeResult(TokenModelImpl.ENTITY_CACHE_ENABLED,
			TokenImpl.class, token.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Token> tokens) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Token token : tokens) {
			EntityCacheUtil.removeResult(TokenModelImpl.ENTITY_CACHE_ENABLED,
				TokenImpl.class, token.getPrimaryKey());
		}
	}

	/**
	 * Creates a new token with the primary key. Does not add the token to the database.
	 *
	 * @param tokenId the primary key for the new token
	 * @return the new token
	 */
	@Override
	public Token create(long tokenId) {
		Token token = new TokenImpl();

		token.setNew(true);
		token.setPrimaryKey(tokenId);

		String uuid = PortalUUIDUtil.generate();

		token.setUuid(uuid);

		return token;
	}

	/**
	 * Removes the token with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tokenId the primary key of the token
	 * @return the token that was removed
	 * @throws com.rivetlogic.event.NoSuchTokenException if a token with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Token remove(long tokenId)
		throws NoSuchTokenException, SystemException {
		return remove((Serializable)tokenId);
	}

	/**
	 * Removes the token with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the token
	 * @return the token that was removed
	 * @throws com.rivetlogic.event.NoSuchTokenException if a token with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Token remove(Serializable primaryKey)
		throws NoSuchTokenException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Token token = (Token)session.get(TokenImpl.class, primaryKey);

			if (token == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTokenException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(token);
		}
		catch (NoSuchTokenException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Token removeImpl(Token token) throws SystemException {
		token = toUnwrappedModel(token);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(token)) {
				token = (Token)session.get(TokenImpl.class,
						token.getPrimaryKeyObj());
			}

			if (token != null) {
				session.delete(token);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (token != null) {
			clearCache(token);
		}

		return token;
	}

	@Override
	public Token updateImpl(com.rivetlogic.event.model.Token token)
		throws SystemException {
		token = toUnwrappedModel(token);

		boolean isNew = token.isNew();

		TokenModelImpl tokenModelImpl = (TokenModelImpl)token;

		if (Validator.isNull(token.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			token.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (token.isNew()) {
				session.save(token);

				token.setNew(false);
			}
			else {
				session.merge(token);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TokenModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tokenModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { tokenModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { tokenModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((tokenModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTICIPANTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tokenModelImpl.getOriginalParticipantId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARTICIPANTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTICIPANTID,
					args);

				args = new Object[] { tokenModelImpl.getParticipantId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARTICIPANTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARTICIPANTID,
					args);
			}
		}

		EntityCacheUtil.putResult(TokenModelImpl.ENTITY_CACHE_ENABLED,
			TokenImpl.class, token.getPrimaryKey(), token);

		return token;
	}

	protected Token toUnwrappedModel(Token token) {
		if (token instanceof TokenImpl) {
			return token;
		}

		TokenImpl tokenImpl = new TokenImpl();

		tokenImpl.setNew(token.isNew());
		tokenImpl.setPrimaryKey(token.getPrimaryKey());

		tokenImpl.setUuid(token.getUuid());
		tokenImpl.setTokenId(token.getTokenId());
		tokenImpl.setParticipantId(token.getParticipantId());
		tokenImpl.setExpiredDate(token.getExpiredDate());

		return tokenImpl;
	}

	/**
	 * Returns the token with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the token
	 * @return the token
	 * @throws com.rivetlogic.event.NoSuchTokenException if a token with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Token findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTokenException, SystemException {
		Token token = fetchByPrimaryKey(primaryKey);

		if (token == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTokenException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return token;
	}

	/**
	 * Returns the token with the primary key or throws a {@link com.rivetlogic.event.NoSuchTokenException} if it could not be found.
	 *
	 * @param tokenId the primary key of the token
	 * @return the token
	 * @throws com.rivetlogic.event.NoSuchTokenException if a token with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Token findByPrimaryKey(long tokenId)
		throws NoSuchTokenException, SystemException {
		return findByPrimaryKey((Serializable)tokenId);
	}

	/**
	 * Returns the token with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the token
	 * @return the token, or <code>null</code> if a token with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Token fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Token token = (Token)EntityCacheUtil.getResult(TokenModelImpl.ENTITY_CACHE_ENABLED,
				TokenImpl.class, primaryKey);

		if (token == _nullToken) {
			return null;
		}

		if (token == null) {
			Session session = null;

			try {
				session = openSession();

				token = (Token)session.get(TokenImpl.class, primaryKey);

				if (token != null) {
					cacheResult(token);
				}
				else {
					EntityCacheUtil.putResult(TokenModelImpl.ENTITY_CACHE_ENABLED,
						TokenImpl.class, primaryKey, _nullToken);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TokenModelImpl.ENTITY_CACHE_ENABLED,
					TokenImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return token;
	}

	/**
	 * Returns the token with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tokenId the primary key of the token
	 * @return the token, or <code>null</code> if a token with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Token fetchByPrimaryKey(long tokenId) throws SystemException {
		return fetchByPrimaryKey((Serializable)tokenId);
	}

	/**
	 * Returns all the tokens.
	 *
	 * @return the tokens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Token> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Token> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Token> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Token> list = (List<Token>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TOKEN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TOKEN;

				if (pagination) {
					sql = sql.concat(TokenModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Token>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Token>(list);
				}
				else {
					list = (List<Token>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the tokens from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Token token : findAll()) {
			remove(token);
		}
	}

	/**
	 * Returns the number of tokens.
	 *
	 * @return the number of tokens
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TOKEN);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the token persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rivetlogic.event.model.Token")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Token>> listenersList = new ArrayList<ModelListener<Token>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Token>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TokenImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TOKEN = "SELECT token FROM Token token";
	private static final String _SQL_SELECT_TOKEN_WHERE = "SELECT token FROM Token token WHERE ";
	private static final String _SQL_COUNT_TOKEN = "SELECT COUNT(token) FROM Token token";
	private static final String _SQL_COUNT_TOKEN_WHERE = "SELECT COUNT(token) FROM Token token WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "token.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Token exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Token exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TokenPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Token _nullToken = new TokenImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Token> toCacheModel() {
				return _nullTokenCacheModel;
			}
		};

	private static CacheModel<Token> _nullTokenCacheModel = new CacheModel<Token>() {
			@Override
			public Token toEntityModel() {
				return _nullToken;
			}
		};
}