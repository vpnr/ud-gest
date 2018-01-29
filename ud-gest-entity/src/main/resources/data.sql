insert into mandat (libelle_mandat) values ("secrétaire de syndicat");
insert into mandat (libelle_mandat) values ("trésorier de syndicat");
insert into mandat (libelle_mandat) values ("secrétaire de syndicat adjoint");
insert into mandat (libelle_mandat) values ("trésorier de syndicat adjoint");
insert into mandat (libelle_mandat) values ("archiviste de syndicat");
insert into mandat (libelle_mandat) values ("membre du conseil de syndicat");
insert into mandat (libelle_mandat) values ("membre du bureau de syndicat");
insert into mandat (libelle_mandat) values ("secrétaire de groupement");
insert into mandat (libelle_mandat) values ("trésorier de groupement");
insert into mandat (libelle_mandat) values ("secrétaire de groupement adjoint");
insert into mandat (libelle_mandat) values ("trésorier de groupement adjoint");
insert into mandat (libelle_mandat) values ("archiviste de groupement");
insert into mandat (libelle_mandat) values ("membre du conseil de groupement");
insert into mandat (libelle_mandat) values ("membre du bureau de groupement");
insert into mandat (libelle_mandat) values ("secrétaire de section");
insert into mandat (libelle_mandat) values ("trésorier de section");
insert into mandat (libelle_mandat) values ("secrétaire de section adjoint");
insert into mandat (libelle_mandat) values ("trésorier de section adjoint");
insert into mandat (libelle_mandat) values ("archiviste de section");
insert into mandat (libelle_mandat) values ("membre du conseil de section");
insert into mandat (libelle_mandat) values ("membre du bureau de section");
insert into mandat (libelle_mandat) values ("secrétaire UD");
insert into mandat (libelle_mandat) values ("trésorier UD");
insert into mandat (libelle_mandat) values ("secrétaire UD adjoint");
insert into mandat (libelle_mandat) values ("trésorier UD adjoint");
insert into mandat (libelle_mandat) values ("membre du bureau UD");
insert into mandat (libelle_mandat) values ("membre CA UD");
insert into mandat (libelle_mandat) values ("secrétaire de federation");
insert into mandat (libelle_mandat) values ("trésorier de federation");
insert into mandat (libelle_mandat) values ("secrétaire de federation adjoint");
insert into mandat (libelle_mandat) values ("trésorier de federation adjoint");
insert into mandat (libelle_mandat) values ("membre de la commission exécutive de le federation");
insert into mandat (libelle_mandat) values ("membre du bureau de la fédération");
insert into mandat (libelle_mandat) values ("secrétaire du CE");
insert into mandat (libelle_mandat) values ("trésorier du CE");
insert into mandat (libelle_mandat) values ("secrétaire du CE adjoint");
insert into mandat (libelle_mandat) values ("trésorier du CE adjoint");
insert into mandat (libelle_mandat) values ("secrétaire du CHSCT");
insert into mandat (libelle_mandat) values ("délégué syndical");
insert into mandat (libelle_mandat) values ("représentant syndical au CE");
insert into mandat (libelle_mandat) values ("représentant syndical au CHSCT");
insert into mandat (libelle_mandat) values ("membre du CE");
insert into mandat (libelle_mandat) values ("membre du CE suppléant");
insert into mandat (libelle_mandat) values ("membre du CHSCT");
insert into mandat (libelle_mandat) values ("délégué du personnel");
insert into mandat (libelle_mandat) values ("délégué du personnel suppléant");
insert into mandat (libelle_mandat) values ("représentant syndical central");
insert into mandat (libelle_mandat) values ("délégué syndical central");
insert into mandat (libelle_mandat) values ("secrétaire de branche");
insert into mandat (libelle_mandat) values ("membre CPNEFP");

