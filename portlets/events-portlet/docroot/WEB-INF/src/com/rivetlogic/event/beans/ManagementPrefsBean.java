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

package com.rivetlogic.event.beans;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.ContentUtil;
import com.rivetlogic.event.util.PropsKeys;
import com.rivetlogic.event.util.PropsValues;

import java.io.IOException;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

/**
 * @author christopherjimenez
 * 
 */
public class ManagementPrefsBean extends EventsPrefsBean {
    
    public static final String PREFERENCE_UPDATED_INVITATION_SUBJECT = "updatedInvitationSubject";
    public static final String PREFERENCE_UPDATED_INVITATION_BODY = "updatedInvitationBody";
    public static final String PREFERENCE_CANCELLED_EVENT_SUBJECT = "cancelledEventSubject";
    public static final String PREFERENCE_CANCELLED_EVENT_BODY = "cancelledEventBody";
    public static final String PREFERENCE_SUCCESS_MESSAGE_SUBJECT = "successfulMessageSubject";
    public static final String PREFERENCE_SUCCESS_MESSAGE = "successfulMessage";
    public static final String PREFERENCE_REMINDER_EVENT_SUBJECT = "reminderEventSubject";
    public static final String PREFERENCE_REMINDER_EVENT_BODY = "reminderEventBody";
    
    // Updated Event Invitation
    private String updatedEventInvitationSubject;
    private String updatedEventInvitationBody;
    // Cancelled Event Notification
    private String cancelledEventNotificationSubject;
    private String cancelledEventNotificationBody;
    // Successful Registration message
    private String successRegistrationSubject;
    private String successRegistrationBody;
    // Reminder message
    private String reminderEventSubject;
    private String reminderEventBody;
    
    public ManagementPrefsBean(PortletRequest request) {
        super(request);
        PortletPreferences preferences = request.getPreferences();
        setFields(preferences);
    }
    
    public void save(PortletRequest request) throws ReadOnlyException, ValidatorException, IOException {
        
        super.save(request);
        PortletPreferences preferences = request.getPreferences();
        
        preferences.setValue(PropsKeys.UPDATED_INVITATION_SUBJECT, ParamUtil.getString(request, PREFERENCE_UPDATED_INVITATION_SUBJECT, updatedEventInvitationSubject));
        preferences.setValue(PropsKeys.UPDATED_INVITATION_TEMPLATE, ParamUtil.getString(request, PREFERENCE_UPDATED_INVITATION_BODY, updatedEventInvitationBody));
        preferences.setValue(PropsKeys.CANCELLED_INVITATION_SUBJECT, ParamUtil.getString(request, PREFERENCE_CANCELLED_EVENT_SUBJECT, cancelledEventNotificationSubject));
        preferences.setValue(PropsKeys.CANCELLED_INVITATION_TEMPLATE, ParamUtil.getString(request, PREFERENCE_CANCELLED_EVENT_BODY, cancelledEventNotificationBody));
        preferences.setValue(PropsKeys.SUCCESSFUL_REGISTRATION_SUBJECT, ParamUtil.getString(request, PREFERENCE_SUCCESS_MESSAGE_SUBJECT, successRegistrationBody));
        preferences.setValue(PropsKeys.SUCCESSFUL_REGISTRATION_TEMPLATE, ParamUtil.getString(request, PREFERENCE_SUCCESS_MESSAGE, successRegistrationBody));
        preferences.setValue(PropsKeys.REMINDER_SUBJECT, ParamUtil.getString(request, PREFERENCE_REMINDER_EVENT_SUBJECT, reminderEventSubject));
        preferences.setValue(PropsKeys.REMINDER_TEMPLATE, ParamUtil.getString(request, PREFERENCE_REMINDER_EVENT_BODY, reminderEventBody));
        
        preferences.store();
        setFields(preferences);
    }
    
