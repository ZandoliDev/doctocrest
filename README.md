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