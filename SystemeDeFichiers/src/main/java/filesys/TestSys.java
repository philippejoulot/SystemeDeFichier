package filesys;

import java.util.ArrayList;
import java.util.Hashtable;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Pierre Lizet et Philippe Joulot
 */
public class TestSys {
    /**
     * @throws ExceptionSystemeFichier
     *             Test susceptible de lancer une exception de type
     *             ExceptionSystemeFichier
     */
    @Test
    public static void calculTailleVide() throws ExceptionSystemeFichier {
        File fich1;
        fich1 = new File("fich1");
        int taille = fich1.getTaille();
        Assert.assertEquals(0, taille);
    }

    /**
     * @throws ExceptionSystemeFichier
     *             Test susceptible de lancer une exception de type
     *             ExceptionSystemeFichier
     */
    @Test
    public static void calculTailleNonVide() throws ExceptionSystemeFichier {
        File fich1;
        fich1 = new File("fich1", 10);
        int taille = fich1.getTaille();
        Assert.assertTrue(taille >= 0);
    }

    /**
     * @throws ExceptionSystemeFichier
     *             Test susceptible de lancer une exception de type
     *             ExceptionSystemeFichier
     */
    @Test(expected = ExceptionSystemeFichier.class)
    public static void calculTailleNegative() throws ExceptionSystemeFichier {
        File fich1 = new File("fich1", -10);
        int taille = fich1.getTaille();
        Assert.assertTrue(taille >= 0);
    }

    /**
     * @throws ExceptionSystemeFichier
     *             Test susceptible de lancer une exception de type
     *             ExceptionSystemeFichier
     */
    @Test
    public static void calculTailleRepertoire() throws ExceptionSystemeFichier {
        Repertoire dir1;
        dir1 = new Repertoire("Dir1");
        File fich1 = new File("fich1", 10);
        File fich2 = new File("fich2", 20);
        dir1.ajoutComposant(fich1);
        dir1.ajoutComposant(fich2);
        int taille = dir1.getTaille();
        Assert.assertTrue(taille == (fich1.getTaille() + fich2.getTaille()));
    }

    /**
     * @throws ExceptionSystemeFichier
     *             Test susceptible de lancer une exception de type
     *             ExceptionSystemeFichier
     */
    @Test(expected = ExceptionSystemeFichier.class)
    public static void referenceNulle() throws ExceptionSystemeFichier {
        Repertoire dir1 = new Repertoire("Dir1");
        File fich1 = null;
        dir1.ajoutComposant(fich1);
        Assert.assertTrue(!dir1.getComposants().contains(null));
    }

    /**
     * @throws ExceptionSystemeFichier
     *             Test susceptible de lancer une exception de type
     *             ExceptionSystemeFichier
     */
    @Test(expected = ExceptionSystemeFichier.class)
    public static void ajoutMemeNom() throws ExceptionSystemeFichier {
        Repertoire dir1;
        dir1 = new Repertoire("Dir1");
        File fich1 = new File("fich1", 10);
        dir1.ajoutComposant(fich1);
        dir1.ajoutComposant(fich1);
        ArrayList<Composant> contenu = dir1.getComposants();
        Hashtable<Composant, Integer> h = new Hashtable<Composant, Integer>();
        for (Composant item : contenu) {
            if (!h.containsKey(item)) {
                h.put(item, new Integer(1));
            } else {
                Integer occurrence = h.get(item) + 1;
                h.remove(item);
                h.put(item, occurrence);
            }
        }
        Assert.assertTrue(h.size() == contenu.size());
    }

    /**
     * @throws ExceptionSystemeFichier
     *             Test susceptible de lancer une exception de type
     *             ExceptionSystemeFichier
     */
    @Test(expected = ExceptionSystemeFichier.class)
    public static void ajoutSoitMeme() throws ExceptionSystemeFichier {
        Repertoire dir1 = new Repertoire("Dir1");
        dir1.ajoutComposant(dir1);
        Assert.assertTrue(!dir1.getComposants().contains(dir1));
    }

    /**
     * @throws ExceptionSystemeFichier
     *             Test susceptible de lancer une exception de type
     *             ExceptionSystemeFichier
     */
    @Test(expected = ExceptionSystemeFichier.class)
    public static void sousRepertoireLuiMeme() throws ExceptionSystemeFichier {
        Repertoire dir1;
        dir1 = new Repertoire("Dir1");
        Repertoire dir2 = new Repertoire("Dir2");
        Repertoire dir3 = new Repertoire("Dir3");
        File fich1 = new File("Fich1", 10);
        File fich2 = new File("Fich2", 10);
        dir1.ajoutComposant(dir2);
        dir1.ajoutComposant(fich1);
        dir2.ajoutComposant(dir3);
        dir3.ajoutComposant(dir1);
        dir3.ajoutComposant(fich2);
        Assert.assertTrue(!dir1.getComposants().contains(dir1));
    }
}
