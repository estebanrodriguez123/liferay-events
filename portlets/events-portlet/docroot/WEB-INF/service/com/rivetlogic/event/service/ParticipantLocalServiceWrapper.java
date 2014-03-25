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

package com.rivetlogic.event.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ParticipantLocalService}.
 *
 * @author juancarrillo
 * @see ParticipantLocalService
 * @generated
 */
public class ParticipantLocalServiceWrapper implements ParticipantLocalService,
	ServiceWrapper<ParticipantLocalService> {
	public ParticipantLocalServiceWrapper(
		ParticipantLocalService participantLocalService) {
		_participantLocalService = participantLocalService;
	}

	/**
	* Adds the participant to the database. Also notifies the appropriate model listeners.
	*
	* @param participant the participant
	* @return the participant that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.event.model.Participant addParticipant(
		com.rivetlogic.event.model.Participant participant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.addParticipant(participant);
	}

	/**
	* Creates a new participant with the primary key. Does not add the participant to the database.
	*
	* @param participantId the primary key for the new participant
	* @return the new participant
	*/
	@Override
	public com.rivetlogic.event.model.Participant createParticipant(
		long participantId) {
		return _participantLocalService.createParticipant(participantId);
	}

	/**
	* Deletes the participant with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param participantId the primary key of the participant
	* @return the participant that was removed
	* @throws PortalException if a participant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.event.model.Participant deleteParticipant(
		long participantId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.deleteParticipant(participantId);
	}

	/**
	* Deletes the participant from the database. Also notifies the appropriate model listeners.
	*
	* @param participant the participant
	* @return the participant that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.event.model.Participant deleteParticipant(
		com.rivetlogic.event.model.Participant participant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.deleteParticipant(participant);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _participantLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.ParticipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.ParticipantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rivetlogic.event.model.Participant fetchParticipant(
		long participantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.fetchParticipant(participantId);
	}

	/**
	* Returns the participant with the matching UUID and company.
	*
	* @param uuid the participant's UUID
	* @param companyId the primary key of the company
	* @return the matching participant, or <code>null</code> if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.event.model.Participant fetchParticipantByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.fetchParticipantByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the participant matching the UUID and group.
	*
	* @param uuid the participant's UUID
	* @param groupId the primary key of the group
	* @return the matching participant, or <code>null</code> if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.event.model.Participant fetchParticipantByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.fetchParticipantByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the participant with the primary key.
	*
	* @param participantId the primary key of the participant
	* @return the participant
	* @throws PortalException if a participant with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.event.model.Participant getParticipant(
		long participantId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.getParticipant(participantId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the participant with the matching UUID and company.
	*
	* @param uuid the participant's UUID
	* @param companyId the primary key of the company
	* @return the matching participant
	* @throws PortalException if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.event.model.Participant getParticipantByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.getParticipantByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the participant matching the UUID and group.
	*
	* @param uuid the participant's UUID
	* @param groupId the primary key of the group
	* @return the matching participant
	* @throws PortalException if a matching participant could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.event.model.Participant getParticipantByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.getParticipantByUuidAndGroupId(uuid,
			groupId);
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
	public java.util.List<com.rivetlogic.event.model.Participant> getParticipants(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.getParticipants(start, end);
	}

	/**
	* Returns the number of participants.
	*
	* @return the number of participants
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getParticipantsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.getParticipantsCount();
	}

	/**
	* Updates the participant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param participant the participant
	* @return the participant that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.event.model.Participant updateParticipant(
		com.rivetlogic.event.model.Participant participant)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.updateParticipant(participant);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _participantLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_participantLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _participantLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.rivetlogic.event.model.Participant> getParticipants(
		long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.getParticipants(eventId);
	}

	@Override
	public java.util.List<com.rivetlogic.event.model.Participant> getParticipants(
		int status, long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.getParticipants(status, eventId);
	}

	@Override
	public int getParticipantsCount(long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.getParticipantsCount(eventId);
	}

	@Override
	public int getParticipantsCount(int status, long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participantLocalService.getParticipantsCount(status, eventId);
	}

	@Override
	public void clearParticipantsByEventId(java.lang.Long eventId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchParticipantException {
		_participantLocalService.clearParticipantsByEventId(eventId);
	}

	@Override
	public void removeParticipants(java.lang.Long[] ids) {
		_participantLocalService.removeParticipants(ids);
	}

	@Override
	public java.util.List<com.rivetlogic.event.model.Participant> findParticipantByEventIdAndEmail(
		java.lang.Long eventId, java.lang.String email) {
		return _participantLocalService.findParticipantByEventIdAndEmail(eventId,
			email);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ParticipantLocalService getWrappedParticipantLocalService() {
		return _participantLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedParticipantLocalService(
		ParticipantLocalService participantLocalService) {
		_participantLocalService = participantLocalService;
	}

	@Override
	public ParticipantLocalService getWrappedService() {
		return _participantLocalService;
	}

	@Override
	public void setWrappedService(
		ParticipantLocalService participantLocalService) {
		_participantLocalService = participantLocalService;
	}

	private ParticipantLocalService _participantLocalService;
}