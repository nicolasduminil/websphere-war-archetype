#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package};

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.18
 * 2017-03-30T16:02:14.126+02:00
 * Generated source version: 2.7.18
 */

@WebFault(name = "testStringFault", targetNamespace = "http://www.alphacredit.be/tests/")
public class TestOperationException extends Exception {
    
    private ${package}.TestStringFault testStringFault;

    public TestOperationException() {
        super();
    }
    
    public TestOperationException(String message) {
        super(message);
    }
    
    public TestOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestOperationException(String message, ${package}.TestStringFault testStringFault) {
        super(message);
        this.testStringFault = testStringFault;
    }

    public TestOperationException(String message, ${package}.TestStringFault testStringFault, Throwable cause) {
        super(message, cause);
        this.testStringFault = testStringFault;
    }

    public ${package}.TestStringFault getFaultInfo() {
        return this.testStringFault;
    }
}
