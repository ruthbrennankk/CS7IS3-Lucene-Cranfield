package lucene;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.search.similarities.Similarity;

public class Searcher {

    public static void searchDocuments(int n, HashMap<Integer, String> qrys, Analyzer analyzer, Similarity similarity, String outputFile) throws Exception{

        //  Create Everything
        IndexReader reader = getReader();
        MultiFieldQueryParser queryParser = getQueryParser(analyzer);
        PrintWriter writer = getWriter(outputFile);
        IndexSearcher searcher = getSearcher(reader, similarity);
        search(n, qrys, queryParser, searcher, writer);

        //  Close Everything
        writer.close();
        reader.close();

        System.out.println("Search Output Stored at " + outputFile);
    }

    private static IndexReader getReader() {
        IndexReader reader = null;
        try {
            reader = DirectoryReader.open(FSDirectory.open(Paths.get(Constants.INDEX_DIR)));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return reader;
    }

    private static PrintWriter getWriter(String outputFile) {
        PrintWriter writer = null;
        try {
//            File file = new File(Constants.OUTPUT_FILE);
            File file = new File(outputFile);
            writer = new PrintWriter(file, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return writer;
    }

    private static IndexSearcher getSearcher(IndexReader reader, Similarity similarity) {
        IndexSearcher searcher = new IndexSearcher(reader);
        searcher.setSimilarity(similarity);
        return searcher;
    }

    private static MultiFieldQueryParser getQueryParser(Analyzer analyzer) {
        return new MultiFieldQueryParser(Constants.FIELDS, analyzer);
    }

    private static void search(int n, HashMap<Integer, String> qrys, MultiFieldQueryParser queryParser, IndexSearcher searcher, PrintWriter writer) {
        try {
            for (Map.Entry<Integer, String> q : qrys.entrySet()) {
                Query query = queryParser.parse(QueryParser.escape(q.getValue()));

                ScoreDoc[] hits = searcher.search(query, n).scoreDocs;
                for(ScoreDoc sd:hits) {
                    // query-id Q0 document-id rank score STANDARD
                    writer.println((q.getKey()) + " Q0 " + Integer.parseInt(searcher.doc(sd.doc).get(Constants.ID)) + " 0 " + sd.score + " STANDARD");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}