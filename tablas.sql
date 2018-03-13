
CREATE TABLE metodos_pago
(
	metodo_clave         VARCHAR(4) NOT NULL ,
	Nombre_met           VARCHAR(30) NULL ,
CONSTRAINT  metodos_pago_PK PRIMARY KEY (metodo_clave)
);

CREATE TABLE usuarios
(
	usuario_id           int(3) NOT NULL ,
	contrase�a           VARCHAR2(8) NULL ,
	rol                  VARCHAR2(13) NULL ,
CONSTRAINT  usuarios_PK PRIMARY KEY (usuario_id)
);

CREATE TABLE ventas
(
	usuario_id           INT(3) NOT NULL ,
	total                FLOAT NULL ,
	venta_id             CHAR(18) NOT NULL ,
	hora                 DATE NULL ,
	fecha                DATE NULL ,
	metodo_clave         VARCHAR(4) NULL ,
CONSTRAINT  ventas_PK PRIMARY KEY (venta_id),
CONSTRAINT usuarios_ventas FOREIGN KEY (usuario_id) REFERENCES usuarios (usuario_id),
CONSTRAINT metod_ventas FOREIGN KEY (metodo_clave) REFERENCES metodos_pago (metodo_clave) ON DELETE SET NULL
);

CREATE TABLE productos
(
	producto_id          INT(4) NOT NULL ,
	nombre               VARCHAR(30) NULL ,
	precio               FLOAT NULL ,
CONSTRAINT  productos_PK PRIMARY KEY (producto_id)
);

CREATE TABLE ticket
(
	venta_id             CHAR(18) NOT NULL ,
	producto_id          INT(4) NOT NULL ,
CONSTRAINT  ventas_productos_PK PRIMARY KEY (venta_id,producto_id),
CONSTRAINT R_3 FOREIGN KEY (venta_id) REFERENCES ventas (venta_id),
CONSTRAINT R_4 FOREIGN KEY (producto_id) REFERENCES productos (producto_id)
);

CREATE TABLE ingredientes
(
	ingrediente_id       INT(5) NOT NULL ,
	nombre               VARCHAR(30) NULL ,
	cant_disp            FLOAT NULL ,
	fecha_cad            DATE NULL ,
	fecha_ped            DATE NULL ,
	medida							 VARCHAR(5) NULL,
CONSTRAINT  ingredientes_PK PRIMARY KEY (ingrediente_id)
);

CREATE TABLE tam_vasos
(
	clave_tam            CHAR(2) NOT NULL ,
	nombre               VARCHAR(12) NULL ,
	precio               FLOAT NULL ,
CONSTRAINT  tam_vasos_PK PRIMARY KEY (clave_tam)
);

CREATE TABLE recetas
(
	producto_id          INT(4) NOT NULL ,
	ingrediente_id       INT(5) NOT NULL ,
	cant                 FLOAT NULL ,
	clave_tam            CHAR(2) NOT NULL ,
CONSTRAINT  productos_ingredientes_PK PRIMARY KEY (producto_id,ingrediente_id,clave_tam),
CONSTRAINT R_40 FOREIGN KEY (clave_tam) REFERENCES tam_vasos (clave_tam),
CONSTRAINT R_36 FOREIGN KEY (ingrediente_id) REFERENCES ingredientes (ingrediente_id),
CONSTRAINT R_35 FOREIGN KEY (producto_id) REFERENCES productos (producto_id)
);

/* Tabla metodos_pago*/

INSERT INTO metodos_pago VALUES(1, 'Efectivo');
INSERT INTO metodos_pago VALUES(2, 'Tarjeta');

/*Tabla usuarios*/

INSERT INTO usuarios VALUES(1, '123', 'Administrador');
INSERT INTO usuarios VALUES(2, '321', 'Cajero');

