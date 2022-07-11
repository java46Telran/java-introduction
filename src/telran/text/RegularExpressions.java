package telran.text;

public class RegularExpressions {

	public static String javaVariableRegex() {
		
		return "[a-zA-Z$][\\w$]*|_[\\w$]+";
	}
private static String ipOctetRegex() {
		//string expression of number 0-255 with possible leading zeros
	//\\d == [0-9]
		return "\\d\\d?|[0,1]\\d\\d|2[0-4]\\d|25[0-5]";
	}
public static String ipV4Regex() {
	
	return String.format("((%s)\\.){3}(%s)", ipOctetRegex(), ipOctetRegex());
}
/*************************************************************************/
//No parentheses
/**
 * 
 * @return regular expression for arithmetic expression
 * with no parentheses
 * operation: +, -, *, / [/*+-] all operations are binary
 * operand: either java variable or integer number or double number, for example
 * a ; __; 10; 10.2; 10.0
 * assumption: placing of parentheses is not considered
 * a + ((10) * 2) => a+10*2
 * a + ((10) * )2 => a+10*2 according to assumption
 * a + (-10 * 2) => wrong
 */
//public static String arithmeticExpression() {
//	String operator = "[-+*/]";
//	String operand = operandRegex();
//	return String.format("%1$s*(%2$s%1$s)*", operand, operator);
//}

/*************************************************************************/
//With parentheses
/**
* 
* @return regular expression for arithmetic expression
* with  parentheses
* operation: +, -, *, / [/*+-] all operations are binary
* operand: either java variable or integer number or double number, for example
* a ; __; 10; 10.2; 10.0
* requirement: placing of parentheses is  considered
* a + ((10) * 2) => a+10*2
* a + ((10) * )2 => wrong
* a + (-10 * 2) => wrong
*/
public static String arithmeticExpression() {
	String operator = "[-+*/]";
	String operand = operandRegex();
	return String.format("\\(*%1$s\\)*(%2$s\\(*%1$s\\)*)*", operand, operator);
}
/*************************************************************************/
private static String operandRegex() {
	String number = "(\\d+.?\\d*|.\\d+)";
	return String.format("(%1$s|%2$s)", number, javaVariableRegex());
}


}
