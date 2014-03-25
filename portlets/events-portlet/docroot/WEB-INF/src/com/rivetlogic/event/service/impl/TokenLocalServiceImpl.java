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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.rivetlogic.event.NoSuchTokenException;
import com.rivetlogic.event.model.Event;
import com.rivetlogic.event.model.Participant;
import com.rivetlogic.event.model.Token;
import com.rivetlogic.event.service.base.TokenLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the token local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.rivetlogic.event.service.TokenLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author juancarrillo
 * @see com.rivetlogic.event.service.base.TokenLocalServiceBaseImpl
 * @see com.rivetlogic.event.service.TokenLocalServiceUtil
 */
public class TokenLocalServiceImpl extends TokenLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     * 
     * Never reference this interface directly. Always use {@link
     * com.rivetlogic.event.service.TokenLocalServiceUtil} to access the token
     * local service.
     */
    
    public Token createToken(Participant participant) throws SystemException, PortalException {
        
        Event event = eventLocalService.getEvent(participant.getEventId());
        Token token = tokenPersistence.create(counterLocalService.increment(Token.class.getName()));
        token.setExpiredDate(event.getEventDate());
        token.setParticipantId(participant.getParticipantId());
        
        return tokenLocalService.updateToken(token);
    }
    
    public Token getTokenByUuid(String uuid) throws SystemException, NoSuchTokenException {
        
        List<Token> tokens = tokenPersistence.findByUuid(uuid);
        if (tokens.isEmpty()) {
            throw new NoSuchTokenException();
        } else {
            return tokens.get(0);
        }
    }
    
    public List<Token> getTokensByParticipantId(Long participantId) throws SystemException {
        
        return tokenPersistence.findByParticipantId(participantId);
    }
    
    public Token expireToken(Token token) throws SystemException {
        Date now = new Date();
        token.setExpiredDate(now);
        return tokenLocalService.updateToken(token);
    }
    
    public void expiredTokenByParticipantId(Long participantId) throws SystemException {
        
        List<Token> tokens = getTokensByParticipantId(participantId);
        for (Token t : tokens) {
            if (!t.isExpired()) {
                expireToken(t);
            }
        }
    }
}