/*Tabla ventas*/
/*
INSERT INTO ventas VALUES

/*Tabla ingredientes*/
INSERT INTO ingredientes VALUES(1, 'Cafe', 10000, '2016-12-31', '2016-05-20');
INSERT INTO ingredientes VALUES(2, 'Leche', 10000, '2016-12-31', '2016-05-20');
INSERT INTO ingredientes VALUES(3, 'Jarabe de chololate', 10000, '2016-12-31', '2016-05-20');
INSERT INTO ingredientes VALUES(4, 'Jarabe de chololate blanco', 10000, '2016-12-31', '2016-05-20');
INSERT INTO ingredientes VALUES(5, 'Esencia de te chai', 10000, '2016-12-31', '2016-05-20');
INSERT INTO ingredientes VALUES(6, 'Polvo frapuccino', 10000, '2016-12-31', '2016-05-20');
INSERT INTO ingredientes VALUES(7, 'Jarabe trutas tropicales', 10000, '2016-12-31', '2016-05-20');
INSERT INTO ingredientes VALUES(8, 'Masa de crepa', 10000, '2016-12-31', '2016-05-20');
INSERT INTO ingredientes VALUES(9, 'Nutella', 10000, '2016-12-31', '2016-05-20');
INSERT INTO ingredientes VALUES(10, 'Cajeta', 10000, '2016-12-31', '2016-05-20');
INSERT INTO ingredientes VALUES(11, 'Philadelphia', 10000, '2016-12-31', '2016-05-20');
INSERT INTO ingredientes VALUES(12, 'Mermelada de fresa', 10000, '2016-12-31', '2016-05-20');
INSERT INTO ingredientes VALUES(13, 'Mermelada de zarzamora', 10000, '2016-12-31', '2016-05-20');
INSERT INTO ingredientes VALUES(14, 'Lechera', 10000, '2016-12-31', '2016-05-20');
INSERT INTO ingredientes VALUES(15, 'Queso', 10000, '2016-12-31', '2016-05-20');
INSERT INTO ingredientes VALUES(16, 'Jamon', 10000, '2016-12-31', '2016-05-20');
INSERT INTO ingredientes VALUES(17, 'Champi�ones', 10000, '2016-12-31', '2016-05-20');


/*tabla prooductos*/

