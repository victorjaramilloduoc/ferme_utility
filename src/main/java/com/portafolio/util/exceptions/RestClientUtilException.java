package com.portafolio.util.exceptions;

/**
 * The class
 * <code>com.myhotel.bo.reports.exceptions.RestClientUtilException</code> is
 * responsible of
 *
 * @author rrequena - Roberto Requena (rart3001@gmail.com)
 * @version 1.0
 * @since JDK 1.7
 * @since 10 oct. 2017
 */
public class RestClientUtilException extends RuntimeException {

	/**
	 * Represent the value of serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public RestClientUtilException() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public RestClientUtilException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 * @param cause
	 */
	public RestClientUtilException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public RestClientUtilException(String message) {
		super(message);
	}

	/**
	 * Constructor
	 * 
	 * @param cause
	 */
	public RestClientUtilException(Throwable cause) {
		super(cause);
	}

}
