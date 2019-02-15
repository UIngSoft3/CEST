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
(777, 'cambio de valvulas', '2018-12-24', 100000, 001),
(555, 'Revision tecnica', '2019-01-31', 100000, 003),
(999, 'Recarga de 5 extintores', '2018-05-16', 500000, 12),
(888, 'Recarga Extintores', '2018-05-23', 400000, 11);


INSERT INTO elemento VALUES
(1606, 999, 12344541, 'C', 1),
(13, 999, 12344541, 'C', 1),
(2431, 999, 12344541, 'C', 1),
(2020, 888, 9876147, 'B', 2),
(3030, 888, 9876147, 'H', 1),
(9090, 999, 12344541, 'C', 4),
(8080, 999, 12344541, 'C', 3),
(600, 999, 12344541, 'C', 4);


INSERT INTO empresa VALUES
(012, 'Calle 61 # 11 - 29', 'Apaga Fuegos', 4508357),
(001,'Cra 19 # 31', 'PSI extintores', 8809424),
(002,'Cra 20 # 11', 'Extintores manizales', 8804444),
(003,'Cra 14 # 34', 'Seguridad', 8781120),
(011, 'Cra 73A # 2 - 45', 'Fuego y Familia', 2362231),
(010, 'Km 22 via Magdalena', 'Bomberman', 8840001);


INSERT INTO encargado VALUES
(30314336, 'Maria ludivia'),
(1053844347, 'Maria Fernanda'),
(12344541, 'Pepito Perez'),
(9876147, 'Juan Gomez'),
(12345678, 'Anita Velez'),
(1053836293, 'Julian Esteban'),
(1053821139, 'Angelo Osorio'),
(30295043, 'Ana Maria'),
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


INSERT INTO fichatecnica VALUES
('ABC','multiproposito','sirve para apagar incendiosmadera'),
('Solkaflam','multiproposito, polvo quimico','sirve para apagar incendios'),
('BC','multiproposito, agua','sirve para apagar incendioselecctronicos'),
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



INSERT INTO reporte VALUES
(9, NULL, 'Extintor en mal estado', 'Pendiente', '2018-06-09', 'Extintor', 'Sede: Central Bloque: C Piso: 2', 'Si', 'Si'),
(10, NULL, 'malisimo re pesimo', 'Pendiente', '2018-06-09', 'Extintor', 'Sede: Palogrande Bloque: H Piso: 2', 'No', 'Si'),
(11, NULL, 'dwefewr', 'Pendiente', '2018-06-09', 'Botiquin', 'Sede: Central Bloque: A Piso: 1', 'No', 'Si'),
(12, NULL, 'malo', 'Pendiente', '2018-06-18', 'Botiquin', 'Sede: Central Bloque: A Piso: 1', 'Si', 'Si'),
(13, NULL, 'dasd', 'Pendiente', '2018-06-18', 'Botiquin', 'Sede: Central Bloque: C Piso: 2', 'No', 'Si'),
(14, NULL, 'Muy mal estado', 'Pendiente', '2018-07-18', 'Camilla', 'Sede: Central Bloque: B Piso: 2', 'No', 'Si'),
(15, NULL, 'Extintor con mal funcionamiento', 'Pendiente', '2018-08-21', 'Extintor', 'Sede: Central Bloque: B Piso: 2', 'No', 'Si');



INSERT INTO sede VALUES
(1, 'Central'),
(2, 'Palogrande'),
(3, 'Bellas Artes'),
(4, 'Versalles'),
(5, 'Sancancio');



INSERT INTO usuario VALUES
('cest', 'cest'),
('daniel','daniel'),
('luis', 'luis');

