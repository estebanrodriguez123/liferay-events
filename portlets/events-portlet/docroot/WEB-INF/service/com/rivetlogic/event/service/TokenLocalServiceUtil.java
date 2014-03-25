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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Token. This utility wraps
 * {@link com.rivetlogic.event.service.impl.TokenLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author juancarrillo
 * @see TokenLocalService
 * @see com.rivetlogic.event.service.base.TokenLocalServiceBaseImpl
 * @see com.rivetlogic.event.service.impl.TokenLocalServiceImpl
 * @generated
 */
public class TokenLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rivetlogic.event.service.impl.TokenLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the token to the database. Also notifies the appropriate model listeners.
	*
	* @param token the token
	* @return the token that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.event.model.Token addToken(
		com.rivetlogic.event.model.Token token)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addToken(token);
	}

	/**
	* Creates a new token with the primary key. Does not add the token to the database.
	*
	* @param tokenId the primary key for the new token
	* @return the new token
	*/
	public static com.rivetlogic.event.model.Token createToken(long tokenId) {
		return getService().createToken(tokenId);
	}

	/**
	* Deletes the token with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tokenId the primary key of the token
	* @return the token that was removed
	* @throws PortalException if a token with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.event.model.Token deleteToken(long tokenId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteToken(tokenId);
	}

	/**
	* Deletes the token from the database. Also notifies the appropriate model listeners.
	*
	* @param token the token
	* @return the token that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.event.model.Token deleteToken(
		com.rivetlogic.event.model.Token token)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteToken(token);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.TokenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.event.model.impl.TokenModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.rivetlogic.event.model.Token fetchToken(long tokenId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchToken(tokenId);
	}

	/**
	* Returns the token with the primary key.
	*
	* @param tokenId the primary key of the token
	* @return the token
	* @throws PortalException if a token with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.event.model.Token getToken(long tokenId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getToken(tokenId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.rivetlogic.event.model.Token> getTokens(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTokens(start, end);
	}

	/**
	* Returns the number of tokens.
	*
	* @return the number of tokens
	* @throws SystemException if a system exception occurred
	*/
	public static int getTokensCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTokensCount();
	}

	/**
	* Updates the token in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param token the token
	* @return the token that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.event.model.Token updateToken(
		com.rivetlogic.event.model.Token token)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateToken(token);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.rivetlogic.event.model.Token createToken(
		com.rivetlogic.event.model.Participant participant)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().createToken(participant);
	}

	public static com.rivetlogic.event.model.Token getTokenByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.event.NoSuchTokenException {
		return getService().getTokenByUuid(uuid);
	}

	public static java.util.List<com.rivetlogic.event.model.Token> getTokensByParticipantId(
		java.lang.Long participantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTokensByParticipantId(participantId);
	}

	public static com.rivetlogic.event.model.Token expireToken(
		com.rivetlogic.event.model.Token token)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().expireToken(token);
	}

	public static void expiredTokenByParticipantId(java.lang.Long participantId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().expiredTokenByParticipantId(participantId);
	}

	public static void clearService() {
		_service = null;
	}

	public static TokenLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TokenLocalService.class.getName());

			if (invokableLocalService instanceof TokenLocalService) {
				_service = (TokenLocalService)invokableLocalService;
			}
			else {
				_service = new TokenLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TokenLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TokenLocalService service) {
	}

	private static TokenLocalService _service;
}