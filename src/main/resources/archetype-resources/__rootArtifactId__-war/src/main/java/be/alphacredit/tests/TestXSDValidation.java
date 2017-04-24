package be.alphacredit.tests;

import java.math.*;
import java.net.*;

public class TestXSDValidation
{
  public static void main(String[] args) throws Exception
  {
    TestService testService = new TestService(new URL("http://cac40:9080/xsd-validation-war/TestService?wsdl"));
    TestStringInput testStringInput = new TestStringInput();
    testStringInput.setEnum("Toto");
    testStringInput.setFiveDigits(BigInteger.valueOf(99999));
    testStringInput.setRange(100);
    try
    {
      TestStringOutput testStringOutput = testService.getTestServicePort().testOperation(testStringInput);
      System.out.println("*** " + testStringOutput.getTestOutput());
    }
    catch (TestOperationException ex)
    {
      System.out.println("*** TestOperationException: " + ex.getMessage());
    }
  }
}
