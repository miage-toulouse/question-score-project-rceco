package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoix q1;
    private ArrayList<Float> reponses;

    @Before
    public void setUp() throws Exception {
        // given : une instance de question à choix Multiple
        q1 = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)));
        reponses = new ArrayList<Float>();
    }

    @Test
    public void getEnonce() {
        // When : on demande son énoncé à la question
        String resEnonce = q1.getEnonce();
        // Then : l'énoncé retourné est l'énoncé foourni à la construction de la question
        assertEquals("q1", resEnonce);
    }

    @Test
    public void getScoreForIndice() {
        // When : On entre les bonnes reponses et on calcul le score
        float resScore = q1.getScoreForIndice(2);
        resScore += q1.getScoreForIndice(3);
        resScore += q1.getScoreForIndice(5);
        // Then : on obtient 100 comme résultat
        assertEquals(100f,resScore, 0.01f);
    }

    @Test
    public void getScoreForIndiceFaux() {
        // When : On entre des mauvaises reponses et on calcul le score
        float resScore = q1.getScoreForIndice(4);
        resScore += q1.getScoreForIndice(8);
        resScore += q1.getScoreForIndice(7);
        // Then : on obtient 100 comme résultat
        assertEquals(0f,resScore, 0.01f);
    }
}