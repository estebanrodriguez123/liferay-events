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

/**
 * @author christopherjimenez
 *
 */
public class EventConstant {

	public static final int EVENT_STATUS_NOT_SENT = 0;
	public static final int EVENT_STATUS_SENT = 1;
	public static final int EVENT_STATUS_ACCEPTER = 2;
	public static final int EVENT_STATUS_REJECTED = 3;
	
	public static final String STATUS_GOING = "going";
	public static final String STATUS_NOT_GOING = "not-going";
	
	public static final String DEFAULT_COMPANY = "Unknown";
	public static final String DEFAULT_PHONE_NUMBER = "00000000";
}
