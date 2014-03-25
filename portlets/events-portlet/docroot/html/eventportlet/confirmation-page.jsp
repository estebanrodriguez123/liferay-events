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

<liferay-ui:header title="event-registration-header"/>

<c:choose>
    <c:when test="${expiredToken}">
        <span class="event-message">
            <liferay-ui:message key="expired-token-message"/>
        </span>
    </c:when>
	<c:when test="${isGoing}">
		<%
			Event event = (Event) request.getAttribute("event");
		%>
		<%@include file="/html/eventportlet/include/attendance_confirmation.jspf" %>
		<%@include file="/html/eventportlet/include/event-summary.jspf" %>
	</c:when>
	<c:when test="${not isGoing and not invalid}">
		<span class="event-message">
			${prefBean.goodByeMessage}
		</span>
	</c:when>
	<c:when test="${invalid}">
		<span class="event-message">
			${prefBean.invalidConfirmationLinkMessage}
		</span>
	</c:when>
</c:choose>
