package tdd.pratice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * AlgorithmPractice Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>11/26/2021</pre>
 */
public class AlgorithmPracticeTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(AlgorithmPracticeTest.class);
    private AlgorithmPractice algorithmPractice;

    @BeforeEach
    public void before() throws Exception {
        algorithmPractice = new AlgorithmPractice();
    }

    @AfterEach
    public void after() throws Exception {
    }

    /**
     * Method: fizzBuzz(int n)
     */
    @Test
    public void testFizzBuzz() throws Exception {
//TODO: Test goes here...
        List<String> compare_3 = Arrays.asList("1", "2", "Fizz");
        List<String> compare_5 = Arrays.asList("1", "2", "Fizz", "4", "Buzz");
        List<String> compare_15 = Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz");
        assertThat(algorithmPractice.fizzBuzz(3)).isEqualTo(compare_3);
        assertThat(algorithmPractice.fizzBuzz(5)).isEqualTo(compare_5);
        assertThat(algorithmPractice.fizzBuzz(15)).isEqualTo(compare_15);
    }

    /**
     * Method: fizzBuzz(int n)
     */
    @Test
    public void testAddTwoNumbers() throws Exception {
//TODO: Test goes here...
        AlgorithmPractice.ListNode listNodeLeft = new AlgorithmPractice.ListNode(2);
        AlgorithmPractice.ListNode listNodeRight = new AlgorithmPractice.ListNode(5);
        AlgorithmPractice.ListNode listNodeAnswer = new AlgorithmPractice.ListNode(7);
        LOGGER.info("listNodeLeft");
        listNodeLeft.append(4, listNodeLeft);
        listNodeLeft.append(3, listNodeLeft);
        listNodeLeft.printListNode();

        LOGGER.info("listNodeRight");
        listNodeRight.append(6, listNodeRight);
        listNodeRight.append(4, listNodeRight);
        listNodeRight.printListNode();

        LOGGER.info("listNodeAnswer");
        listNodeAnswer.append(0, listNodeAnswer);
        listNodeAnswer.append(8, listNodeAnswer);
        listNodeAnswer.printListNode();

        LOGGER.info("assert");
        algorithmPractice.addTwoNumbers(listNodeLeft, listNodeRight).printListNode();

        assertThat(algorithmPractice.addTwoNumbers(listNodeLeft, listNodeRight).isEqualTo(listNodeAnswer)).isEqualTo(true);
    }

    @Test
    public void testRomanToInt() throws Exception {
        assertThat(algorithmPractice.romanToInt("III")).isEqualTo(3);
        assertThat(algorithmPractice.romanToInt("IV")).isEqualTo(4);
        assertThat(algorithmPractice.romanToInt("IX")).isEqualTo(9);
        assertThat(algorithmPractice.romanToInt("LVIII")).isEqualTo(58);
        assertThat(algorithmPractice.romanToInt("MCMXCIV")).isEqualTo(1994);
        assertThat(algorithmPractice.romanToInt("MCMLXXXVI")).isEqualTo(1986);
        assertThat(algorithmPractice.romanToInt("MMII")).isEqualTo(2002);
        assertThat(algorithmPractice.romanToInt("MMXXI")).isEqualTo(2021);
        assertThat(algorithmPractice.romanToInt("MMMCMLXXXIV")).isEqualTo(3984);
    }


}
