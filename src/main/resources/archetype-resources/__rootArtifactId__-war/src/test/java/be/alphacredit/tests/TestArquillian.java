package be.alphacredit.tests;

import static org.junit.Assert.*;

import java.io.*;
import java.math.*;
import java.net.*;
import java.util.*;

import javax.xml.ws.*;

import org.jboss.arquillian.container.test.api.*;
import org.jboss.arquillian.junit.*;
import org.jboss.shrinkwrap.api.*;
import org.jboss.shrinkwrap.api.spec.*;
import org.junit.*;
import org.junit.runner.*;

@RunWith(Arquillian.class)
public class TestArquillian
{
  private TestService testService;
  private static Properties properties;
  private Properties inContainerProperties;
  
  @Before
  public void setup() throws Exception
  {
    testService = new TestService (new URL("http://" + getPropertiesInContainer().getProperty("host") + ":" + getPropertiesInContainer().getProperty("port") + "/" + getPropertiesInContainer().getProperty("artifactId") + "/TestService?wsdl"));
  }
  
  @After
  public void cleanup()
  {
    testService = null;
  }
  
  @Deployment
  public static Archive<?> createTestArchive() throws Exception
  {
    return ShrinkWrap.createFromZipFile(WebArchive.class, new File("target/" + TestArquillian.getProperties().getProperty("artifactId") + ".war")).addAsResource("project.properties");
  }

  @Test
  public void testShouldPass() throws Exception
  {
    TestStringInput testStringInput = new TestStringInput();
    testStringInput.setEnum("Audi");
    testStringInput.setFiveDigits(new BigInteger("99999"));
    testStringInput.setRange(110);
    TestStringOutput testStringOutput = testService.getTestServicePort().testOperation(testStringInput);
    assertNotNull(testStringOutput);
    assertTrue(testStringOutput.testOutput.length() > 0);
    assertEquals(testStringOutput.testOutput, ">> SERVICE: SEI Test Input String " + testStringInput.getRange() + " " + testStringInput.getEnum() + " " + testStringInput.getFiveDigits());
  }

  @Test
  public void testShouldFailEnumInvalid() throws Exception
  {
    TestStringInput testStringInput = new TestStringInput();
    testStringInput.setEnum("Dacia");
    testStringInput.setFiveDigits(new BigInteger("99999"));
    testStringInput.setRange(110);
    try
    {
      testService.getTestServicePort().testOperation(testStringInput);
    }
    catch (WebServiceException ex)
    {
      fail();
    }
  }

  @Test
  public void testShouldFailRangeInvalidInvalid() throws Exception
  {
    TestStringInput testStringInput = new TestStringInput();
    testStringInput.setEnum("Audi");
    testStringInput.setFiveDigits(new BigInteger("99999"));
    testStringInput.setRange(999);
    try
    {
      testService.getTestServicePort().testOperation(testStringInput);
    }
    catch (WebServiceException ex)
    {
      fail();
    }
  }

  @Test
  public void testShouldFailFiveDigitsInvalid() throws Exception
  {
    TestStringInput testStringInput = new TestStringInput();
    testStringInput.setEnum("Audi");
    testStringInput.setFiveDigits(new BigInteger("999999"));
    testStringInput.setRange(110);
    try
    {
      testService.getTestServicePort().testOperation(testStringInput);
    }
    catch (WebServiceException ex)
    {
      fail();
    }
  }
  
  private static Properties getProperties() throws Exception
  {
    if (properties == null)
    {
      properties = new Properties();
      properties.load(new FileInputStream("target/test-classes/project.properties"));
    }
    return properties;
  }
  
  private Properties getPropertiesInContainer() throws Exception
  {
    if (inContainerProperties == null)
    {
      inContainerProperties = new Properties();
      inContainerProperties.load(this.getClass().getClassLoader().getResourceAsStream("/WEB-INF//classes/project.properties"));
    }
    return inContainerProperties;
  }
}
