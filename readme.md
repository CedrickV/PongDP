# Pong avec Design Patterns

Ce projet est une implémentation du jeu classique Pong en Java en utilisant JavaFX pour l'interface graphique. Il met en œuvre les patrons de conception suivants : Singleton, Strategy et Observer.

## Instructions de build

1. Assurez-vous d'avoir Java 11 ou supérieur et Maven installés sur votre machine.
2. Clonez le dépôt git : `git clone https://github.com/CedrickV/PongDP.git`
3. Accédez au répertoire du projet : `cd PongDP`
4. Exécutez la commande Maven pour construire le projet : `mvn clean install`
5. Exécutez la commande Maven pour lancer l'application : `mvn exec:java`

## Justification des patrons de conception employés

### Singleton

Le patron Singleton a été utilisé pour la classe `JavaFXDisplay`. Comme il n'est nécessaire d'avoir qu'une seule instance de l'affichage JavaFX à travers l'application, le patron Singleton garantit que l'instance de `JavaFXDisplay` est unique et accessible globalement.

### Strategy

Le patron Strategy a été implémenté pour déterminer le comportement de la balle dans le jeu Pong. Plus précisément, la classe `Ball` utilise une interface `BallBehavior` qui définit une méthode `updatePosition()` qui permet de mettre à jour la position de la balle. En utilisant ce patron, on peut facilement changer le comportement de la balle en changeant simplement la classe qui implémente `BallBehavior`. Cela permet également d'ajouter facilement de nouveaux comportements de balle à l'avenir sans avoir à modifier le code existant de la classe `Ball`.

### Observer

Le patron Observer est utilisé pour mettre à jour l'affichage lorsque l'état du jeu change. La classe `Game` agit en tant qu'objet Observable, et la classe `JavaFXDisplay` (qui implémente l'interface `Observer`) agit en tant qu'observateur. Lorsque l'état du jeu change, la classe `Game` notifie `JavaFXDisplay` qui met à jour l'affichage en conséquence. Ce modèle permet d'ajouter facilement d'autres types d'affichage à l'avenir, sans affecter la logique du jeu.
