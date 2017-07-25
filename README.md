# Practical Test for OWNK
## Tools & Requirement
- Maven 3.5.0 installed
- Netbeans 8.2
- Java version: 1.8.0_131, vendor: Oracle Corporation JDK 8
- Tomcat 7
- Spring boot

## Database SQL
```
CREATE DATABASE ownk_test;
CREATE TABLE `Vendedor` (
`idVend` int(15) NOT NULL PRIMARY KEY AUTO_INCREMENT,
`nombres` varchar(50) NOT NULL,
`apellidos` varchar(50) NOT NULL,
`cedula` varchar(30) NOT NULL);

CREATE TABLE `Producto` (
`idProd` int(15) NOT NULL PRIMARY KEY AUTO_INCREMENT,
`codigo` varchar(50) NOT NULL,
`descripcion` varchar(150) NOT NULL,
`idVend` int(15) NOT NULL);

ALTER TABLE `Producto`
ADD CONSTRAINT Vendedor FOREIGN KEY (idVend) REFERENCES Vendedor (idVend)
ON DELETE CASCADE
ON UPDATE CASCADE;

CREATE USER 'userownk'@'localhost' IDENTIFIED BY 'userownk';

```







