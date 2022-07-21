-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Creato il: Lug 21, 2022 alle 08:53
-- Versione del server: 10.4.21-MariaDB
-- Versione PHP: 7.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `esame_engim`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `articolo`
--

CREATE TABLE `articoli` (
  `Id` int(11) NOT NULL,
  `Codice` varchar(10) DEFAULT NULL,
  `Descrizione` varchar(256) DEFAULT NULL,
  `Peso` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `articolo`
--

INSERT INTO `articoli` (`Id`, `Codice`, `Descrizione`, `Peso`) VALUES
(1, 'PNDRV8', 'Pen drive 8G no brand', 0.15),
(2, 'DCP-J715E', 'Stampante Brother DCP J715 W', 5.3),
(3, 'LNVCX1', 'Notebook Lenovo Carbon X1', 1.9),
(4, 'ALCPPC3', 'Smartphone Alcatel POP C3', 0.53),
(5, 'BSHT1R', 'Ampli Combo valvolare BlackStar HT 1-R', 6);

-- --------------------------------------------------------

--
-- Struttura della tabella `ordine`
--

CREATE TABLE `ordini` (
  `Id` int(11) NOT NULL,
  `Numero` int(3) DEFAULT NULL,
  `Data` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `ordine`
--

INSERT INTO `ordini` (`Id`, `Numero`, `Data`) VALUES
(1, 15, '2022-07-21 10:53:40'),
(2, 3, '2022-07-21 10:53:40'),
(3, 7, '2022-07-21 10:53:40'),
(4, 150, '2022-07-21 10:53:40'),
(5, 8, '2022-07-21 10:53:40'),
(6, 20, '2022-07-21 10:53:40'),
(7, 1, '2022-07-21 10:53:40'),
(8, 3, '2022-07-21 10:53:40'),
(9, 9, '2022-07-21 10:53:40');

-- --------------------------------------------------------

--
-- Struttura della tabella `tariffa_corriere`
--

CREATE TABLE `tariffe_corrieri` (
  `Id` int(11) NOT NULL,
  `nome_corriere` varchar(64) DEFAULT NULL,
  `nome_tariffa` varchar(64) DEFAULT NULL,
  `peso_massimo` float DEFAULT NULL,
  `costo` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `tariffa_corriere`
--

INSERT INTO `tariffe_corrieri` (`Id`, `nome_corriere`, `nome_tariffa`, `peso_massimo`, `costo`) VALUES
(1, 'SDA', 'Economy', 1, 5.9),
(2, 'SDA', 'Veloce', 5, 7.9),
(3, 'SDA', 'Bigbox', 30, 12.9),
(4, 'DHL', 'Veloce', 1.5, 6.5),
(5, 'DHL', 'Assicurata', 7.5, 9.9),
(6, 'DHL', 'XXL', 40, 13.9),
(7, 'UPS', 'Economy', 0.7, 5.2),
(8, 'UPS', 'Standard', 3, 6.9),
(9, 'UPS', 'Jumbo', 25, 11.5);

-- --------------------------------------------------------

--
-- Struttura della tabella `voce`
--

CREATE TABLE `voci` (
  `Id_ordine` int(11) DEFAULT NULL,
  `articolo` int(11) DEFAULT NULL,
  `quantità` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `voce`
--

INSERT INTO `voci` (`Id_ordine`, `articolo`, `quantità`) VALUES
(1, 3, 2),
(2, 2, 1),
(2, 3, 1),
(3, 3, 1),
(3, 4, 1),
(4, 1, 2),
(4, 4, 1),
(5, 4, 2),
(5, 1, 1),
(6, 1, 3),
(7, 2, 7),
(8, 5, 1),
(8, 3, 1),
(9, 5, 6);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `articolo`
--
ALTER TABLE `articoli`
  ADD PRIMARY KEY (`Id`);

--
-- Indici per le tabelle `ordine`
--
ALTER TABLE `ordini`
  ADD PRIMARY KEY (`Id`);

--
-- Indici per le tabelle `tariffa_corriere`
--
ALTER TABLE `tariffe_corrieri`
  ADD PRIMARY KEY (`Id`);

--
-- Indici per le tabelle `voce`
--
ALTER TABLE `voci`
  ADD KEY `fk_voce_ordine` (`Id_ordine`),
  ADD KEY `fk_voce_articolo` (`articolo`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `articolo`
--
ALTER TABLE `articoli`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `ordine`
--
ALTER TABLE `ordini`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT per la tabella `tariffa_corriere`
--
ALTER TABLE `tariffe_corrieri`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `voce`
--
ALTER TABLE `voci`
  ADD CONSTRAINT `fk_voce_articolo` FOREIGN KEY (`articolo`) REFERENCES `articoli` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_voce_ordine` FOREIGN KEY (`Id_ordine`) REFERENCES `ordini` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
