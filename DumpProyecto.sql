CREATE DATABASE  IF NOT EXISTS `proyecto_ucema` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `proyecto_ucema`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: proyecto_ucema
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity` (
  `activity_id` bigint NOT NULL AUTO_INCREMENT,
  `available_capacity` int NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `main_image` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `status` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `activity_profile_id` bigint DEFAULT NULL,
  PRIMARY KEY (`activity_id`),
  KEY `FK90sqy6rf07i77nfiv1dhys63` (`activity_profile_id`),
  CONSTRAINT `FK90sqy6rf07i77nfiv1dhys63` FOREIGN KEY (`activity_profile_id`) REFERENCES `activity_profile` (`activity_profile_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (1,20,'Actividad al aire libre','2023-08-24 09:00:00.000000','¡Descubrí Mendoza Volando! AndusFly es un equipo de pilotos profesionales registrados y avalados por FAVL (Federación Argentina de Vuelo Libre) y brindamos la experiencia única de volar sobre la ciudad de Mendoza a 1650 mtrs disfrutando de hermosas vistas y paisajes de la precordillera. Podés volar con amigos, pareja, familia. Es una actividad divertida y segura','https://media.tacdn.com/media/attractions-splice-spp-674x446/0f/d8/b5/d8.jpg',50000,'PENDING','Parapente Vuelo Biplaza con Instructor + HD',2),(2,20,'Actividad al aire libre','2023-08-01 15:00:00.000000','¡Descubrí Mendoza Volando! AndusFly es un equipo de pilotos profesionales registrados y avalados por FAVL (Federación Argentina de Vuelo Libre) y brindamos la experiencia única de volar sobre la ciudad de Mendoza a 1650 mtrs disfrutando de hermosas vistas y paisajes de la precordillera. Podés volar con amigos, pareja, familia. Es una actividad divertida y segura','https://media.tacdn.com/media/attractions-splice-spp-674x446/0f/d8/b5/d8.jpg',50000,'PENDING','Parapente Vuelo Biplaza con Instructor + HD',2),(3,50,'actividad al aire libre','2023-07-29 10:00:00.000000','Partirá de la ciudad de Córdoba por la Ruta Provincial E55 donde podrá conocer La Calera, la Usina Hidroeléctrica y el Paredón del Dique San Roque, el más antiguo de la provincia. Pasará por Bialet Massé (localidad del departamento de Punilla) y Santa María de Punilla hasta llegar a Cosquín, la Capital Nacional de la música Folclore.Seguirá por Valle Hermoso hasta La Falda, donde recorrerá la clásica Av. Edén, el centro comercial, etc. Atravesará Huerta Grande y Villa Giardino para arribar a Capilla del Monte, al pie del místico cerro Uritorco (considerado uno de los centros energéticos más importantes de la Argentina, al que se le atribuyen bondades místicas y curativas), donde conocerá la original calle techada, el complejo el Zapato, el dique El Cajón, y muchas otras.','https://images.almundo.com/205/image/fetch/c_fill,h_430,w_1150,q_auto:eco/https://images.almundo.com/activities/gl/15808-punilla5.jpg',26874,'PENDING','Excursión de día completo al Valle de Punilla desde Córdoba con guía en ingles',3),(4,50,'actividad al aire libre','2023-08-03 09:00:00.000000','Partirá de la ciudad de Córdoba por la Ruta Provincial E55 donde podrá conocer La Calera, la Usina Hidroeléctrica y el Paredón del Dique San Roque, el más antiguo de la provincia. Pasará por Bialet Massé (localidad del departamento de Punilla) y Santa María de Punilla hasta llegar a Cosquín, la Capital Nacional de la música Folclore.Seguirá por Valle Hermoso hasta La Falda, donde recorrerá la clásica Av. Edén, el centro comercial, etc. Atravesará Huerta Grande y Villa Giardino para arribar a Capilla del Monte, al pie del místico cerro Uritorco (considerado uno de los centros energéticos más importantes de la Argentina, al que se le atribuyen bondades místicas y curativas), donde conocerá la original calle techada, el complejo el Zapato, el dique El Cajón, y muchas otras.','https://images.almundo.com/205/image/fetch/c_fill,h_430,w_1150,q_auto:eco/https://images.almundo.com/activities/gl/15808-punilla5.jpg',26874,'PENDING','Excursión de día completo al Valle de Punilla desde Córdoba con guía en ingles',3),(5,50,'actividad al aire libre','2023-09-14 09:00:00.000000','Partirá de la ciudad de Córdoba por la Ruta Provincial E55 donde podrá conocer La Calera, la Usina Hidroeléctrica y el Paredón del Dique San Roque, el más antiguo de la provincia. Pasará por Bialet Massé (localidad del departamento de Punilla) y Santa María de Punilla hasta llegar a Cosquín, la Capital Nacional de la música Folclore.Seguirá por Valle Hermoso hasta La Falda, donde recorrerá la clásica Av. Edén, el centro comercial, etc. Atravesará Huerta Grande y Villa Giardino para arribar a Capilla del Monte, al pie del místico cerro Uritorco (considerado uno de los centros energéticos más importantes de la Argentina, al que se le atribuyen bondades místicas y curativas), donde conocerá la original calle techada, el complejo el Zapato, el dique El Cajón, y muchas otras.','https://images.almundo.com/205/image/fetch/c_fill,h_430,w_1150,q_auto:eco/https://images.almundo.com/activities/gl/15808-punilla5.jpg',26874,'PENDING','Excursión de día completo al Valle de Punilla desde Córdoba con guía en ingles',3),(6,30,'actividad al aire libre','2023-07-29 11:00:00.000000','Déjate maravillar por todos los colores de Purmamarca. Desde la quebrada de Humahuaca, pasarás por pueblos tradicionales del norte hasta llegar a Purmamarca con su Cerro de los 7 colores y arribar a Abra del Potrerillo donde estás a los 4150 msnm y luego al desierto blando de las Salinas grandes.','https://media.staticontent.com/media/pictures/0d5e5814-70af-442d-9cfc-f20c087b96b7/465x264',18514,'PENDING','Salinas Grandes por Purmamarca con caminata en Los colorados',5),(7,20,'Actividad al aire libre','2023-08-31 09:00:00.000000','¡Descubrí Mendoza Volando! AndusFly es un equipo de pilotos profesionales registrados y avalados por FAVL (Federación Argentina de Vuelo Libre) y brindamos la experiencia única de volar sobre la ciudad de Mendoza a 1650 mtrs disfrutando de hermosas vistas y paisajes de la precordillera. Podés volar con amigos, pareja, familia. Es una actividad divertida y segura','https://media.tacdn.com/media/attractions-splice-spp-674x446/0f/d8/b5/d8.jpg',50000,'PENDING','Parapente Vuelo Biplaza con Instructor + HD',2),(8,50,'actividad al aire libre','2023-07-30 09:00:00.000000','Partirá de la ciudad de Córdoba por la Ruta Provincial E55, pasando por el Monumento a Myriam Stefford, Alta Gracia, Anisacate, La Bolsa y Villa Ciudad de América. Continuará el recorrido cruzando los cuatro ríos afluentes del Lago Los Molinos y las localidades de Potrero de Garay y Los Reartes. Desde allí ascendemos por las Sierras Grandes, atravesando una pintoresca región de bosques de coníferas. Pasará por Villa Berna y arribamos a La Cumbrecita, un pueblito de estilo alpino que tiene la singularidad de ser uno de los pocos pueblos peatonales del mundo.','https://images.almundo.com/205/image/fetch/c_fill,h_430,w_1150,q_auto:eco/https://images.almundo.com/activities/gl/VillaGralBelgrano0.jpg',19759,'PENDING','Córdoba: Tour La Cumbrecita',4),(9,20,'Actividad al aire libre','2023-07-27 09:00:00.000000','¡Descubrí Mendoza Volando! AndusFly es un equipo de pilotos profesionales registrados y avalados por FAVL (Federación Argentina de Vuelo Libre) y brindamos la experiencia única de volar sobre la ciudad de Mendoza a 1650 mtrs disfrutando de hermosas vistas y paisajes de la precordillera. Podés volar con amigos, pareja, familia. Es una actividad divertida y segura','https://media.tacdn.com/media/attractions-splice-spp-674x446/0f/d8/b5/d8.jpg',50000,'PENDING','Parapente Vuelo Biplaza con Instructor + HD',2),(10,30,'actividad al aire libre','2023-07-22 11:00:00.000000','Déjate maravillar por todos los colores de Purmamarca. Desde la quebrada de Humahuaca, pasarás por pueblos tradicionales del norte hasta llegar a Purmamarca con su Cerro de los 7 colores y arribar a Abra del Potrerillo donde estás a los 4150 msnm y luego al desierto blando de las Salinas grandes.','https://media.staticontent.com/media/pictures/0d5e5814-70af-442d-9cfc-f20c087b96b7/465x264',18514,'PENDING','Salinas Grandes por Purmamarca con caminata en Los colorados',5),(11,50,'actividad al aire libre','2023-07-27 09:00:00.000000','Partirá de la ciudad de Córdoba por la Ruta Provincial E55 donde podrá conocer La Calera, la Usina Hidroeléctrica y el Paredón del Dique San Roque, el más antiguo de la provincia. Pasará por Bialet Massé (localidad del departamento de Punilla) y Santa María de Punilla hasta llegar a Cosquín, la Capital Nacional de la música Folclore.Seguirá por Valle Hermoso hasta La Falda, donde recorrerá la clásica Av. Edén, el centro comercial, etc. Atravesará Huerta Grande y Villa Giardino para arribar a Capilla del Monte, al pie del místico cerro Uritorco (considerado uno de los centros energéticos más importantes de la Argentina, al que se le atribuyen bondades místicas y curativas), donde conocerá la original calle techada, el complejo el Zapato, el dique El Cajón, y muchas otras.','https://images.almundo.com/205/image/fetch/c_fill,h_430,w_1150,q_auto:eco/https://images.almundo.com/activities/gl/15808-punilla5.jpg',26874,'PENDING','Excursión de día completo al Valle de Punilla desde Córdoba con guía en ingles',3),(12,70,'actividad al aire libre','2023-07-28 11:00:00.000000','Salta de inicio a fin. Sube a bordo de un cómodo bus y descubre la ciudad de Salta, su historia, atracciones y tradiciones en este tour completo por la ciudad y sus alrededores como San Bernardo y San Lorenzo','https://media.staticontent.com/media/pictures/6879cf2a-31e8-4c5e-a277-1719aa69cd6c/1366x406',11066,'PENDING','City Tour: Salta, San Lorenzo y cerro San Bernardo',6),(13,50,'actividad al aire libre','2023-07-28 09:00:00.000000','Partirá de la ciudad de Córdoba por la Ruta Provincial E55, pasando por el Monumento a Myriam Stefford, Alta Gracia, Anisacate, La Bolsa y Villa Ciudad de América. Continuará el recorrido cruzando los cuatro ríos afluentes del Lago Los Molinos y las localidades de Potrero de Garay y Los Reartes. Desde allí ascendemos por las Sierras Grandes, atravesando una pintoresca región de bosques de coníferas. Pasará por Villa Berna y arribamos a La Cumbrecita, un pueblito de estilo alpino que tiene la singularidad de ser uno de los pocos pueblos peatonales del mundo.','https://images.almundo.com/205/image/fetch/c_fill,h_430,w_1150,q_auto:eco/https://images.almundo.com/activities/gl/VillaGralBelgrano0.jpg',19759,'PENDING','Córdoba: Tour La Cumbrecita',4),(14,30,'actividad al aire libre','2023-07-28 11:00:00.000000','Déjate maravillar por todos los colores de Purmamarca. Desde la quebrada de Humahuaca, pasarás por pueblos tradicionales del norte hasta llegar a Purmamarca con su Cerro de los 7 colores y arribar a Abra del Potrerillo donde estás a los 4150 msnm y luego al desierto blando de las Salinas grandes.','https://media.staticontent.com/media/pictures/0d5e5814-70af-442d-9cfc-f20c087b96b7/465x264',18514,'PENDING','Salinas Grandes por Purmamarca con caminata en Los colorados',5),(15,68,'actividad al aire libre','2023-07-21 17:00:00.000000','Salta de inicio a fin. Sube a bordo de un cómodo bus y descubre la ciudad de Salta, su historia, atracciones y tradiciones en este tour completo por la ciudad y sus alrededores como San Bernardo y San Lorenzo','https://media.staticontent.com/media/pictures/6879cf2a-31e8-4c5e-a277-1719aa69cd6c/1366x406',11066,'PENDING','City Tour: Salta, San Lorenzo y cerro San Bernardo',6),(16,30,'Actividad al aire libre','2023-07-22 11:00:00.000000','Brindamos un servicio personalizado, donde usted es el protagonista de esta aventura. Adaptándonos a sus tiempos y preferencias, para que viva un día perfecto, combinando el paisaje y relax de las Termas de Cacheuta y la adrenalina que nos brinda el Río Mendoza.','https://media.tacdn.com/media/attractions-splice-spp-674x446/09/a2/7a/76.jpg',25000,'PENDING','ParqueTermas De Cacheuta + Rafting Intermedio',1),(17,30,'Actividad al aire libre','2023-07-29 11:00:00.000000','Brindamos un servicio personalizado, donde usted es el protagonista de esta aventura. Adaptándonos a sus tiempos y preferencias, para que viva un día perfecto, combinando el paisaje y relax de las Termas de Cacheuta y la adrenalina que nos brinda el Río Mendoza.','https://media.tacdn.com/media/attractions-splice-spp-674x446/09/a2/7a/76.jpg',25000,'PENDING','ParqueTermas De Cacheuta + Rafting Intermedio',1),(18,20,'Actividad al aire libre','2023-07-27 11:00:00.000000','¡Descubrí Mendoza Volando! AndusFly es un equipo de pilotos profesionales registrados y avalados por FAVL (Federación Argentina de Vuelo Libre) y brindamos la experiencia única de volar sobre la ciudad de Mendoza a 1650 mtrs disfrutando de hermosas vistas y paisajes de la precordillera. Podés volar con amigos, pareja, familia. Es una actividad divertida y segura','https://media.tacdn.com/media/attractions-splice-spp-674x446/0f/d8/b5/d8.jpg',50000,'PENDING','Parapente Vuelo Biplaza con Instructor + HD',2),(19,50,'actividad al aire libre','2023-07-15 10:30:00.000000','Partirá de la ciudad de Córdoba por la Ruta Provincial E55, pasando por el Monumento a Myriam Stefford, Alta Gracia, Anisacate, La Bolsa y Villa Ciudad de América. Continuará el recorrido cruzando los cuatro ríos afluentes del Lago Los Molinos y las localidades de Potrero de Garay y Los Reartes. Desde allí ascendemos por las Sierras Grandes, atravesando una pintoresca región de bosques de coníferas. Pasará por Villa Berna y arribamos a La Cumbrecita, un pueblito de estilo alpino que tiene la singularidad de ser uno de los pocos pueblos peatonales del mundo.','https://images.almundo.com/205/image/fetch/c_fill,h_430,w_1150,q_auto:eco/https://images.almundo.com/activities/gl/VillaGralBelgrano0.jpg',19759,'PENDING','Córdoba: Tour La Cumbrecita',4),(20,29,'Actividad al aire libre','2023-07-15 11:00:00.000000','Brindamos un servicio personalizado, donde usted es el protagonista de esta aventura. Adaptándonos a sus tiempos y preferencias, para que viva un día perfecto, combinando el paisaje y relax de las Termas de Cacheuta y la adrenalina que nos brinda el Río Mendoza.','https://media.tacdn.com/media/attractions-splice-spp-674x446/09/a2/7a/76.jpg',25000,'PENDING','ParqueTermas De Cacheuta + Rafting Intermedio',1),(21,19,'Actividad al aire libre','2023-11-30 09:00:00.000000','¡Descubrí Mendoza Volando! AndusFly es un equipo de pilotos profesionales registrados y avalados por FAVL (Federación Argentina de Vuelo Libre) y brindamos la experiencia única de volar sobre la ciudad de Mendoza a 1650 mtrs disfrutando de hermosas vistas y paisajes de la precordillera. Podés volar con amigos, pareja, familia. Es una actividad divertida y segura','https://media.tacdn.com/media/attractions-splice-spp-674x446/0f/d8/b5/d8.jpg',50000,'PENDING','Parapente Vuelo Biplaza con Instructor + HD',2),(22,69,'actividad al aire libre','2023-07-28 17:00:00.000000','Salta de inicio a fin. Sube a bordo de un cómodo bus y descubre la ciudad de Salta, su historia, atracciones y tradiciones en este tour completo por la ciudad y sus alrededores como San Bernardo y San Lorenzo','https://media.staticontent.com/media/pictures/6879cf2a-31e8-4c5e-a277-1719aa69cd6c/1366x406',11066,'PENDING','City Tour: Salta, San Lorenzo y cerro San Bernardo',6),(23,30,'Actividad al aire libre','2023-07-07 10:00:00.000000','Brindamos un servicio personalizado, donde usted es el protagonista de esta aventura. Adaptándonos a sus tiempos y preferencias, para que viva un día perfecto, combinando el paisaje y relax de las Termas de Cacheuta y la adrenalina que nos brinda el Río Mendoza.','https://media.tacdn.com/media/attractions-splice-spp-674x446/09/a2/7a/76.jpg',25000,'PENDING','ParqueTermas De Cacheuta + Rafting Intermedio',1);
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_profile`
--

DROP TABLE IF EXISTS `activity_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity_profile` (
  `activity_profile_id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `main_image` varchar(255) DEFAULT NULL,
  `max_capacity` int NOT NULL,
  `price` double NOT NULL,
  `status` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`activity_profile_id`),
  KEY `FKactdrcemo7bqbr0dent08rblo` (`user_id`),
  CONSTRAINT `FKactdrcemo7bqbr0dent08rblo` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_profile`
--

LOCK TABLES `activity_profile` WRITE;
/*!40000 ALTER TABLE `activity_profile` DISABLE KEYS */;
INSERT INTO `activity_profile` VALUES (1,'Actividad al aire libre','Brindamos un servicio personalizado, donde usted es el protagonista de esta aventura. Adaptándonos a sus tiempos y preferencias, para que viva un día perfecto, combinando el paisaje y relax de las Termas de Cacheuta y la adrenalina que nos brinda el Río Mendoza.','https://media.tacdn.com/media/attractions-splice-spp-674x446/09/a2/7a/76.jpg',30,25000,'PUBLISHED','ParqueTermas De Cacheuta + Rafting Intermedio',1),(2,'Actividad al aire libre','¡Descubrí Mendoza Volando! AndusFly es un equipo de pilotos profesionales registrados y avalados por FAVL (Federación Argentina de Vuelo Libre) y brindamos la experiencia única de volar sobre la ciudad de Mendoza a 1650 mtrs disfrutando de hermosas vistas y paisajes de la precordillera. Podés volar con amigos, pareja, familia. Es una actividad divertida y segura','https://media.tacdn.com/media/attractions-splice-spp-674x446/0f/d8/b5/d8.jpg',20,50000,'PUBLISHED','Parapente Vuelo Biplaza con Instructor + HD',1),(3,'actividad al aire libre','Partirá de la ciudad de Córdoba por la Ruta Provincial E55 donde podrá conocer La Calera, la Usina Hidroeléctrica y el Paredón del Dique San Roque, el más antiguo de la provincia. Pasará por Bialet Massé (localidad del departamento de Punilla) y Santa María de Punilla hasta llegar a Cosquín, la Capital Nacional de la música Folclore.Seguirá por Valle Hermoso hasta La Falda, donde recorrerá la clásica Av. Edén, el centro comercial, etc. Atravesará Huerta Grande y Villa Giardino para arribar a Capilla del Monte, al pie del místico cerro Uritorco (considerado uno de los centros energéticos más importantes de la Argentina, al que se le atribuyen bondades místicas y curativas), donde conocerá la original calle techada, el complejo el Zapato, el dique El Cajón, y muchas otras.','https://images.almundo.com/205/image/fetch/c_fill,h_430,w_1150,q_auto:eco/https://images.almundo.com/activities/gl/15808-punilla5.jpg',50,26874,'PUBLISHED','Excursión de día completo al Valle de Punilla desde Córdoba con guía en ingles',1),(4,'actividad al aire libre','Partirá de la ciudad de Córdoba por la Ruta Provincial E55, pasando por el Monumento a Myriam Stefford, Alta Gracia, Anisacate, La Bolsa y Villa Ciudad de América. Continuará el recorrido cruzando los cuatro ríos afluentes del Lago Los Molinos y las localidades de Potrero de Garay y Los Reartes. Desde allí ascendemos por las Sierras Grandes, atravesando una pintoresca región de bosques de coníferas. Pasará por Villa Berna y arribamos a La Cumbrecita, un pueblito de estilo alpino que tiene la singularidad de ser uno de los pocos pueblos peatonales del mundo.','https://images.almundo.com/205/image/fetch/c_fill,h_430,w_1150,q_auto:eco/https://images.almundo.com/activities/gl/VillaGralBelgrano0.jpg',50,19759,'PUBLISHED','Córdoba: Tour La Cumbrecita',1),(5,'actividad al aire libre','Déjate maravillar por todos los colores de Purmamarca. Desde la quebrada de Humahuaca, pasarás por pueblos tradicionales del norte hasta llegar a Purmamarca con su Cerro de los 7 colores y arribar a Abra del Potrerillo donde estás a los 4150 msnm y luego al desierto blando de las Salinas grandes.','https://media.staticontent.com/media/pictures/0d5e5814-70af-442d-9cfc-f20c087b96b7/465x264',30,18514,'PUBLISHED','Salinas Grandes por Purmamarca con caminata en Los colorados',1),(6,'actividad al aire libre','Salta de inicio a fin. Sube a bordo de un cómodo bus y descubre la ciudad de Salta, su historia, atracciones y tradiciones en este tour completo por la ciudad y sus alrededores como San Bernardo y San Lorenzo','https://media.staticontent.com/media/pictures/6879cf2a-31e8-4c5e-a277-1719aa69cd6c/1366x406',70,11066,'PUBLISHED','City Tour: Salta, San Lorenzo y cerro San Bernardo',1);
/*!40000 ALTER TABLE `activity_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendee`
--

DROP TABLE IF EXISTS `attendee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendee` (
  `attendee_id` bigint NOT NULL AUTO_INCREMENT,
  `attendee_type` varchar(255) NOT NULL,
  `date_of_birth` date NOT NULL,
  `document_number` varchar(255) DEFAULT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `reservation_id` bigint NOT NULL,
  PRIMARY KEY (`attendee_id`),
  KEY `FK6jwudckoquqrj0tumy4816pqd` (`reservation_id`),
  CONSTRAINT `FK6jwudckoquqrj0tumy4816pqd` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendee`
