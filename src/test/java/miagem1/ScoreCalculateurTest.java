package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    private QuestionAChoix q1;
    private ScoreCalculateur calc;
    private ArrayList<Integer> reponses;

    @Before
    public void setUp() throws Exception {
        // given : une instance de question à choix exclusif
        q1 = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)));
        calc = new ScoreCalculateur();
        reponses = new ArrayList<Integer>();
    }

    @Test
    public void calculeScoreJuste() {
        float result;

        // When : quand on calcule le score pour une liste de réponses contenant les valeurs 1 et 4,
        reponses.add(reponses.size(),1);
        reponses.add(reponses.size(),4);
        // Then : on obtient 0 comme résultat
        assertEquals(0f,calc.calculeScore(reponses,q1), 0.01f);

        // Given : quand on calcule le score pour une liste de réponses contenant les valeurs 2 et 3
        reponses.clear();
        reponses.add(reponses.size(),2);
        reponses.add(reponses.size(),3);
        // Then : on obtient 2*100/3 à 0,01 près comme résultat ;
        result = (2*100)/3f;
        assertEquals(result,calc.calculeScore(reponses,q1), 0.01f);

        // Given : quand on calcule le score pour une liste de réponses contenant les valeurs 2, 3 et 5,
        reponses.clear();
        reponses.add(reponses.size(),2);
        reponses.add(reponses.size(),3);
        reponses.add(reponses.size(),5);
        // Then : on obtient 100 à 0,01 près comme résultat.
        assertEquals(100f,calc.calculeScore(reponses,q1), 0.01f);


    }



}