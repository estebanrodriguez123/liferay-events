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

import com.liferay.util.portlet.PortletProps;

public class PropsValues {
    
    public static final String REGULAR_INVITATION_SUBJECT = PortletProps.get(PropsKeys.REGULAR_INVITATION_SUBJECT);
    public static final String REGULAR_INVITATION_TEMPLATE = PortletProps.get(PropsKeys.REGULAR_INVITATION_TEMPLATE);
    
    public static final String UPDATED_INVITATION_SUBJECT = PortletProps.get(PropsKeys.UPDATED_INVITATION_SUBJECT);
    public static final String UPDATED_INVITATION_TEMPLATE = PortletProps.get(PropsKeys.UPDATED_INVITATION_TEMPLATE);
    
    public static final String CANCELLED_INVITATION_SUBJECT = PortletProps.get(PropsKeys.CANCELLED_INVITATION_SUBJECT);
    public static final String CANCELLED_INVITATION_TEMPLATE = PortletProps
            .get(PropsKeys.CANCELLED_INVITATION_TEMPLATE);
    
    public static final String SUCCESSFUL_REGISTRATION_SUBJECT = PortletProps
            .get(PropsKeys.SUCCESSFUL_REGISTRATION_SUBJECT);
    public static final String SUCCESSFUL_REGISTRATION_MESSAGE = PortletProps
            .get(PropsKeys.SUCCESSFUL_REGISTRATION_TEMPLATE);
    
    public static final String REMINDER_SUBJECT = PortletProps.get(PropsKeys.REMINDER_SUBJECT);
    public static final String REMINDER_TEMPLATE = PortletProps.get(PropsKeys.REMINDER_TEMPLATE);
    
    public static final String GOOD_BYE_MESSAGE = PortletProps.get(PropsKeys.GOOD_BYE_MESSAGE);
    
    public static final String PUBLIC_EVENT_URL = PortletProps.get(PropsKeys.PUBLIC_EVENT_URL);
    
    public static final String INVALID_CONFIRMATION_LINK_MESSAGE = PortletProps
            .get(PropsKeys.INVALID_CONFIRMATION_LINK_MESSAGE);
    
    public static final String CONFIRMATION_LINK = PortletProps.get(PropsKeys.CONFIRMATION_LINK);
    
    public static final String EVENT_EMAIL_FROM_NAME = PortletProps.get(PropsKeys.EVENT_EMAIL_FROM_NAME);
    
    public static final String EVENT_EMAIL_ADDRESS = PortletProps.get(PropsKeys.EVENT_EMAIL_ADDRESS);
    
    public static final String NUM_ROWS = PortletProps.get(PropsKeys.NUM_ROWS);
    
}
