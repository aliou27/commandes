
# Application de Gestion de Commandes – API REST Spring Boot

Institut Polytechnique de Saint-Louis
Module : Développement d'Applications Backend avec Spring Boot
Enseignant : Dr Samba SIDIBE

**Étudiant : Aliou Ba**

## Contexte du projet

Ce projet est réalisé dans le cadre du TP de développement backend avec Spring Boot.  
Il s'agit d'une **API REST professionnelle** de gestion de commandes clients, respectant une architecture en couches, les bonnes pratiques industrielles et les consignes pédagogiques imposées.

### Fonctionnalités principales
- Gestion complète des **Produits**, **Clients** et **Commandes**
- Création de commandes avec gestion des lignes de commande
- Contrôles métier : vérification du stock, calcul automatique du total, mise à jour du stock après validation
- CRUD complet pour chaque entité
- Documentation interactive de l’API via **OpenAPI / Swagger**
- Support de plusieurs profils Spring (dev, test, prod)
- Configuration externalisée via variables d’environnement
- Initialisation de données uniquement en profil dev

## Architecture du projet

```
com.polytech.commandes
├── entity
├── repository
├── service
│   └── impl
├── controller
├── dto
├── exception
├── config
└── CommandesApplication.java
```

Règles respectées :
- Aucune logique métier dans les contrôleurs
- Les entités ne sont jamais exposées directement (utilisation systématique de DTO)
- Séparation stricte des responsabilités (Controller → Service → Repository)

## Technologies utilisées

- Spring Boot 3.x
- Spring Data JPA + Hibernate
- MySQL 
- Springdoc OpenAPI + Swagger UI
- Lombok (réduction du boilerplate)
- Maven

## Prérequis

- Java 21
- Maven
- MySQL installé localement 
- Variables d’environnement (voir section ci-dessous)

## Variables d’environnement obligatoires

| Variable                  | Description                              | Exemple (dev)                              |
|---------------------------|------------------------------------------|--------------------------------------------|
| `SPRING_PROFILES_ACTIVE`  | Profil Spring à activer                  | `dev`, `test` ou `prod`                    |
| `DB_URL`                  | URL JDBC complète                        | `jdbc:mysql://localhost:3306/gestion_commande` |
| `DB_USERNAME`             | Utilisateur de la base                   | `root` ou `commande_gestion`               |
| `DB_PASSWORD`             | Mot de passe de la base                  | `votre_mot_de_passe`                       |
| `SERVER_PORT`             | Port du serveur (optionnel)              | `8080`                                     |

## Installation et lancement

### 1. Cloner le dépôt

```bash
git clone https://github.com/aliou27/commandes.git
cd commandes
```

### 2. Lancer l’application (plusieurs options)

#### Option A – Profil dev (recommandé pour le développement)

```bash
# Méthode 1 – avec Maven
mvn spring-boot:run -Dspring-boot.run.profiles=dev \
  -Dspring-boot.run.jvmArguments="-DDB_URL=jdbc:mysql://localhost:3306/gestion_commande_dev -DDB_USERNAME=root -DDB_PASSWORD=secret"

# Méthode 2 – variables d’environnement
export SPRING_PROFILES_ACTIVE=dev
export DB_URL=jdbc:mysql://localhost:3306/gestion_commande_dev
export DB_USERNAME=root
export DB_PASSWORD=secret
export SERVER_PORT=8080

mvn spring-boot:run
```

→ La base est automatiquement initialisée + données de test insérées (clients, produits, une commande exemple)

#### Option B – Profil prod (simulation production)

```bash
export SPRING_PROFILES_ACTIVE=prod
export DB_URL=jdbc:mysql://votre-serveur:3306/gestion_commande
export DB_USERNAME=appuser
export DB_PASSWORD=supersecretprod2026
export SERVER_PORT=9000

java -jar target/commandes-0.0.1-SNAPSHOT.jar
```

→ `ddl-auto=validate` → la base ne doit pas être modifiée automatiquement

## Accès à la documentation API (Swagger)

Une fois l’application démarrée :

- **Swagger UI** :  
  http://localhost:8080/swagger-ui.html  
  (ou http://localhost:PORT/swagger-ui.html selon SERVER_PORT)

- **OpenAPI JSON** :  
  http://localhost:8080/api-docs

Les endpoints sont regroupés par tags :  
- Clients  
- Produits  
- Commandes

## Exemples d’appels API (via curl ou Postman)

### Créer un client

```bash
curl -X 'POST' \
  'http://localhost:8080/api/clients' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nom": "Fatou Diop",
  "email": "fatou.diop@example.sn"
}'
```

### Créer un produit

```bash
curl -X 'POST' \
  'http://localhost:8080/api/produits' \
  -H 'Content-Type: application/json' \
  -d '{
  "nom": "Smartphone Samsung",
  "prix": 350000,
  "stock": 45
}'
```

### Créer une commande (exemple simplifié)

```bash
curl -X 'POST' \
  'http://localhost:8080/api/commandes' \
  -H 'Content-Type: application/json' \
  -d '{
  "clientId": 1,
  "lignes": [
    {
      "produitId": 1,
      "quantite": 2
    },
    {
      "produitId": 3,
      "quantite": 1
    }
  ]
}'
```

## Structure des profils Spring

| Profil | Usage                     | ddl-auto     | Données initiales | Logging SQL |
|--------|---------------------------|--------------|-------------------|-------------|
| `dev`  | Développement local       | create-drop  | Oui               | Oui         |
| `test` | Tests automatisés         | create-drop  | Non               | Non         |
| `prod` | Production / déploiement  | validate     | Non               | Non         |

## Livrables fournis

- Code source complet respectant l’architecture imposée
- README détaillé (ce fichier)
- Configuration multi-profils + variables d’environnement
- Documentation OpenAPI/Swagger fonctionnelle
- Initialisation des données en profil dev


Aliou Ba – Février 2026
