package pub;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 *
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
class PubException extends Exception {

    Object[] params;

    public PubException( String defaultMessage, Object... params ) {
        super( defaultMessage );
        this.params = params;
    }

    @Override
    public String getLocalizedMessage() {
        return getMessageOrDefault();
    }

    public String getMessageOrDefault() {
        //TODO do the work to compose the message with params
         return "";
    }
}
