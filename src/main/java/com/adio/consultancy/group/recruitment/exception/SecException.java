package com.adio.consultancy.group.recruitment.exception;

/**
 * @author kolawole
 */
public class SecException extends Exception {

  String message;
  String code;

  public SecException(String message) {
    this.message = message;
  }

  public SecException(Exception e) {
    this.message = e.getMessage();
    super.setStackTrace(e.getStackTrace());
  }

  public SecException(String message, String code) {
    this.message = message;
    this.code = code;
  }


  @Override
  public String getMessage() {
    return message;
  }

  public String getCode() {
    return code;
  }


}
