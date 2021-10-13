package lucene;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.search.similarities.BM25Similarity;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Indexer {
    public static void indexDocuments(HashMap<Integer, DocumentModel> docs, Analyzer analyzer) {
        try {
            IndexWriter writer = getWriter(analyzer);
            for (Map.Entry<Integer, DocumentModel> entry : docs.entrySet()) {
                Document luceneDoc = new Document();
                luceneDoc.add(new TextField(Constants.ID, Integer.toString(entry.getKey()), Field.Store.YES));

                DocumentModel doc = entry.getValue();
                luceneDoc.add(new TextField(Constants.TITLE, doc.getTitle(), Field.Store.YES));
                luceneDoc.add(new TextField(Constants.AUTHOR, doc.getAuthor(), Field.Store.YES));
                luceneDoc.add(new TextField(Constants.BIBLIOGRAPHY, doc.getBibliography(), Field.Store.YES));
                luceneDoc.add(new TextField(Constants.CONTENT, doc.getContent(), Field.Store.YES));

                try {
                    writer.addDocument(luceneDoc);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }

            writer.close();
            System.out.println("Indexed Files Stored at " + Constants.INDEX_DIR);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static Directory getIndexDir() {
        Directory dir = null;
        try {
            dir = FSDirectory.open(Paths.get(Constants.INDEX_DIR));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return dir;
    }

    private static IndexWriter getWriter(Analyzer analyzer) {
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        iwc.setOpenMode(OpenMode.CREATE);
        iwc.setSimilarity(new BM25Similarity());
        IndexWriter writer = null;
        try {
            writer = new IndexWriter(getIndexDir(), iwc);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return writer;
    }
}
