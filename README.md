# Practical Test for OWNK
## Tools & Requirement
- Maven 3.5.0 installed
- Netbeans 8.2
- Java version: 1.8.0_131, vendor: Oracle Corporation JDK 8

## Database SQL
```
CREATE DATABASE ownk;
CREATE TABLE `Vendedor` (
  `idVend` int(15) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `cedula` varchar(30) NOT NULL);

CREATE TABLE `Producto` (
  `idProd` int(15) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `codigo` varchar(50) NOT NULL,
  `descripcion` varchar(150) NOT NULL,
  `imagen` varchar(128) NULL);

CREATE TABLE `Detalle` (
  `idDet` int(15) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `idVend` int(15) NOT NULL,
  `idProd` int(15) NOT NULL,
  FOREIGN KEY (idVend) REFERENCES Vendedor(idVend),
  FOREIGN KEY (idProd) REFERENCES Producto(idProd)
);

INSERT INTO Vendedor VALUES (1,'Saúl','Quintero','V14503198');
INSERT INTO Vendedor VALUES (2,'Diana','Pedroza','V18879430');
INSERT INTO Producto VALUES (1,'A001','Reebok Blancas','');
INSERT INTO Producto VALUES (2,'A002','Nike Negras','');
INSERT INTO Detalle VALUES (1,1,1);
INSERT INTO Detalle VALUES (2,2,2);
mysql> SELECT * FROM Vendedor;
+--------+---------+-----------+-----------+
| idVend | nombres | apellidos | cedula    |
+--------+---------+-----------+-----------+
|      1 | Saúl    | Quintero  | V14503198 |
|      2 | Diana   | Pedroza   | V18879430 |
+--------+---------+-----------+-----------+
2 rows in set (0.00 sec)

mysql> SELECT * FROM Producto;
+--------+--------+----------------+--------+
| idProd | codigo | descripcion    | imagen |
+--------+--------+----------------+--------+
|      1 | A001   | Reebok Blancas |        |
|      2 | A002   | Nike Negras    |        |
+--------+--------+----------------+--------+
2 rows in set (0.00 sec)

mysql> SELECT * FROM Detalle;
+-------+--------+--------+
| idDet | idVend | idProd |
+-------+--------+--------+
|     1 |      1 |      1 |
|     2 |      2 |      2 |
+-------+--------+--------+
2 rows in set (0.00 sec)
mysql> SELECT Detalle.idDet,Vendedor.nombres, Producto.descripcion
    -> FROM Detalle
    -> INNER JOIN (Vendedor,Producto)
    -> ON ( Detalle.idVend = Vendedor.idVend AND Detalle.idProd = Producto.idProd);
+----+---------+----------------+
| id | nombres | descripcion    |
+----+---------+----------------+
|  1 | Saúl    | Reebok Blancas |
|  2 | Diana   | Nike Negras    |
+----+---------+----------------+
2 rows in set (0.00 sec)

CREATE USER 'userownk'@'localhost' IDENTIFIED BY 'userownk';
GRANT ALL PRIVILEGES ON ownk.* TO 'userownk'@'localhost';
FLUSH PRIVILEGES;
```







