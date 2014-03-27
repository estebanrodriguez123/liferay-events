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
	<portlet:param name="<%=WebKeys.REDIRECT%>" value="<%=currentURL%>"/>
</portlet:actionURL>

<aui:form name="fm_edit_preferences" action="${changePreferencesUrl}" method="POST" onSubmit="event.preventDefault(); ${pns}saveConfiguration();">
	<aui:input name="<%=WebKeys.SELECTED_TAB%>" value="<%= selectedTab %>" type="hidden"/>
	<liferay-ui:tabs
		names='<%=PreferencesConstants.DISPLAY_EMAIL_FROM + "," + PreferencesConstants.DISPLAY_REGULAR_INVITATION + "," +
			PreferencesConstants.GOOD_BYE_MESSAGE + "," + PreferencesConstants.DISPLAY_OTHERS%>'
		param="<%=WebKeys.SELECTED_TAB%>"
		url="<%=portletURL%>"
	/>
	<c:choose>
		<c:when test='<%= selectedTab.equals(PreferencesConstants.DISPLAY_EMAIL_FROM) %>'>
			<%@include file="/html/include/email-from.jspf" %>
		</c:when>
		<c:when test='<%= selectedTab.equals(PreferencesConstants.DISPLAY_REGULAR_INVITATION) %>'>
			<%@include file="/html/include/regular-invitation.jspf" %>
		</c:when>
		<c:when test='<%= selectedTab.equals(PreferencesConstants.GOOD_BYE_MESSAGE) %>'>
			<aui:fieldset>
				<aui:field-wrapper label="event-email-body">
					<liferay-ui:input-editor toolbarSet="email"/>
				</aui:field-wrapper>
				<aui:input name="<%=EventsPrefsBean.PREFERENCE_REJECTION_MESSAGE %>" type="hidden" value="${prefBean.goodByeMessage}"/>	
			</aui:fieldset>
			<%@include file="/html/eventManagementPortlet/definition-of-terms.jspf" %>
		</c:when>
		<c:when test='<%= selectedTab.equals(PreferencesConstants.EXPIRED_EVENT) %>'>
			<aui:fieldset>
				<aui:field-wrapper label="event-email-body">
					<liferay-ui:input-editor toolbarSet="email"/>
				</aui:field-wrapper>
				<aui:input name="expiredEventMessage" type="hidden" value="${prefBean.expiredEventMessage}"/>	
			</aui:fieldset>
			<%@include file="/html/eventManagementPortlet/definition-of-terms.jspf" %>
		</c:when>
		<c:when test='<%= selectedTab.equals(PreferencesConstants.DISPLAY_OTHERS) %>'>
			<%@include file="/html/eventportlet/include/event-links.jspf" %>
		</c:when>
	</c:choose>
	<aui:button-row>
		<aui:button name="save-preferences" label="save-preferences" type="submit"/>
	</aui:button-row>
</aui:form>
<aui:script>
	function ${pns}initEditor() {
		if(<%=selectedTab.equals(PreferencesConstants.DISPLAY_REGULAR_INVITATION)%>){
			return document.${pns}fm_edit_preferences.${pns}regularInvitationBody.value;
		}
		if(<%=selectedTab.equals(PreferencesConstants.DISPLAY_OTHERS)%>){
			return document.${pns}fm_edit_preferences.${pns}invalidConfirmationLinkMessage.value;
		}
		if(<%=selectedTab.equals(PreferencesConstants.EXPIRED_EVENT)%>){
			return document.${pns}fm_edit_preferences.${pns}expiredEventMessage.value;
		}

		if(<%=selectedTab.equals(PreferencesConstants.GOOD_BYE_MESSAGE)%>){
			return document.${pns}fm_edit_preferences.${pns}goodByeMessage.value;
		}	
	};
	
	Liferay.provide(window,'${pns}saveConfiguration',
		function() {
			if(<%=selectedTab.equals(PreferencesConstants.DISPLAY_REGULAR_INVITATION)%>){
				document.${pns}fm_edit_preferences.${pns}regularInvitationBody.value = window.${pns}editor.getHTML();
			}
			if(<%=selectedTab.equals(PreferencesConstants.DISPLAY_OTHERS)%>){
				document.${pns}fm_edit_preferences.${pns}invalidConfirmationLinkMessage.value = window.${pns}editor.getHTML();
			}	
			if(<%=selectedTab.equals(PreferencesConstants.EXPIRED_EVENT)%>){
				document.${pns}fm_edit_preferences.${pns}expiredEventMessage.value = window.${pns}editor.getHTML();
			}
			if(<%=selectedTab.equals(PreferencesConstants.GOOD_BYE_MESSAGE)%>){
				document.${pns}fm_edit_preferences.${pns}goodByeMessage.value = window.${pns}editor.getHTML();
			}
		   submitForm(document.${pns}fm_edit_preferences);
		},
		['liferay-util-list-fields']
	);

</aui:script>