INSERT INTO prooductos VALUES(1, 'Crepa nutcaje', 35);
INSERT INTO prooductos VALUES(2, 'Crepa nutelphia', 35);
INSERT INTO prooductos VALUES(3, 'Crepa nutfresa', 35);
INSERT INTO prooductos VALUES(4, 'Crepa nutzarza', 35);
INSERT INTO prooductos VALUES(5, 'Crepa nutchera', 35);
INSERT INTO prooductos VALUES(6, 'Crepa cajelphia', 35);
INSERT INTO prooductos VALUES(7, 'Crepa cajfresa', 35);
INSERT INTO prooductos VALUES(8, 'Crepa cajzarza', 35);
INSERT INTO prooductos VALUES(9, 'Crepa cajchera',35);
INSERT INTO prooductos VALUES(10,'Crepa philafresa',35);
INSERT INTO prooductos VALUES(11, 'Crepa philazarza', 35);
INSERT INTO prooductos VALUES(12, 'Crepa philachera',35);
INSERT INTO prooductos VALUES(13, 'Crepa frezarza', 35);
INSERT INTO prooductos VALUES(14, 'Crepa frechera', 35);
INSERT INTO prooductos VALUES(15, 'Crepa zarzachera', 35);
INSERT INTO prooductos VALUES(16, 'Crepa lechera', 20);
INSERT INTO prooductos VALUES(17, 'Crepa nutella', 20);
INSERT INTO prooductos VALUES(18, 'Crepa cajeta', 20);
INSERT INTO prooductos VALUES(19, 'Crepa philadelphia', 20);
INSERT INTO prooductos VALUES(20, 'Crepa fresa', 20);
INSERT INTO prooductos VALUES(21, 'Crepa zarzamora', 20);
INSERT INTO prooductos VALUES(22, 'Crepa quesomon', 35);
INSERT INTO prooductos VALUES(23, 'Crepa quesochamp', 35);
INSERT INTO prooductos VALUES(24, 'Crepa quesophilia', 35);
INSERT INTO prooductos VALUES(25, 'Crepa jamonchamp', 35);
INSERT INTO prooductos VALUES(26, 'Crepa jamonphi', 35);
INSERT INTO prooductos VALUES(27, 'Crepa champhi', 35);
INSERT INTO prooductos VALUES(28, 'Crepa queso', 20);
INSERT INTO prooductos VALUES(29, 'Crepa jamon', 20);
INSERT INTO prooductos VALUES(30, 'Crepa champi�ones', 20);
INSERT INTO prooductos VALUES(31, 'Americano chico', 18);
INSERT INTO prooductos VALUES(32, 'Americano mediano', 23);
INSERT INTO prooductos VALUES(33, 'Americano grade', 26);
INSERT INTO prooductos VALUES(34, 'Latte chico', 27);
INSERT INTO prooductos VALUES(35, 'Latte mediano', 32);
INSERT INTO prooductos VALUES(36, 'Latte grande',35);
INSERT INTO prooductos VALUES(37, 'Capuccino chico', 27);
INSERT INTO prooductos VALUES(38, 'Capuccino mediano', 32);
INSERT INTO prooductos VALUES(39, 'Capuccino grande', 35);
INSERT INTO prooductos VALUES(40, 'Moka chico', 32);
INSERT INTO prooductos VALUES(41, 'Moka mediano', 37);
INSERT INTO prooductos VALUES(42, 'Moka grande', 40);
INSERT INTO prooductos VALUES(43, 'Moka blanco chico', 32);
INSERT INTO prooductos VALUES(44, 'Moka blanco mediano', 37);
INSERT INTO prooductos VALUES(45, 'Moka blanco grande', 40);
INSERT INTO prooductos VALUES(46, 'Chocolate chico' 28);
INSERT INTO prooductos VALUES(47, 'Chocolate mediano', 33);
INSERT INTO prooductos VALUES(48, 'Chocolate grande', 36);
INSERT INTO prooductos VALUES(49, 'Chocolate blanco chico', 28);
INSERT INTO prooductos VALUES(50, 'Chocolate blanco mediano', 33);
INSERT INTO prooductos VALUES(51, 'Chocolate blanco grande', 36);
INSERT INTO prooductos VALUES(52, 'Te chai chico', 28);
INSERT INTO prooductos VALUES(53, 'Te chai mediano', 33);
INSERT INTO prooductos VALUES(54, 'Te chai grande',36);
INSERT INTO prooductos VALUES(55, 'Expresso chico', 16);
INSERT INTO prooductos VALUES(56, 'Expresso mediano', 18);
INSERT INTO prooductos VALUES(57, 'Expresso grande', 20);
INSERT INTO prooductos VALUES(58, 'Frapuccino chico', 40);
INSERT INTO prooductos VALUES(59, 'Frapuccino mediano', 45);
INSERT INTO prooductos VALUES(60, 'Frapuccino grande', 50);
INSERT INTO prooductos VALUES(61, 'Smoothie chico', 45);
INSERT INTO prooductos VALUES(62, 'Smoothie mediano', 50);
INSERT INTO prooductos VALUES(63, 'Smoothie grande', 55);
INSERT INTO prooductos VALUES(64, 'Te chai helado chico', 28);
INSERT INTO prooductos VALUES(65, 'Te chai helado mediano', 33);
INSERT INTO prooductos VALUES(66, ' Te chai helado grande', 36);
INSERT INTO prooductos VALUES(67, 'Latte frio chico', 27);
INSERT INTO prooductos VALUES(68, 'Latte frio mediano', 32);
INSERT INTO prooductos VALUES(69, 'Latte frio grande', 35);

/* tabla tickets */

/*INSERT INTO ticket VALUES();*/

/*TABLA RECETAS*/
INSERT INTO recetas VALUES(1, 9, 25.0);/*nutella. NUTCAJE*/
INSERT INTO recetas VALUES(1, 10, 25.0);/*cajeta*/
INSERT INTO recetas VALUES(1,8,450.0);/*masa*/

