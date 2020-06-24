import kotlin.test.AssertionsKt;
import org.junit.Test;

import static org.junit.Assert.*;

public class APPTest {
    @Test
     public void shouldreturn_Whitewins_when_give_sample1(){
        Texas poke= new Texas();
        String expectedResult =poke.rule("2H 3D 5S 9C KD","2C 3H 4S 8C AH");
        AssertionsKt.assertEquals("White wins",expectedResult,"jiebro");
    }

    @Test
    public void shouldreturn_Whitewins_when_give_sample2(){
        Texas poke= new Texas();
        String expectedResult =poke.rule("2H 4S 4C 2D 4H","2S 8S AS QS 3S");
        AssertionsKt.assertEquals("Black wins",expectedResult,"jiebro");
    }

    @Test
    public void shouldreturn_Blackwins_when_give_sample3(){
        Texas poke= new Texas();
        String expectedResult =poke.rule("2H 3H 5H 9H KH","2C 3H 4S 5C 6H");
        AssertionsKt.assertEquals("Black wins",expectedResult,"jiebro");
    }

    @Test
    public void shouldreturn_Tie_when_give_sample4(){
        Texas poke= new Texas();
        String expectedResult =poke.rule("2H 3D 5S 9C KD","2D 3H 5C 9S KH");
        AssertionsKt.assertEquals("Tie",expectedResult,"jiebro");
    }
}
