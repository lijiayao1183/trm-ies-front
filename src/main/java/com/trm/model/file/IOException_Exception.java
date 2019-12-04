
package com.trm.model.file;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.6
 * 2016-08-03T11:29:56.526+08:00
 * Generated source version: 3.1.6
 */

@SuppressWarnings("serial")
@WebFault(name = "IOException", targetNamespace = "http://server.webservice.trm.com/")
public class IOException_Exception extends Exception {
    
    private IOException ioException;

    public IOException_Exception() {
        super();
    }
    
    public IOException_Exception(String message) {
        super(message);
    }
    
    public IOException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public IOException_Exception(String message, IOException ioException) {
        super(message);
        this.ioException = ioException;
    }

    public IOException_Exception(String message, IOException ioException, Throwable cause) {
        super(message, cause);
        this.ioException = ioException;
    }

    public IOException getFaultInfo() {
        return this.ioException;
    }
}
