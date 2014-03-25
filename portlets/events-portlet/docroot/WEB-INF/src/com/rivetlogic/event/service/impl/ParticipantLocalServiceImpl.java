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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.rivetlogic.event.NoSuchParticipantException;
import com.rivetlogic.event.model.Participant;
import com.rivetlogic.event.service.base.ParticipantLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the participant local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.rivetlogic.event.service.ParticipantLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author juancarrillo
 * @see com.rivetlogic.event.service.base.ParticipantLocalServiceBaseImpl
 * @see com.rivetlogic.event.service.ParticipantLocalServiceUtil
 */
public class ParticipantLocalServiceImpl extends ParticipantLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     * 
     * Never reference this interface directly. Always use {@link
     * com.rivetlogic.event.service.ParticipantLocalServiceUtil} to access the
     * participant local service.
     */
    
    @Override
    public Participant addParticipant(Participant participant) throws SystemException {
        
        participant.setParticipantId(counterLocalService.increment(Participant.class.getName()));
        
        return super.addParticipant(participant);
    }
    
    public List<Participant> getParticipants(long eventId) throws SystemException {
        
        List<Participant> participants = new ArrayList<Participant>();
        
        try {
            participants = participantPersistence.findByEventId(eventId);
            
        } catch (SystemException e) {
            _log.error(e);
        }
        
        return participants;
    }
    
    public List<Participant> getParticipants(int status, long eventId) throws SystemException {
        
        List<Participant> unfilterdParticipants = new ArrayList<Participant>();
        List<Participant> filterdParticipants = new ArrayList<Participant>();
        
        try {
            unfilterdParticipants = getParticipants(eventId);
            
        } catch (SystemException e) {
            _log.error(e);
        }
        
        for (Participant participant : unfilterdParticipants) {
            if (Validator.equals(participant.getStatus(), status))
                filterdParticipants.add(participant);
        }
        
        return filterdParticipants;
    }
    
    public int getParticipantsCount(long eventId) throws SystemException {
        
        int count = 0;
        
        try {
            count = participantPersistence.countByEventId(eventId);
        } catch (SystemException e) {
            _log.error(e);
        }
        
        return count;
    }
    
    public int getParticipantsCount(int status, long eventId) throws SystemException {
        
        List<Participant> participants = getParticipants(status, eventId);
        
        return participants.size();
    }
    
    public void clearParticipantsByEventId(Long eventId) throws NoSuchParticipantException, SystemException {
        
        List<Participant> participants = getParticipants(eventId);
        
        for (Participant p : participants) {
            participantPersistence.remove(p.getParticipantId());
        }
    }
    
    public void removeParticipants(Long[] ids) {
        for (Long id : ids) {
            try {
                participantPersistence.remove(id);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
    
    public List<Participant> findParticipantByEventIdAndEmail(Long eventId, String email) {
        
        List<Participant> participants = new ArrayList<Participant>();
        
        try {
            participants = participantPersistence.findByEventIdAndEmail(eventId, email);
            
        } catch (Exception e) {
            _log.error(e);
        }
        
        return participants;
    }
    
    private static Log _log = LogFactoryUtil.getLog(ParticipantLocalServiceImpl.class);
}