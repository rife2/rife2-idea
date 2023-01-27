package rife.idea.editor.comments;

import com.intellij.codeInsight.generation.CommenterWithLineSuffix;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Rife2Commenter implements CommenterWithLineSuffix {
    @Override
    @Nullable
    public String getLineCommentPrefix() {
        return "<!--c-->";
    }

    @Override
    @NotNull
    public String getLineCommentSuffix() {
        return "<!--/c-->";
    }

    @Override
    @Nullable
    public String getBlockCommentPrefix() {
        return "<!--c-->";
    }

    @Override
    @Nullable
    public String getBlockCommentSuffix() {
        return "<!--/c-->";
    }

    @Override
    @Nullable
    public String getCommentedBlockCommentPrefix() {
        return null;
    }

    @Override
    @Nullable
    public String getCommentedBlockCommentSuffix() {
        return null;
    }
}