insert into federation (libelle_federation, numero_rue, libelle_rue, tel_federation, fax_federation, mail_federation) values("FO Pharmacie", "7", "passage tenaille", "0140528560", "0140528561", "fopharma@wanadoo.fr");
insert into federation (libelle_federation, numero_rue, libelle_rue, tel_federation, fax_federation, mail_federation) values("FO batiment", "102", "micile fix", "0145854525", "0146525412", "fochantier@gmail.fr");
insert into federation (libelle_federation, numero_rue, libelle_rue, tel_federation, fax_federation, mail_federation) values("FO Cheminot", "4", "allee de la boissiere", "0145854578", "0143621549", "focheminot@wanadoo.fr");
insert into federation (libelle_federation, numero_rue, libelle_rue, tel_federation, fax_federation, mail_federation) values("FO Textile", "12", "impasse de la raie", "0196989591", "0121545487", "foapoil@wanadoo.fr");

insert into branche (libelle_branche, id_federation_branche) values ("Construction", 2);
insert into branche (libelle_branche, id_federation_branche) values ("Labo", 1);
insert into branche (libelle_branche, id_federation_branche) values ("Officine", 1);
insert into branche (libelle_branche, id_federation_branche) values ("Livreur", 1);

insert into ud (libelle_ud, numero_rue, libelle_rue, cp_ud, ville_ud, tel_ud, fax_ud, mail_ud, siteweb_ud) values ("ud78", "5", "rue de verdun", "94563", "villejuif", "0145454542", "0145785221", "ud78@yahoo.fr", null);
insert into ud (libelle_ud, numero_rue, libelle_rue, cp_ud, ville_ud, tel_ud, fax_ud, mail_ud, siteweb_ud) values ("ud85", "1", "rue de tunis", "95000", "cergy pontoise", "0145877896", "0215469632", "ud85@yahoo.fr", null);
insert into ud (libelle_ud, numero_rue, libelle_rue, cp_ud, ville_ud, tel_ud, fax_ud, mail_ud, siteweb_ud) values ("ud92", "9", "boulevard voltaire", "92350", "le plessis robinson",  "0149969696", "0145656985", "ud92@yahoo.fr", null);
insert into ud (libelle_ud, numero_rue, libelle_rue, cp_ud, ville_ud, tel_ud, fax_ud, mail_ud, siteweb_ud) values ("ud12", "77", "rue de la liberte", "91140", "mante la jolie", "0836656565", "0145487878", "ud12@yahoo.fr", null);

insert into entreprise (libelle_entreprise, numero_rue, libelle_rue, cp_entreprise, ville_entreprise, tel_entreprise, fax_entreprise, mail_entreprise, date_election) values ("OCP", "5", "avenue galile", "06125", "nice", "0150454210", "0150421050", "ocp@gmail.com", "2016-01-16");
insert into entreprise (libelle_entreprise, numero_rue, libelle_rue, cp_entreprise, ville_entreprise, tel_entreprise, fax_entreprise, mail_entreprise, date_election) values ("Afcepf", "3", "rue danton", "36654", "toulon", "0112455201", "0145523550", "afcepf@afcepf.fr", "2016-11-15");
insert into entreprise (libelle_entreprise, numero_rue, libelle_rue, cp_entreprise, ville_entreprise, tel_entreprise, fax_entreprise, mail_entreprise, date_election) values ("A2RT", "22", "avenue aristid briand", "92400", "sèvres", "0145401010", "0145478585", "a2rt@msn.com", "2016-12-10");
insert into entreprise (libelle_entreprise, numero_rue, libelle_rue, cp_entreprise, ville_entreprise, tel_entreprise, fax_entreprise, mail_entreprise, date_election) values ("Cerp", "12", "avenue du general de gaule", "92100", "boulogne", "0145454545", "0145454546", "lacerp@gmail.com", "2016-02-23");
insert into entreprise (libelle_entreprise, numero_rue, libelle_rue, cp_entreprise, ville_entreprise, tel_entreprise, fax_entreprise, mail_entreprise, date_election) values ("OCP", "5", "avenue galile", "0150454210", "75001", "paris", "0150421050", "ocp@gmail.com", "2016-01-16");
insert into entreprise (libelle_entreprise, numero_rue, libelle_rue, cp_entreprise, ville_entreprise, tel_entreprise, fax_entreprise, mail_entreprise, date_election) values ("Afcepf", "3", "rue danton", "0112455201", "36542", "strasbourg", "0145523550", "afcepf@afcepf.fr", "2016-11-15");
insert into entreprise (libelle_entreprise, numero_rue, libelle_rue, cp_entreprise, ville_entreprise, tel_entreprise, fax_entreprise, mail_entreprise, date_election) values ("A2RT", "22", "avenue aristid briand", "91254", "bagneux", "0145401010", "0145478585", "a2rt@msn.com", "2016-12-10");
insert into entreprise (libelle_entreprise, numero_rue, libelle_rue, cp_entreprise, ville_entreprise, tel_entreprise, fax_entreprise, mail_entreprise, date_election) values ("Cerp", "12", "avenue du general de gaule", "92150", "fontenay aux roses", "0145454545", "0145454546", "lacerp@gmail.com", "2016-02-23");

