
drop table usuario;
drop table  sede;
drop table  reporte;
drop table  piso;
drop table  fichatecnica;
drop table  extintor;
drop table  empresa;
drop table  encargado;
drop table  elemento;
drop table  contrato;
drop table  botiquin;
drop table  camilla;
drop table bloque;

CREATE TABLE bloque (
  id_sede int(11) NOT NULL,
  letra varchar(255) NOT NULL,
  nombre varchar(255) DEFAULT NULL,
  sede_id int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
 

CREATE TABLE botiquin (
  idelemento int(11) NOT NULL,
  alcoholantiseptico varchar(255) DEFAULT NULL,
  algodon varchar(255) DEFAULT NULL,
  cantidadesparadrapo int(11) NOT NULL,
  curaestandar varchar(255) DEFAULT NULL,
  esparadrapo varchar(255) DEFAULT NULL,
  fechavencimiento date DEFAULT NULL,
  fechavencimientoesparadrapo date DEFAULT NULL,
  linterna varchar(255) DEFAULT NULL,
  numerorecibdo int(11) NOT NULL,
  parcheocular varchar(255) DEFAULT NULL,
  pito varchar(255) DEFAULT NULL,
  saleshidratantes varchar(255) DEFAULT NULL,
  solucionsalina varchar(255) DEFAULT NULL,
  solucionyodada varchar(255) DEFAULT NULL,
  tapabocas varchar(255) DEFAULT NULL,
  termometro varchar(255) DEFAULT NULL,
  vendaalgodon varchar(255) DEFAULT NULL,
  elemento_id int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
 

 
CREATE TABLE camilla (
  idelemento int(11) NOT NULL,
  elemento_id int(11) DEFAULT NULL,
  tipocamilla varchar(255) DEFAULT NULL,
  encargado int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

 
 
CREATE TABLE contrato (
  numero int(11) NOT NULL,
  descripcion varchar(255) DEFAULT NULL,
  fecha date DEFAULT NULL,
  valor float NOT NULL,
  empresa_nit int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


 
CREATE TABLE elemento (
  id int(11) NOT NULL,
  contrato_numero int(11) DEFAULT NULL,
  encargado_cedula int(11) NOT NULL,
  piso_letra_bloque varchar(255) NOT NULL,
  piso_numero int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
 
 

 
CREATE TABLE empresa (
  nit int(11) NOT NULL,
  direccion varchar(255) DEFAULT NULL,
  nombre varchar(255) DEFAULT NULL,
  telefono int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
 

 
CREATE TABLE encargado (
  cedula int(11) NOT NULL,
  nombre varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
 

 
CREATE TABLE extintor (
  idelemento int(11) NOT NULL,
  caducidadanios varchar(255) NOT NULL,
  estado varchar(255) DEFAULT NULL,
  fechaultimarecarga date DEFAULT NULL,
  fechavencimiento date DEFAULT NULL,
  tamanio varchar(255) DEFAULT NULL,
  elemento_id int(11) DEFAULT NULL,
  fichatecnica_tipo varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


 
CREATE TABLE fichatecnica (
  tipo varchar(255) NOT NULL,
  descripcion varchar(255) DEFAULT NULL,
  componentes varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

 
CREATE TABLE piso (
  letra_bloque varchar(255) NOT NULL,
  numero int(11) NOT NULL,
  bloque_id_sede int(11) DEFAULT NULL,
  bloque_letra varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE reporte (
  id int(11) NOT NULL,
  argumento varchar(255) DEFAULT NULL,
  descripcion varchar(255) DEFAULT NULL,
  estado varchar(255) DEFAULT NULL,
  fechareporte date DEFAULT NULL,
  tipoelemento varchar(255) DEFAULT NULL,
  ubicacion varchar(255) DEFAULT NULL,
  leido varchar(255) DEFAULT NULL,
  notificado varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
 
CREATE TABLE sede (
  id int(11) NOT NULL,
  nombre varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE usuario (
  contrasena varchar(255) NOT NULL,
  usuario varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

ALTER TABLE bloque
  ADD PRIMARY KEY (id_sede,letra),
  ADD KEY FKpnyvsj5fo51dlgkdfe03v5ssd (sede_id);

ALTER TABLE botiquin
  ADD PRIMARY KEY (idelemento),
  ADD KEY FKep51xeikcux9pfunrr99yq8dl (elemento_id);

ALTER TABLE camilla
  ADD PRIMARY KEY (idelemento),
  ADD KEY FK52b3ny3r05t6itste92e31w9p (elemento_id);

ALTER TABLE contrato
  ADD PRIMARY KEY (numero),
  ADD KEY FKpkadjqp9hhdvd1lv468yvh38x (empresa_nit);

ALTER TABLE elemento
  ADD PRIMARY KEY (id),
  ADD KEY FKtrv05yd1likvp556qgys95kd1 (contrato_numero),
  ADD KEY FKehlggjkntopc72xntw4c4332i (encargado_cedula),
  ADD KEY FKt6vd7xm9ha44shqek6xy71ywd (piso_letra_bloque,piso_numero);

ALTER TABLE empresa
  ADD PRIMARY KEY (nit);

ALTER TABLE encargado
  ADD PRIMARY KEY (cedula);

ALTER TABLE extintor
  ADD PRIMARY KEY (idelemento),
  ADD KEY FKh7r7s38d421wi02jibl6q8d9f (elemento_id),
  ADD KEY FKafkv4iwmt8ykwrg0ne5u49ab8 (fichatecnica_tipo);

ALTER TABLE fichatecnica
  ADD PRIMARY KEY (tipo);

ALTER TABLE piso
  ADD PRIMARY KEY (letra_bloque,numero),
  ADD KEY FKbnx8w2pjcsqbtk5ruitlost5l (bloque_id_sede,bloque_letra);
 
ALTER TABLE reporte
  ADD PRIMARY KEY (id);

ALTER TABLE sede
  ADD PRIMARY KEY (id);

ALTER TABLE usuario
  ADD PRIMARY KEY (contrasena);
COMMIT;



insert into usuario values ('user','user');
insert into usuario values ('cest','cest');
insert into usuario values ('luis','luis');


INSERT INTO bloque VALUES
(1, 'C', 'Edificio Central', 1),
(1, 'B', 'Edificio Central', 1),
(1, 'A', 'Edificio Administrativo', 1),
(1, 'D', 'Edificio del Parque', 1),
(1, 'E', 'Edificio Laboratorios', 1),
(1, 'S', 'Edificio Biofilo', 1),
(1, 'U', 'Edificio Bicentenario', 1),
(2, 'H', 'Edificio Palogrande', 2),
(2, 'I', 'Edificio Palogrande', 2),
(2, 'J', 'Edificio Palogrande', 2),
(2, 'O', 'Edificio Palogrande', 2),
(3, 'N', 'Edificio Bellas Artes', 3),
(4, 'K', 'Edificio Ciencias para la Salud', 4),
(4, 'M', 'Edificio Ciencias para la Salud', 4),
(4, 'L', 'Edificio Ciencias para la Salud', 4),
(5, 'F', 'Edificio Ciencias Agropecuarias', 5),
(5, 'G', 'Edificio Ciencias Agropecuarias', 5);

INSERT INTO contrato VALUES
(999, 'Recarga de 5 extintores', '2018-05-16', 500000, 12),
(888, 'Recarga Extintores', '2018-05-23', 400000, 11);

INSERT INTO elemento VALUES
(1606, 999, 1234, 'C', 1),
(13, 999, 1234, 'C', 1),
(2431, 999, 1234, 'C', 1),
(2020, 888, 9876, 'B', 2),
(3030, 888, 9876, 'H', 1),
(9090, 999, 1234, 'C', 4),
(8080, 999, 1234, 'C', 3),
(600, 999, 1234, 'C', 4),
(2000, 999, 1234, 'D', 2);

INSERT INTO empresa VALUES
(12, 'Calle 61 # 11 - 29', 'Apaga Fuegos', 45083),
(11, 'Carrera 73A # 2 - 45', 'Fuego y Familia', 23622),
(10, 'Km 22 via Magdalena', 'Bomberman', 88400);

INSERT INTO encargado VALUES
(1234, 'Pepito Perez'),
(9876, 'Juan Gomez'),
(12345678, 'Anita Velez'),
(10279174, 'Jose Fernando');

INSERT INTO extintor VALUES
(1606, '3', 'Activo', '2018-05-16', '2021-05-16', '10 Libras', 1606, 'ABC'),
(13, '4', 'Baja', '2018-05-21', '2022-05-21', '370 Gramos', 13, 'CO2'),
(2431, '2', 'Mantenimiento', '2018-05-22', '2020-05-22', '15 Libras', 2431, 'ABC'),
(2020, '4', 'Activo', '2018-05-23', '2022-05-23', '20 Libras', 2020, 'CO2'),
(3030, '2', 'Vencido', '2018-05-23', '2020-05-23', '2,5 Litros', 3030, 'ABC'),
(9090, '2', 'Activo', '2018-05-24', '2020-05-24', '15 Libras', 9090, 'ABC'),
(8080, '3', 'Activo', '2018-05-25', '2021-05-25', '150 Litros', 8080, 'ABC'),
(600, '2', 'Activo', '2018-05-28', '2020-05-28', '150 Litros', 600, 'ABC');

INSERT INTO camilla VALUES
(2000, 1234, 'Lona', 2000);

INSERT INTO fichatecnica VALUES
('ABC', 'ABC', NULL),
('CO2', 'Dióxodo de Carbono', NULL);

INSERT INTO piso VALUES
('C', 1, 1, 'C'),
('C', 2, 1, 'C'),
('C', 3, 1, 'C'),
('C', 4, 1, 'C'),
('B', 1, 1, 'B'),
('B', 2, 1, 'B'),
('B', 3, 1, 'B'),
('B', 4, 1, 'B'),
('A', 1, 1, 'A'),
('A', 2, 1, 'A'),
('A', 3, 1, 'A'),
('A', 4, 1, 'A'),
('A', 5, 1, 'A'),
('D', 0, 1, 'D'),
('D', 1, 1, 'D'),
('D', 2, 1, 'D'),
('D', 3, 1, 'D'),
('H', 1, 2, 'H'),
('H', 2, 2, 'H'),
('H', 3, 2, 'H'),
('H', 4, 2, 'H');

INSERT INTO sede VALUES
(1, 'Central'),
(2, 'Palogrande'),
(3, 'Bellas Artes'),
(4, 'Versalles'),
(5, 'Sancancio');



