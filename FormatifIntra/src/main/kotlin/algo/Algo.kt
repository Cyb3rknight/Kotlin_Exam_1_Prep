package algo

fun main() {
    // Tu peux tester la fonction en l'appelant ici.
    println(racineCarre(2.0))
}

/**
 * Tu dois faire un programme en Kotlin qui calcule la racine en base 2 d'un nombre, en te basant sur le pseudo-code fourni.
 *
 * (3 points) Tu dois traduire le pseudo-code fourni pour programmer la fonction racineCarre.
 * (1 point) Tu dois inclure toutes les annotations de type sur les variables.
 */

/*
     racineCarre(x qui est un nombre en virgule flottante)
       resultat est initialisé à 0,0
       Tant que (resultat + 1) * (resultat +1) est inférieur ou égal à x faire
             resultat++
       fin du tant que
       remplir un tableau appelé fractions avec les valeurs 0,1 puis 0,01 puis 0,001 puis 0,0001
       pour fraction dans fractions faire
           initialiser base avec la valeur de resultat
           pour chaque chiffre entre 0 et 9 inclus, faire
               initialiser test avec la valeur de base + (fraction * chiffre)
               si test multiplié par test est inférieur ou égal à x
               alors on veut que resultat prenne la valeur de test
           fin du pour sur les chiffre

       fin du pour sur les fraction
       renvoyer resultat
  */


fun racineCarre(x: Double): Double {

    // Initialisation de la variable resultat à 0.0
    var resultat = 0.0

    // Boucle pour trouver la partie entière de la racine carrée
    while ((resultat + 1) * (resultat + 1) <= x) {
        // Incrémentation de resultat tant que le carré de resultat + 1 est inférieur ou égal à x
        resultat++
    }

    // Définition d'un tableau de fractions pour affiner la racine carrée
    val fractions = arrayOf(0.1, 0.01, 0.001, 0.0001)

    // Boucle pour affiner la racine carrée en utilisant les fractions
    for (fraction in fractions) {
        // Initialisation de la variable base avec la valeur de resultat
        var base = resultat

        // Boucle pour tester les chiffres de 0 à 9
        for (digit in 0..9) {
            // Calcul de la valeur de test en ajoutant la fraction multipliée par le chiffre à la base
            val test = base + fraction * digit

            // Vérification si le carré de test est inférieur ou égal à x
            if (test * test <= x) {
                // Mise à jour de resultat avec la valeur de test si le carré de test est inférieur ou égal à x
                resultat = test
            }
        }
    }

    // Retour de la valeur de resultat, qui est la racine carrée approximée de x
    return resultat
}

