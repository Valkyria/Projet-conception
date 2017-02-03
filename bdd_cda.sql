
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


CREATE TABLE `bdd_cda`.`annonce` (
  `idAnnonce` int(11) NOT NULL,
  `dateDebutAnnonce` date NOT NULL,
  `dateFinAnnonce` date NOT NULL,
  `nbPlaces` int(11) NOT NULL,
  `idRestaurant` int(11) NOT NULL,
  `idRestaurateur` int(11) NOT NULL,
  `nomAnnonce` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `idCategorie` int(11) NOT NULL,
  `nomCatagorie` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `catégorisation`
--

CREATE TABLE `catégorisation` (
  `idCategorie` int(11) NOT NULL,
  `idRestaurant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idClient` int(11) NOT NULL,
  `idVille` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `creneau`
--

CREATE TABLE `creneau` (
  `idCreneau` int(11) NOT NULL,
  `heureDebutCreneau` time NOT NULL,
  `heureFinCreneau` time NOT NULL,
  `idAnnonce` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `fermeture`
--

CREATE TABLE `fermeture` (
  `idPlageFermeture` int(11) NOT NULL,
  `idRestaurant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `localisation`
--

CREATE TABLE `localisation` (
  `idRestaurant` int(11) NOT NULL,
  `idVille` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `menu`
--

CREATE TABLE `menu` (
  `idMenu` int(11) NOT NULL,
  `prixMenu` double NOT NULL,
  `idReduction` int(11) NOT NULL,
  `nomMenu` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `menu`
--

INSERT INTO `menu` (`idMenu`, `prixMenu`, `idReduction`, `nomMenu`) VALUES
(1, 21.3, 1, '0');

-- --------------------------------------------------------

--
-- Structure de la table `plagefermeture`
--

CREATE TABLE `plagefermeture` (
  `idPlageFermeture` int(11) NOT NULL,
  `débutPlage` varchar(10) NOT NULL,
  `finPlage` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `plat`
--

CREATE TABLE `plat` (
  `idPlat` int(11) NOT NULL,
  `nomPlat` varchar(50) NOT NULL,
  `idMenu` int(11) NOT NULL,
  `idRestaurant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `reduction`
--

CREATE TABLE `reduction` (
  `idReduction` int(11) NOT NULL,
  `dateDebutReduction` date NOT NULL,
  `dateFinReduction` date NOT NULL,
  `pourcentageReduction` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `reduction`
--

INSERT INTO `reduction` (`idReduction`, `dateDebutReduction`, `dateFinReduction`, `pourcentageReduction`) VALUES
(1, '2017-02-08', '2017-02-15', 0.54);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `idReservation` int(11) NOT NULL,
  `dateReservation` date NOT NULL,
  `heureReservation` time DEFAULT NULL,
  `heureReservationE` time DEFAULT NULL,
  `evenementReservation` varchar(50) DEFAULT NULL,
  `idClient` int(11) NOT NULL,
  `idAnnonce` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `restaurant`
--

CREATE TABLE `restaurant` (
  `idRestaurant` int(11) NOT NULL,
  `nomRestaurant` varchar(50) NOT NULL,
  `adresseRestaurant` varchar(100) NOT NULL,
  `telephoneRestaurant` varchar(10) NOT NULL,
  `emailRestaurant` varchar(50) NOT NULL,
  `heureOuvertureRestaurant` time NOT NULL,
  `heureFermetureRestaurant` time NOT NULL,
  `idTpsMoyenRepas` int(11) NOT NULL,
  `idRestaurateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `restaurateur`
--

CREATE TABLE `restaurateur` (
  `idRestaurateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `tpsmoyenrepas`
--

CREATE TABLE `tpsmoyenrepas` (
  `idTpsMoyenRepas` int(11) NOT NULL,
  `dureeRepas` varchar(5) NOT NULL,
  `dureeEvenement` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idUtilisateur` int(11) NOT NULL,
  `nomUtilisateur` varchar(50) NOT NULL,
  `prenomUtilisateur` varchar(50) NOT NULL,
  `telephoneUtilisateur` varchar(10) NOT NULL,
  `adresseUtilisateur` varchar(100) NOT NULL,
  `login` varchar(50) NOT NULL,
  `motdePasse` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtilisateur`, `nomUtilisateur`, `prenomUtilisateur`, `telephoneUtilisateur`, `adresseUtilisateur`, `login`, `motdePasse`) VALUES
(1, 'cedric', 'cedric', '0681813399', '104 rue test', 'mail@mail.com', 'mdp0000'),
(2, 'cedric', 'cedric', '0681813399', '104 rue test', 'mail@mail.com', 'mdp0000'),
(3, 'cedric', 'cedric', '0681813399', '104 rue test', 'mail@mail.com', 'mdp0000'),
(4, 'cedric', 'cedric', '0681813399', '104 rue test', 'mail@mail.com', 'mdp0000'),
(20, 'testJsF', 'testJsF', '0681813399', '104 rue test', 'mail@mail.com', 'mdp0000'),
(21, 'test', 'test', '0681813399', '104 rue test', 'mail@mail.com', 'mdp0000');

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

CREATE TABLE `ville` (
  `idVille` int(11) NOT NULL,
  `nomVille` varchar(100) NOT NULL,
  `codePostal` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD PRIMARY KEY (`idAnnonce`),
  ADD KEY `idRestaurant` (`idRestaurant`),
  ADD KEY `idRestaurateur` (`idRestaurateur`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`idCategorie`);

--
-- Index pour la table `catégorisation`
--
ALTER TABLE `catégorisation`
  ADD PRIMARY KEY (`idCategorie`,`idRestaurant`),
  ADD KEY `idCategorie` (`idCategorie`),
  ADD KEY `idRestaurant` (`idRestaurant`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`),
  ADD KEY `idVille` (`idVille`);

--
-- Index pour la table `creneau`
--
ALTER TABLE `creneau`
  ADD PRIMARY KEY (`idCreneau`),
  ADD KEY `idAnnonce` (`idAnnonce`);

--
-- Index pour la table `fermeture`
--
ALTER TABLE `fermeture`
  ADD PRIMARY KEY (`idPlageFermeture`,`idRestaurant`),
  ADD KEY `idPlageFermeture` (`idPlageFermeture`),
  ADD KEY `idRestaurant_idx` (`idPlageFermeture`,`idRestaurant`),
  ADD KEY `FK_FERMETURE2` (`idRestaurant`);

--
-- Index pour la table `localisation`
--
ALTER TABLE `localisation`
  ADD PRIMARY KEY (`idRestaurant`,`idVille`),
  ADD KEY `idRestaurant` (`idRestaurant`),
  ADD KEY `idVille` (`idVille`);

--
-- Index pour la table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`idMenu`),
  ADD KEY `idReduction` (`idReduction`);

--
-- Index pour la table `plagefermeture`
--
ALTER TABLE `plagefermeture`
  ADD PRIMARY KEY (`idPlageFermeture`);

--
-- Index pour la table `plat`
--
ALTER TABLE `plat`
  ADD PRIMARY KEY (`idPlat`),
  ADD KEY `idMenu` (`idMenu`),
  ADD KEY `idRestaurant` (`idRestaurant`);

--
-- Index pour la table `reduction`
--
ALTER TABLE `reduction`
  ADD PRIMARY KEY (`idReduction`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`idReservation`),
  ADD KEY `idClient` (`idClient`),
  ADD KEY `idAnnonce` (`idAnnonce`);

--
-- Index pour la table `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`idRestaurant`),
  ADD KEY `idTpsMoyenRepas` (`idTpsMoyenRepas`),
  ADD KEY `idRestaurateur` (`idRestaurateur`);

--
-- Index pour la table `restaurateur`
--
ALTER TABLE `restaurateur`
  ADD PRIMARY KEY (`idRestaurateur`);

--
-- Index pour la table `tpsmoyenrepas`
--
ALTER TABLE `tpsmoyenrepas`
  ADD PRIMARY KEY (`idTpsMoyenRepas`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUtilisateur`);

--
-- Index pour la table `ville`
--
ALTER TABLE `ville`
  ADD PRIMARY KEY (`idVille`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `annonce`
--
ALTER TABLE `annonce`
  MODIFY `idAnnonce` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `idCategorie` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `creneau`
--
ALTER TABLE `creneau`
  MODIFY `idCreneau` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `menu`
--
ALTER TABLE `menu`
  MODIFY `idMenu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `plagefermeture`
--
ALTER TABLE `plagefermeture`
  MODIFY `idPlageFermeture` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `plat`
--
ALTER TABLE `plat`
  MODIFY `idPlat` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `reduction`
--
ALTER TABLE `reduction`
  MODIFY `idReduction` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `idReservation` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `idRestaurant` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `restaurateur`
--
ALTER TABLE `restaurateur`
  MODIFY `idRestaurateur` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `tpsmoyenrepas`
--
ALTER TABLE `tpsmoyenrepas`
  MODIFY `idTpsMoyenRepas` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT pour la table `ville`
--
ALTER TABLE `ville`
  MODIFY `idVille` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `FK_RESTAURATEUR` FOREIGN KEY (`idRestaurateur`) REFERENCES `restaurateur` (`idRestaurateur`);

--
-- Contraintes pour la table `catégorisation`
--
ALTER TABLE `catégorisation`
  ADD CONSTRAINT `FK_CATEGORIE1` FOREIGN KEY (`idCategorie`) REFERENCES `categorie` (`idCategorie`),
  ADD CONSTRAINT `FK_CATEGORIE2` FOREIGN KEY (`idRestaurant`) REFERENCES `restaurant` (`idRestaurant`);

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FK_PKCLIENT` FOREIGN KEY (`idClient`) REFERENCES `utilisateur` (`idUtilisateur`),
  ADD CONSTRAINT `FK_VILLE` FOREIGN KEY (`idVille`) REFERENCES `ville` (`idVille`);

--
-- Contraintes pour la table `creneau`
--
ALTER TABLE `creneau`
  ADD CONSTRAINT `FK_ANNONCEBIS` FOREIGN KEY (`idAnnonce`) REFERENCES `annonce` (`idAnnonce`);

--
-- Contraintes pour la table `fermeture`
--
ALTER TABLE `fermeture`
  ADD CONSTRAINT `FK_FERMETURE1` FOREIGN KEY (`idPlageFermeture`) REFERENCES `plagefermeture` (`idPlageFermeture`),
  ADD CONSTRAINT `FK_FERMETURE2` FOREIGN KEY (`idRestaurant`) REFERENCES `restaurant` (`idRestaurant`);

--
-- Contraintes pour la table `localisation`
--
ALTER TABLE `localisation`
  ADD CONSTRAINT `FK_RESTAURANTV` FOREIGN KEY (`idRestaurant`) REFERENCES `restaurant` (`idRestaurant`),
  ADD CONSTRAINT `FK_VILLER` FOREIGN KEY (`idVille`) REFERENCES `ville` (`idVille`);

--
-- Contraintes pour la table `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `FK_REDUCTION` FOREIGN KEY (`idReduction`) REFERENCES `reduction` (`idReduction`);

--
-- Contraintes pour la table `plat`
--
ALTER TABLE `plat`
  ADD CONSTRAINT `FK_MENU` FOREIGN KEY (`idMenu`) REFERENCES `menu` (`idMenu`),
  ADD CONSTRAINT `FK_RESTAURANT` FOREIGN KEY (`idRestaurant`) REFERENCES `restaurant` (`idRestaurant`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FK_ANN` FOREIGN KEY (`idAnnonce`) REFERENCES `annonce` (`idAnnonce`),
  ADD CONSTRAINT `FK_CLIENT` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`);

--
-- Contraintes pour la table `restaurant`
--
ALTER TABLE `restaurant`
  ADD CONSTRAINT `FK_RESTAURATEUR1` FOREIGN KEY (`idRestaurateur`) REFERENCES `restaurateur` (`idRestaurateur`),
  ADD CONSTRAINT `FK_TPSMOYENREPAS` FOREIGN KEY (`idTpsMoyenRepas`) REFERENCES `tpsmoyenrepas` (`idTpsMoyenRepas`);

--
-- Contraintes pour la table `restaurateur`
--
ALTER TABLE `restaurateur`
  ADD CONSTRAINT `FK_PKRESTAURANT` FOREIGN KEY (`idRestaurateur`) REFERENCES `utilisateur` (`idUtilisateur`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
