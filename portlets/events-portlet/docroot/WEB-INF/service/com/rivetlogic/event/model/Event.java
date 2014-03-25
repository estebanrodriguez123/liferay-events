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

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Event service. Represents a row in the &quot;rivetlogic_event_Event&quot; database table, with each column mapped to a property of this class.
 *
 * @author juancarrillo
 * @see EventModel
 * @see com.rivetlogic.event.model.impl.EventImpl
 * @see com.rivetlogic.event.model.impl.EventModelImpl
 * @generated
 */
public interface Event extends EventModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.rivetlogic.event.model.impl.EventImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public boolean isPast();

	public java.util.List<com.rivetlogic.event.model.Participant> getParticipants();

	public java.util.List<com.rivetlogic.event.model.Participant> getParticipants(
		int[] statuses);

	@Override
	public boolean equals(java.lang.Object obj);
}