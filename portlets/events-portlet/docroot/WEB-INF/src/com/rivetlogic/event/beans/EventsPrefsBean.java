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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.ContentUtil;
import com.rivetlogic.event.notification.constant.NotificationConstants;
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
public class EventsPrefsBean {
    
    public static final String PREFERENCE_EMAIL_FROM_NAME = "emailFromName";
    public static final String PREFERENCE_EMAIL_FROM_ADDRESS = "emailFromAdress";
    public static final String PREFERENCE_REGULAR_INVITATION_SUBJECT = "regularInvitationSubject";
    public static final String PREFERENCE_REGULAR_INVITATION_BODY = "regularInvitationBody";
    public static final String PREFERENCE_PUBLIC_EVENT_URL = "publicEventUrl";
    public static final String PREFERENCE_INVALID_CONFIRMATION_MESSAGE = "invalidConfirmationLinkMessage";
    public static final String PREFERENCE_REJECTION_MESSAGE = "goodByeMessage";
    public static final String PREFERENCE_NUM_ROWS = "numRows";
    
    protected String nameFrom;
    protected String emailFrom;
    // Regular Invitation
    protected String regularInvitationSubject;
    protected String regularInvitationBody;
    // Public event Pagename (Location of event display portlet)
    protected String publicEventsURL;
    // Invalid Confirmation Link message
    protected String invalidConfirmationLinkMessage;
    // Expired Event Message
    private String goodByeMessage;
    // number of rows
    private int numRows;
    
    public EventsPrefsBean(PortletRequest request) {
        PortletPreferences preferences = request.getPreferences();
        setFields(preferences);
    }
    
    public void save(PortletRequest request) throws ReadOnlyException, ValidatorException, IOException {
        
        PortletPreferences preferences = request.getPreferences();
        
        preferences.setValue(PropsKeys.EVENT_EMAIL_FROM_NAME, ParamUtil.getString(request, PREFERENCE_EMAIL_FROM_NAME, nameFrom));
        preferences.setValue(PropsKeys.EVENT_EMAIL_ADDRESS, ParamUtil.getString(request, PREFERENCE_EMAIL_FROM_ADDRESS, emailFrom));
        preferences.setValue(PropsKeys.REGULAR_INVITATION_SUBJECT, ParamUtil.getString(request, PREFERENCE_REGULAR_INVITATION_SUBJECT, regularInvitationSubject));
        preferences.setValue(PropsKeys.REGULAR_INVITATION_TEMPLATE, ParamUtil.getString(request, PREFERENCE_REGULAR_INVITATION_BODY, regularInvitationBody));
        preferences.setValue(PropsKeys.PUBLIC_EVENT_URL, ParamUtil.getString(request, PREFERENCE_PUBLIC_EVENT_URL, publicEventsURL));
        preferences.setValue(PropsKeys.INVALID_CONFIRMATION_LINK_MESSAGE, ParamUtil.getString(request, PREFERENCE_INVALID_CONFIRMATION_MESSAGE, invalidConfirmationLinkMessage));
        preferences.setValue(PropsKeys.GOOD_BYE_MESSAGE, ParamUtil.getString(request, PREFERENCE_REJECTION_MESSAGE, goodByeMessage));        
        preferences .setValue(PropsKeys.NUM_ROWS, String.valueOf(ParamUtil.getInteger(request, PREFERENCE_NUM_ROWS, numRows)));
        
        preferences.store();
        setFields(preferences);
    }
    
