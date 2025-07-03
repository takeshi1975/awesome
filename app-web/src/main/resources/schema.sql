CREATE TABLE CLIENTS (
  id NUMBER PRIMARY KEY,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  telephone VARCHAR(30) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE ADDRESS (
  id NUMBER PRIMARY KEY,
  street VARCHAR(200) NOT NULL,
  postcode VARCHAR(5) NOT NULL,
  city VARCHAR(100) NOT NULL,
  country VARCHAR(100)
);

CREATE TABLE ORDERS (
  order_number VARCHAR(50) UNIQUE PRIMARY KEY,
  client_id NUMBER NOT NULL,
  address_id NUMBER NOT NULL,
  pilotes NUMBER,
  order_total DOUBLE,
  creation_date DATETIME NOT NULL,
  FOREIGN KEY (client_id) REFERENCES CLIENTS(id),
  FOREIGN KEY (address_id) REFERENCES ADDRESS(id)
);

INSERT INTO CLIENTS (id, first_name, last_name, telephone, email) 
VALUES (1, 'María', 'Gómez', '+34611223344', 'maria.gomez@yahoo.com');

INSERT INTO CLIENTS (id, first_name, last_name, telephone, email) 
VALUES (2, 'Carlos', 'Rodríguez', '+34987654321', 'carlos.rodriguez@google.com');

INSERT INTO CLIENTS (id, first_name, last_name, telephone, email) 
VALUES (3, 'Ana', 'López', '+34765432198', 'ana.lopez@example.com');

INSERT INTO CLIENTS (id, first_name, last_name, telephone, email) 
VALUES (4, 'Javier', 'Martínez', '+34123456789', 'javier.martinez@bde.com');

INSERT INTO CLIENTS (id, first_name, last_name, telephone, email) 
VALUES (5, 'Paco', 'Sánchez', '+34567891234', 'lucia.sanchez@vodafone.com');

INSERT INTO ADDRESS (id, street, postcode, city, country)	
	VALUES (1, 'Calle Mayor 1', '28001', 'Madrid', 'Spain');	
INSERT INTO ADDRESS (id, street, postcode, city, country)
    VALUES (2, 'Avenida Diagonal 123', '08008', 'Barcelona', 'Spain');
INSERT INTO ADDRESS (id, street, postcode, city, country)
    VALUES (3, 'Calle Gran Vía 45', '28013', 'Madrid', 'Spain');
INSERT INTO ADDRESS (id, street, postcode, city, country)	
    	VALUES (4, 'Calle de la Princesa 10', '28008', 'Madrid', 'Spain');
INSERT INTO ADDRESS (id, street, postcode, city, country)
    VALUES (5, 'Calle de Serrano 50', '28006', 'Madrid', 'Spain');
INSERT INTO ADDRESS (id, street, postcode, city, country)	
    VALUES (6, 'Avd Gabriel Alomar', '07015', 'Palma de Mallorca', 'Spain');       	
    	    	
    	
    	
    	
    	
    	
    	
