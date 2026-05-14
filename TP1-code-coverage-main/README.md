# TP1 - Tests Unitaires et Couverture du Code

## Objectifs
- Mesurer la couverture du code par les tests unitaires
- Utiliser les critères de couverture des lignes, des branches et des conditions
- Utiliser IntelliJ IDEA pour vérifier la couverture du code
- Écrire des tests unitaires complets et robustes

## Prérequis
- Java 8 ou supérieur
- IntelliJ IDEA
- Connexion internet
- Connaissances de base de JUnit 5


## Erreurs Identifiées et Corrections

### Exercice 1 - Palindrome

#### Erreur :

Dans la boucle while, les indices sont mal incrémentés : j++ et i-- au lieu de j-- et i++

#### Correction :

Remplacer j++ par j--

Remplacer i-- par i++



### Exercice 2 - Anagramme
#### Erreur :

La boucle for utilise i <= s1.length() au lieu de i < s1.length(), ce qui provoque une StringIndexOutOfBoundsException

#### Correction :

Remplacer i <= s1.length() par i < s1.length()

### Exercice 3 - BinarySearch
#### Erreurs :

Condition de boucle while (low < high) au lieu de while (low <= high)

Comparaison array[mid] <= element au lieu de array[mid] < element

#### Corrections :

Remplacer low < high par low <= high

Remplacer <= par < dans la condition else if


### Exercice 4 - QuadraticEquation

#### Erreur
if (delta == 0)
#### Problème
comparaison directe de double (instable)
#### correction
if (Math.abs(delta) < 1e-9)


### Exercice 5 - RomanNumeral

#### Erreurs :

La boucle for utilise i <= symbols.length au lieu de i < symbols.length, causant un dépassement de tableau

La condition while (n > values[i]) au lieu de while (n >= values[i]), ce qui empêche d'utiliser correctement les symboles lorsque n est égal à une valeur

#### Corrections :

Remplacer i <= symbols.length par i < symbols.length

Remplacer n > values[i] par n >= values[i]


### Exercice 6 - FizzBuzz

#### Erreur :

La validation if (n <= 1) est trop restrictive. Elle rejette n = 1 alors que 1 est un entier positif valide qui doit retourner "1"

#### Correction :

Remplacer if (n <= 1) par if (n <= 0)