--

LOCK TABLES `attendee` WRITE;
/*!40000 ALTER TABLE `attendee` DISABLE KEYS */;
INSERT INTO `attendee` VALUES (1,'ADULT','2000-01-28','1111','adulto','1','arg',1),(2,'CHILD','2023-07-27','11111','niño','2','arg',1),(3,'ADULT','2023-07-25','1232131','Juana','Sucasaire','arg',2),(4,'ADULT','2023-07-25','231231','aaaa','aaaa','arg',3),(5,'ADULT','2023-07-14','21312','adulto','2131','31',4);
/*!40000 ALTER TABLE `attendee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `availability`
--

DROP TABLE IF EXISTS `availability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `availability` (
  `availability_id` bigint NOT NULL AUTO_INCREMENT,
  `date_of_week` varchar(255) NOT NULL,
  `hours` varchar(255) NOT NULL,
  `activity_profile_id` bigint DEFAULT NULL,
  PRIMARY KEY (`availability_id`),
  KEY `FK89ppbe450fsi7lrfcem4le0yl` (`activity_profile_id`),
  CONSTRAINT `FK89ppbe450fsi7lrfcem4le0yl` FOREIGN KEY (`activity_profile_id`) REFERENCES `activity_profile` (`activity_profile_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `availability`
--

LOCK TABLES `availability` WRITE;
/*!40000 ALTER TABLE `availability` DISABLE KEYS */;
INSERT INTO `availability` VALUES (1,'FRIDAY','10:00',1),(2,'SATURDAY','11:00',1),(3,'TUESDAY','15:00',2),(4,'THURSDAY','9:00,11:00',2),(5,'MONDAY','9:00',3),(6,'THURSDAY','9:00',3),(7,'SATURDAY','10:00',3),(8,'FRIDAY','9:00',4),(9,'SUNDAY','9:00',4),(10,'SATURDAY','10:30',4),(11,'FRIDAY','11:00',5),(12,'SUNDAY','11:00',5),(13,'SATURDAY','11:00',5),(14,'WEDNESDAY','11:00,17:00',6),(15,'THURSDAY','11:00,17:00',6),(16,'FRIDAY','11:00,17:00',6);
/*!40000 ALTER TABLE `availability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `reservation_id` bigint NOT NULL AUTO_INCREMENT,
  `attendee_count` int NOT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `reservation_date` datetime(6) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `activity_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `telephone_contact` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `FKf56tgucgqr62fno50bpmhdc99` (`activity_id`),
  KEY `FKm4oimk0l1757o9pwavorj6ljg` (`user_id`),
  CONSTRAINT `FKf56tgucgqr62fno50bpmhdc99` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`activity_id`),
  CONSTRAINT `FKm4oimk0l1757o9pwavorj6ljg` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,2,'2023-07-28 16:20:45.099304',22132,'2023-07-21 17:00:00.000000','CONFIRMED',15,2,'1122877103'),(2,1,'2023-07-28 21:16:04.789588',25000,'2023-07-15 11:00:00.000000','CONFIRMED',20,2,'1111'),(3,1,'2023-07-28 21:19:30.468074',50000,'2023-11-30 09:00:00.000000','CONFIRMED',21,2,'1122877103'),(4,1,'2023-07-28 22:56:19.137112',11066,'2023-07-28 17:00:00.000000','CONFIRMED',22,2,'1231321');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `deleted` bit(1) NOT NULL,
  `email` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,_binary '\0','provider@test.com','Provider','test','$2a$10$wFQnPdNB588m2W2A226rgeloKH9rQ5wvCNqAwwQ1ZHbZYiC318RbS','PROVIDER'),(2,_binary '\0','user@test.com','User','Test','$2a$10$gFl4mnwmbJudO0Lvlcph1uA2ujdRj79qdMGul/F2TLszHgx2dS6aa','USER'),(4,_binary '\0','user2@test.com','user2','test','$2a$10$JW0nKC/eFyBr.xPnP37BGu9o1YR9s529jrfTQIPxSbYQdQNhusfUK','USER'),(5,_binary '\0','user3@test.com','user3','test3','$2a$10$jEWPoxtdZWzG19raZXKhKe06o3iMWuBQAa4ZsJ6z33F3VzQ2FbGJq','USER'),(6,_binary '\0','test5@test.com','user 5','test5','$2a$10$ZcBuaKXBF7khTGWBk9UZcOen55TzpbRtpD9HGl/ZwsN7YEwC3BPOW','USER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'proyecto_ucema'
--

--
-- Dumping routines for database 'proyecto_ucema'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-30 21:46:57
