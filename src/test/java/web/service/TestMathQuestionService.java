package web.service;

import org.junit.Assert;
import org.junit.Test;

import web.service.MathQuestionService;

public class TestMathQuestionService {

	
	//addition tests
	
	@Test
	public void testCorrectInputsAddSuccess() {
		Assert.assertEquals(3, MathQuestionService.q1Addition("1", "2"), 0);
	}	
	@Test
	public void testNullInput1AddFail() {
		Assert.assertEquals(9999, MathQuestionService.q1Addition(null, "1"), 0);
	}	
	@Test
	public void testNullInput2AddFail() {
		Assert.assertEquals(9999, MathQuestionService.q1Addition("1", null), 0);
	}	
	@Test
	public void 	testEmptyInput1AddFail() {
		Assert.assertEquals(9999, MathQuestionService.q1Addition("", "1"), 0);
	}	
	@Test
	public void	testEmptyInput2AddFail() {
		Assert.assertEquals(9999, MathQuestionService.q1Addition("1", ""), 0);
	}	
	@Test
	public void	testStringInput1AddFail() {
		Assert.assertEquals(9999, MathQuestionService.q1Addition("abc", "1"), 0);
	}	
	@Test
	public void	testStringInput2AddFail() {
		Assert.assertEquals(9999, MathQuestionService.q1Addition("1", "abc"), 0);
	}	
	@Test
	public void	testNegativeInput1AddSuccess() {
		Assert.assertEquals(1, MathQuestionService.q1Addition("-1", "2"), 0);
	}	
	@Test
	public void	testNegativeInput2AddSuccess() {
		Assert.assertEquals(-1, MathQuestionService.q1Addition("1", "-2"), 0);
	}	
	
	
	// subtraction tests
	
	@Test
	public void testCorrectInputsSubSuccess() {
		Assert.assertEquals( 1, MathQuestionService.q2Subtraction("3", "2"), 0);
	}	
	@Test
	public void testNullInput1SubFail() {
		Assert.assertEquals(9999, MathQuestionService.q2Subtraction(null, "1"), 0);
	}	
	@Test
	public void testNullInput2SubFail() {
		Assert.assertEquals(9999, MathQuestionService.q2Subtraction("1", null), 0);
	}	
	@Test
	public void 	testEmptyInput1SubFail() {
		Assert.assertEquals( 9999, MathQuestionService.q2Subtraction("", "1"),0);
	}	
	@Test
	public void	testEmptyInput2SubFail() {
		Assert.assertEquals(9999, MathQuestionService.q2Subtraction("1", ""), 0);
	}	
	@Test
	public void	testStringInput1SubFail() {
		Assert.assertEquals(9999, MathQuestionService.q2Subtraction("abc", "1"), 0);
	}	
	@Test
	public void	testStringInput2SubFail() {
		Assert.assertEquals( 9999, MathQuestionService.q2Subtraction("1", "abc"), 0);
	}	
	@Test
	public void	testNegativeInput1SubSuccess() {
		Assert.assertEquals(-3, MathQuestionService.q2Subtraction("-1", "2"), 0);
	}	
	@Test
	public void	testNegativeInput2SubSuccess() {
		Assert.assertEquals(3, MathQuestionService.q2Subtraction("1", "-2"), 0);
	}	
	
	

	// multiplication tests
	@Test
	public void testCorrectInputsMultSuccess() {
		Assert.assertEquals(6, MathQuestionService.q3Multiplication("3", "2"), 0);
	}	
	@Test
	public void testNullInput1MultFail() {
		Assert.assertEquals(9999, MathQuestionService.q3Multiplication(null, "1"), 0);
	}	
	@Test
	public void testNullInput2MultFail() {
		Assert.assertEquals(9999, MathQuestionService.q3Multiplication("1", null), 0);
	}	
	@Test
	public void 	testEmptyInput1MultFail() {
		Assert.assertEquals(9999, MathQuestionService.q3Multiplication("", "1"), 0);
	}	
	@Test
	public void	testEmptyInput2MultFail() {
		Assert.assertEquals(9999, MathQuestionService.q3Multiplication("1", ""), 0);
	}	
	@Test
	public void	testStringInput1MultFail() {
		Assert.assertEquals(9999, MathQuestionService.q3Multiplication("abc", "1"), 0);
	}	
	@Test
	public void	testStringInput2MultFail() {
		Assert.assertEquals(9999, MathQuestionService.q3Multiplication("1", "abc"), 0);
	}	
	@Test
	public void	testNegativeInput1MultSuccess() {
		Assert.assertEquals(-2, MathQuestionService.q3Multiplication("-1", "2"), 0);
	}	
	@Test
	public void	testNegativeInput2MultSuccess() {
		Assert.assertEquals(-2, MathQuestionService.q3Multiplication("1", "-2"), 0);
	}	
	@Test
	public void	testDoubleNegativeInputMultSuccess() {
		Assert.assertEquals(2, MathQuestionService.q3Multiplication("-1", "-2"), 0);
	}
}
