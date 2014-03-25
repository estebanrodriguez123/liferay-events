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

package com.rivetlogic.event.notification.messagelistener;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.rivetlogic.event.model.Event;
import com.rivetlogic.event.model.Participant;
import com.rivetlogic.event.model.Token;
import com.rivetlogic.event.notification.constant.NotificationConstants;
import com.rivetlogic.event.notification.util.EmailNotificationUtil;
import com.rivetlogic.event.notification.util.MessageSender;
import com.rivetlogic.event.notification.util.MessageSenderImpl;
import com.rivetlogic.event.service.EventLocalServiceUtil;
import com.rivetlogic.event.service.ParticipantLocalServiceUtil;
import com.rivetlogic.event.service.TokenLocalServiceUtil;
import com.rivetlogic.event.util.EventConstant;
import com.rivetlogic.event.util.PropsValues;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class NotificationListener implements MessageListener {
    
    @Override
    public void receive(Message message) throws MessageListenerException {
        try {
            doReceive(message);
        } catch (Exception e) {
            _log.error(e);
        }
    }
    
    private void doReceive(Message message) throws AddressException, PortalException, SystemException {
        
        String cmd = message.getString(NotificationConstants.CMD);
        String[] data = null;
        MessageSenderImpl messageSender = new MessageSenderImpl();
        setCommonFields(message, messageSender);
        
        if (NotificationConstants.REGULAR_INVITATION.equalsIgnoreCase(cmd)) {
            
            data = processRegularInvitation(message, messageSender);
            
        } else if (NotificationConstants.MANUAL_EVENT_REGISTRATION.equalsIgnoreCase(cmd)) {
            
            data = processManualEvent(message, messageSender);
            
        } else if (NotificationConstants.EVENT_UPDATED.equalsIgnoreCase(cmd)) {
            
            processUpdatedEvent(message, messageSender);
            
        } else if (NotificationConstants.EVENT_CANCELLED.equalsIgnoreCase(cmd)) {
            
            processCancelledEvent(message, messageSender);
            
        } else if (NotificationConstants.SINGLE_EVENT_UPDATE.equalsIgnoreCase(cmd)) {
            
            data = processSingleUpdatedEvent(message, messageSender);
            
        } else if (NotificationConstants.SINGLE_CANCELLED_EVENT.equalsIgnoreCase(cmd)) {
            
            processSingleCancelledEvent(message, messageSender);
            
        } else if (NotificationConstants.REMINDER_MESSAGE.equalsIgnoreCase(cmd)) {
            
            processReminderMessage(message, messageSender);
        }
        
        if (data != null) {
            processTemplate(messageSender, data);
            
            if (_log.isDebugEnabled())
                _log.debug(messageSender.getBody());
            
            EmailNotificationUtil.sendEmailNotification(messageSender);
            
            if (!message.getBoolean(NotificationConstants.DONT_UPDATE_USER)) {
                updateParticipantStatus(message.getLong(NotificationConstants.PARTICIPANT_ID));
            }
        }
    }
    
    private void setCommonFields(Message message, MessageSenderImpl messageSender) throws AddressException {
        
        messageSender.setSubject(message.getString(NotificationConstants.SUBJECT_TEMPLATE));
        messageSender.setBody(message.getString(NotificationConstants.BODY_TEMPLATE));
        
        String senderMail = (String) message.get(NotificationConstants.SENDER);
        String senderName = (String) message.get(NotificationConstants.SENDER_NAME);
        
        if (Validator.isNull(senderMail) || Validator.isNull(senderName)) {
            senderMail = PropsValues.EVENT_EMAIL_ADDRESS;
            ;
            senderName = PropsValues.EVENT_EMAIL_FROM_NAME;
        }
        try {
            messageSender.setSender(new InternetAddress(senderMail, senderName));
        } catch (UnsupportedEncodingException e) {
            throw new AddressException(e.getMessage());
        }
    }
    
    private void processTemplate(MessageSender messageSender, String[] data) {
        messageSender.processBody(NotificationConstants.COMMON_VARIABLES, data);
        messageSender.processSubject(NotificationConstants.COMMON_VARIABLES, data);
    }
    
    private void updateParticipantStatus(Long participantId) {
        try {
            Participant p = ParticipantLocalServiceUtil.getParticipant(participantId);
            if (p.getStatus() == EventConstant.EVENT_STATUS_NOT_SENT) {
                p.setStatus(EventConstant.EVENT_STATUS_SENT);
                ParticipantLocalServiceUtil.updateParticipant(p);
            }
        } catch (Exception e) {
            _log.error(LOG_ERROR_UPDATING_STATUTS, e);
        }
    }
    
    private String[] processRegularInvitation(Message message, MessageSenderImpl messageSender)
        throws AddressException, PortalException, SystemException {
        
        messageSender.setRecipients(message.getString(NotificationConstants.RECIPIENTS));
        Long eventId = message.getLong(NotificationConstants.EVENT_ID);
        Long participantId = message.getLong(NotificationConstants.PARTICIPANT_ID);
        Event event = EventLocalServiceUtil.getEvent(eventId);
        Participant participant = ParticipantLocalServiceUtil.getParticipant(participantId);
        String confirmationURL = PropsValues.CONFIRMATION_LINK;
        String portalURL = message.getString(NotificationConstants.PORTAL_URL) + StringPool.FORWARD_SLASH;
        Token token = TokenLocalServiceUtil.createToken(participant);
        
        confirmationURL = StringUtil.replace(confirmationURL,
                new String[] { PATTERN_REPLACE_ZERO, PATTERN_REPLACE_ONE }, new String[] { Long.toString(eventId),
                        token.getUuid() });
        
        if (_log.isDebugEnabled())
            _log.debug(LOG_DEBUG_CONFIRMATION_URL + confirmationURL);
        
        String[] data = new String[] {
                messageSender.getSender().getAddress(),
                messageSender.getSender().getPersonal(),
                event.getName(),
                NotificationConstants.CDF.format(event.getEventDate()),
                participant.getFullName(),
                messageSender.getRecipients()[0].toString(),
                event.getLocation(),
                event.getDescription(),
                portalURL + message.getString(NotificationConstants.PUBLIC_URL),
                portalURL + message.getString(NotificationConstants.PUBLIC_URL) + confirmationURL
                        + EventConstant.STATUS_GOING,
                portalURL + message.getString(NotificationConstants.PUBLIC_URL) + confirmationURL
                        + EventConstant.STATUS_NOT_GOING, portalURL };
        
        return data;
    }
    
    private String[] processManualEvent(Message message, MessageSenderImpl messageSender) throws PortalException,
        SystemException, AddressException {
        
        message.put(NotificationConstants.DONT_UPDATE_USER, true);
        messageSender.setRecipients(message.getString(NotificationConstants.RECIPIENTS));
        Participant participant = (Participant) message.get(NotificationConstants.PARTICIPANT);
        
        Event event = EventLocalServiceUtil.getEvent(participant.getEventId());
        Token token = TokenLocalServiceUtil.createToken(participant);
        String confirmationURL = PropsValues.CONFIRMATION_LINK;
        
        String portalURL = message.getString(NotificationConstants.PORTAL_URL) + StringPool.FORWARD_SLASH;
        confirmationURL = StringUtil.replace(confirmationURL,
                new String[] { PATTERN_REPLACE_ZERO, PATTERN_REPLACE_ONE },
                new String[] { Long.toString(event.getEventId()), token.getUuid() });
        
        if (_log.isDebugEnabled())
            _log.debug(LOG_DEBUG_CONFIRMATION_URL + confirmationURL);
        
        String[] data = new String[] {
                messageSender.getSender().getAddress(),
                messageSender.getSender().getPersonal(),
                event.getName(),
                NotificationConstants.CDF.format(event.getEventDate()),
                participant.getFullName(),
                messageSender.getRecipients()[0].toString(),
                event.getLocation(),
                event.getDescription(),
                portalURL + message.getString(NotificationConstants.PUBLIC_URL),
                portalURL + message.getString(NotificationConstants.PUBLIC_URL) + confirmationURL
                        + EventConstant.STATUS_GOING,
                portalURL + message.getString(NotificationConstants.PUBLIC_URL) + confirmationURL
                        + EventConstant.STATUS_NOT_GOING, portalURL };
        
        return data;
    }
    
    private void processUpdatedEvent(Message message, MessageSenderImpl messageSender) throws PortalException,
        SystemException, AddressException {
        
        Long eventId = message.getLong(NotificationConstants.EVENT_ID);
        Event event = EventLocalServiceUtil.getEvent(eventId);
        List<Participant> participants = event.getParticipants(new int[] { EventConstant.EVENT_STATUS_ACCEPTER,
                EventConstant.EVENT_STATUS_SENT, EventConstant.EVENT_STATUS_NOT_SENT });
        
        String portalURL = message.getString(NotificationConstants.PORTAL_URL) + StringPool.FORWARD_SLASH;
        
        for (Participant p : participants) {
            
            String confirmationURL = PropsValues.CONFIRMATION_LINK;
            Token token = TokenLocalServiceUtil.createToken(p);
            confirmationURL = StringUtil.replace(confirmationURL, new String[] { PATTERN_REPLACE_ZERO,
                    PATTERN_REPLACE_ONE }, new String[] { Long.toString(event.getEventId()), token.getUuid() });
            
            String[] data = new String[] {
                    messageSender.getSender().getAddress(),
                    messageSender.getSender().getPersonal(),
                    event.getName(),
                    NotificationConstants.CDF.format(event.getEventDate()),
                    p.getFullName(),
                    p.getEmail(),
                    event.getLocation(),
                    event.getDescription(),
                    portalURL + message.getString(NotificationConstants.PUBLIC_URL),
                    portalURL + message.getString(NotificationConstants.PUBLIC_URL) + confirmationURL
                            + EventConstant.STATUS_GOING,
                    portalURL + message.getString(NotificationConstants.PUBLIC_URL) + confirmationURL
                            + EventConstant.STATUS_NOT_GOING, message.getString(NotificationConstants.PORTAL_URL) };
            
            processTemplate(messageSender, data);
            try {
                messageSender.setRecipients(p.getEmail());
                EmailNotificationUtil.sendEmailNotification(messageSender);
                
            } catch (AddressException e) {
                _log.error(String.format(LOG_EROR_PARTICIPANT_WRONG_EMAIL, p.getFullName(), p.getEmail()), e);
            }
            
            setCommonFields(message, messageSender);// Set a clean template
        }
    }
    
    @SuppressWarnings("unchecked")
    private void processCancelledEvent(Message message, MessageSenderImpl messageSender) throws PortalException,
        SystemException, AddressException {
        
        Event event = (Event) message.get(NotificationConstants.EVENT);
        List<Participant> participants = (List<Participant>) message.get(NotificationConstants.PARTICIPANTS);
        String portalURL = message.getString(NotificationConstants.PORTAL_URL) + StringPool.FORWARD_SLASH;
        if (participants == null)
            participants = event.getParticipants(new int[] { EventConstant.EVENT_STATUS_ACCEPTER,
                    EventConstant.EVENT_STATUS_SENT });
        
        for (Participant p : participants) {
            String[] data = new String[] { messageSender.getSender().getAddress(),
                    messageSender.getSender().getPersonal(), event.getName(),
                    NotificationConstants.CDF.format(event.getEventDate()), p.getFullName(), p.getEmail(),
                    event.getLocation(), event.getDescription(),
                    portalURL + message.getString(NotificationConstants.PUBLIC_URL), StringPool.BLANK,
                    StringPool.BLANK, portalURL };
            
            processTemplate(messageSender, data);
            try {
                messageSender.setRecipients(p.getEmail());
                EmailNotificationUtil.sendEmailNotification(messageSender);
            } catch (Exception e) {
                _log.error(String.format(LOG_EROR_PARTICIPANT_WRONG_EMAIL, p.getFullName(), p.getEmail()));
            }
            setCommonFields(message, messageSender);// Set a clean template
        }
    }
    
    private String[] processSingleUpdatedEvent(Message message, MessageSenderImpl messageSender)
        throws PortalException, SystemException, AddressException {
        
        Participant p = (Participant) message.get(NotificationConstants.PARTICIPANT);
        Event event = EventLocalServiceUtil.getEvent(p.getEventId());
        
        message.put(NotificationConstants.PARTICIPANT_ID, p.getParticipantId());
        
        Token token = TokenLocalServiceUtil.createToken(p);
        String confirmationURL = PropsValues.CONFIRMATION_LINK;
        String portalURL = message.getString(NotificationConstants.PORTAL_URL) + StringPool.FORWARD_SLASH;
        confirmationURL = StringUtil.replace(confirmationURL,
                new String[] { PATTERN_REPLACE_ZERO, PATTERN_REPLACE_ONE },
                new String[] { Long.toString(event.getEventId()), token.getUuid() });
        
        String[] data = new String[] {
                messageSender.getSender().getAddress(),
                messageSender.getSender().getPersonal(),
                event.getName(),
                NotificationConstants.CDF.format(event.getEventDate()),
                p.getFullName(),
                p.getEmail(),
                event.getLocation(),
                event.getDescription(),
                portalURL + message.getString(NotificationConstants.PUBLIC_URL),
                portalURL + message.getString(NotificationConstants.PUBLIC_URL) + confirmationURL
                        + EventConstant.STATUS_GOING,
                portalURL + message.getString(NotificationConstants.PUBLIC_URL) + confirmationURL
                        + EventConstant.STATUS_NOT_GOING, portalURL };
        
        messageSender.setRecipients(p.getEmail());
        
        return data;
    }
    
    private void processSingleCancelledEvent(Message message, MessageSenderImpl messageSender) throws AddressException,
        PortalException, SystemException {
        
        Participant p = (Participant) message.get(NotificationConstants.PARTICIPANT);
        Event event = EventLocalServiceUtil.getEvent(p.getEventId());
        String portalURL = message.getString(NotificationConstants.PORTAL_URL) + StringPool.FORWARD_SLASH;
        ;
        String[] data = new String[] { messageSender.getSender().getAddress(), messageSender.getSender().getPersonal(),
                event.getName(), NotificationConstants.CDF.format(event.getEventDate()), p.getFullName(), p.getEmail(),
                event.getLocation(), event.getDescription(),
                portalURL + message.getString(NotificationConstants.PUBLIC_URL), StringPool.BLANK, StringPool.BLANK,
                portalURL };
        
        messageSender.setRecipients(p.getEmail());
        processTemplate(messageSender, data);
        EmailNotificationUtil.sendEmailNotification(messageSender);
    }
    
    private void processReminderMessage(Message message, MessageSenderImpl messageSender) throws PortalException,
        SystemException, AddressException {
        
        Long eventId = message.getLong(NotificationConstants.EVENT_ID);
        Event event = EventLocalServiceUtil.getEvent(eventId);
        List<Participant> participants = event.getParticipants(new int[] { EventConstant.EVENT_STATUS_ACCEPTER });
        String portalURL = message.getString(NotificationConstants.PORTAL_URL) + StringPool.FORWARD_SLASH;
        
        for (Participant p : participants) {
            
            String confirmationURL = PropsValues.CONFIRMATION_LINK;
            Token token = TokenLocalServiceUtil.createToken(p);
            confirmationURL = StringUtil.replace(confirmationURL, new String[] { PATTERN_REPLACE_ZERO,
                    PATTERN_REPLACE_ONE }, new String[] { Long.toString(event.getEventId()), token.getUuid() });
            
            String[] data = new String[] {
                    messageSender.getSender().getAddress(),
                    messageSender.getSender().getPersonal(),
                    event.getName(),
                    NotificationConstants.CDF.format(event.getEventDate()),
                    p.getFullName(),
                    p.getEmail(),
                    event.getLocation(),
                    event.getDescription(),
                    portalURL + message.getString(NotificationConstants.PUBLIC_URL),
                    portalURL + message.getString(NotificationConstants.PUBLIC_URL) + confirmationURL
                            + EventConstant.STATUS_GOING,
                    portalURL + message.getString(NotificationConstants.PUBLIC_URL) + confirmationURL
                            + EventConstant.STATUS_NOT_GOING, portalURL };
            
            processTemplate(messageSender, data);
            
            try {
                messageSender.setRecipients(p.getEmail());
                EmailNotificationUtil.sendEmailNotification(messageSender);
            } catch (AddressException ae) {
                _log.error(String.format(LOG_EROR_PARTICIPANT_WRONG_EMAIL, p.getFullName(), p.getEmail()));
            }
            
            setCommonFields(message, messageSender);// Set a clean template
        }
    }
    
    private static final Log _log = LogFactoryUtil.getLog(NotificationListener.class);
    private static final String LOG_ERROR_UPDATING_STATUTS = "error updating participant status";
    private static final String LOG_EROR_PARTICIPANT_WRONG_EMAIL = "this participant %s has a incorrect format email: %s";
    private static final String LOG_DEBUG_CONFIRMATION_URL = "confirmation url: ";
    private static final String PATTERN_REPLACE_ZERO = "{0}";
    private static final String PATTERN_REPLACE_ONE = "{1}";
}