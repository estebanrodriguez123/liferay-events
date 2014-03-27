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

package com.rivetlogic.event.notification.constant;

public class PreferencesConstants {
    
    public static final String EMAIL_FROM = "event-email-from";
    public static final String DISPLAY_EMAIL_FROM = "display-event-email-from";
    
    public static final String REGULAR_INVITATION = "invitation-regular";
    public static final String DISPLAY_REGULAR_INVITATION = "display-invitation-regular";
    
    public static final String UPDATED_INVITATION = "invitation-updated";
    
    public static final String CANCELLED_INVITATION = "invitation-cancelled";
    
    public static final String SUCCESSFUL_REGISTRATION = "successful-registration";
    
    public static final String EXPIRED_EVENT = "expired-event";
    
    public static final String EVENT_LINKS = "event-links";
    public static final String DISPLAY_OTHERS = "display-others";
    
    
    public static final String GOOD_BYE_MESSAGE = "good-bye-message";
    
    public static final String REMINDER_MESSAGE = "reminder-message";
    
    public static String getOptions() {
        return EMAIL_FROM + "," + REGULAR_INVITATION + "," + UPDATED_INVITATION + "," + CANCELLED_INVITATION + ","
               + REMINDER_MESSAGE + "," + EVENT_LINKS;
    }
    
    public static final String ERROR_LOAD_PREFERENCES = "preferences-load-error";
    
    public static final String ERROR_WRITE_PERFERENCES = "preferences-writes-error";
    
    public static final String ERROR_IO_PREFERENCES = "preferences-io-error";
}
