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

import com.rivetlogic.event.NoSuchParticipantException;
import com.rivetlogic.event.model.Participant;
import com.rivetlogic.event.model.impl.ParticipantImpl;
import com.rivetlogic.event.model.impl.ParticipantModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the participant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author juancarrillo
 * @see ParticipantPersistence
 * @see ParticipantUtil
 * @generated
 */
public class ParticipantPersistenceImpl extends BasePersistenceImpl<Participant>
	implements ParticipantPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ParticipantUtil} to access the participant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ParticipantImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantModelImpl.FINDER_CACHE_ENABLED, ParticipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantModelImpl.FINDER_CACHE_ENABLED, ParticipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantModelImpl.FINDER_CACHE_ENABLED, ParticipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantModelImpl.FINDER_CACHE_ENABLED, ParticipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ParticipantModelImpl.UUID_COLUMN_BITMASK |
			ParticipantModelImpl.FULLNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the participants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Participant> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the participants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.ParticipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of participants
	 * @param end the upper bound of the range of participants (not inclusive)
	 * @return the range of matching participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Participant> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the participants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.ParticipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of participants
	 * @param end the upper bound of the range of participants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Participant> findByUuid(String uuid, int start, int end,
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

		List<Participant> list = (List<Participant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Participant participant : list) {
				if (!Validator.equals(uuid, participant.getUuid())) {
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

			query.append(_SQL_SELECT_PARTICIPANT_WHERE);

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
				query.append(ParticipantModelImpl.ORDER_BY_JPQL);
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
					list = (List<Participant>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Participant>(list);
				}
				else {
					list = (List<Participant>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first participant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participant
	 * @throws com.rivetlogic.event.NoSuchParticipantException if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchParticipantException, SystemException {
		Participant participant = fetchByUuid_First(uuid, orderByComparator);

		if (participant != null) {
			return participant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchParticipantException(msg.toString());
	}

	/**
	 * Returns the first participant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participant, or <code>null</code> if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Participant> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last participant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participant
	 * @throws com.rivetlogic.event.NoSuchParticipantException if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchParticipantException, SystemException {
		Participant participant = fetchByUuid_Last(uuid, orderByComparator);

		if (participant != null) {
			return participant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchParticipantException(msg.toString());
	}

	/**
	 * Returns the last participant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participant, or <code>null</code> if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Participant> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the participants before and after the current participant in the ordered set where uuid = &#63;.
	 *
	 * @param participantId the primary key of the current participant
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next participant
	 * @throws com.rivetlogic.event.NoSuchParticipantException if a participant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant[] findByUuid_PrevAndNext(long participantId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchParticipantException, SystemException {
		Participant participant = findByPrimaryKey(participantId);

		Session session = null;

		try {
			session = openSession();

			Participant[] array = new ParticipantImpl[3];

			array[0] = getByUuid_PrevAndNext(session, participant, uuid,
					orderByComparator, true);

			array[1] = participant;

			array[2] = getByUuid_PrevAndNext(session, participant, uuid,
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

	protected Participant getByUuid_PrevAndNext(Session session,
		Participant participant, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PARTICIPANT_WHERE);

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
			query.append(ParticipantModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(participant);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Participant> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the participants where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Participant participant : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(participant);
		}
	}

	/**
	 * Returns the number of participants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching participants
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

			query.append(_SQL_COUNT_PARTICIPANT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "participant.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "participant.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(participant.uuid IS NULL OR participant.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantModelImpl.FINDER_CACHE_ENABLED, ParticipantImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ParticipantModelImpl.UUID_COLUMN_BITMASK |
			ParticipantModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the participant where uuid = &#63; and groupId = &#63; or throws a {@link com.rivetlogic.event.NoSuchParticipantException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching participant
	 * @throws com.rivetlogic.event.NoSuchParticipantException if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant findByUUID_G(String uuid, long groupId)
		throws NoSuchParticipantException, SystemException {
		Participant participant = fetchByUUID_G(uuid, groupId);

		if (participant == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchParticipantException(msg.toString());
		}

		return participant;
	}

	/**
	 * Returns the participant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching participant, or <code>null</code> if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the participant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching participant, or <code>null</code> if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Participant) {
			Participant participant = (Participant)result;

			if (!Validator.equals(uuid, participant.getUuid()) ||
					(groupId != participant.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PARTICIPANT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Participant> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Participant participant = list.get(0);

					result = participant;

					cacheResult(participant);

					if ((participant.getUuid() == null) ||
							!participant.getUuid().equals(uuid) ||
							(participant.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, participant);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Participant)result;
		}
	}

	/**
	 * Removes the participant where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the participant that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant removeByUUID_G(String uuid, long groupId)
		throws NoSuchParticipantException, SystemException {
		Participant participant = findByUUID_G(uuid, groupId);

		return remove(participant);
	}

	/**
	 * Returns the number of participants where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PARTICIPANT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "participant.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "participant.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(participant.uuid IS NULL OR participant.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "participant.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantModelImpl.FINDER_CACHE_ENABLED, ParticipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantModelImpl.FINDER_CACHE_ENABLED, ParticipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ParticipantModelImpl.UUID_COLUMN_BITMASK |
			ParticipantModelImpl.COMPANYID_COLUMN_BITMASK |
			ParticipantModelImpl.FULLNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the participants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Participant> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the participants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.ParticipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of participants
	 * @param end the upper bound of the range of participants (not inclusive)
	 * @return the range of matching participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Participant> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the participants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.ParticipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of participants
	 * @param end the upper bound of the range of participants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Participant> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Participant> list = (List<Participant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Participant participant : list) {
				if (!Validator.equals(uuid, participant.getUuid()) ||
						(companyId != participant.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PARTICIPANT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ParticipantModelImpl.ORDER_BY_JPQL);
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

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Participant>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Participant>(list);
				}
				else {
					list = (List<Participant>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first participant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participant
	 * @throws com.rivetlogic.event.NoSuchParticipantException if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchParticipantException, SystemException {
		Participant participant = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (participant != null) {
			return participant;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchParticipantException(msg.toString());
	}

	/**
	 * Returns the first participant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participant, or <code>null</code> if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Participant> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last participant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participant
	 * @throws com.rivetlogic.event.NoSuchParticipantException if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchParticipantException, SystemException {
		Participant participant = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (participant != null) {
			return participant;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchParticipantException(msg.toString());
	}

	/**
	 * Returns the last participant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participant, or <code>null</code> if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Participant> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the participants before and after the current participant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param participantId the primary key of the current participant
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next participant
	 * @throws com.rivetlogic.event.NoSuchParticipantException if a participant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant[] findByUuid_C_PrevAndNext(long participantId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchParticipantException, SystemException {
		Participant participant = findByPrimaryKey(participantId);

		Session session = null;

		try {
			session = openSession();

			Participant[] array = new ParticipantImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, participant, uuid,
					companyId, orderByComparator, true);

			array[1] = participant;

			array[2] = getByUuid_C_PrevAndNext(session, participant, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Participant getByUuid_C_PrevAndNext(Session session,
		Participant participant, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PARTICIPANT_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(ParticipantModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(participant);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Participant> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the participants where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Participant participant : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(participant);
		}
	}

	/**
	 * Returns the number of participants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PARTICIPANT_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "participant.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "participant.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(participant.uuid IS NULL OR participant.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "participant.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTID = new FinderPath(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantModelImpl.FINDER_CACHE_ENABLED, ParticipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEventId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID =
		new FinderPath(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantModelImpl.FINDER_CACHE_ENABLED, ParticipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventId",
			new String[] { Long.class.getName() },
			ParticipantModelImpl.EVENTID_COLUMN_BITMASK |
			ParticipantModelImpl.FULLNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTID = new FinderPath(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the participants where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the matching participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Participant> findByEventId(long eventId)
		throws SystemException {
		return findByEventId(eventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the participants where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.ParticipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of participants
	 * @param end the upper bound of the range of participants (not inclusive)
	 * @return the range of matching participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Participant> findByEventId(long eventId, int start, int end)
		throws SystemException {
		return findByEventId(eventId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the participants where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.ParticipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of participants
	 * @param end the upper bound of the range of participants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Participant> findByEventId(long eventId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID;
			finderArgs = new Object[] { eventId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTID;
			finderArgs = new Object[] { eventId, start, end, orderByComparator };
		}

		List<Participant> list = (List<Participant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Participant participant : list) {
				if ((eventId != participant.getEventId())) {
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

			query.append(_SQL_SELECT_PARTICIPANT_WHERE);

			query.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ParticipantModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventId);

				if (!pagination) {
					list = (List<Participant>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Participant>(list);
				}
				else {
					list = (List<Participant>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first participant in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participant
	 * @throws com.rivetlogic.event.NoSuchParticipantException if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant findByEventId_First(long eventId,
		OrderByComparator orderByComparator)
		throws NoSuchParticipantException, SystemException {
		Participant participant = fetchByEventId_First(eventId,
				orderByComparator);

		if (participant != null) {
			return participant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventId=");
		msg.append(eventId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchParticipantException(msg.toString());
	}

	/**
	 * Returns the first participant in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participant, or <code>null</code> if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant fetchByEventId_First(long eventId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Participant> list = findByEventId(eventId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last participant in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participant
	 * @throws com.rivetlogic.event.NoSuchParticipantException if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant findByEventId_Last(long eventId,
		OrderByComparator orderByComparator)
		throws NoSuchParticipantException, SystemException {
		Participant participant = fetchByEventId_Last(eventId, orderByComparator);

		if (participant != null) {
			return participant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventId=");
		msg.append(eventId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchParticipantException(msg.toString());
	}

	/**
	 * Returns the last participant in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participant, or <code>null</code> if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant fetchByEventId_Last(long eventId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEventId(eventId);

		if (count == 0) {
			return null;
		}

		List<Participant> list = findByEventId(eventId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the participants before and after the current participant in the ordered set where eventId = &#63;.
	 *
	 * @param participantId the primary key of the current participant
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next participant
	 * @throws com.rivetlogic.event.NoSuchParticipantException if a participant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant[] findByEventId_PrevAndNext(long participantId,
		long eventId, OrderByComparator orderByComparator)
		throws NoSuchParticipantException, SystemException {
		Participant participant = findByPrimaryKey(participantId);

		Session session = null;

		try {
			session = openSession();

			Participant[] array = new ParticipantImpl[3];

			array[0] = getByEventId_PrevAndNext(session, participant, eventId,
					orderByComparator, true);

			array[1] = participant;

			array[2] = getByEventId_PrevAndNext(session, participant, eventId,
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

	protected Participant getByEventId_PrevAndNext(Session session,
		Participant participant, long eventId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PARTICIPANT_WHERE);

		query.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

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
			query.append(ParticipantModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(eventId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(participant);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Participant> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the participants where eventId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEventId(long eventId) throws SystemException {
		for (Participant participant : findByEventId(eventId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(participant);
		}
	}

	/**
	 * Returns the number of participants where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the number of matching participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEventId(long eventId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTID;

		Object[] finderArgs = new Object[] { eventId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PARTICIPANT_WHERE);

			query.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventId);

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

	private static final String _FINDER_COLUMN_EVENTID_EVENTID_2 = "participant.eventId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTIDANDEMAIL =
		new FinderPath(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantModelImpl.FINDER_CACHE_ENABLED, ParticipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEventIdAndEmail",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTIDANDEMAIL =
		new FinderPath(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantModelImpl.FINDER_CACHE_ENABLED, ParticipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventIdAndEmail",
			new String[] { Long.class.getName(), String.class.getName() },
			ParticipantModelImpl.EVENTID_COLUMN_BITMASK |
			ParticipantModelImpl.EMAIL_COLUMN_BITMASK |
			ParticipantModelImpl.FULLNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTIDANDEMAIL = new FinderPath(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEventIdAndEmail",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the participants where eventId = &#63; and email = &#63;.
	 *
	 * @param eventId the event ID
	 * @param email the email
	 * @return the matching participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Participant> findByEventIdAndEmail(long eventId, String email)
		throws SystemException {
		return findByEventIdAndEmail(eventId, email, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the participants where eventId = &#63; and email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.ParticipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param email the email
	 * @param start the lower bound of the range of participants
	 * @param end the upper bound of the range of participants (not inclusive)
	 * @return the range of matching participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Participant> findByEventIdAndEmail(long eventId, String email,
		int start, int end) throws SystemException {
		return findByEventIdAndEmail(eventId, email, start, end, null);
	}

	/**
	 * Returns an ordered range of all the participants where eventId = &#63; and email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.ParticipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param email the email
	 * @param start the lower bound of the range of participants
	 * @param end the upper bound of the range of participants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Participant> findByEventIdAndEmail(long eventId, String email,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTIDANDEMAIL;
			finderArgs = new Object[] { eventId, email };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTIDANDEMAIL;
			finderArgs = new Object[] {
					eventId, email,
					
					start, end, orderByComparator
				};
		}

		List<Participant> list = (List<Participant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Participant participant : list) {
				if ((eventId != participant.getEventId()) ||
						!Validator.equals(email, participant.getEmail())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PARTICIPANT_WHERE);

			query.append(_FINDER_COLUMN_EVENTIDANDEMAIL_EVENTID_2);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EVENTIDANDEMAIL_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENTIDANDEMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EVENTIDANDEMAIL_EMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ParticipantModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventId);

				if (bindEmail) {
					qPos.add(email);
				}

				if (!pagination) {
					list = (List<Participant>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Participant>(list);
				}
				else {
					list = (List<Participant>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first participant in the ordered set where eventId = &#63; and email = &#63;.
	 *
	 * @param eventId the event ID
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participant
	 * @throws com.rivetlogic.event.NoSuchParticipantException if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant findByEventIdAndEmail_First(long eventId, String email,
		OrderByComparator orderByComparator)
		throws NoSuchParticipantException, SystemException {
		Participant participant = fetchByEventIdAndEmail_First(eventId, email,
				orderByComparator);

		if (participant != null) {
			return participant;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventId=");
		msg.append(eventId);

		msg.append(", email=");
		msg.append(email);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchParticipantException(msg.toString());
	}

	/**
	 * Returns the first participant in the ordered set where eventId = &#63; and email = &#63;.
	 *
	 * @param eventId the event ID
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participant, or <code>null</code> if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant fetchByEventIdAndEmail_First(long eventId, String email,
		OrderByComparator orderByComparator) throws SystemException {
		List<Participant> list = findByEventIdAndEmail(eventId, email, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last participant in the ordered set where eventId = &#63; and email = &#63;.
	 *
	 * @param eventId the event ID
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participant
	 * @throws com.rivetlogic.event.NoSuchParticipantException if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant findByEventIdAndEmail_Last(long eventId, String email,
		OrderByComparator orderByComparator)
		throws NoSuchParticipantException, SystemException {
		Participant participant = fetchByEventIdAndEmail_Last(eventId, email,
				orderByComparator);

		if (participant != null) {
			return participant;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventId=");
		msg.append(eventId);

		msg.append(", email=");
		msg.append(email);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchParticipantException(msg.toString());
	}

	/**
	 * Returns the last participant in the ordered set where eventId = &#63; and email = &#63;.
	 *
	 * @param eventId the event ID
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participant, or <code>null</code> if a matching participant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant fetchByEventIdAndEmail_Last(long eventId, String email,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEventIdAndEmail(eventId, email);

		if (count == 0) {
			return null;
		}

		List<Participant> list = findByEventIdAndEmail(eventId, email,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the participants before and after the current participant in the ordered set where eventId = &#63; and email = &#63;.
	 *
	 * @param participantId the primary key of the current participant
	 * @param eventId the event ID
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next participant
	 * @throws com.rivetlogic.event.NoSuchParticipantException if a participant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant[] findByEventIdAndEmail_PrevAndNext(long participantId,
		long eventId, String email, OrderByComparator orderByComparator)
		throws NoSuchParticipantException, SystemException {
		Participant participant = findByPrimaryKey(participantId);

		Session session = null;

		try {
			session = openSession();

			Participant[] array = new ParticipantImpl[3];

			array[0] = getByEventIdAndEmail_PrevAndNext(session, participant,
					eventId, email, orderByComparator, true);

			array[1] = participant;

			array[2] = getByEventIdAndEmail_PrevAndNext(session, participant,
					eventId, email, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Participant getByEventIdAndEmail_PrevAndNext(Session session,
		Participant participant, long eventId, String email,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PARTICIPANT_WHERE);

		query.append(_FINDER_COLUMN_EVENTIDANDEMAIL_EVENTID_2);

		boolean bindEmail = false;

		if (email == null) {
			query.append(_FINDER_COLUMN_EVENTIDANDEMAIL_EMAIL_1);
		}
		else if (email.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EVENTIDANDEMAIL_EMAIL_3);
		}
		else {
			bindEmail = true;

			query.append(_FINDER_COLUMN_EVENTIDANDEMAIL_EMAIL_2);
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
			query.append(ParticipantModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(eventId);

		if (bindEmail) {
			qPos.add(email);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(participant);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Participant> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the participants where eventId = &#63; and email = &#63; from the database.
	 *
	 * @param eventId the event ID
	 * @param email the email
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEventIdAndEmail(long eventId, String email)
		throws SystemException {
		for (Participant participant : findByEventIdAndEmail(eventId, email,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(participant);
		}
	}

	/**
	 * Returns the number of participants where eventId = &#63; and email = &#63;.
	 *
	 * @param eventId the event ID
	 * @param email the email
	 * @return the number of matching participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEventIdAndEmail(long eventId, String email)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTIDANDEMAIL;

		Object[] finderArgs = new Object[] { eventId, email };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PARTICIPANT_WHERE);

			query.append(_FINDER_COLUMN_EVENTIDANDEMAIL_EVENTID_2);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EVENTIDANDEMAIL_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENTIDANDEMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EVENTIDANDEMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventId);

				if (bindEmail) {
					qPos.add(email);
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

	private static final String _FINDER_COLUMN_EVENTIDANDEMAIL_EVENTID_2 = "participant.eventId = ? AND ";
	private static final String _FINDER_COLUMN_EVENTIDANDEMAIL_EMAIL_1 = "participant.email IS NULL";
	private static final String _FINDER_COLUMN_EVENTIDANDEMAIL_EMAIL_2 = "participant.email = ?";
	private static final String _FINDER_COLUMN_EVENTIDANDEMAIL_EMAIL_3 = "(participant.email IS NULL OR participant.email = '')";

	public ParticipantPersistenceImpl() {
		setModelClass(Participant.class);
	}

	/**
	 * Caches the participant in the entity cache if it is enabled.
	 *
	 * @param participant the participant
	 */
	@Override
	public void cacheResult(Participant participant) {
		EntityCacheUtil.putResult(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantImpl.class, participant.getPrimaryKey(), participant);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { participant.getUuid(), participant.getGroupId() },
			participant);

		participant.resetOriginalValues();
	}

	/**
	 * Caches the participants in the entity cache if it is enabled.
	 *
	 * @param participants the participants
	 */
	@Override
	public void cacheResult(List<Participant> participants) {
		for (Participant participant : participants) {
			if (EntityCacheUtil.getResult(
						ParticipantModelImpl.ENTITY_CACHE_ENABLED,
						ParticipantImpl.class, participant.getPrimaryKey()) == null) {
				cacheResult(participant);
			}
			else {
				participant.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all participants.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ParticipantImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ParticipantImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the participant.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Participant participant) {
		EntityCacheUtil.removeResult(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantImpl.class, participant.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(participant);
	}

	@Override
	public void clearCache(List<Participant> participants) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Participant participant : participants) {
			EntityCacheUtil.removeResult(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
				ParticipantImpl.class, participant.getPrimaryKey());

			clearUniqueFindersCache(participant);
		}
	}

	protected void cacheUniqueFindersCache(Participant participant) {
		if (participant.isNew()) {
			Object[] args = new Object[] {
					participant.getUuid(), participant.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				participant);
		}
		else {
			ParticipantModelImpl participantModelImpl = (ParticipantModelImpl)participant;

			if ((participantModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						participant.getUuid(), participant.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					participant);
			}
		}
	}

	protected void clearUniqueFindersCache(Participant participant) {
		ParticipantModelImpl participantModelImpl = (ParticipantModelImpl)participant;

		Object[] args = new Object[] {
				participant.getUuid(), participant.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((participantModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					participantModelImpl.getOriginalUuid(),
					participantModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new participant with the primary key. Does not add the participant to the database.
	 *
	 * @param participantId the primary key for the new participant
	 * @return the new participant
	 */
	@Override
	public Participant create(long participantId) {
		Participant participant = new ParticipantImpl();

		participant.setNew(true);
		participant.setPrimaryKey(participantId);

		String uuid = PortalUUIDUtil.generate();

		participant.setUuid(uuid);

		return participant;
	}

	/**
	 * Removes the participant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param participantId the primary key of the participant
	 * @return the participant that was removed
	 * @throws com.rivetlogic.event.NoSuchParticipantException if a participant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant remove(long participantId)
		throws NoSuchParticipantException, SystemException {
		return remove((Serializable)participantId);
	}

	/**
	 * Removes the participant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the participant
	 * @return the participant that was removed
	 * @throws com.rivetlogic.event.NoSuchParticipantException if a participant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant remove(Serializable primaryKey)
		throws NoSuchParticipantException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Participant participant = (Participant)session.get(ParticipantImpl.class,
					primaryKey);

			if (participant == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchParticipantException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(participant);
		}
		catch (NoSuchParticipantException nsee) {
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
	protected Participant removeImpl(Participant participant)
		throws SystemException {
		participant = toUnwrappedModel(participant);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(participant)) {
				participant = (Participant)session.get(ParticipantImpl.class,
						participant.getPrimaryKeyObj());
			}

			if (participant != null) {
				session.delete(participant);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (participant != null) {
			clearCache(participant);
		}

		return participant;
	}

	@Override
	public Participant updateImpl(
		com.rivetlogic.event.model.Participant participant)
		throws SystemException {
		participant = toUnwrappedModel(participant);

		boolean isNew = participant.isNew();

		ParticipantModelImpl participantModelImpl = (ParticipantModelImpl)participant;

		if (Validator.isNull(participant.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			participant.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (participant.isNew()) {
				session.save(participant);

				participant.setNew(false);
			}
			else {
				session.merge(participant);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ParticipantModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((participantModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						participantModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { participantModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((participantModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						participantModelImpl.getOriginalUuid(),
						participantModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						participantModelImpl.getUuid(),
						participantModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((participantModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						participantModelImpl.getOriginalEventId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID,
					args);

				args = new Object[] { participantModelImpl.getEventId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID,
					args);
			}

			if ((participantModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTIDANDEMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						participantModelImpl.getOriginalEventId(),
						participantModelImpl.getOriginalEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTIDANDEMAIL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTIDANDEMAIL,
					args);

				args = new Object[] {
						participantModelImpl.getEventId(),
						participantModelImpl.getEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTIDANDEMAIL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTIDANDEMAIL,
					args);
			}
		}

		EntityCacheUtil.putResult(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
			ParticipantImpl.class, participant.getPrimaryKey(), participant);

		clearUniqueFindersCache(participant);
		cacheUniqueFindersCache(participant);

		return participant;
	}

	protected Participant toUnwrappedModel(Participant participant) {
		if (participant instanceof ParticipantImpl) {
			return participant;
		}

		ParticipantImpl participantImpl = new ParticipantImpl();

		participantImpl.setNew(participant.isNew());
		participantImpl.setPrimaryKey(participant.getPrimaryKey());

		participantImpl.setUuid(participant.getUuid());
		participantImpl.setParticipantId(participant.getParticipantId());
		participantImpl.setCompanyId(participant.getCompanyId());
		participantImpl.setGroupId(participant.getGroupId());
		participantImpl.setEventId(participant.getEventId());
		participantImpl.setFullName(participant.getFullName());
		participantImpl.setEmail(participant.getEmail());
		participantImpl.setPhoneNumber(participant.getPhoneNumber());
		participantImpl.setCompanyName(participant.getCompanyName());
		participantImpl.setStatus(participant.getStatus());

		return participantImpl;
	}

	/**
	 * Returns the participant with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the participant
	 * @return the participant
	 * @throws com.rivetlogic.event.NoSuchParticipantException if a participant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant findByPrimaryKey(Serializable primaryKey)
		throws NoSuchParticipantException, SystemException {
		Participant participant = fetchByPrimaryKey(primaryKey);

		if (participant == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchParticipantException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return participant;
	}

	/**
	 * Returns the participant with the primary key or throws a {@link com.rivetlogic.event.NoSuchParticipantException} if it could not be found.
	 *
	 * @param participantId the primary key of the participant
	 * @return the participant
	 * @throws com.rivetlogic.event.NoSuchParticipantException if a participant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant findByPrimaryKey(long participantId)
		throws NoSuchParticipantException, SystemException {
		return findByPrimaryKey((Serializable)participantId);
	}

	/**
	 * Returns the participant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the participant
	 * @return the participant, or <code>null</code> if a participant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Participant participant = (Participant)EntityCacheUtil.getResult(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
				ParticipantImpl.class, primaryKey);

		if (participant == _nullParticipant) {
			return null;
		}

		if (participant == null) {
			Session session = null;

			try {
				session = openSession();

				participant = (Participant)session.get(ParticipantImpl.class,
						primaryKey);

				if (participant != null) {
					cacheResult(participant);
				}
				else {
					EntityCacheUtil.putResult(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
						ParticipantImpl.class, primaryKey, _nullParticipant);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ParticipantModelImpl.ENTITY_CACHE_ENABLED,
					ParticipantImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return participant;
	}

	/**
	 * Returns the participant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param participantId the primary key of the participant
	 * @return the participant, or <code>null</code> if a participant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Participant fetchByPrimaryKey(long participantId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)participantId);
	}

	/**
	 * Returns all the participants.
	 *
	 * @return the participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Participant> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the participants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.ParticipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of participants
	 * @param end the upper bound of the range of participants (not inclusive)
	 * @return the range of participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Participant> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the participants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.ParticipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of participants
	 * @param end the upper bound of the range of participants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of participants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Participant> findAll(int start, int end,
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

		List<Participant> list = (List<Participant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PARTICIPANT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PARTICIPANT;

				if (pagination) {
					sql = sql.concat(ParticipantModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Participant>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Participant>(list);
				}
				else {
					list = (List<Participant>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the participants from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Participant participant : findAll()) {
			remove(participant);
		}
	}

	/**
	 * Returns the number of participants.
	 *
	 * @return the number of participants
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

				Query q = session.createQuery(_SQL_COUNT_PARTICIPANT);

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
	 * Initializes the participant persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rivetlogic.event.model.Participant")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Participant>> listenersList = new ArrayList<ModelListener<Participant>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Participant>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ParticipantImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PARTICIPANT = "SELECT participant FROM Participant participant";
	private static final String _SQL_SELECT_PARTICIPANT_WHERE = "SELECT participant FROM Participant participant WHERE ";
	private static final String _SQL_COUNT_PARTICIPANT = "SELECT COUNT(participant) FROM Participant participant";
	private static final String _SQL_COUNT_PARTICIPANT_WHERE = "SELECT COUNT(participant) FROM Participant participant WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "participant.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Participant exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Participant exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ParticipantPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Participant _nullParticipant = new ParticipantImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Participant> toCacheModel() {
				return _nullParticipantCacheModel;
			}
		};

	private static CacheModel<Participant> _nullParticipantCacheModel = new CacheModel<Participant>() {
			@Override
			public Participant toEntityModel() {
				return _nullParticipant;
			}
		};
}