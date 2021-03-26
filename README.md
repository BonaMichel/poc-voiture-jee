# Gestion Voiture - JEE

Ceux ci est un POC devellopez avec java JEE consernant une application de gestion de voiture avec possibilité d'ajouter des divers commentaires.


# 1 - JWT token Authentication
## connexion
L'utilisateur check sur le lien */user/signIn*  pour se connecter , ainsi comme resultat on obtient un JWT token

## deconnexion

l'utilisateur check sur le lien */user/logout* pour se decconecter et invalider le token de connextion

## liste utilisateur 
les listes des utilisateurs sont auto généré sur l'application. Pour se connecter voici deux exemples d'utilisateur possible:
*login: user1*  
*password:userPassword1*

*login:user2* 
 *password:userPassword2*

# 2 - Véhicule
##  recuperation de liste des voitures
l'utilisateur check sur le lien */vehicle/all* pour obtenir la liste des voitures dans l'application que se soit un utilisateur connecté ou un simple visiteur.
Par contre les détails ne seront disponible que pour les Utilisateur connectés sur le lien */vehicle/idvehicle*

# 3 - Commentaire

on peut ajouter des divers commentaires sur chaque vehicule present, mais seul les utilisateurs connectés peuvent les faire ainsi que les voir.  
## publié un commentaire
disponible sur le lien */comment/add*
## check un commentaire sur un véhicule
disponible sur le lien */comment/idVehicle*

# 4 - Environement
## Base de donnée : PostgreSQL
## Swagger : http://localhost:8081/swagger-ui.html#/
## application : http://localhost:8081
## Authentication: JWT token (Bearer token)


