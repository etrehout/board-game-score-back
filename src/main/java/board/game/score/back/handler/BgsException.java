package board.game.score.back.handler;

import java.text.MessageFormat;

public class BgsException extends RuntimeException {
    public BgsException(String errorCodeMessage, String... args) {
        super(MessageFormat.format(errorCodeMessage, args));
    }

    public BgsException(String errorCodeMessage) {
        super(errorCodeMessage);
    }
}