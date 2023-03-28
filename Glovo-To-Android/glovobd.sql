-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-03-2023 a las 22:00:37
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `glovobd`
--
CREATE DATABASE IF NOT EXISTS `glovobd` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci;
USE `glovobd`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bebida`
--

CREATE TABLE `bebida` (
  `id_Bebida` int(11) NOT NULL,
  `id_Restaurante` int(2) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Imagen` varchar(255) DEFAULT NULL,
  `Precio` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `bebida`
--

INSERT INTO `bebida` (`id_Bebida`, `id_Restaurante`, `Nombre`, `Imagen`, `Precio`) VALUES
(1, 1, 'Coca-cola', 'https://w7.pngwing.com/pngs/574/913/png-transparent-coca-cola-coca-cola-bottle-glass-bottles.png', '2.99'),
(2, 1, 'Agua mineral', 'https://elfornet.com/media/catalog/product/cache/728587fcd73f36684dd4a1c3c4b36cfb/a/g/agua_sin_gas_01.jpg', '1.99'),
(3, 1, 'Sangría', 'https://images.hola.com/imagenes/cocina/recetas/20200514167988/receta-sangria-clasica/0-823-899/sangria-t.jpg', '4.99'),
(4, 1, 'Vino tinto', 'https://img2.freepng.es/20180525/xfq/kisspng-red-wine-distilled-beverage-pinotage-grape-saffron-5b084bf460bb57.4970590515272703883962.jpg', '22.99'),
(5, 1, 'Cerveza', 'https://www.paulaner.com/content/11-es/1-productos/1-weissbier/modules/1-product_intro-9p648i/bottle-int-1000x1550-hwbn.png', '3.99');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `id_pedido` int(2) NOT NULL,
  `Id_Usuario` int(2) NOT NULL,
  `precio_total` int(5) NOT NULL,
  `fecha` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`id_pedido`, `Id_Usuario`, `precio_total`, `fecha`) VALUES
(1, 1, 3, '27/03/23'),
(9, 1, 17, '27/03/23'),
(10, 1, 24, '27/03/23'),
(11, 1, 0, '27/03/23'),
(12, 1, 23, '27/03/23'),
(13, 1, 32, '27/03/23'),
(14, 1, 17, '28/03/23'),
(15, 1, 13, '28/03/23'),
(16, 1, 9, '28/03/23'),
(17, 1, 9, '28/03/23');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `platos`
--

