/**
 * Copyright (C) 2014 Rivet Logic Corporation. All rights reserved.
 */

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

package com.rivetlogic.event.model.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.rivetlogic.event.model.Event;
import com.rivetlogic.event.model.Participant;
import com.rivetlogic.event.service.ParticipantLocalServiceUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The extended model implementation for the Event service. Represents a row in
 * the &quot;rivetlogic_event_Event&quot; database table, with each column
 * mapped to a property of this class.
 * 
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link com.rivetlogic.event.model.Event} interface.
 * </p>
 * 
 * @author juancarrillo
 */
public class EventImpl extends EventBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     * 
     * Never reference this class directly. All methods that expect a event
     * model instance should use the {@link com.rivetlogic.event.model.Event}
     * interface instead.
     */
    public EventImpl() {
    }
    
    public boolean isPast() {
        Date eventDate = this.getEventDate();
        return (eventDate != null) && eventDate.before(new Date());
    }
    
    public List<Participant> getParticipants() {
        List<Participant> participants = new ArrayList<Participant>();
        try {
            participants = ParticipantLocalServiceUtil.getParticipants(getEventId());
        } catch (Exception e) {
            _log.error(e);
        }
        
        return participants;
    }
    
    public List<Participant> getParticipants(int[] statuses) {
        List<Participant> participants = getParticipants();
        List<Participant> filteredParticipants = new ArrayList<Participant>();
        for (Participant p : participants) {
            if (ArrayUtil.contains(statuses, p.getStatus())) {
                filteredParticipants.add(p);
            }
        }
        
        return filteredParticipants;
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean isEquals = super.equals(obj);
        
        if (isEquals) {
            isEquals = false;
            Event event = (Event) obj;
            if (getPrivateEvent() == event.getPrivateEvent()) {
                if (getName().equals(event.getName())) {
                    if (getDescription().equals(event.getDescription())) {
                        if (getEventDate().equals(event.getEventDate())) {
                            if (getLocation().equals(event.getLocation())) {
                                isEquals = true;
                            }
                        }
                    }
                }
            }
        }
        
        return isEquals;
    }
    
    private static final Log _log = LogFactoryUtil.getLog(EventImpl.class);
}