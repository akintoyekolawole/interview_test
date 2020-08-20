package com.adio.consultancy.group.recruitment.util;

import com.adio.consultancy.group.recruitment.exception.ProcessingException;
import org.apache.commons.codec.binary.Hex;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author kolawole
 */
public class SecurityUtil {

  public static String hashWithMd5(String rawKey) throws ProcessingException {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] encrypted = md.digest(rawKey.getBytes());
      return new String(Hex.encodeHex(encrypted));
    } catch (NoSuchAlgorithmException ex) {
      String errorMessage = "Unable to hash this string";
      throw new ProcessingException(errorMessage);
    }
  }
}
