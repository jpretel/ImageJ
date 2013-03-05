create table persona (
	id int not null auto_increment,
	nombres varchar(200),
	apellido_paterno varchar(200),
	apellido_materno varchar(200),
	fecNacimiento date,
	primary key (id)
)

create table tipo_huella(
	id int not null auto_increment,
	descripcion varchar(200),
	primary key (id)
)

create table huella (
	id int not null auto_increment,
	idtipohuella int,
	imagen longblob,
	idpersona int,
	primary key(id),
	key idtipohuella (idtipohuella),
	key idpersona (idpersona),
	foreign key (idtipohuella) references tipo_huella (id),
	foreign key (idpersona) references persona (id)
)

create table tipo_minucia (
	id int not null auto_increment,
	descripcion varchar(200),
	primary key(id)
)

create table minucia (
	id int not null auto_increment,
	idtipominucia int,
	x int,
	y int,
	primary key(id),
	key idtipominucia (idtipominucia),
	foreign key (idtipominucia) references tipo_minucia (id)
)