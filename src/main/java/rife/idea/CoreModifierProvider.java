package rife.idea;

import com.intellij.codeInsight.lookup.LookupElementBuilder;

import java.util.ArrayList;
import java.util.List;

public class CoreModifierProvider {
    final static List<LookupElementBuilder> modifiers = new ArrayList<>();

    static public List<LookupElementBuilder> getModifiers() {
        modifiers.add(LookupElementBuilder.create("add"));
        modifiers.add(LookupElementBuilder.create("add_slashes"));
        modifiers.add(LookupElementBuilder.create("ampersand_list"));
        modifiers.add(LookupElementBuilder.create("as"));
        modifiers.add(LookupElementBuilder.create("ascii"));
        modifiers.add(LookupElementBuilder.create("at"));

        return modifiers;
    }
}
