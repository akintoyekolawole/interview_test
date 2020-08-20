package com.adio.consultancy.group.recruitment.exception;

/**
 * @author kolawole
 */
public abstract class AppraisalApiException extends RuntimeException {

  AppraisalApiException(String message) {
    super(message);
  }

  AppraisalApiException(String message, Throwable cause) {
    super(message, cause);
    if (this.getCause() == null && cause != null) {
      this.initCause(cause);
    }
  }
}
