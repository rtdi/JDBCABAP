package io.rtdi.jdbcabap.sql;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 * A singleton class of an parser error handler
 */
public class ErrorHandler extends BaseErrorListener {

	/**
	 * Provides access to the ErrorHandler object
	 */
	public static final ErrorHandler INSTANCE = new ErrorHandler();

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) throws ParseCancellationException {
		throw new ParseCancellationException(String.format("line %d,%s: %s", line, charPositionInLine, msg));
	}
}