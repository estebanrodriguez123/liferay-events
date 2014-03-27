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

<%
  String selectedTab = GetterUtil.getString(renderRequest.getAttribute(WebKeys.SELECTED_TAB));    		
%>
<liferay-ui:error key="preferences-load-error" message="preferences-load-error" />
<liferay-ui:error key="preferences-writes-error" message="preferences-writes-error" />
<liferay-ui:error key="preferences-io-error" message="preferences-io-error" />

<portlet:renderURL var="portletURL">
	<portlet:param name="tabsConf" value="<%= selectedTab %>" />
	<portlet:param name="<%=WebKeys.REDIRECT%>" value="<%= redirect %>"/>	
</portlet:renderURL>

<portlet:actionURL name="changePreferences" var="changePreferencesUrl">
	<portlet:param name="<%=WebKeys.REDIRECT%>" value="<%= currentURL %>"/>
</portlet:actionURL>

<aui:form name="fm_edit_preferences" action="${changePreferencesUrl}" method="POST" onSubmit="event.preventDefault(); ${pns}saveConfiguration();">
	<aui:input name="<%=WebKeys.SELECTED_TAB%>" value="<%= selectedTab %>" type="hidden"/>
	
	<liferay-ui:tabs
		names="<%= PreferencesConstants.getOptions() %>"
		param="<%=WebKeys.SELECTED_TAB%>"
		url="<%= portletURL %>"
	/>
		
	<c:choose>
		<c:when test='<%= selectedTab.equals(PreferencesConstants.EMAIL_FROM) %>'>
			<%@include file="/html/include/email-from.jspf" %>
		</c:when>
		<c:when test='<%= selectedTab.equals(PreferencesConstants.REGULAR_INVITATION) %>'>
			<%@include file="/html/include/regular-invitation.jspf" %>
		</c:when>
		<c:when test='<%= selectedTab.equals(PreferencesConstants.UPDATED_INVITATION) %>'>
			<aui:fieldset>
				<aui:input name="<%=ManagementPrefsBean.PREFERENCE_UPDATED_INVITATION_SUBJECT %>" label="event-subject" value="${prefBean.updatedEventInvitationSubject}" type="text" cssClass="email-subject">
					<aui:validator name="required"/>
				</aui:input>
				<aui:field-wrapper label="event-email-body">
					<liferay-ui:input-editor toolbarSet="email"/>
				</aui:field-wrapper>
				<aui:input name="<%=ManagementPrefsBean.PREFERENCE_UPDATED_INVITATION_BODY %>" type="hidden" value="${prefBean.updatedEventInvitationBody}"/>
			</aui:fieldset>
			<%@include file="/html/eventManagementPortlet/definition-of-terms.jspf" %>
		</c:when>
		<c:when test='<%= selectedTab.equals(PreferencesConstants.CANCELLED_INVITATION) %>'>
			<aui:fieldset>
				<aui:input name="<%=ManagementPrefsBean.PREFERENCE_CANCELLED_EVENT_SUBJECT %>" label="event-subject" value="${prefBean.cancelledEventNotificationSubject}" type="text" cssClass="email-subject">
					<aui:validator name="required"/>
				</aui:input>
				<aui:field-wrapper label="event-email-body">
					<liferay-ui:input-editor toolbarSet="email"/>
				</aui:field-wrapper>
				<aui:input name="<%=ManagementPrefsBean.PREFERENCE_CANCELLED_EVENT_BODY %>" type="hidden" value="${prefBean.cancelledEventNotificationBody}"/>
			</aui:fieldset>
			<%@include file="/html/eventManagementPortlet/definition-of-terms.jspf" %>
		</c:when>
		<%-- Hiding this option because we are not sending an sucessful registration message by now
		<c:when test='<%=selectedTab.equals(PreferencesConstants.SUCCESSFUL_REGISTRATION)%>'>
			<aui:fieldset>
				<aui:input name="<%=ManagementPrefsBean.PREFERENCE_SUCCESS_MESSAGE_SUBJECT %>" label="event-subject" value="${prefBean.successRegistrationSubject}" type="text" cssClass="email-subject">
					<aui:validator name="required"/>
				</aui:input>
				<aui:field-wrapper label="event-email-body">
					<liferay-ui:input-editor toolbarSet="email"/>
				</aui:field-wrapper>
				<aui:input name="<%=ManagementPrefsBean.PREFERENCE_SUCCESS_MESSAGE %>" type="hidden" value="${prefBean.successRegistrationBody}"/>
			</aui:fieldset>
			<%@include file="/html/eventManagementPortlet/definition-of-terms.jspf" %>
		</c:when>
		 --%>
		<c:when test="<%=selectedTab.equals(PreferencesConstants.REMINDER_MESSAGE)%>">
			<aui:fieldset>
				<aui:input name="<%=ManagementPrefsBean.PREFERENCE_REMINDER_EVENT_SUBJECT %>" label="event-subject" value="${prefBean.reminderEventSubject}" type="text" cssClass="email-subject">
					<aui:validator name="required"/>
				</aui:input>
				<aui:field-wrapper label="event-email-body">
					<liferay-ui:input-editor toolbarSet="email"/>
				</aui:field-wrapper>
				<aui:input name="<%=ManagementPrefsBean.PREFERENCE_REMINDER_EVENT_BODY %>" type="hidden" value="${prefBean.reminderEventBody}"/>
			</aui:fieldset>
			<%@include file="/html/eventManagementPortlet/definition-of-terms.jspf" %>
		</c:when>
		
		<c:when test='<%=selectedTab.equals(PreferencesConstants.EVENT_LINKS)%>'>
			<%@include file="/html/eventManagementPortlet/include/event-links.jspf" %>
		</c:when>
	</c:choose>
	
	<aui:button-row>
		<aui:button name="save-preferences" label="save-preferences" type="submit"/>
	</aui:button-row>
