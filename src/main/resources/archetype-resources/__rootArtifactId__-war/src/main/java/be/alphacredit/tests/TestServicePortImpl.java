package be.alphacredit.tests;

import javax.jws.*;

import org.slf4j.*;

@WebService(endpointInterface = "be.alphacredit.tests.TestServicePortType", targetNamespace = "http://www.alphacredit.be/tests/", serviceName = "TestService", portName = "TestServicePort", wsdlLocation = "WEB-INF/wsdl/test.wsdl")
@HandlerChain(file="/META-INF/handler.xml")
public class TestServicePortImpl
{
  private static final Logger slf4jLogger = LoggerFactory.getLogger(TestServicePortImpl.class);
  public TestStringOutput testOperation(TestStringInput parameter)
  {
    TestStringOutput testStringOutput = new TestStringOutput();
    testStringOutput.setTestOutput(">> SERVICE: SEI Test Input String " + parameter.getRange() + " " + parameter.getEnum() + " " + parameter.getFiveDigits());
    slf4jLogger.debug(">> SERVICE: SEI Test JAX-WS Service: Request received.");
    slf4jLogger.debug(testStringOutput.getTestOutput());
    return testStringOutput;
  }
}
