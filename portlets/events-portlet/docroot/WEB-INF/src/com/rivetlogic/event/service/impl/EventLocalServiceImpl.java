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

package com.rivetlogic.event.service.impl;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.rivetlogic.event.model.Event;
import com.rivetlogic.event.service.base.EventLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the event local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.rivetlogic.event.service.EventLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author juancarrillo
 * @see com.rivetlogic.event.service.base.EventLocalServiceBaseImpl
 * @see com.rivetlogic.event.service.EventLocalServiceUtil
 */
public class EventLocalServiceImpl extends EventLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     * 
     * Never reference this interface directly. Always use {@link
     * com.rivetlogic.event.service.EventLocalServiceUtil} to access the event
     * local service.
     */
    
    @Override
    public Event addEvent(Event newEvent) throws SystemException {
        
        Event event = eventPersistence.create(counterLocalService.increment(Event.class.getName()));
        
        event.setCompanyId(newEvent.getCompanyId());
        event.setGroupId(newEvent.getGroupId());
        event.setUserId(newEvent.getUserId());
        
        event.setName(newEvent.getName());
        event.setDescription(newEvent.getDescription());
        event.setEventDate(newEvent.getEventDate());
        event.setLocation(newEvent.getLocation());
        event.setPrivateEvent(newEvent.getPrivateEvent());
        
        eventPersistence.update(event);
        return event;
    }
    
    public Event updateEvent(Event event) throws SystemException {
        eventPersistence.update(event);
        return event;
    }
    
    public Event deleteEvent(Event event) throws SystemException {
        return eventPersistence.remove(event);
        
    }
    
    public Event deleteEvent(long eventId) throws SystemException, PortalException {
        
        return deleteEvent(getEvent(eventId));
    }
    
    private DynamicQuery getEventsDynamicQuery(Criterion criterion, boolean useOrder) {
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Event.class);
        dynamicQuery.add(criterion);
        if(useOrder) {
        	Order order = OrderFactoryUtil.asc(EVENT_DATE_COLUMN);
        	dynamicQuery.addOrder(order);
        }
        return dynamicQuery;
    }
    
    private DynamicQuery getPastEventsDynamicQuery(boolean useOrder) {
        Date currentDate = new Date();
        Criterion criterion = RestrictionsFactoryUtil.le(EVENT_DATE_COLUMN, currentDate);
        return getEventsDynamicQuery(criterion, useOrder);
    }
    
    @SuppressWarnings("unchecked")
    public List<Event> getPastEvents(int start, int end) {
        
        List<Event> pastEvents = new ArrayList<Event>();
        
        DynamicQuery dynamicQuery = getPastEventsDynamicQuery(true);
        
        try {
            pastEvents = (List<Event>) eventPersistence.findWithDynamicQuery(dynamicQuery, start, end);
        } catch (SystemException e) {
            _log.error(e);
        }
        
        return pastEvents;
    }
    
    public int getPastEventsCount() {
        int result = 0;
        DynamicQuery dynamicQuery = getPastEventsDynamicQuery(false);
        try {
            result = (int) eventPersistence.countWithDynamicQuery(dynamicQuery);
        } catch (SystemException e) {
            _log.error(e);
        }
        return result;
    }
    
    private DynamicQuery getUpcomingEventsDynamicQuery(boolean useOrder) {
        Date currentDate = new Date();
        Criterion criterion = RestrictionsFactoryUtil.ge(EVENT_DATE_COLUMN, currentDate);
        return getEventsDynamicQuery(criterion, useOrder);
    }
    
    @SuppressWarnings("unchecked")
    public List<Event> getUpcomingEvents(int start, int end) {
        
        List<Event> upcomingEvents = new ArrayList<Event>();
        
        DynamicQuery dynamicQuery = getUpcomingEventsDynamicQuery(true);
        
        try {
            upcomingEvents = (List<Event>) eventPersistence.findWithDynamicQuery(dynamicQuery, start, end);
        } catch (SystemException e) {
            _log.error(e);
        }
        
        return upcomingEvents;
    }
    
    public int getUpcomingEventsCount() {
        int result = 0;
        DynamicQuery dynamicQuery = getUpcomingEventsDynamicQuery(false);
        try {
            result = (int) eventPersistence.countWithDynamicQuery(dynamicQuery);
        } catch (SystemException e) {
            _log.error(e);
        }
        return result;
    }
    
    private DynamicQuery getPublicUpcomingEventsDynamicQuery(boolean useOrder) {
        DynamicQuery dynamicQuery = getUpcomingEventsDynamicQuery(useOrder);
        Criterion criterion = RestrictionsFactoryUtil.eq(EVENT_PRIVATE_COLUMN, false);
        dynamicQuery.add(criterion);
        return dynamicQuery;
    }
    
    @SuppressWarnings("unchecked")
    public List<Event> getPublicEvents(int start, int end) {
        
        List<Event> publicEvents = new ArrayList<Event>();
        
        DynamicQuery dynamicQuery = getPublicUpcomingEventsDynamicQuery(true);
        
        try {
            publicEvents = (List<Event>) eventPersistence.findWithDynamicQuery(dynamicQuery, start, end);
        } catch (SystemException e) {
            _log.error(e);
        }
        
        return publicEvents;
    }
    
    public int getPublicEventsCount() {
        
        int result = 0;
        DynamicQuery dynamicQuery = getPublicUpcomingEventsDynamicQuery(false);
        try {
            result = (int) eventPersistence.countWithDynamicQuery(dynamicQuery);
        } catch (SystemException e) {
            _log.error(e);
        }
        return result;
    }
    
    private static final String EVENT_DATE_COLUMN = "eventDate";
    private static final String EVENT_PRIVATE_COLUMN = "privateEvent";
    private static Log _log = LogFactoryUtil.getLog(EventLocalServiceImpl.class);
}