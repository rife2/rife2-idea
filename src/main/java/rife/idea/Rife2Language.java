package rife.idea;

import com.intellij.ide.highlighter.HtmlFileType;
import com.intellij.lang.InjectableLanguage;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.psi.templateLanguages.TemplateLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Rife2Language extends Language implements TemplateLanguage, InjectableLanguage {
    public static final Rife2Language INSTANCE = new Rife2Language();

    @SuppressWarnings("SameReturnValue") // ideally this would be public static, but the static inits in the tests get cranky when we do that
    public static LanguageFileType getDefaultTemplateLang() {
        return HtmlFileType.INSTANCE;
    }

    public Rife2Language() {
        super("RIFE2", "text/x-rife2-template", "text/x-rife2");
    }

    public Rife2Language(@Nullable Language baseLanguage, @NotNull @NonNls final String ID, @NonNls final String @NotNull ... mimeTypes) {
        super(baseLanguage, ID, mimeTypes);
    }
}