</aui:form>
<aui:script>
	function ${pns}initEditor() {
		if(<%=selectedTab.equals(PreferencesConstants.REGULAR_INVITATION)%>){
			return document.${pns}fm_edit_preferences.${pns}regularInvitationBody.value;
		}
		if(<%=selectedTab.equals(PreferencesConstants.UPDATED_INVITATION)%>){
			return document.${pns}fm_edit_preferences.${pns}updatedInvitationBody.value;
		}
		if(<%=selectedTab.equals(PreferencesConstants.CANCELLED_INVITATION)%>){
			return document.${pns}fm_edit_preferences.${pns}cancelledEventBody.value;
		}
		if(<%=selectedTab.equals(PreferencesConstants.SUCCESSFUL_REGISTRATION)%>){
			return document.${pns}fm_edit_preferences.${pns}successfulMessage.value;
		}
		if(<%=selectedTab.equals(PreferencesConstants.REMINDER_MESSAGE)%>){
			return document.${pns}fm_edit_preferences.${pns}reminderEventBody.value;
		}

	};
	
	Liferay.provide(window,'${pns}saveConfiguration',
		function() {
			if(<%=selectedTab.equals(PreferencesConstants.REGULAR_INVITATION)%>){
				document.${pns}fm_edit_preferences.${pns}regularInvitationBody.value = window.${pns}editor.getHTML();
			}
			if(<%=selectedTab.equals(PreferencesConstants.UPDATED_INVITATION)%>){
				document.${pns}fm_edit_preferences.${pns}updatedInvitationBody.value = window.${pns}editor.getHTML();
			}
			if(<%=selectedTab.equals(PreferencesConstants.CANCELLED_INVITATION)%>){
				document.${pns}fm_edit_preferences.${pns}cancelledEventBody.value = window.${pns}editor.getHTML();
			}
			if(<%=selectedTab.equals(PreferencesConstants.SUCCESSFUL_REGISTRATION)%>){
				document.${pns}fm_edit_preferences.${pns}successfulMessage.value = window.${pns}editor.getHTML();
			}
			if(<%=selectedTab.equals(PreferencesConstants.REMINDER_MESSAGE) %>){
				document.${pns}fm_edit_preferences.${pns}reminderEventBody.value = window.${pns}editor.getHTML();
			}
			submitForm(document.${pns}fm_edit_preferences);
		},
		['liferay-util-list-fields']
	);

</aui:script>