insert into syndicat (libelle_syndicat, numero_rue, libelle_rue, cp_syndicat, ville_syndicat, tel_syndicat, fax_syndicat, mail_syndicat, dernier_ag, prochain_ag, id_federation_syndicat, id_branche_syndicat, id_ud_syndicat) values ("FO78",  "78", "rue du moulin", "12458", "nantes", "0145859696", "0112131313", "fo@gmail.com", "2016-02-23", "2017-02-23", 2, 1, 1);
insert into syndicat (libelle_syndicat, numero_rue, libelle_rue, cp_syndicat, ville_syndicat, tel_syndicat, fax_syndicat, mail_syndicat, dernier_ag, prochain_ag, id_federation_syndicat, id_branche_syndicat, id_ud_syndicat) values ("CGT92",  "10", "rue marcel samba", "25441", "saindié", "0145487854", "0146305050", "cgt@yahoo.fr", "2016-05-02", "2017-05-12", 2, 1, 2);
insert into syndicat (libelle_syndicat, numero_rue, libelle_rue, cp_syndicat, ville_syndicat, tel_syndicat, fax_syndicat, mail_syndicat, dernier_ag, prochain_ag, id_federation_syndicat, id_branche_syndicat, id_ud_syndicat) values ("CGT78",  "7", "villa lamarre", "10212", "beaulieu", "0132151749", "0124545201", "lagoute@hotmail.fr", "2016-04-10", "2017-04-11", 1, 2, 2);
insert into syndicat (libelle_syndicat, numero_rue, libelle_rue, cp_syndicat, ville_syndicat, tel_syndicat, fax_syndicat, mail_syndicat, dernier_ag, prochain_ag, id_federation_syndicat, id_branche_syndicat, id_ud_syndicat) values ("FO92",  "9", "rue du moulin", "20001", "bastia", "0645487852", "0145784852", "fo@gmail.com", "2016-11-10", "2017-11-01", 1, 2, 3);

insert into adherent(nom_adherent, prenom_adherent, dob_adherent, numero_rue, libelle_rue, cp_adherent, ville_adherent, tel_adherent, mail_adherent, id_entreprise_adherent, id_syndicat_adherent) values ("Pannier", "Vincent", "1989-06-23", "14", "rue fernand fourcade", "92350", "le plessis robinson", "0669391170", "vi.pannier@gmail.com", 1, 1);
insert into adherent(nom_adherent, prenom_adherent, dob_adherent, numero_rue, libelle_rue, cp_adherent, ville_adherent, tel_adherent, mail_adherent, id_entreprise_adherent, id_syndicat_adherent) values ("Bouchet", "Messaline", "1991-10-11", "6", "mat laurent", "91250", "es ulis", "06645549965", "messbou@gmail.com", 2, 2);
insert into adherent(nom_adherent, prenom_adherent, dob_adherent, numero_rue, libelle_rue, cp_adherent, ville_adherent, tel_adherent, mail_adherent, id_entreprise_adherent, id_syndicat_adherent) values ("Pannier", "Philippe", "1965-12-04", "14", "rue du capitaine facq", "21120", "dreux", "0685810505", "phil.pannier@msn.com", 1, 4);
insert into adherent(nom_adherent, prenom_adherent, dob_adherent, numero_rue, libelle_rue, cp_adherent, ville_adherent, tel_adherent, mail_adherent, id_entreprise_adherent, id_syndicat_adherent) values ("Pannier", "Veronique", "1964-12-18", "14", "rue A", "54236", "dourdan", "0688447250", "lagoute92@hotmail.com", 2, 3);

