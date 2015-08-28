/** 
 * Copyright (C) 2005-2014 Rivet Logic Corporation. 
 * 
 * This program is free software; you can redistribute it and/or 
 * modify it under the terms of the GNU General Public License 
 * as published by the Free Software Foundation; version 3 
 * of the License. 
 * 
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 * GNU General Public License for more details. 
 * 
 * You should have received a copy of the GNU General Public License 
 * along with this program; if not, write to the Free Software 
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, 
 * Boston, MA 02110-1301, USA. 
 */

package com.rivetlogic.event.util;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.rivetlogic.event.NoSuchEventException;
import com.rivetlogic.event.model.Event;
import com.rivetlogic.event.model.Participant;
import com.rivetlogic.event.model.impl.EventImpl;
import com.rivetlogic.event.model.impl.ParticipantImpl;
import com.rivetlogic.event.notification.constant.EventPortletConstants;
import com.rivetlogic.event.notification.constant.NotificationConstants;
import com.rivetlogic.event.service.EventLocalServiceUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;

public class EventActionUtil {
    
    private static final String NO_SUCH_EVENT = "no-such-event";
    private static final String EVENT_MUST_BE_PUBLIC = "event-must-be-public";
    private static final String EVENT_IS_IN_PAST = "event-is-in-past";
    
    public static Participant getParticipantFromRequest(ActionRequest request) {
        
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        
        Participant participant = new ParticipantImpl();
        
        participant.setCompanyId(themeDisplay.getCompanyId());
        participant.setGroupId(themeDisplay.getScopeGroupId());
        participant.setEventId(ParamUtil.getLong(request, NotificationConstants.EVENT_ID));
        
        participant.setFullName(ParamUtil.getString(request, EventPortletConstants.PARAMETER_FULL_NAME));
        participant.setEmail(ParamUtil.getString(request, EventPortletConstants.PARAMETER_EMAIL));
        participant.setCompanyName(ParamUtil.getString(request, EventPortletConstants.PARAMETER_COMPANY_NAME));
        participant.setPhoneNumber(ParamUtil.getString(request, EventPortletConstants.PARAMETER_PHONE_NUMBER));
        participant.setStatus(EventConstant.EVENT_STATUS_SENT);
        
        return participant;
    }
    
    public static void loadEvent(RenderRequest request) throws PortletException, SystemException {
        loadEvent(request, false);
    }
    
    public static void loadEvent(RenderRequest request, boolean forcePublic) throws PortletException, SystemException {
        
        Event event = (Event) request.getAttribute(WebKeys.EVENT_ENTRY);
        
        if (Validator.isNull(event)) {
            long resourcePrimKey = ParamUtil.getLong(request, EventPortletConstants.PARAMETER_RESOURCE_PRIMARY_KEY);
            
            if (Validator.isNotNull(resourcePrimKey)) {
                event = loadEventFromResourceKey(request, resourcePrimKey);
                if (forcePublic && event != null && event.isPrivateEvent()){
                    SessionErrors.add(request, EVENT_MUST_BE_PUBLIC);
                    event = null;
                }
                if (event != null && event.isPast()){
                    SessionErrors.add(request, EVENT_IS_IN_PAST);
                    event = null;
				}
				CalendarBooking booking = CalendarBookingLocalServiceUtil
						.fetchCalendarBooking(event.getCalendarBookingId());
				if(booking != null) {
					event.setCalendarId(booking.getCalendarId());
				}
                
            } else {
				event = new EventImpl();
				ThemeDisplay themeDisplay = (ThemeDisplay) request
						.getAttribute(WebKeys.THEME_DISPLAY);

				ServiceContext serviceContext;
				try {
					serviceContext = ServiceContextFactory
							.getInstance(Event.class.getName(), request);
					Calendar userCalendar = EventLocalServiceUtil.getUserCalendar(
							themeDisplay.getUserId(), serviceContext);
					event.setCalendarId(userCalendar.getCalendarId());
				} catch (PortalException e) {
					e.printStackTrace();
				} catch(SystemException e) {
					e.printStackTrace();
				}
            }
            
            request.setAttribute(WebKeys.EVENT_ENTRY, event);
        }
    }
    
    private static Event loadEventFromResourceKey(PortletRequest request, long resourcePrimKey) throws PortletException {
        
        Event event = null;
        
        try {
            event = EventLocalServiceUtil.getEvent(resourcePrimKey);
            
        } catch (Exception e) {
            
            if (e instanceof NoSuchEventException) {
                SessionErrors.add(request, NO_SUCH_EVENT, String.valueOf(resourcePrimKey));                
            } else {
                throw new PortletException(e);
            }
        }
        
        return event;
    }
    
    public static void setErrors(List<String> errors, PortletRequest request) {
        for (String error : errors) {
            SessionErrors.add(request, error);
        }
    }
    
    public static Long[] listToArray(List<Participant> participants) {
        Long[] ids = new Long[participants.size()];
        for (int i = 0; i < participants.size(); i++) {
            Participant p = participants.get(i);
            ids[i] = p.getParticipantId();
        }
        return ids;
    }
    
}
