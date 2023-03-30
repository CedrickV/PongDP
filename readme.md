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

Le patron Strategy est utilisé pour déterminer le comportement des raquettes dans le jeu. L'interface `PaddleBehavior` définit les méthodes pour les différentes stratégies de déplacement de la raquette. Actuellement, une seule stratégie est implémentée, `AutoPaddle`, qui déplace la raquette automatiquement en fonction de la position de la balle. Cela permet d'ajouter facilement d'autres stratégies de déplacement de raquette à l'avenir, telles que le contrôle manuel du joueur, sans affecter les autres parties du code.

### Observer

Le patron Observer est utilisé pour mettre à jour l'affichage lorsque l'état du jeu change. La classe `Game` agit en tant qu'objet Observable, et la classe `JavaFXDisplay` (qui implémente l'interface `Display`) agit en tant qu'observateur. Lorsque l'état du jeu change, la classe `Game` notifie `JavaFXDisplay` qui met à jour l'affichage en conséquence. Ce modèle permet d'ajouter facilement d'autres types d'affichage à l'avenir, sans affecter la logique du jeu.
