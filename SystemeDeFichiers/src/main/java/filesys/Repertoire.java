package filesys;

import java.util.ArrayList;

/**
 * La classe Repertoire d�crit un r�pertoire du syst�me de fichiers.
 * @author Pierre Lizet et Philippe Joulot
 * @version 1.0
 */
public class Repertoire extends Composant {
    /**
     * Les Composants contenu dans le r�pertoire.
     */
    private ArrayList<Composant> composants;
    /**
     * Le nombre de composant contenu dans le r�pertoire.
     */
    private int nbrComposants;

    /**
     * . Constructeur de la classe R�pertoire
     * @param parNom
     *            Le Nom du r�pertoire
     * @throws ExceptionSystemeFichier
     *             Exception lev�e lorsque le nom est nul.
     */
    public Repertoire(String parNom) throws ExceptionSystemeFichier {
        super(parNom);
        // initialise instance variables
        this.composants = new ArrayList<Composant>();
        this.nbrComposants = 0;
    }

    /**
     * . Fonction ajoutant un Composant au r�pertoire
     * @param parComposant
     *            Composant que l'on ajoute au r�pertoire
     * @throws ExceptionSystemeFichier
     *             Exception lev�e si le composant ne r�pond pas aux crit�res
     *             exig�s
     */
    public void ajoutComposant(Composant parComposant)
            throws ExceptionSystemeFichier {

        if (parComposant == null) {
            throw new ExceptionSystemeFichier(
                    "Le composant ajout� doit �tre non nul.");
        } else {
            if (this.equals(parComposant)) {
                throw new ExceptionSystemeFichier(
                        "On ne peut pas ajouter un r�pertoire � lui-m�me.");
            } else {
                if (!this.estDescendant(parComposant)) {
                    throw new ExceptionSystemeFichier(
                            "On ne peut pas s'ajouter r�cursivement.");
                } else {
                    boolean testMemeNom = true;
                    for (Composant item : composants) {
                        if (item.getNom().equals(parComposant.getNom())) {
                            testMemeNom = false;
                        }
                    }
                    if (!testMemeNom) {
                        throw new ExceptionSystemeFichier(
                                "On ne peut pas ajouter deux composants de m�me nom.");
                    } else {
                        this.composants.add(parComposant);
                        this.nbrComposants += 1;
                    }
                }
            }
        }

    }

    @Override
    public int getTaille() {
        int retour = 0;
        ArrayList<Composant> contenu = composants;

        for (Composant item : contenu) {
            retour += item.getTaille();
        }
        return (retour);
    }

    /**
     * . Getter composants: Retourne les composants du r�pertoire
     * @return composants
     */
    public ArrayList<Composant> getComposants() {
        return (composants);
    }

    /**
     * . Getter nbrComposants
     * @return Le nombre de composants du r�pertoire
     */

    public int getNbrComposants() {
        return (nbrComposants);
    }

    /**
     * . V�rifie si un r�pertoire est un sous-r�pertoire de lui m�me (m�me
     * indirectement)
     * @param rep2
     *            Le composant que l'on veut ajouter au r�pertoire.
     * @return retour Retourne vrai si c'est un descendant sinon faux
     */
    public boolean estDescendant(Composant rep2) {
        boolean retour = true;
        if (rep2 instanceof Repertoire) {
            ArrayList<Composant> contenu = ((Repertoire) rep2).composants;

            for (Composant item : contenu) {
                if (!item.equals(this)) {
                    retour = false;
                } else {
                    if (item instanceof Repertoire) {
                        estDescendant(item);
                    }
                }
            }
        }
        return (retour);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((composants == null) ? 0 : composants.hashCode());
        result = prime * result + nbrComposants;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Repertoire other = (Repertoire) obj;
        if (composants == null) {
            if (other.composants != null) {
                return false;
            }
        } else if (!composants.equals(other.composants)) {
            return false;
        }
        if (nbrComposants != other.nbrComposants) {
            return false;
        }
        return true;
    }

}
