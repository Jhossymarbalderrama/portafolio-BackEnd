SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `backend_portafolio` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `backend_portafolio`;

CREATE TABLE `educacion` (
  `id` bigint(20) NOT NULL,
  `aneos` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  `nombre_establecimiento` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `url_logo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `educacion` (`id`, `aneos`, `descripcion`, `direccion`, `id_usuario`, `nombre_establecimiento`, `titulo`, `url_logo`) VALUES
(352, '2016 - 2017', 'Habilidades para realizar programas o componentes de sistemas de computacion.', 'Leandro Alem 1910, Dock Sud (Avellaneda) - Buenos Aires (ARG).', 1, 'Escuela Secundaria Tecnica Nº1', 'Tecnico en Programación', 'https://firebasestorage.googleapis.com/v0/b/my-portafolio-7abab.appspot.com/o/images-logo-educacion%2Fjhossymarbalderrama_542023_2399.jpg?alt=media&token=a24dbaab-fc1b-4dbb-87c7-6732e4563903'),
(353, '2010 - 2016', 'Flexibilidad en solución de problemas.', 'Leandro Alem 1910, Dock Sud (Avellaneda) - Buenos Aires (ARG).', 1, 'Escuela Secundaria Tecnica Nº1', 'Bachiller en Bienes y Servicios', 'https://firebasestorage.googleapis.com/v0/b/my-portafolio-7abab.appspot.com/o/images-logo-educacion%2Fjhossymarbalderrama_542023_231232.jpg?alt=media&token=28922f4a-21b0-4806-abec-9ed1d93376d7'),
(354, '2020 - 2023', 'Actualmente cursando la ultima materia de la carrera.', 'Av. Mitre 750 (C1870ART) - Buenos Aires (ARG).', 1, 'Universidad Tecnológica Nacional (Avellaneda)', 'Tecnico Universitario en Programación', 'https://firebasestorage.googleapis.com/v0/b/my-portafolio-7abab.appspot.com/o/images-logo-educacion%2Fjhossymarbalderrama_542023_231115.png?alt=media&token=c1b15e97-b674-44b5-bb74-c8e85e2ef736'),
(355, '2021 - 2022', 'Curso Online en udemy', 'www.udemy.com.ar', 1, 'Udemy', 'Master en JavaScript', 'https://firebasestorage.googleapis.com/v0/b/my-portafolio-7abab.appspot.com/o/images-logo-educacion%2Fjhossymarbalderrama_542023_231742.svg?alt=media&token=1f9860bf-1120-4c8a-99c8-c9b3474f43e7'),
(356, '2022 - 2023', 'Desarrollador Full Stack con Framework Angular y Spring Boot.', 'https://argentinaprograma.inti.com.ar/', 1, '#Argentina Programa 4.0', 'Full Stack Developer Jr', 'https://firebasestorage.googleapis.com/v0/b/my-portafolio-7abab.appspot.com/o/images-logo-educacion%2Fjhossymarbalderrama_542023_23155.png?alt=media&token=27c8c9ba-2d2c-48dc-a602-6757d23f41c8');

CREATE TABLE `educacion_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `educacion_seq` (`next_val`) VALUES
(501);

CREATE TABLE `experiencia` (
  `id` bigint(20) NOT NULL,
  `aneos` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  `nombre_empresa` varchar(255) DEFAULT NULL,
  `url_logo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `experiencia` (`id`, `aneos`, `descripcion`, `direccion`, `id_usuario`, `nombre_empresa`, `url_logo`) VALUES
(454, '2017 - 2019', 'Desarrollador en Genexus Ev2, Ev3 y 9', 'Anatole France 123 (Sarandi) - Buenos Aires (ARG).', 1, 'CA VLB s.a', 'https://firebasestorage.googleapis.com/v0/b/my-portafolio-7abab.appspot.com/o/images-logo-experiencia%2Fjhossymarbalderrama_542023_23119.png?alt=media&token=f806a767-52a5-48bd-994a-f35b059e4a83'),
(456, '2017 - 2019', 'Desarrollador Web con Joomla 2.5v - 3.0v', 'Anatole France 123 (Sarandi) - Buenos Aires (ARG).', 1, 'CA VLB s.a', 'https://firebasestorage.googleapis.com/v0/b/my-portafolio-7abab.appspot.com/o/images-logo-experiencia%2Fjhossymarbalderrama_542023_23430.png?alt=media&token=bd1425c3-e1a8-4020-822c-9009a09bef84');

CREATE TABLE `experiencia_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `experiencia_seq` (`next_val`) VALUES
(801);

CREATE TABLE `hard_soft_skills` (
  `id` bigint(20) NOT NULL,
  `detalle` varchar(255) DEFAULT NULL,
  `porcentaje` bigint(20) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `url_imagen` varchar(255) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `hard_soft_skills` (`id`, `detalle`, `porcentaje`, `titulo`, `url_imagen`, `id_usuario`) VALUES
(402, 'Habilidad', 85, 'Angular', NULL, 1),
(403, 'Habilidad', 40, 'Spring Boot', NULL, 1),
(404, 'Habilidad', 50, 'Ruby', NULL, 1),
(405, 'Habilidad', 60, 'Genexus Ev2 - Ev3', NULL, 1),
(406, 'Habilidad', 85, 'Joomla', NULL, 1),
(407, 'Habilidad', 70, 'Git', NULL, 1),
(408, 'Habilidad', 60, 'Java', NULL, 1),
(409, 'Habilidad', 80, 'MySQL', NULL, 1),
(410, 'Habilidad', 80, 'Typescript', NULL, 1),
(411, 'Habilidad', 60, 'Javascript', NULL, 1),
(412, 'Habilidad', 50, 'PHP', NULL, 1),
(413, 'Habilidad', 90, 'Boostrap', NULL, 1);

CREATE TABLE `hard_soft_skills_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `hard_soft_skills_seq` (`next_val`) VALUES
(501);

CREATE TABLE `persona` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `celular` bigint(20) DEFAULT NULL,
  `edad` bigint(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `sobre_mi` varchar(255) DEFAULT NULL,
  `telefono` bigint(20) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `url_banner_perfil` varchar(255) DEFAULT NULL,
  `url_foto_perfil` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `persona` (`id`, `apellido`, `celular`, `edad`, `email`, `nombre`, `sobre_mi`, `telefono`, `titulo`, `url_banner_perfil`, `url_foto_perfil`) VALUES
(1, 'Balderrama Rocha', 1163079082, 25, 'jhossymarbalderrama@gmail.com', 'Jhossymar', 'Mi nombre es Balderrama Rocha Jhossymar, tengo 25 años, soy de Avellaneda (Buenos Aires), actualmente estoy terminando la carrera de Técnico Universitario en Programación en la (UTN) Universidad Tecnológica Nacional de Avellaneda.', 42015260, 'Full Stack Developer Jr', 'https://firebasestorage.googleapis.com/v0/b/my-portafolio-7abab.appspot.com/o/images-banner%2Fjhossymarbalderrama_542023_225637.jpg?alt=media&token=d4a237d4-1eb8-4640-a8ca-4eace5ba1a32', 'https://firebasestorage.googleapis.com/v0/b/my-portafolio-7abab.appspot.com/o/images-perfil%2Fjhossymarbalderrama_542023_225611.jpg?alt=media&token=e019395e-0d37-4f60-8070-ea4e3e8e5098');

CREATE TABLE `persona_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `persona_seq` (`next_val`) VALUES
(101);

CREATE TABLE `proyecto` (
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  `nombre_proyecto` varchar(255) DEFAULT NULL,
  `sistema` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `proyecto` (`id`, `descripcion`, `id_usuario`, `nombre_proyecto`, `sistema`) VALUES
(352, 'Pagina Web dedicada a una Clinica Medica que cuenta con un servicio de Turnos Online.', 1, 'Clinica Online', 'Desarrollado con Angular - Firebase'),
(353, 'Mi Portafolio Web online.', 1, 'Portafolio Web - #ArgentinaPrograma 4.0', 'Desarrollado con Angular y Spring Boot');

CREATE TABLE `proyecto_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `proyecto_seq` (`next_val`) VALUES
(601);

CREATE TABLE `redes_sociales` (
  `id` bigint(20) NOT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `redes_sociales` (`id`, `id_usuario`, `link`, `nombre`) VALUES
(1, 1, 'https://www.linkedin.com/in/balderrama-rocha-jhossymar/', 'Linkedin'),
(2, 1, 'https://www.facebook.com/jhossymar.balderrama/', 'Facebook'),
(3, 1, 'https://github.com/Jhossymarbalderrama', 'GitHub'),
(4, 1, 'https://www.instagram.com/blackjhossy/', 'Instagram');

CREATE TABLE `redes_sociales_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `redes_sociales_seq` (`next_val`) VALUES
(151);

CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `rol_nombre` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `rol_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `rol_seq` (`next_val`) VALUES
(1);

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL,
  `contraseña` varchar(255) DEFAULT NULL,
  `id_persona` bigint(20) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `usuario` (`id`, `contraseña`, `id_persona`, `usuario`) VALUES
(1, 'Jbalderrama123', 1, 'jbalderrama');

CREATE TABLE `usuario_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `usuario_seq` (`next_val`) VALUES
(351);


ALTER TABLE `educacion`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `experiencia`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `hard_soft_skills`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `proyecto`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `redes_sociales`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
