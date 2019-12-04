package com.trm.util.pdf.Exception;

/**
 * @author zhaosimiao 2018-5-3 11:16:22
 */
@SuppressWarnings("serial")
public class PDFException extends BaseException {

    public PDFException(){
        super("PDF异常");
    }

    public PDFException(int errorCode, String errorMsg){
        super(errorMsg);
        this.errorCode=errorCode;
        this.errorMsg=errorMsg;
    }
    public PDFException(String errorMsg){
        super(errorMsg);
        this.errorCode=500;
        this.errorMsg=errorMsg;
    }
    public PDFException(String errorMsg, Exception e){
        super(errorMsg,e);
        this.errorCode=500;
        this.errorMsg=errorMsg;
    }


}
