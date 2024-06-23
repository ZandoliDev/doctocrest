# Comment faire une requête sur l'API DoctoCrest ?

Utiliser Postman pour effectuer une requête POST sur l'adresse :
*http://localhost:8080/rendez-vous*

Avec le body suivant :
```json
{
  "patient": {
    "nom": "Tom"
  },
  "specialite": "CARDIOLOGUE"
}
```

La réponse doit indiquer un code 200 et le message suivant :
```json
{
  "praticien": {
    "nom": "Dr. Alice Martin",
    "specialite": "CARDIOLOGUE"
  },
  "patient": {
    "nom": "Tom"
  },
  "prix": 100.0
}
```

# Comment initialiser la base de données ?

Spring JPA utilise une base de données H2 en mémoire dans ce projet. 
Pour initialiser la base de données, il suffit de lancer l'application. 
La base de données est automatiquement initialisée en se basant sur les classes d'entités.

La configuration dans le fichier *application.yaml*
```yaml
spring:
  jpa:
    hibernate:
      ddl-auto: update
```
permet de mettre à jour la base de données à chaque lancement de l'application.

# Comment explorer la base de données ?

Spring JPA fournit une interface web pour explorer la base de données. Pour y accéder, il suffit de se rendre à l'adresse :
*http://localhost:8080/h2-console*

Remplir les champs de la manière suivante :
- Driver Class: org.h2.Driver
- JDBC URL: jdbc:h2:mem:doctocrest (voir le fichier application.yaml)
- User Name: (vide - voir le fichier application.yaml)
- Password: (vide - voir le fichier application.yaml)