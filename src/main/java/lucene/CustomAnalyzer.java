package lucene;
import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.en.*;
import org.apache.lucene.analysis.standard.ClassicTokenizer;

//   Custom Analyzer
public class CustomAnalyzer extends Analyzer {

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        Tokenizer source = new ClassicTokenizer();
        TokenStream tokenStream = new LowerCaseFilter(source);
        tokenStream = new EnglishPossessiveFilter(tokenStream);
        tokenStream = new EnglishMinimalStemFilter(tokenStream);
        tokenStream = new KStemFilter(tokenStream);
        tokenStream = new PorterStemFilter(tokenStream);
        CharArraySet stopSet = CharArraySet.copy(EnglishAnalyzer.getDefaultStopSet());
        tokenStream = new StopFilter(tokenStream, stopSet);
        return new TokenStreamComponents(source, tokenStream);
    }
}