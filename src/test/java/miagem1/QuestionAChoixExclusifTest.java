package miagem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Given When Then ==> Etat du monde
 */
public class QuestionAChoixExclusifTest {

    private QuestionAChoixExclusif question;

    @Before
    public void setUp() throws Exception {
        // given : une instance de question à choix exclusif
        question = new QuestionAChoixExclusif("un énoncé",2);
    }

    @Test
    public void getEnonce() {
        // When : on demande son énoncé à la question
        String resEnonce = question.getEnonce();
        // Then : l'énoncé retourné est l'énoncé foourni à la construction de la question
        assertEquals("un énoncé", resEnonce);
    }

    @Test
    public void getScoreForIndiceJuste() {
        // When : quand l'étudiant fournit l'indice
        int indiceEtudiant = 2 ;
        // and : on demande le score de l'indice à la question
        float resScore = question.getScoreForIndice(indiceEtudiant);
        // Then : le score obtenu est 100
        assertEquals(100f, resScore, 0.01f);
    }

    @Test
    public void getScoreForIndiceFaux() {
        // When : quand l'étudiant fournit l'indice (un indice faux)
        int indiceEtudiant = 1 ;
        // and : on demande le score de l'indice à la question
        float resScore = question.getScoreForIndice(indiceEtudiant);
        // Then : le score obtenu est 100
        assertEquals(0f, resScore, 0.01f);
    }
}