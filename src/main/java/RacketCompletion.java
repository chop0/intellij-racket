import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;
import org.racket.lang.RacketLanguage;
import org.racket.lang.core.psi.RacketElementTypes;

public class RacketCompletion extends CompletionContributor {
    private static final String[] keywords = new String[]{"cdr", "and", "begin", "case", "cond", "cond", "define", "delay", "do", "else", "if", "if", "lambda", "let", "let*", "letrec", "or", "quasiquote", "quote", "set!", "unquote", "unquote-splicing"};

    public RacketCompletion() {

        this.extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(RacketElementTypes.IDENTIFIER).withLanguage(RacketLanguage.INSTANCE),
                new CompletionProvider<>() {
                    @Override
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        for (String keyword : keywords) {
                            resultSet.addElement(LookupElementBuilder.create(keyword));
                        }
                    }
                }
        );
    }
}
