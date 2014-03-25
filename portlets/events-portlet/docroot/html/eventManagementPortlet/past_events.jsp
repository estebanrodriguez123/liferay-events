<%--
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
--%>

<%@include file="/html/init.jsp" %>

<liferay-ui:success key="participant-registration-success" message="participant-registration-success" />
<liferay-ui:success key="participant-registration-email" message="participant-registration-email" />

<portlet:renderURL var="backURL">
 	<portlet:param name="<%=WebKeys.MVC_PATH %>" value="/html/eventManagementPortlet/view.jsp" />
</portlet:renderURL>

<div class="past-events">
	<liferay-ui:header title="event-my-past-events" backURL="${backURL}"/>
	
	<liferay-ui:search-container emptyResultsMessage="event-empty-results" 
		delta="${prefBean.numRows}" deltaConfigurable="true">
		
		<liferay-ui:search-container-results 
			results="<%=EventLocalServiceUtil.getPastEvents(searchContainer.getStart(), searchContainer.getEnd())%>"
			total="<%=EventLocalServiceUtil.getPastEventsCount()%>"
		/>
	
		<liferay-ui:search-container-row 
			className="com.rivetlogic.event.model.Event" 
			keyProperty="eventId" modelVar="event">
				<liferay-ui:search-container-column-text name="event-date" buffer="buffer">
					<% buffer.append(NotificationConstants.SDF.format(event.getEventDate())); %>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="event-name" value="${event.name}" />
				<liferay-ui:search-container-column-jsp path="/html/eventManagementPortlet/include/events-actions.jsp"/>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
		
	</liferay-ui:search-container>
</div> 

