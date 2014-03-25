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

package com.rivetlogic.event.notification.util;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;

import java.util.List;
import java.util.Map;

/**
 * @author christopherjimenez
 */
public class EmailNotificationUtil {
    
    private static final String EXCEPTION_IMPLEMENTATION = "This object %s does not implement a Hash Interface";
    
    public static void sendEmailNotification(MessageSender messageSender) {
        
        MailMessage mailMessage = new MailMessage(messageSender.getSender(), messageSender.getSubject(),
                messageSender.getBody(), messageSender.isHTMLFormat());
        
        mailMessage.setBCC(messageSender.getRecipients());
        
        MailServiceUtil.sendEmail(mailMessage);
    }
    
    @SuppressWarnings("unchecked")
    public static Map<String, Object> extractMap(Object o) throws Exception {
        
        if (o instanceof Map<?, ?>) {
            return (Map<String, Object>) o;
        }
        throw new Exception(String.format(EXCEPTION_IMPLEMENTATION, o));
    }
    
    @SuppressWarnings("unchecked")
    public static <T extends List<?>> T extractList(Object obj) {
        return (T) obj;
    }
}
