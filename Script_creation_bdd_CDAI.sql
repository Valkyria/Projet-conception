-- Base de données :  `projet_cdai`
--

-- --------------------------------------------------------

--
-- Structure de la table `Annonce`
--

CREATE TABLE `Annonce` (
  `idAnnonce` int(11) NOT NULL,
  `dateDebutAnnonce` date NOT NULL,
  `dateFinAnnonce` date NOT NULL,
  `nbPlaces` int(11) NOT NULL,
  `idRestaurant` int(11) NOT NULL,
  `idRestaurateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Categorie`
--

CREATE TABLE `Categorie` (
  `idCategorie` int(11) NOT NULL,
  `nomCatagorie` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Catégorisation`
--

CREATE TABLE `Catégorisation` (
  `idCategorie` int(11) NOT NULL,
  `idRestaurant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Client`
--

CREATE TABLE `Client` (
  `idClient` int(11) NOT NULL,
  `idVille` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Creneau`
--

CREATE TABLE `Creneau` (
  `idCreneau` int(11) NOT NULL,
  `heureDebutCreneau` time NOT NULL,
  `heureFinCreneau` time NOT NULL,
  `idAnnonce` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Fermeture`
--

CREATE TABLE `Fermeture` (
  `idPlageFermeture` int(11) NOT NULL,
  `idRestaurant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Localisation`
--

CREATE TABLE `Localisation` (
  `idRestaurant` int(11) NOT NULL,
  `idVille` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Menu`
--

CREATE TABLE `Menu` (
  `idMenu` int(11) NOT NULL,
  `prixMenu` double NOT NULL,
  `idReduction` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `PlageFermeture`
--

CREATE TABLE `PlageFermeture` (
  `idPlageFermeture` int(11) NOT NULL,
  `débutPlage` varchar(10) NOT NULL,
  `finPlage` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Plat`
--

CREATE TABLE `Plat` (
  `idPlat` int(11) NOT NULL,
  `nomPlat` varchar(50) NOT NULL,
  `idMenu` int(11) NOT NULL,
  `idRestaurant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Reduction`
--

CREATE TABLE `Reduction` (
  `idReduction` int(11) NOT NULL,
  `dateDebutReduction` date NOT NULL,
  `dateFinReduction` date NOT NULL,
  `pourcentageReduction` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Reservation`
--

CREATE TABLE `Reservation` (
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
-- Structure de la table `Restaurant`
--

CREATE TABLE `Restaurant` (
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
-- Structure de la table `Restaurateur`
--

CREATE TABLE `Restaurateur` (
  `idRestaurateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `TpsMoyenRepas`
--

CREATE TABLE `TpsMoyenRepas` (
  `idTpsMoyenRepas` int(11) NOT NULL,
  `dureeRepas` varchar(5) NOT NULL,
  `dureeEvenement` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Utilisateur`
--

CREATE TABLE `Utilisateur` (
  `idUtilisateur` int(11) NOT NULL,
  `nomUtilisateur` varchar(50) NOT NULL,
  `prenomUtilisateur` varchar(50) NOT NULL,
  `telephoneUtilisateur` varchar(10) NOT NULL,
  `adresseUtilisateur` varchar(100) NOT NULL,
  `login` varchar(50) NOT NULL,
  `motdePasse` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Ville`
--

CREATE TABLE `Ville` (
  `idVille` int(11) NOT NULL,
  `nomVille` varchar(100) NOT NULL,
  `codePostal` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Annonce`
--
ALTER TABLE `Annonce`
  ADD PRIMARY KEY (`idAnnonce`),
  ADD KEY `idRestaurant` (`idRestaurant`),
  ADD KEY `idRestaurateur` (`idRestaurateur`);

--
-- Index pour la table `Categorie`
--
ALTER TABLE `Categorie`
  ADD PRIMARY KEY (`idCategorie`);

--
-- Index pour la table `Catégorisation`
--
ALTER TABLE `Catégorisation`
  ADD PRIMARY KEY (`idCategorie`,`idRestaurant`),
  ADD KEY `idCategorie` (`idCategorie`),
  ADD KEY `idRestaurant` (`idRestaurant`);

--
-- Index pour la table `Client`
--
ALTER TABLE `Client`
  ADD PRIMARY KEY (`idClient`),
  ADD KEY `idVille` (`idVille`);

--
-- Index pour la table `Creneau`
--
ALTER TABLE `Creneau`
  ADD PRIMARY KEY (`idCreneau`),
  ADD KEY `idAnnonce` (`idAnnonce`);

--
-- Index pour la table `Fermeture`
--
ALTER TABLE `Fermeture`
  ADD PRIMARY KEY (`idPlageFermeture`,`idRestaurant`),
  ADD KEY `idPlageFermeture` (`idPlageFermeture`),
  ADD KEY `idRestaurant_idx` (`idPlageFermeture`,`idRestaurant`),
  ADD KEY `FK_FERMETURE2` (`idRestaurant`);

--
-- Index pour la table `Localisation`
--
ALTER TABLE `Localisation`
  ADD PRIMARY KEY (`idRestaurant`,`idVille`),
  ADD KEY `idRestaurant` (`idRestaurant`),
  ADD KEY `idVille` (`idVille`);

--
-- Index pour la table `Menu`
--
ALTER TABLE `Menu`
  ADD PRIMARY KEY (`idMenu`),
  ADD KEY `idReduction` (`idReduction`);

--
-- Index pour la table `PlageFermeture`
--
ALTER TABLE `PlageFermeture`
  ADD PRIMARY KEY (`idPlageFermeture`);

--
-- Index pour la table `Plat`
--
ALTER TABLE `Plat`
  ADD PRIMARY KEY (`idPlat`),
  ADD KEY `idMenu` (`idMenu`),
  ADD KEY `idRestaurant` (`idRestaurant`);

--
-- Index pour la table `Reduction`
--
ALTER TABLE `Reduction`
  ADD PRIMARY KEY (`idReduction`);

--
-- Index pour la table `Reservation`
--
ALTER TABLE `Reservation`
  ADD PRIMARY KEY (`idReservation`),
  ADD KEY `idClient` (`idClient`),
  ADD KEY `idAnnonce` (`idAnnonce`);

--
-- Index pour la table `Restaurant`
--
ALTER TABLE `Restaurant`
  ADD PRIMARY KEY (`idRestaurant`),
  ADD KEY `idTpsMoyenRepas` (`idTpsMoyenRepas`),
  ADD KEY `idRestaurateur` (`idRestaurateur`);

--
-- Index pour la table `Restaurateur`
--
ALTER TABLE `Restaurateur`
  ADD PRIMARY KEY (`idRestaurateur`);

--
-- Index pour la table `TpsMoyenRepas`
--
ALTER TABLE `TpsMoyenRepas`
  ADD PRIMARY KEY (`idTpsMoyenRepas`);

--
-- Index pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD PRIMARY KEY (`idUtilisateur`);

--
-- Index pour la table `Ville`
--
ALTER TABLE `Ville`
  ADD PRIMARY KEY (`idVille`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Annonce`
--
ALTER TABLE `Annonce`
  MODIFY `idAnnonce` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Categorie`
--
ALTER TABLE `Categorie`
  MODIFY `idCategorie` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Client`
--
ALTER TABLE `Client`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Creneau`
--
ALTER TABLE `Creneau`
  MODIFY `idCreneau` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Menu`
--
ALTER TABLE `Menu`
  MODIFY `idMenu` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `PlageFermeture`
--
ALTER TABLE `PlageFermeture`
  MODIFY `idPlageFermeture` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Plat`
--
ALTER TABLE `Plat`
  MODIFY `idPlat` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Reduction`
--
ALTER TABLE `Reduction`
  MODIFY `idReduction` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Reservation`
--
ALTER TABLE `Reservation`
  MODIFY `idReservation` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Restaurant`
--
ALTER TABLE `Restaurant`
  MODIFY `idRestaurant` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Restaurateur`
--
ALTER TABLE `Restaurateur`
  MODIFY `idRestaurateur` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `TpsMoyenRepas`
--
ALTER TABLE `TpsMoyenRepas`
  MODIFY `idTpsMoyenRepas` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  MODIFY `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `Ville`
--
ALTER TABLE `Ville`
  MODIFY `idVille` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Annonce`
--
ALTER TABLE `Annonce`
  ADD CONSTRAINT `FK_RESTAURATEUR` FOREIGN KEY (`idRestaurateur`) REFERENCES `Restaurateur` (`idRestaurateur`);

--
-- Contraintes pour la table `Catégorisation`
--
ALTER TABLE `Catégorisation`
  ADD CONSTRAINT `FK_CATEGORIE1` FOREIGN KEY (`idCategorie`) REFERENCES `Categorie` (`idCategorie`),
  ADD CONSTRAINT `FK_CATEGORIE2` FOREIGN KEY (`idRestaurant`) REFERENCES `Restaurant` (`idRestaurant`);

--
-- Contraintes pour la table `Client`
--
ALTER TABLE `Client`
  ADD CONSTRAINT `FK_PKCLIENT` FOREIGN KEY (`idClient`) REFERENCES `Utilisateur` (`idUtilisateur`),
  ADD CONSTRAINT `FK_VILLE` FOREIGN KEY (`idVille`) REFERENCES `Ville` (`idVille`);

--
-- Contraintes pour la table `Creneau`
--
ALTER TABLE `Creneau`
  ADD CONSTRAINT `FK_ANNONCEBIS` FOREIGN KEY (`idAnnonce`) REFERENCES `Annonce` (`idAnnonce`);

--
-- Contraintes pour la table `Fermeture`
--
ALTER TABLE `Fermeture`
  ADD CONSTRAINT `FK_FERMETURE2` FOREIGN KEY (`idRestaurant`) REFERENCES `Restaurant` (`idRestaurant`),
  ADD CONSTRAINT `FK_FERMETURE1` FOREIGN KEY (`idPlageFermeture`) REFERENCES `PlageFermeture` (`idPlageFermeture`);

--
-- Contraintes pour la table `Localisation`
--
ALTER TABLE `Localisation`
  ADD CONSTRAINT `FK_RESTAURANTV` FOREIGN KEY (`idRestaurant`) REFERENCES `Restaurant` (`idRestaurant`),
  ADD CONSTRAINT `FK_VILLER` FOREIGN KEY (`idVille`) REFERENCES `Ville` (`idVille`);

--
-- Contraintes pour la table `Menu`
--
ALTER TABLE `Menu`
  ADD CONSTRAINT `FK_REDUCTION` FOREIGN KEY (`idReduction`) REFERENCES `Reduction` (`idReduction`);

--
-- Contraintes pour la table `Plat`
--
ALTER TABLE `Plat`
  ADD CONSTRAINT `FK_MENU` FOREIGN KEY (`idMenu`) REFERENCES `Menu` (`idMenu`),
  ADD CONSTRAINT `FK_RESTAURANT` FOREIGN KEY (`idRestaurant`) REFERENCES `Restaurant` (`idRestaurant`);

--
-- Contraintes pour la table `Reservation`
--
ALTER TABLE `Reservation`
  ADD CONSTRAINT `FK_ANN` FOREIGN KEY (`idAnnonce`) REFERENCES `Annonce` (`idAnnonce`),
  ADD CONSTRAINT `FK_CLIENT` FOREIGN KEY (`idClient`) REFERENCES `Client` (`idClient`);

--
-- Contraintes pour la table `Restaurant`
--
ALTER TABLE `Restaurant`
  ADD CONSTRAINT `FK_RESTAURATEUR1` FOREIGN KEY (`idRestaurateur`) REFERENCES `Restaurateur` (`idRestaurateur`),
  ADD CONSTRAINT `FK_TPSMOYENREPAS` FOREIGN KEY (`idTpsMoyenRepas`) REFERENCES `TpsMoyenRepas` (`idTpsMoyenRepas`);

--
-- Contraintes pour la table `Restaurateur`
--
ALTER TABLE `Restaurateur`
  ADD CONSTRAINT `FK_PKRESTAURANT` FOREIGN KEY (`idRestaurateur`) REFERENCES `Utilisateur` (`idUtilisateur`);
