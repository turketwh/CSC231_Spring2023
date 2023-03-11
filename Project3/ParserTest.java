import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    Language1Parser l1p;
    YourLanguageParser ylp;

    @Before
    public void setUp() throws Exception {
        l1p = new Language1Parser();
        ylp = new YourLanguageParser();
    }


    // TESTS 1 - 6 EVALUATE WORDS AGAINST THE LANGUAGE 1 GRAMMAR
    // USE THESE TO VERIFY YOUR WORK IN LR0Parser.java
    @Test
    public void test1() {
        assertEquals("R1,R3", l1p.parse("a#"));
    }

    @Test
    public void test2() {
        assertEquals("R1,R2,R3", l1p.parse("(a)#"));
    }

    @Test
    public void test3() {
        assertEquals("R1,R2,R2,R3", l1p.parse("((a))#"));
    }

    @Test
    public void test4() {
        assertEquals("Unexpected )", l1p.parse("()#"));
    }

    @Test
    public void test5() {
        assertEquals("Unexpected (", l1p.parse("(a)(#"));
    }

    @Test
    public void test6() {
        assertEquals("Unexpected #", l1p.parse("#"));
    }


    // TESTS 7 - 12 EVALUATE WORDS AGAINST THE LANGUAGE A GRAMMAR
    // USE THESE TO VERIFY YOUR WORK IF YOU WERE ASSIGNED LANGUAGE A

    /*
    @Test
    public void test7() { assertEquals("R1,R3", ylp.parse("n#")); }

    @Test
    public void test8() {
        assertEquals("R1,R2,R3", ylp.parse("n+n#"));
    }

    @Test
    public void test9() {
        assertEquals("R1,R2,R2,R3", ylp.parse("n+n+n#"));
    }

    @Test
    public void test10() {
        assertEquals("Unexpected +", ylp.parse("n++#"));
    }

    @Test
    public void test11() {
        assertEquals("Unexpected n", ylp.parse("nn#"));
    }

    @Test
    public void test12() {
        assertEquals("Unexpected #", ylp.parse("#"));
    }
    */

    // TESTS 13 - 18 EVALUATE WORDS AGAINST THE LANGUAGE B GRAMMAR
    // USE THESE TO VERIFY YOUR WORK IF YOU WERE ASSIGNED LANGUAGE B

    /*
    @Test
    public void test13() { assertEquals("R1,R3", ylp.parse("ab#")); }

    @Test
    public void test14() {
        assertEquals("R1,R2,R3", ylp.parse("aabb#"));
    }

    @Test
    public void test15() {
        assertEquals("R1,R2,R2,R3", ylp.parse("aaabbb#"));
    }

    @Test
    public void test16() {
        assertEquals("Unexpected b", ylp.parse("abb#"));
    }

    @Test
    public void test17() {
        assertEquals("Unexpected a", ylp.parse("aba#"));
    }

    @Test
    public void test18() {
        assertEquals("Unexpected #", ylp.parse("#"));
    }
    */


    // TESTS 19 - 24 EVALUATE WORDS AGAINST THE LANGUAGE C GRAMMAR
    // USE THESE TO VERIFY YOUR WORK IF YOU WERE ASSIGNED LANGUAGE C

    /*
    @Test
    public void test19() { assertEquals("R1,R3", ylp.parse("b#")); }

    @Test
    public void test20() {
        assertEquals("R1,R2,R3", ylp.parse("ab#"));
    }

    @Test
    public void test21() {
        assertEquals("R1,R2,R2,R3", ylp.parse("aab#"));
    }

    @Test
    public void test22() {
        assertEquals("Unexpected b", ylp.parse("abb#"));
    }

    @Test
    public void test23() {
        assertEquals("Unexpected a", ylp.parse("aba#"));
    }

    @Test
    public void test24() {
        assertEquals("Unexpected #", ylp.parse("#"));
    }
     */
}
