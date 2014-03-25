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

AUI.add(
	'event-management-plugin',
	function(A) {
		Liferay.EventManagement = {
			init: function(params) {
				var instance = this;
				var box = params.container;
				
				instance.namespace = params.namespace;
				instance.form = box.one("#"+instance.namespace+"fm_edit_event"); 
				instance.description = box.one("#"+instance.namespace + "description");
				instance.participants = box.one('#'+instance.namespace+'add-participants');
				instance.timeInput = box.one(".event-hour input");
				instance.container = box;
				
				instance.setComponents();
			},
			
			setComponents: function(container) {
				var instance = this;
				
				instance.setValidator();
				instance.setFormAction();
				instance.setParticipantsAutoFields();
				instance.setDatepicker();
			},
			
			setValidator: function() {
				var instance = this;
				
				var validatorValues = 
				{
			    	boundingBox: instance.form,
			    	validateOnInput: false,
			    	rules : { }
				};
				
				validatorValues.rules[instance.namespace + 'name'] =  {
					required: true
	        	};
				
				validatorValues.rules[instance.namespace + 'eventDate'] =  {
					required: true,
					date: true
		        };
				
				//time
				validatorValues.rules[instance.namespace] =  {
					required: true
				};
				
				validatorValues.rules[instance.namespace + 'location'] =  {
						required: true
				};
				
				validatorValues.rules[instance.namespace + 'description'] =  {
					required: true
				};
				
			},
			
			setFormAction: function() {
				var instance = this;
				
				instance.form.on('submit', function(e){
					e.preventDefault();
					instance.description.set('value', window[instance.namespace+"editor"].getHTML());
					submitForm(instance.form);
				});
			},
			
			initEditor: function() {
				var instance = this;
				
				Liferay.provide(
					window,
					instance.namespace +'initEditor',
					function() {
						return instance.description.get('value');
					}
				);
			},
			
			setDatepicker: function() {
				var instance = this;
				
				Liferay.component(
					instance.namespace + "eventDatePicker",
					function(){
						var datePicker = new A.DatePicker({
							trigger: '#'+ instance.namespace +'eventDate',
							popover: {
								zIndex: 1
							},
							calendar: {
					        	 minimumDate: new Date(),
					        },
					        on: {
					        	disabledChange: function(e){
					        		console.info('disable');
					        	},
					        	selectionChange: function(e){
					        		var eventDateInput = A.one('#'+ instance.namespace +'eventDate');
									if (eventDateInput.hasClass('error-field') &&  e.newSelection[0] != null) {
										eventDateInput.replaceClass('error-field', 'success-field');
										eventDateInput.get('parentNode').replaceClass('error', 'success');
										eventDateInput.get('parentNode').one('.help-inline .required').set('text', '');
									} 
					        	}
					        }
						});
						
						return datePicker;
					}
				);
				
				Liferay.component(instance.namespace + "eventDatePicker");
			},
			
			setParticipantsAutoFields: function(){
				var instance = this;
				
				new Liferay.AutoFields(
					{
						contentBox: instance.participants,
						fieldIndexes: instance.namespace + 'participantIndexes',
						namespace: instance.namespace
					}
				).render();
			},
			
			container: null,
			form: null,
			description: null,
			participants: null,
			timeInput: null,
			validator: null
			
		};
	},
	'',
	{
		requires: ['aui-base', 'node', 'aui-datepicker', 'aui-calendar', 'aui-form-validator', 
		           'liferay-util-list-fields', 'liferay-auto-fields', 'node-event-simulate']
	}
);