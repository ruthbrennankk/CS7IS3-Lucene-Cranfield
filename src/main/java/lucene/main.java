package lucene;

import java.util.Date;
import java.util.HashMap;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.search.similarities.Similarity;

//  System Driver Class
public class main {

    private static void parseHelper(HashMap<Integer, DocumentModel> docs, HashMap<Integer, String> qrys) {
        // Parser
        docs = Parser.parseDocuments();
        qrys = Parser.parseQueries();
    }




    private static void helper(int n, Analyzer analyzer, Similarity similarity,
                               String outputFile, HashMap<Integer, DocumentModel> docs,
                               HashMap<Integer, String> qrys) throws Exception {
        //  Indexer
        Indexer.indexDocuments(docs, analyzer);

        //  Searcher
        Searcher.searchDocuments(n, qrys, analyzer, similarity, outputFile);
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("**************************************************************");
        System.out.println("Starting Program Execution...");
        System.out.println("**************************************************************");

        // Parser
        HashMap<Integer, DocumentModel> docs = Parser.parseDocuments();
        HashMap<Integer, String> qrys = Parser.parseQueries();

        System.out.println("Custom Classic");
        Analyzer analyzer = GetAnalyzer.getOtherCustomAnalyzer();
        Similarity similarity = GetScoring.getClassicSimilarity();
        helper(Constants.N, analyzer, similarity, Constants.OUTPUT_FILE_CUSTOM_CLASSIC, docs, qrys);

        System.out.println("Custom BM25");
        analyzer = GetAnalyzer.getOtherCustomAnalyzer();
        similarity = GetScoring.getBM25Similarity();
        helper(Constants.N, analyzer, similarity, Constants.OUTPUT_FILE_CUSTOM_BM25, docs, qrys);

        System.out.println("English Classic");
        analyzer = GetAnalyzer.getEnglishAnalyzer();
        similarity = GetScoring.getClassicSimilarity();
        helper(Constants.N, analyzer, similarity, Constants.OUTPUT_FILE_ENGLISH_CLASSIC, docs, qrys);

        System.out.println("English BM25");
        analyzer = GetAnalyzer.getEnglishAnalyzer();
        similarity = GetScoring.getBM25Similarity();
        helper(Constants.N, analyzer, similarity, Constants.OUTPUT_FILE_ENGLISH_BM25, docs, qrys);

        System.out.println("**************************************************************");
        System.out.println("Finishing Program Execution...");
        System.out.println("**************************************************************");
    }

}