CREATE TABLE `platos` (
  `id_Plato` int(11) NOT NULL,
  `id_Restaurante` int(2) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Descripcion` varchar(450) NOT NULL,
  `Ingredientes` varchar(450) NOT NULL,
  `Precio` int(3) NOT NULL,
  `Imagen` varchar(450) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `platos`
--

INSERT INTO `platos` (`id_Plato`, `id_Restaurante`, `Nombre`, `Descripcion`, `Ingredientes`, `Precio`, `Imagen`) VALUES
(1, 1, 'Hamburguesa', 'Deliciosa hamburguesa de carne de ternera con lechuga, tomate y queso', 'Carne de ternera, lechuga, tomate, queso, pan de hamburguesa', 8, 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/NCI_Visuals_Food_Hamburger.jpg/640px-NCI_Visuals_Food_Hamburger.jpg'),
(2, 2, 'Ensalada César', 'Ensalada de lechuga romana, pollo a la parrilla, croutones y salsa César', 'Lechuga romana, pollo, croutones, queso parmesano, salsa César', 10, 'https://www.thespruceeats.com/thmb/6EOTZ8FWQvDA1svol9UXqugxUls=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/caesar-salad-recipe-256363-3e0462e398f44032bb7b93abc1ea8b31.jpg'),
(3, 3, 'Pizza Margarita', 'Pizza clásica con salsa de tomate, mozzarella y albahaca fresca', 'Masa de pizza, salsa de tomate, mozzarella, albahaca fresca', 12, 'https://images.hola.com/imagenes/cocina/recetas/20190911149183/pizza-margarita/0-717-935/pizza-m.jpg'),
(4, 4, 'Salmón a la parrilla', 'Salmón a la parrilla con verduras asadas', 'Salmón, pimiento rojo, pimiento verde, cebolla, calabacín, aceite de oliva', 18, 'https://images-gmi-pmc.edge-generalmills.com/33c536a0-9743-4e5b-b867-e4b0d89abab2.jpg'),
(5, 5, 'Pollo Tikka Masala', 'Pollo en una salsa cremosa de especias, servido con arroz basmati', 'Pollo, cebolla, jengibre, ajo, tomate, especias indias, leche de coco, arroz basmati', 15, 'https://entrenosotros.consum.es/public/Image/2021/4/adobestock_255420208.jpg'),
(6, 6, 'Curry de cordero', 'Curry de cordero con arroz pilaf', 'Cordero, cebolla, jengibre, ajo, tomate, especias indias, arroz basmati', 17, 'https://okdiario.com/img/2018/11/28/receta-de-cordero-al-curry.jpg'),
(7, 7, 'Pollo Tandoori', 'Pollo marinado en yogur y especias, asado en horno tandoor', 'Pollo, yogur, especias indias, limón, jengibre, ajo', 16, 'https://cocina-casera.com/wp-content/uploads/2015/03/receta-pollo-tandoori.jpg'),
(8, 8, 'Biryani de verduras', 'Arroz basmati con verduras y especias, servido con raita', 'Arroz basmati, zanahoria, guisantes, cebolla, jengibre, ajo, especias indias, yogur', 13, 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Biryani_Home.jpg/1200px-Biryani_Home.jpg'),
(9, 9, 'Sushi variado', 'Selección de sushi variado', 'Arroz para sushi, alga nori, salmón, atún, aguacate, pepino, zanahoria', 20, 'https://cdn.businessinsider.es/sites/navi.axelspringer.es/public/media/image/2018/02/sushi-alimento.jpg?tf=3840x'),
(10, 10, 'Paella Valenciana', 'Arroz con pollo, conejo, garrofó, tomate y azafrán', 'Arroz, pollo, conejo, garrofó, tomate, azafrán', 16, 'https://imag.bonviveur.com/paella-valenciana-tradicional.jpg'),
(11, 1, 'Gazpacho Andaluz', 'Sopa fría de tomate, pepino, pimiento y ajo', 'Tomate, pepino, pimiento, ajo, aceite de oliva', 9, 'https://www.hogarmania.com/archivos/201905/gazpacho-adaluz-xl-1280x720x80xX.jpg'),
(12, 2, 'Moussaka Griega', 'Plato de berenjenas, carne picada, tomate y bechamel gratinado al horno', 'Berenjena, carne picada, tomate, cebolla, ajo, bechamel', 13, 'https://www.recipetineats.com/wp-content/uploads/2019/03/Greek-Moussaka_3-re-edited-SQ.jpg'),
(13, 3, 'Ensalada Griega', 'Ensalada de lechuga, tomate, pepino, cebolla, aceitunas y queso feta', 'Lechuga, tomate, pepino, cebolla, aceitunas, queso feta', 10, 'https://www.comedera.com/wp-content/uploads/2018/05/ensalada-griega.jpg'),
(14, 4, 'Cuscús Haddad', 'Plato de cuscús con verduras, pasas, garbanzos y cordero', 'Cuscús, cordero, caldo de pollo, cebolla, zanahoria, garbanzos, pasas', 15, 'https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/11937D2D-373D-4581-820F-B3A1B53CD7CE/Derivates/B5CC5239-1E8D-46FC-A379-6A7CE8142121.jpg'),
(15, 5, 'Ramen Misato', 'Fideos salsa miso, carne, sushi', 'Fideos orientales con salsa casera', 20, 'https://www.halfbakedharvest.com/wp-content/uploads/2020/02/30-Minute-Creamy-Sesame-Miso-Ramen-with-Crispy-Mushrooms-1.jpg'),
(16, 6, 'Espagheti minguilingui', 'Pasta al pesto rosso con trufa y salsa de tomate', 'Pasta fresca, tomate natural, trufas de campo', 15, 'https://biancazapatka.com/wp-content/uploads/2017/04/img_9300.jpg'),
(17, 7, 'Falafel', 'Falafel acompañado de ensalada con patatas', 'Falafel de carne rollos de maiz, ensalada de huerta.', 12, 'https://recetasarabes.com/wp-content/img-recetas-arabes/2012/03/falafel-3.jpg'),
(18, 8, 'Maki guacamole', 'Sushi con alga marina, y acompañado de un trozo de guacamole', 'guacamole, arroz, algas marinas, salmon', 5, 'https://www.lafujimama.com/wp-content/uploads/2014/09/Spicy-Cucumber-Guacamole-Sushi-Roll.jpg'),
(19, 9, 'Costillas ', 'Costillas con patatas fritas', 'costillas, patatas, sal, especias', 7, 'https://cdn0.recetasgratis.net/es/posts/1/4/0/costillas_carmensita_38041_orig.jpg'),
(20, 10, 'Curry original', 'curry original de la india', 'arroz, curry, carne', 16, 'https://www.gourmet.cl/wp-content/uploads/2022/08/curry-de-garbanzos-ajustada-web-570x458.jpg'),
(21, 1, 'Asado argentino', 'Asado tipico argentino boca yo te amo lololo', 'carne patatas sal aderezo', 15, 'https://cocina-casera.com/wp-content/uploads/2015/02/asado-argentino-nunca-debes-hacer.jpg'),
(22, 2, 'Durum con patatas dentro', 'Durum kebab mixto con patatas dentro', 'pollo ternera durum patatas salsa yougurth', 6, 'https://canalcocina.es/medias/images/1703Los22MinutosDeJuliusDurumCordero3.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurante`
--

CREATE TABLE `restaurante` (
  `id_Restaurante` int(2) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Tipo` varchar(50) NOT NULL,
  `Ventas` int(99) NOT NULL,
  `Puntuacion` int(10) NOT NULL,
  `Imagen` varchar(535) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `restaurante`
--

INSERT INTO `restaurante` (`id_Restaurante`, `Nombre`, `Tipo`, `Ventas`, `Puntuacion`, `Imagen`) VALUES
(1, 'Pacos', 'Abrasador', 10, 5, 'https://www.noroestemadrid.com/wp-content/uploads/2021/06/ABRASADOR-PACO-PRADO-MADRID-1-002.jpg'),
(2, 'Kebaberia', 'Kebab', 60, 3, 'https://insidezaragoza.com/wp-content/uploads/2022/09/fachada-kebab-miralbueno.png'),
(3, 'Variopinto', 'Pijo', 25, 3, 'https://metro7.es/wp-content/uploads/2020/03/mg_5351_web-385x385.jpg'),
(4, 'Tagliatela', 'Pijo', 40, 4, 'https://res.cloudinary.com/hesvvq3zo/image/upload/v1613038199/0013V00000BTALkQAP/Images__c/1.jpg.jpg'),
(5, 'Takeshi', 'Japones', 75, 5, 'https://images.adsttc.com/media/images/5bf3/5d1c/08a5/e509/1100/014e/newsletter/FEATURE_IMAGE.jpg?1542675707'),
(6, 'Manuel y los hermanos', 'Abrasador', 90, 1, 'https://abrasador.com/wp-content/uploads/2016/02/rio-jerte-salon-2-op.jpg'),
(7, 'Mushashi', 'Japones', 79, 2, 'https://images.adsttc.com/media/images/5b22/d9cf/f197/ccfa/2700/010f/newsletter/06075_140925-002D.jpg?1529010631'),
(8, 'Ankara kebab', 'Kebab', 73, 4, 'https://images.milanuncios.com/api/v1/ma-ad-media-pro/images/1733d0a6-29ee-410c-9dcf-f67616e884ce?rule=hw396_70'),
(9, 'Indidu', 'Indio', 10, 1, 'https://media-cdn.tripadvisor.com/media/photo-s/0f/54/87/17/interior-restaurante.jpg'),
(10, 'Goa', 'Indio', 20, 2, 'https://media-cdn.tripadvisor.com/media/photo-s/18/1a/a5/40/getlstd-property-photo.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Id_Usuario` int(2) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`Id_Usuario`, `Nombre`, `Password`, `Email`) VALUES
(1, 'Alberto', '123', 'albertoblanco@gmail.com'),
(2, 'María', 'abcde12345', 'maria@example.com'),
(3, 'Pedro', 'contraseña456', 'pedro@example.com'),
(4, 'Sofía', '123456', 'sofia@example.com'),
(5, 'Ana', 'contraseña789', 'ana@example.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bebida`
--
ALTER TABLE `bebida`
  ADD PRIMARY KEY (`id_Bebida`),
  ADD KEY `id_Restaurante` (`id_Restaurante`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `Id_Usuario` (`Id_Usuario`);

--
-- Indices de la tabla `platos`
--
ALTER TABLE `platos`
  ADD PRIMARY KEY (`id_Plato`),
  ADD KEY `id_Restaurante` (`id_Restaurante`);

--
-- Indices de la tabla `restaurante`
--
ALTER TABLE `restaurante`
  ADD PRIMARY KEY (`id_Restaurante`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Id_Usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bebida`
--
ALTER TABLE `bebida`
  MODIFY `id_Bebida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `id_pedido` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `platos`
--
ALTER TABLE `platos`
  MODIFY `id_Plato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `restaurante`
--
ALTER TABLE `restaurante`
  MODIFY `id_Restaurante` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `Id_Usuario` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bebida`
--
ALTER TABLE `bebida`
  ADD CONSTRAINT `bebida_ibfk_1` FOREIGN KEY (`id_Restaurante`) REFERENCES `restaurante` (`id_Restaurante`);

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`Id_Usuario`) REFERENCES `usuario` (`Id_Usuario`);

--
-- Filtros para la tabla `platos`
--
ALTER TABLE `platos`
  ADD CONSTRAINT `platos_ibfk_1` FOREIGN KEY (`id_Restaurante`) REFERENCES `restaurante` (`id_Restaurante`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
