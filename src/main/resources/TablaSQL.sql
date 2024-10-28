/* Se crea la base de datos */
DROP SCHEMA IF EXISTS practica;
CREATE SCHEMA practica;

/* Se crea un usuario para la base de datos llamado "usuario_practica" */
DROP USER IF EXISTS 'usuario_practica'@'%';
CREATE USER 'usuario_practica'@'%' IDENTIFIED BY 'la_Clave';

/* Se asignan los privilegios sobre la base de datos practica al usuario creado */
GRANT ALL PRIVILEGES ON practica.* TO 'usuario_practica'@'%';
FLUSH PRIVILEGES;

USE practica;

/* Se crea la tabla arbol */
CREATE TABLE arbol (
    id_arbol INT NOT NULL AUTO_INCREMENT,
    nombre_comun VARCHAR(50) NOT NULL,
    tipo_flor VARCHAR(50) NOT NULL,
    dureza_madera INT NOT NULL,
    altura FLOAT NOT NULL,
    ruta_imagen VARCHAR(1024),
    PRIMARY KEY (id_arbol)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

/* Se pueden insertar algunos registros de ejemplo en la tabla arbol */
INSERT INTO arbol (nombre_comun, tipo_flor, dureza_madera, altura, ruta_imagen) VALUES
('Roble', 'Blanca', 800, 20.5, 'https://www.hogarmania.com/archivos/201603/roble01-416x236x80xX-1.jpg'),
('Pino', 'Amarilla', 400, 25.0, 'https://cdn.pixabay.com/photo/2020/03/11/15/34/pine-4922503_1280.jpg'),
('Sauce', 'Verde', 300, 15.0, 'https://upload.wikimedia.org/wikipedia/commons/3/36/Saul_pleureur.jpg'),
('Cerezo', 'Rosa', 600, 10.0, 'https://upload.wikimedia.org/wikipedia/commons/1/10/Cerisier_du_Japon_Prunus_serrulata.jpg'),
('Abeto', 'Blanca', 500, 18.0, 'https://upload.wikimedia.org/wikipedia/commons/8/85/Sapin_lure.jpg');
