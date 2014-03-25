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

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * @author christopherjimenez
 */
public class MessageSenderImpl implements MessageSender {

	private InternetAddress sender;
	private InternetAddress[] recipients;
	private boolean isHTMLFormat;
	private String body;
	private String subject;

	public MessageSenderImpl(){
		this.sender = null;
		this.recipients = null;
		this.isHTMLFormat = true;
		this.body = StringPool.BLANK;
		this.subject = StringPool.BLANK;
	}
	
	public InternetAddress getSender() {
		return sender;
	}

	public void setSender(InternetAddress sender) {
		this.sender = sender;
	}
	
	public void setSender(String sender) throws AddressException{
		this.sender = new InternetAddress(sender);
	}

	public InternetAddress[] getRecipients() {
		return recipients;
	}

	public void setRecipients(InternetAddress[] recipients) {
		this.recipients = recipients;
	}

	/**
	 * @param recipients
	 * @throws AddressException
	 * <code>recipients</code> must be a list of addresses separated by comma
	 * e.g email@domain.com,email@domain2.com
	 */
	public void setRecipients(String recipients) throws AddressException {
		this.recipients = InternetAddress.parse(recipients);
	}
	
	public Boolean isHTMLFormat() {
		return isHTMLFormat;
	}

	public void setHTMLFormat(boolean isHTMLFormat) {
		this.isHTMLFormat = isHTMLFormat;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void processBody(String[] oldSubs, String[] newSubs){
		this.body = StringUtil.replace(this.body, oldSubs, newSubs);
	}
	
	public void processSubject(String[] oldSubs, String[] newSubs){
		this.subject = StringUtil.replace(this.subject, oldSubs, newSubs);
	}
	
}
