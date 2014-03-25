create table rivetlogic_event_Event (
	uuid_ VARCHAR(75) null,
	eventId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	name VARCHAR(400) null,
	location STRING null,
	description STRING null,
	eventDate DATE null,
	privateEvent BOOLEAN
);

create table rivetlogic_event_Participant (
	uuid_ VARCHAR(75) null,
	participantId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	eventId LONG,
	fullName VARCHAR(75) null,
	email VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	companyName VARCHAR(75) null,
	status INTEGER
);

create table rivetlogic_event_Token (
	uuid_ VARCHAR(75) null,
	tokenId LONG not null primary key,
	participantId LONG,
	expiredDate DATE null
);