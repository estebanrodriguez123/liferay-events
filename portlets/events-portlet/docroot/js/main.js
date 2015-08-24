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

				instance.form.one("#" + instance.namespace + "startTime").on('blur', function() {
					instance.validator.validateField(instance.namespace + 'endTime');
				});
				instance.form.one("#" + instance.namespace + "endTime").on('blur', function() {
					instance.validator.validateField(instance.namespace + 'startTime');
				});
			},
			getDate : function(form, instance, fieldName) {
				var node = form.one('[name=' + instance.namespace + fieldName + ']');
				var dateValue = null;
				var nodePickerSelection = node.getData().datepickerSelection;
				if(nodePickerSelection) {
					dateValue = nodePickerSelection[0];
					if(dateValue) {
						dateValue.setHours(0,0,0,0);
					}
				}
				return dateValue;
			},
			endDateGreaterThanStartDate : function(form, instance) {
				var startDate = instance.getDate(form, instance, 'eventDate');
				var endDate = instance.getDate(form, instance, 'eventEndDate');
				
				if(!startDate || !endDate) {
					return false;
				}
				
				return startDate <= endDate;
			},
			endTimeGreaterThanStartTime : function(form, instance) {
				var startDate = instance.getDate(form, instance, 'eventDate');
				var endDate = instance.getDate(form, instance, 'eventEndDate');

				if(!startDate || !endDate) {
					return true;
				}
				
				if(startDate.getTime() != endDate.getTime()) {
					return true;
				}
				
				var startAmpm = form.one('[name=' + instance.namespace + 'startAmpm]').val();
				var endAmpm = form.one('[name=' + instance.namespace + 'endAmpm]').val();
				
				var startHour= form.one('[name=' + instance.namespace + 'startHour]').val();
				var endHour = form.one('[name=' + instance.namespace + 'endHour]').val();
				
				var startMinutes = form.one('[name=' + instance.namespace + 'startMin]').val();
				var endMinutes = form.one('[name=' + instance.namespace + 'endMin]').val();
				
				if(startAmpm < endAmpm) {
					return true;
				}
				
				if(endAmpm < startAmpm) {
					return false;
				}
				
				if(startHour < endHour) {
					return true;
				}
				if(startHour > endHour) {
					return false;
				}
				return startMinutes < endMinutes;
			},
			
			setComponents: function(container) {
				var instance = this;
				
				instance.setValidator();
				instance.setFormAction();
				instance.setParticipantsAutoFields();
				instance.setDatepicker('eventDate');
				instance.setDatepicker('eventEndDate');
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
				
				validatorValues.rules[instance.namespace + 'file'] = {
					acceptFiles: '.csv'	
				};
				
				var compareStartEndDates = function(val, fieldNode, ruleValue) {
					return instance.endDateGreaterThanStartDate(form, instance);
				};
				
				var compareStartEndTimes = function(val, fieldNode, ruleValue) {
					return instance.endTimeGreaterThanStartTime(form, instance);
				}

				A.config.FormValidator.RULES.greaterThanStartDate = compareStartEndDates;
				A.config.FormValidator.RULES.lessThanEndDate = compareStartEndDates;

				A.config.FormValidator.RULES.greaterThanStartTime = compareStartEndTimes;
				A.config.FormValidator.RULES.lessThanEndTime = compareStartEndTimes;

				A.config.FormValidator.STRINGS.greaterThanStartDate = Liferay.Language.get('end-date-after-start-date');
				A.config.FormValidator.STRINGS.lessThanEndDate = Liferay.Language.get('start-date-before-start-date');

				A.config.FormValidator.STRINGS.greaterThanStartTime = Liferay.Language.get('end-time-after-start-time');
				A.config.FormValidator.STRINGS.lessThanEndTime = Liferay.Language.get('start-time-before-start-time');

				validatorValues.rules[instance.namespace + 'startTime'] =  {
					lessThanEndTime: true
				};
				validatorValues.rules[instance.namespace + 'endTime'] =  {
					greaterThanStartTime: true
				};
				
				validatorValues.rules[instance.namespace + 'eventDate'] =  {
					required: true,
					lessThanEndDate: true,
					date: true
		        };
				
				validatorValues.rules[instance.namespace + 'eventEndDate'] =  {
					required: true,
					greaterThanStartDate: true,
					date: true
	        	};
				
				
				var form = A.one('#' + instance.namespace + "fm_edit_event");
				if (form != null && form != '' && form != undefined) {
					instance.validator = new A.FormValidator(validatorValues);
					//validator.validate();
				}
				
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
			
			setDatepicker: function(fieldName) {
				var instance = this;
				
				Liferay.component(
					instance.namespace + fieldName + "Picker",
					function(){
						var datePicker = new A.DatePicker({
							trigger: '#'+ instance.namespace + fieldName,
							popover: {
								zIndex: 1
							},
							calendar: {
					        	 minimumDate: new Date(),
					        },
					        after: {
					        	selectionChange: function(e) {
					        		instance.validator.validateField(instance.namespace + 'eventDate');
					        		instance.validator.validateField(instance.namespace + 'eventEndDate');
					        		
					        		instance.validator.validateField(instance.namespace + 'startTime');
					        		instance.validator.validateField(instance.namespace + 'endTime');
					        	}
					        },
					        on: {
					        	disabledChange: function(e){
					        		console.info('disable');
					        	},
					        	selectionChange: function(e) {
					        	}
					        }
						});
						
						return datePicker;
					}
				);
				
				Liferay.component(instance.namespace + fieldName + "Picker");
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