# Lancer le serveur

    git clone https://github.com/JXS-Groupe2/Project_Amir_Allan_Joceran_Pierre.git
    cd back-end
    mvn clean install
    mvn exec:java

Bravo ! Maintenant l'API est disponible à 

    http://<ADRESSE>:8080/metadrive/<INSTRUCTIONS>
   
Par exemple pour créer un fichier test.txt à la racine de vos drives : 

    GET http://localhost:8080/metadrive/files/test.txt/create
    
# Lancer le front
    <retour à la racine du dossier projet>
    cd metadrive
    npm install
    ng serve
    
Vous pouvez donc maintenant accéder au site à 
    http://localhost:4200

# L'API (à compléter)

## Utilisateurs

### Créer un utilisateur

## Fichiers

### Créer un fichier



