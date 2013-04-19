package filesys;

/**
 * La classe Composant d�crit un �l�ment du Syst�me de Fichiers qui sera soit un
 * fichier, soit un r�pertoire.
 * @author Pierre Lizet et Philippe Joulot
 * @version 1.0
 */
public abstract class Composant {

    /**
     * . Le nom du composant
     */
    protected String nom;

    /**
     * . Constructeur de la classe Composant
     * @param parnom
     *            Le nom du comoosant
     * @throws ExceptionSystemeFichier
     *             Exception lev�e si le nom est nul.
     */
    public Composant(String parnom) throws ExceptionSystemeFichier {
        // initialise instance variables
        if (parnom.equals("") || parnom == null) {
            throw new ExceptionSystemeFichier(
                    "On ne peut pas ajouter un r�pertoire avec un nom nul.");
        } else {
            nom = parnom;
        }
    }

    /**
     * . La taille du composant
     * @return la taille du composant
     */
    public abstract int getTaille();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Composant other = (Composant) obj;
        if (nom == null) {
            if (other.nom != null) {
                return false;
            }
        } else if (!nom.equals(other.nom)) {
            return false;
        }
        return true;
    }

    /**
     * . Getter Nom
     * @return nom
     */
    public String getNom() {
        return (nom);
    }
}