INSERT INTO recetas VALUES(2, 9, 25.0);/*nutella. NUTELPHIA*/
INSERT INTO recetas VALUES(2, 11, 25.0);/*philadelphia*/
INSERT INTO recetas VALUES(2, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(3, 9, 25.0);/*nutella. NUTFRESA*/
INSERT INTO recetas VALUES(3, 12, 25.0);/*mermelada de fresa*/
INSERT INTO recetas VALUES(3, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(4, 9, 25.0);/*nutella. NUTZARZA*/
INSERT INTO recetas VALUES(4, 13, 25.0);/*zarzamora*/
INSERT INTO recetas VALUES(4, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(5, 9, 25.0);/*nutella. NUTCHERA*/
INSERT INTO recetas VALUES(5, 14, 25.0);/*lechera*/
INSERT INTO recetas VALUES(5, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(6, 10, 25.0);/*cajeta. CAJELPHIA*/
INSERT INTO recetas VALUES(6, 11, 25.0);/*philadelphia*/
INSERT INTO recetas VALUES(6, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(7, 10, 25.0);/*cajeta. CAJFRESA*/
INSERT INTO recetas VALUES(7, 12, 25.0);/*fresa*/
INSERT INTO recetas VALUES(7, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(8, 10, 25.0);/*cajeta. CAJZARZA*/
INSERT INTO recetas VALUES(8, 13, 25.0);/*zarzamora*/
INSERT INTO recetas VALUES(8, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(9,10, 25.0);/*cajeta. CAJCHERA*/
INSERT INTO recetas VALUES(9, 14, 25.0);/*lechera*/
INSERT INTO recetas VALUES(9, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(10, 11, 25.0);/*philadelohia. PHILAFRESA*/
INSERT INTO recetas VALUES(10, 12, 25.0);/*fresa*/
INSERT INTO recetas VALUES(10, 8, 25.0);/*masa*/

INSERT INTO recetas VALUES(11, 11, 25.0);/*philadelphia. PHILAZARZA*/
INSERT INTO recetas VALUES(11, 13, 25.0);/*zarzamora*/
INSERT INTO recetas VALUES(11, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(12, 11, 25.0);/*philadelphia. PHILACHERA*/
INSERT INTO recetas VALUES(12, 14, 25.0);/*lechera*/
INSERT INTO recetas VALUES(12, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(13, 12, 25.0);/*fresa. FREZARZA*/
INSERT INTO recetas VALUES(13, 13, 25.0);/*zarzamora*/
INSERT INTO recetas VALUES(13, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(14, 12, 25.0);/*fresa. FRECHERA*/
INSERT INTO recetas VALUES(14, 14, 25.0);/*lechera*/
INSERT INTO recetas VALUES(14, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(15, 13, 25.0);/*zarzamonra. ZARZACHERA*/
INSERT INTO recetas VALUES(15, 14, 25.0);/*lechera*/
INSERT INTO recetas VALUES(15, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(16, 14, 25.0); /*lechera, SOLO LECHERA*/
INSERT INTO recetas VALUES(16, 8, 450.0); /*masa*/

INSERT INTO recetas VALUES(17, 9, 25.0);/*nutella, SOLO NUTELLA*/
INSERT INTO recetas VALUES(17, 8, 450.0);/*Crepa nutella MASA*/

INSERT INTO recetas VALUES(18, 10, 25.0);/*cajeta SOLO CAJETA*/
INSERT INTO recetas VALUES(18, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(19, 11, 25.0);/*philadelphia SOLO PHILADELPHIA*/
INSERT INTO recetas VALUES(19, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(20, 12, 25.0);/*fresa SOLO FRESA*/
INSERT INTO recetas VALUES(20, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(21, 13, 25.0);/*zarzamora SOLO ZARZA*/
INSERT INTO recetas VALUES(21, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(22, 15, 25.0);/*queso. QUESOMON*/
INSERT INTO recetas VALUES(22, 16, 25.0);/*jamon*/
INSERT INTO recetas VALUES(22, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(23, 15, 25.0);/*queso. QUESOCHAMP*/
INSERT INTO recetas VALUES(23, 17, 25.0);/*champi�ones*/
INSERT INTO recetas VALUES(23, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(24, 15, 25.0);/*queso. QUESODELPHIA*/
INSERT INTO recetas VALUES(24, 11, 25.0);/*philadelphia*/
INSERT INTO recetas VALUES(24, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(25, 16, 25.0);/*jamon. JAMONCHAMP.*/
INSERT INTO recetas VALUES(25, 17, 25.0);/*champi�ones*/
INSERT INTO recetas VALUES(25, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(26, 16, 25.0);/*jamon. JAMONDELPHIA*/
INSERT INTO recetas VALUES(26, 11, 25.0);/*philadelphia*/
INSERT INTO recetas VALUES(26, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(27, 17, 25.0);/*champi�on. CHAMPIDELPHIA*/
INSERT INTO recetas VALUES(27, 11, 25.0);/*philadelphia*/
INSERT INTO recetas VALUES(27, 8, 450.0);/*masa*/

INSERT INTO recetas VALUES(28, 15, 25.0);/*queso SOLO QUESO*/
INSERT INTO recetas VALUES(28, 8, 25.0);/*masa*/

INSERT INTO recetas VALUES(29, 16, 30.0);/*jamon SOLO JAMON*/
INSERT INTO recetas VALUES(29, 8, 30.0);/*masa*/

INSERT INTO recetas VALUES(30, 17, 25.5);/*champi�ones SOLO CHAMPI�ON*/
INSERT INTO recetas VALUES(30, 8, 25.5);/*masa*/

INSERT INTO recetas VALUES(31, 1, 50.0);/*cafe. AMERICANO CHICO*/

INSERT INTO recetas VALUES(32, 1, 100.0);/*cafe. AMERICANO MEDIANO*/

INSERT INTO recetas VALUES(33, 1, 150.0);/*cafe. AMERICANO GRANDE*/

INSERT INTO recetas VALUES(34, 1, 50.0, );/*cafe. LATTE CHICO*/
INSERT INTO recetas VALUES(34, 2, 350.0);/*leche*/

INSERT INTO recetas VALUES(35, 1, 100.0);/*cafe. LATTE MEDIANO*/
INSERT INTO recetas VALUES(35, 2, 400.0);/*leche*/

INSERT INTO recetas VALUES(36, 1, 150);/*cafe. LATTE GRANDE*/
INSERT INTO recetas VALUES(36, 2, 500);/*leche*/

INSERT INTO recetas VALUES(37, 1, 50.0, );/*cafe. CAPUCCINO CHICO*/
INSERT INTO recetas VALUES(37, 2, 350.0);/*leche*/

INSERT INTO recetas VALUES(38, 1, 100.0);/*cafe. CAPUCCINO MEDIANO*/
INSERT INTO recetas VALUES(38, 2, 400.0);/*leche*/

INSERT INTO recetas VALUES(39, 1, 150.0);/*cafe. CAPUCCINO GRANDE*/
INSERT INTO recetas VALUES(39, 2, 500.0);/*leche*/

INSERT INTO recetas VALUES(40, 1, 50.0);/*cafe. MOKA CHICO*/
INSERT INTO recetas VALUES(40, 2, 325.0);/*leche*/
INSERT INTO recetas VALUES(40, 3, 25.0);/*chocolate*/

INSERT INTO recetas VALUES(41, 1, 100.0);/*cafe. MOKA MEDIANO*/
INSERT INTO recetas VALUES(41, 2, 350.0);/*leche*/
INSERT INTO recetas VALUES(41, 3, 50.0);/*chocolate*/

INSERT INTO recetas VALUES(42, 1, 100.0);/*cafe. MOKA GRANDE*/
INSERT INTO recetas VALUES(42, 2, 425.0);/*leche*/
INSERT INTO recetas VALUES(42, 3, 75.0);/*chocolate*/

INSERT INTO recetas VALUES(43, 1, 50.0);/*cafe. MOKA BLANCO CHICO*/
INSERT INTO recetas VALUES(43, 2, 325.0);/*leche*/
INSERT INTO recetas VALUES(43, 4, 25.0);/*chocolate blanco*/

INSERT INTO recetas VALUES(44, 1, 100.0);/*cafe. MOKA BLANCO MEDIANO*/
INSERT INTO recetas VALUES(44, 2, 350.0);/*leche*/
INSERT INTO recetas VALUES(44, 4, 50.0);/*chocolate blanco*/

INSERT INTO recetas VALUES(45, 1, 100.0);/*cafe. MOKA BLANCO GRANDE*/
INSERT INTO recetas VALUES(45, 2, 425.0);/*leche*/
INSERT INTO recetas VALUES(45, 4, 75.0);/*chocolate blanco*/

INSERT INTO recetas VALUES(46, 2, 370.0);/*leche. CHOCOLATE CHICO*/
INSERT INTO recetas VALUES(46, 3, 30.0);/*chocolate*/

INSERT INTO recetas VALUES(47, 2, 445.0);/*leche. CHOCOLATE MEDIANO*/
INSERT INTO recetas VALUES(47, 3, 55.0);/*chocolate*/

INSERT INTO recetas VALUES(48, 2, 570.0);/*leche. CHOCOLATE GRANDE*/
INSERT INTO recetas VALUES(48, 3, 80.0);/*chocolate*/

INSERT INTO recetas VALUES(49, 2, 370.0);/*leche. CHOCOLATE BLANCO CHICO*/
INSERT INTO recetas VALUES(49, 4, 30.0);/*chocolate blanco*/

INSERT INTO recetas VALUES(50, 2, 445.0);/*leche. CHOCOLATE BLANCO MEDIANO*/
INSERT INTO recetas VALUES(50, 4, 55.0);/*chocolate blanco*/

INSERT INTO recetas VALUES(51, 2, 570.0);/*leche. CHOCOLATE BLANCO GRANDE*/
INSERT INTO recetas VALUES(51, 4, 80.0);/*chocolate blanco*/

INSERT INTO recetas VALUES(52, 5, 20.0);/*escencia de te chai. TE CHAI CHICO*/
INSERT INTO recetas VALUES(52, 2, 380.0);/*leche*/

INSERT INTO recetas VALUES(53, 5, 40.0);/*escencia de te chai. TE CHAI MEDIANO*/
INSERT INTO recetas VALUES(53, 2, 460.0);/*leche*/

INSERT INTO recetas VALUES(54, 5, 60.0);/*escencia de te chai. TE CHAI GRANDE*/
INSERT INTO recetas VALUES(54, 2, 590.0);/*leche*/

INSERT INTO recetas VALUES(55, 1, 50.0);/*cafe. EXPRESSO CHICO*/

INSERT INTO recetas VALUES(56, 1, 100.0);/*cafe. EXPRESSO MEDIANO*/

INSERT INTO recetas VALUES(57, 1, 150.0);/*cafe. EXPRESSO GRANDE*/

INSERT INTO recetas VALUES(58, 6, 100.0);/*polvo frapuccino, FRAPUCCINO CHICO*/
INSERT INTO recetas VALUES(58, 2, 200.0);/*leche*/

INSERT INTO recetas VALUES(59, 6, 200.0);/*polvo frapuccino, FRAPUCCINO MEDIANO*/
INSERT INTO recetas VALUES(59, 2, 300.0);/*leche*/

INSERT INTO recetas VALUES(60, 6, 350.0);/*polvo frapuccino, FRAPUCCINO GRANDE*/
INSERT INTO recetas VALUES(60, 2, 400.0);/*leche*/

INSERT INTO recetas VALUES(61, 7, 50.0);/*jarabe frutas tropicales. SMOOTHIE CHICO*/

INSERT INTO recetas VALUES(62, 7, 70.0);/*jarabe frutas tropicales. SMOOTHIE MEDIANO*/

INSERT INTO recetas VALUES(63, 7, 90.0);/*jarabe frutas tropicales. SMOOTHIE GRANDE*/

INSERT INTO recetas VALUES(64, 5, 20.0);/*escencia de te chai. TE CHAI HELADO CHICO*/
INSERT INTO recetas VALUES(64, 2, 380.0);/*leche*/

INSERT INTO recetas VALUES(65, 5, 40.0);/*escencia de te chai. TE CHAI HELADO MEDIANO*/
INSERT INTO recetas VALUES(65, 2, 460.0);/*leche*/

INSERT INTO recetas VALUES(66, 5, 60.0);/*escencia de te chai. TE CHAI HELADO GRANDE*/
INSERT INTO recetas VALUES(66, 2, 590.0);/*leche*/

INSERT INTO recetas VALUES(67, 1, 50.0, );/*cafe. LATTE HELADO CHICO*/
INSERT INTO recetas VALUES(67, 2, 350.0);/*leche*/

INSERT INTO recetas VALUES(68, 1, 100.0);/*cafe. LATTE HELADO MEDIANO*/
INSERT INTO recetas VALUES(68, 2, 400.0);/*leche*/

INSERT INTO recetas VALUES(69, 1, 150);/*cafe. LATTE HELADO GRANDE*/
INSERT INTO recetas VALUES(69, 2, 500);/*leche*/
