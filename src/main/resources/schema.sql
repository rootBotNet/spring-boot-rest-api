--Person Details Table
create table person_details
(
	id integer not null auto_increment,
	name varchar(255),
	age varchar(255),
    ageCategory varchar(255),
	primary key (id)
);