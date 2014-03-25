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

public enum EmailTemplateVariables {
	
	FROM_NAME("[$FROM_NAME$]","from-name-help"),
	FROM_ADDRESS("[$FROM_ADDRESS$]","from-address-help"),
	EVENT_NAME("[$EVENT_NAME$]","event-name-help"),
	EVENT_DATE("[$EVENT_DATE$]","event-date-help"),
	TO_NAME("[$TO_NAME$]","to-name-help"),
	TO_ADDRESS("[$TO_ADDRESS$]","to-address-help"),
	EVENT_LOCATION("[$EVENT_LOCATION$]", "event-location-help"),
	EVENT_DESCRIPTION("[$EVENT_DESCRIPTION$]", "event-description-help"),
	PUBLIC_EVENTS_URL("[$PUBLIC_EVENTS_URL$]", "public-events-url-help"),
	CONFIRMATION_URL("[$CONFIRMATION_URL$]", "confirmation-url-help"),
	REJECTION_URL("[$REJECTION_URL$]", "rejection-url-help");
	
	EmailTemplateVariables(String token, String help) {
		this.token = token;
		this.help = help;
	}

	public String getToken() {
		return token;
	}

	public String getHelp() {
		return help;
	}

	private final String token;
	private final String help;
}
