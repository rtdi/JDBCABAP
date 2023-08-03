package io.rtdi.jdbcabap.sql;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class ErrorHandler extends BaseErrorListener {

	public static final ErrorHandler INSTANCE = new ErrorHandler();

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) throws ParseCancellationException {
		throw new ParseCancellationException(String.format("line %d,%s: %s", line, charPositionInLine, msg));
	}
}