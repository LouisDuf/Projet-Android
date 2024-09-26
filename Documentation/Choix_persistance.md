# Choix de persistance
Il faut se poser les bonnes question à ce momment là :
- Partons-nous sur une BDD ou pas ? Ce quel apporte ?
- On stock quoi ?

## Sans BDD
Dans notre contexte une base de données distante est inutile, une persistance locale suffirait.
On a rien a stocker en ligne. L'utilisateur peut-être simplement stocké dans le **local storage** du téléphone.
*(id juste par un nom -> pas l'objectif de garder des infos.)*
Apres pour les infos des films c'est uniquement via l'API et garder en cache sur le tel en local.

Pour la persistance, on peut ne pas s'embeter et la faire simplement dans un fichier JSON

## Avec BDD

### [PostgreSQL](https://www.postgresql.org/)

PostgreSQL est un système de gestion de base de données relationnelles (SGBDR) open-source, développé depuis les années 1980 par une communauté de développeurs. Il est connu pour sa robustesse, sa fiabilité et sa sécurité, ainsi que pour sa capacité à gérer de grandes quantités de données.

PostgreSQL supporte le langage SQL (Structured Query Language) et offre des fonctionnalités avancées telles que les transactions, les contraintes d'intégrité, la gestion des vues, la réplication, les fonctions stockées, les déclencheurs, la géolocalisation, et la gestion des index avancée. Il est également extensible grâce à son architecture modulaire qui permet aux développeurs d'ajouter de nouvelles fonctionnalités.

PostgreSQL est compatible avec une variété de systèmes d'exploitation, y compris Linux, Windows, macOS et diverses distributions de Unix. Il est utilisé par de nombreuses entreprises, grandes et petites, ainsi que par des organisations gouvernementales, des universités et des communautés open-source.

En tant que système de gestion de base de données open-source, PostgreSQL est gratuit et peut être téléchargé à partir de son site officiel. Cependant, il existe également des services commerciaux pour PostgreSQL qui offrent des fonctionnalités supplémentaires et un support professionnel.


### [Firebase](https://firebase.google.com/)

Firebase est une plateforme de développement d'applications mobiles et web offerte par Google. Elle fournit une infrastructure en nuage complète qui permet aux développeurs de créer et de déployer des applications hautement évolutives, sécurisées et performantes.

Firebase offre une large gamme de fonctionnalités et de services tels que la base de données en temps réel, l'authentification des utilisateurs, le stockage en nuage, l'hébergement web, la messagerie en temps réel, les fonctions cloud, les notifications push, les analyses, la sécurité et la conformité, ainsi que des outils de développement et d'intégration.

Firebase est populaire auprès des développeurs car elle leur permet de se concentrer sur la création de fonctionnalités uniques pour leurs applications sans avoir à se soucier de la gestion de l'infrastructure. Elle est également très adaptable, ce qui la rend adaptée à une grande variété d'applications, des petites applications aux grandes applications d'entreprise.

Firebase est disponible en tant que service payant avec des plans tarifaires adaptés aux besoins des développeurs, ainsi qu'en version gratuite avec des limites d'utilisation. Les développeurs peuvent s'inscrire sur le site Web de Firebase et commencer à utiliser ses fonctionnalités pour leurs projets.


