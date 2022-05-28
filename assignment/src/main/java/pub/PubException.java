package pub;

import java.text.MessageFormat;
import java.util.Locale;
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
        ResourceBundle bundle = ResourceBundle.getBundle("pub.inthepub", Locale.getDefault());
        String defaultMessage = this.getMessage();
        String utterance = bundle.getLocale().getLanguage();
        String message = LanguageUtils.getMessageOrDefault(bundle, defaultMessage, defaultMessage);
        return MessageFormat.format(message, params);
    }
}
