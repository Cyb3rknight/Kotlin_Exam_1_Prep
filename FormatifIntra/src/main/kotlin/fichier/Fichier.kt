package fichier

import java.io.File
import java.io.PrintWriter


fun main() {
    // Tu peux tester tes fonctions en les appellants ici.
    println(lire())
    val args = arrayOf("pipo.txt", "Contenu du fichier")
    println(ecrire(args))
}

/**
 * (1 point) Affiche dans la console le contenu du fichier message.txt qui se trouve dans le projet de départ.
 */
fun lire() {
 var fichier: File = File("message.txt")
    if (fichier.exists()) {
    println(fichier.readText())
    }
    else
    {
        println("Le fichier $fichier n'existe pas")
    }
}

/**
 * (1 point) S’il n’y a pas 2 éléments dans le paramètre args, affiche un message d'erreur, et retourne la valeur -1.
 * (1 point) Crée un fichier dans le répertoire du projet, dont le nom sera déterminé par le premier argument.
 *           Par exemple, si l’argument est « pipo.txt » l’application crée le fichier dans le dossier du projet avec le
 *           nom « pipo.txt ».
 * (1 point) Le fichier aura comme contenu le texte contenu dans le 2ème élément qui est dans le paramètre args.
 * Si tout s'est bien passé, on retourne la valeur 1.
 */
fun ecrire(args: Array<String>): Int {
    // Vérification si le nombre d'arguments est égal à 2
    if(args.size != 2 )
    {
        // Si le nombre d'arguments est incorrect, retourner -1
        return -1
    }

    // Récupération du nom de fichier et du contenu à partir des arguments
    val fileName = args[0]
    val fileContent = args[1]

    // Création du fichier avec le nom spécifié
    val file = File(fileName)
    if (file.createNewFile()) {
        // Écriture du contenu dans le fichier
        val writer = PrintWriter(file)
        writer.print(fileContent)
        writer.close()
        println("Fichier créé avec succès : $fileName")
        println("Contenu du fichier : $fileContent")
        // Retourner 1 si tout s'est bien passé
        return 1
    } else {
        // Erreur lors de la création du fichier
        println("Erreur lors de la création du fichier : $fileName")
        return -1
    }
}