    private void setFields(PortletPreferences preferences) {
        this.regularInvitationSubject = preferences.getValue(PropsKeys.REGULAR_INVITATION_SUBJECT,
                PropsValues.REGULAR_INVITATION_SUBJECT);
        this.regularInvitationBody = preferences.getValue(PropsKeys.REGULAR_INVITATION_TEMPLATE,
                ContentUtil.get(PropsValues.REGULAR_INVITATION_TEMPLATE));
        this.updatedEventInvitationSubject = preferences.getValue(PropsKeys.UPDATED_INVITATION_SUBJECT,
                PropsValues.UPDATED_INVITATION_SUBJECT);
        this.updatedEventInvitationBody = preferences.getValue(PropsKeys.UPDATED_INVITATION_TEMPLATE,
                ContentUtil.get(PropsValues.UPDATED_INVITATION_TEMPLATE));
        this.cancelledEventNotificationSubject = preferences.getValue(PropsKeys.CANCELLED_INVITATION_SUBJECT,
                PropsValues.CANCELLED_INVITATION_SUBJECT);
        this.cancelledEventNotificationBody = preferences.getValue(PropsKeys.CANCELLED_INVITATION_TEMPLATE,
                ContentUtil.get(PropsValues.CANCELLED_INVITATION_TEMPLATE));
        this.successRegistrationSubject = preferences.getValue(PropsKeys.SUCCESSFUL_REGISTRATION_SUBJECT,
                PropsValues.SUCCESSFUL_REGISTRATION_SUBJECT);
        this.successRegistrationBody = preferences.getValue(PropsKeys.SUCCESSFUL_REGISTRATION_TEMPLATE,
                ContentUtil.get(PropsValues.SUCCESSFUL_REGISTRATION_MESSAGE));
        this.reminderEventSubject = preferences.getValue(PropsKeys.REMINDER_SUBJECT, PropsValues.REMINDER_SUBJECT);
        this.reminderEventBody = preferences.getValue(PropsKeys.REMINDER_TEMPLATE,
                ContentUtil.get(PropsValues.REMINDER_TEMPLATE));
    }
    
    public String getUpdatedEventInvitationSubject() {
        return updatedEventInvitationSubject;
    }
    
    public String getUpdatedEventInvitationBody() {
        return updatedEventInvitationBody;
    }
    
    public String getCancelledEventNotificationSubject() {
        return cancelledEventNotificationSubject;
    }
    
    public String getCancelledEventNotificationBody() {
        return cancelledEventNotificationBody;
    }
    
    public String getSuccessRegistrationSubject() {
        return successRegistrationSubject;
    }
    
    public String getSuccessRegistrationBody() {
        return successRegistrationBody;
    }
    
    public String getReminderEventSubject() {
        return reminderEventSubject;
    }
    
    public String getReminderEventBody() {
        return reminderEventBody;
    }
    
    public void setUpdatedEventInvitationSubject(String updatedEventInvitationSubject) {
        this.updatedEventInvitationSubject = updatedEventInvitationSubject;
    }
    
    public void setUpdatedEventInvitationBody(String updatedEventInvitationBody) {
        this.updatedEventInvitationBody = updatedEventInvitationBody;
    }
    
    public void setCancelledEventNotificationSubject(String cancelledEventNotificationSubject) {
        this.cancelledEventNotificationSubject = cancelledEventNotificationSubject;
    }
    
    public void setCancelledEventNotificationBody(String cancelledEventNotificationBody) {
        this.cancelledEventNotificationBody = cancelledEventNotificationBody;
    }
    
    public void setSuccessRegistrationSubject(String successRegistrationSubject) {
        this.successRegistrationSubject = successRegistrationSubject;
    }
    
    public void setSuccessRegistrationBody(String successRegistrationBody) {
        this.successRegistrationBody = successRegistrationBody;
    }
    
    public void setReminderEventSubject(String reminderEventSubject) {
        this.reminderEventSubject = reminderEventSubject;
    }
    
    public void setReminderEventBody(String reminderEventBody) {
        this.reminderEventBody = reminderEventBody;
    }
}
