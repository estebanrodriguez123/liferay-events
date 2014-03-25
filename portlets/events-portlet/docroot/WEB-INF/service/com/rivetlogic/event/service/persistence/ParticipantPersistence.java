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

import com.rivetlogic.event.model.Participant;

/**
 * The persistence interface for the participant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author juancarrillo
 * @see ParticipantPersistenceImpl
 * @see ParticipantUtil
 * @generated
 */
public interface ParticipantPersistence extends BasePersistence<Participant> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ParticipantUtil} to access the participant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the participants where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching participants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Participant> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.event.model.Participant> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.event.model.Participant> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first participant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching participant
	* @throws com.rivetlogic.event.NoSuchParticipantException if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchParticipantException;

	/**
	* Returns the first participant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching participant, or <code>null</code> if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last participant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching participant
	* @throws com.rivetlogic.event.NoSuchParticipantException if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchParticipantException;

	/**
	* Returns the last participant in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching participant, or <code>null</code> if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.event.model.Participant[] findByUuid_PrevAndNext(
		long participantId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchParticipantException;

	/**
	* Removes all the participants where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of participants where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching participants
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the participant where uuid = &#63; and groupId = &#63; or throws a {@link com.rivetlogic.event.NoSuchParticipantException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching participant
	* @throws com.rivetlogic.event.NoSuchParticipantException if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchParticipantException;

	/**
	* Returns the participant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching participant, or <code>null</code> if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the participant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching participant, or <code>null</code> if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the participant where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the participant that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchParticipantException;

	/**
	* Returns the number of participants where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching participants
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the participants where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching participants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Participant> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.event.model.Participant> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.event.model.Participant> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.event.model.Participant findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchParticipantException;

	/**
	* Returns the first participant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching participant, or <code>null</code> if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.event.model.Participant findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchParticipantException;

	/**
	* Returns the last participant in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching participant, or <code>null</code> if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.event.model.Participant[] findByUuid_C_PrevAndNext(
		long participantId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchParticipantException;

	/**
	* Removes all the participants where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of participants where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching participants
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the participants where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the matching participants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Participant> findByEventId(
		long eventId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.event.model.Participant> findByEventId(
		long eventId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.event.model.Participant> findByEventId(
		long eventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first participant in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching participant
	* @throws com.rivetlogic.event.NoSuchParticipantException if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant findByEventId_First(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchParticipantException;

	/**
	* Returns the first participant in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching participant, or <code>null</code> if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant fetchByEventId_First(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last participant in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching participant
	* @throws com.rivetlogic.event.NoSuchParticipantException if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant findByEventId_Last(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchParticipantException;

	/**
	* Returns the last participant in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching participant, or <code>null</code> if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant fetchByEventId_Last(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.event.model.Participant[] findByEventId_PrevAndNext(
		long participantId, long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchParticipantException;

	/**
	* Removes all the participants where eventId = &#63; from the database.
	*
	* @param eventId the event ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEventId(long eventId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of participants where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the number of matching participants
	* @throws SystemException if a system exception occurred
	*/
	public int countByEventId(long eventId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the participants where eventId = &#63; and email = &#63;.
	*
	* @param eventId the event ID
	* @param email the email
	* @return the matching participants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Participant> findByEventIdAndEmail(
		long eventId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.event.model.Participant> findByEventIdAndEmail(
		long eventId, java.lang.String email, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.event.model.Participant> findByEventIdAndEmail(
		long eventId, java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.event.model.Participant findByEventIdAndEmail_First(
		long eventId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchParticipantException;

	/**
	* Returns the first participant in the ordered set where eventId = &#63; and email = &#63;.
	*
	* @param eventId the event ID
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching participant, or <code>null</code> if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant fetchByEventIdAndEmail_First(
		long eventId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.event.model.Participant findByEventIdAndEmail_Last(
		long eventId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchParticipantException;

	/**
	* Returns the last participant in the ordered set where eventId = &#63; and email = &#63;.
	*
	* @param eventId the event ID
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching participant, or <code>null</code> if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant fetchByEventIdAndEmail_Last(
		long eventId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.event.model.Participant[] findByEventIdAndEmail_PrevAndNext(
		long participantId, long eventId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchParticipantException;

	/**
	* Removes all the participants where eventId = &#63; and email = &#63; from the database.
	*
	* @param eventId the event ID
	* @param email the email
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEventIdAndEmail(long eventId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of participants where eventId = &#63; and email = &#63;.
	*
	* @param eventId the event ID
	* @param email the email
	* @return the number of matching participants
	* @throws SystemException if a system exception occurred
	*/
	public int countByEventIdAndEmail(long eventId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the participant in the entity cache if it is enabled.
	*
	* @param participant the participant
	*/
	public void cacheResult(com.rivetlogic.event.model.Participant participant);

	/**
	* Caches the participants in the entity cache if it is enabled.
	*
	* @param participants the participants
	*/
	public void cacheResult(
		java.util.List<com.rivetlogic.event.model.Participant> participants);

	/**
	* Creates a new participant with the primary key. Does not add the participant to the database.
	*
	* @param participantId the primary key for the new participant
	* @return the new participant
	*/
	public com.rivetlogic.event.model.Participant create(long participantId);

	/**
	* Removes the participant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param participantId the primary key of the participant
	* @return the participant that was removed
	* @throws com.rivetlogic.event.NoSuchParticipantException if a participant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant remove(long participantId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchParticipantException;

	public com.rivetlogic.event.model.Participant updateImpl(
		com.rivetlogic.event.model.Participant participant)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the participant with the primary key or throws a {@link com.rivetlogic.event.NoSuchParticipantException} if it could not be found.
	*
	* @param participantId the primary key of the participant
	* @return the participant
	* @throws com.rivetlogic.event.NoSuchParticipantException if a participant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant findByPrimaryKey(
		long participantId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchParticipantException;

	/**
	* Returns the participant with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param participantId the primary key of the participant
	* @return the participant, or <code>null</code> if a participant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.event.model.Participant fetchByPrimaryKey(
		long participantId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the participants.
	*
	* @return the participants
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.event.model.Participant> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.event.model.Participant> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.event.model.Participant> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the participants from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of participants.
	*
	* @return the number of participants
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}