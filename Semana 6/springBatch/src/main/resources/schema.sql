DROP TABLE empleado IF EXISTS;

CREATE TABLE empleado (
    empId VARCHAR(20) NOT NULL,
    empNombre VARCHAR(20),
    empDesc VARCHAR(60),
    salario VARCHAR(30)
);