    private void setFields(PortletPreferences preferences) {
        this.nameFrom = preferences.getValue(PropsKeys.EVENT_EMAIL_FROM_NAME, PropsValues.EVENT_EMAIL_FROM_NAME);
        this.emailFrom = preferences.getValue(PropsKeys.EVENT_EMAIL_ADDRESS, PropsValues.EVENT_EMAIL_ADDRESS);
        this.regularInvitationSubject = preferences.getValue(PropsKeys.REGULAR_INVITATION_SUBJECT, PropsValues.REGULAR_INVITATION_SUBJECT);
        this.regularInvitationBody = preferences.getValue(PropsKeys.REGULAR_INVITATION_TEMPLATE, ContentUtil.get(PropsValues.REGULAR_INVITATION_TEMPLATE));
        this.publicEventsURL = preferences.getValue(PropsKeys.PUBLIC_EVENT_URL, PropsValues.PUBLIC_EVENT_URL);
        this.invalidConfirmationLinkMessage = preferences.getValue(PropsKeys.INVALID_CONFIRMATION_LINK_MESSAGE, ContentUtil.get(PropsValues.INVALID_CONFIRMATION_LINK_MESSAGE));
        this.goodByeMessage = preferences.getValue(PropsKeys.GOOD_BYE_MESSAGE, ContentUtil.get(PropsValues.GOOD_BYE_MESSAGE));
        this.numRows = Integer.parseInt(preferences.getValue(PropsKeys.NUM_ROWS, PropsValues.NUM_ROWS));
    }
    
    public void processTemplates(String[] data) {
        this.regularInvitationSubject = StringUtil.replace(this.regularInvitationSubject, NotificationConstants.COMMON_VARIABLES, data);
        this.regularInvitationBody = StringUtil.replace(this.regularInvitationBody, NotificationConstants.COMMON_VARIABLES, data);
        this.invalidConfirmationLinkMessage = StringUtil.replace(this.invalidConfirmationLinkMessage, NotificationConstants.COMMON_VARIABLES, data);
        this.goodByeMessage = StringUtil.replace(this.goodByeMessage, NotificationConstants.COMMON_VARIABLES, data);
        
    }
    
    public String getNameFrom() {
        return nameFrom;
    }
    
    public String getEmailFrom() {
        return emailFrom;
    }
    
    @AutoEscape
    public String getRegularInvitationSubject() {
        return regularInvitationSubject;
    }
    
    @AutoEscape
    public String getRegularInvitationBody() {
        return regularInvitationBody;
    }
    
    public String getPublicEventsURL() {
        return publicEventsURL;
    }
    
    @AutoEscape
    public String getInvalidConfirmationLinkMessage() {
        return invalidConfirmationLinkMessage;
    }
    
    @AutoEscape
    public String getGoodByeMessage() {
        return goodByeMessage;
    }
    
    public int getNumRows() {
        return numRows;
    }
    
    public void setNameFrom(String nameFrom) {
        this.nameFrom = nameFrom;
    }
    
    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }
    
    public void setRegularInvitationSubject(String regularInvitationSubject) {
        this.regularInvitationSubject = regularInvitationSubject;
    }
    
    public void setRegularInvitationBody(String regularInvitationBody) {
        this.regularInvitationBody = regularInvitationBody;
    }
    
    public void setPublicEventsURL(String publicEventsURL) {
        this.publicEventsURL = publicEventsURL;
    }
    
    public void setInvalidConfirmationLinkMessage(String invalidConfirmationLinkMessage) {
        this.invalidConfirmationLinkMessage = invalidConfirmationLinkMessage;
    }
    
    public void setGoodByeMessage(String goodByeMessage) {
        this.goodByeMessage = goodByeMessage;
    }
    
    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }
    
    @Override
    public String toString() {
        StringBundler builder = new StringBundler();
        builder.append("EventsPrefsBean [nameFrom=");
        builder.append(nameFrom);
        builder.append(", emailFrom=");
        builder.append(emailFrom);
        builder.append(", regularInvitationSubject=");
        builder.append(regularInvitationSubject);
        builder.append(", regularInvitationBody=");
        builder.append(regularInvitationBody);
        builder.append(", publicEventsURL=");
        builder.append(publicEventsURL);
        builder.append(", invalidConfirmationLinkMessage=");
        builder.append(invalidConfirmationLinkMessage);
        builder.append(", goodByeMessage=");
        builder.append(goodByeMessage);
        builder.append(", numRows=");
        builder.append(numRows);
        builder.append("]");
        return builder.toString();
    }
    
}
