package com.adio.consultancy.group.recruitment.exception;

/**
 * @author kolawole
 */
public class ProcessingException extends AppraisalApiException {

  public ProcessingException(String message) {
    super(message);
  }

  public ProcessingException(String message, Throwable cause) {
    super(message, cause);
  }
}
