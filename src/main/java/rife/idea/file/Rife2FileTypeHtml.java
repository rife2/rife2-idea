package rife.idea.file;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.*;
import rife.idea.Rife2LanguageHtml;

import javax.swing.*;

public class Rife2FileTypeHtml extends Rife2FileType {
    public static final LanguageFileType INSTANCE = new Rife2FileTypeHtml();

    private Rife2FileTypeHtml() {
        super(Rife2LanguageHtml.INSTANCE);
    }

    @NonNls
    public static final String DEFAULT_EXTENSION = "html";

    @NotNull
    @Override
    public String getName() {
        return "RIFE2HTML";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "RIFE2 HTML template file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return Rife2Icons.FILE;
    }
}
