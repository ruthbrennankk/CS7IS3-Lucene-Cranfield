package lucene;

// Lucene Analyzers
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.custom.CustomAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;

//  Custom Imports
import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.en.EnglishMinimalStemFilter;
import org.apache.lucene.analysis.en.EnglishPossessiveFilter;
import org.apache.lucene.analysis.en.KStemFilter;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.apache.lucene.analysis.standard.ClassicTokenizer;

public class GetAnalyzer {

    //  Returns WhitespaceAnalyzer (Splits tokens by whitespace)
    public static Analyzer getWhitespaceAnalyzer() {
        return new WhitespaceAnalyzer();
    }

    //  Returns SimpleAnalyzer (Splits text at non letter characters and lowercases)
    public static Analyzer getSimpleAnalyzer() {
        return new SimpleAnalyzer();
    }

    //  Returns SimpleAnalyzer (Divides text at non letter characters, lowercases, and removes stop words)
    public static Analyzer getStopAnalyzer() {
        return new StopAnalyzer(EnglishAnalyzer.getDefaultStopSet());
    }

    //  Returns StandardAnalyzer (Divides text at non letter characters, lowercases, and removes stop words)
    public static Analyzer getStandardAnalyzer() {
        return new StandardAnalyzer(EnglishAnalyzer.getDefaultStopSet());
    }

    //  Returns EnglishAnalyzer (Divides text at non letter characters, lowercases, and removes stop words)
    public static Analyzer getEnglishAnalyzer() {
        return new EnglishAnalyzer(EnglishAnalyzer.getDefaultStopSet());
    }

    public static Analyzer getCustomAnalyzer() {
        Analyzer a = null;
        try {
            a = CustomAnalyzer.builder()
                    .withTokenizer("standard")
                    .addTokenFilter("lowercase")
                    .addTokenFilter("stop")
                    .addTokenFilter("porterstem")
                    .addTokenFilter("capitalization")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return a;
    }

    public static Analyzer getOtherCustomAnalyzer() {
        return new lucene.CustomAnalyzer();
    }


}
