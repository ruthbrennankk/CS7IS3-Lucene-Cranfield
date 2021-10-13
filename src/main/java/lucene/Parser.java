package lucene;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.io.FileReader;

//    Parser Class to read in the Cranfield Collection for indexing
public class Parser {

    public static HashMap<Integer, DocumentModel> parseDocuments() {
        HashMap<Integer, DocumentModel> docs = new HashMap<>();
        parseDocumentsHelper(docs);
        System.out.println("Documents Parsed Successfully");
        return docs;
    }

    private static void parseDocumentsHelper(HashMap<Integer, DocumentModel> docs) {
        String updateProperty = null;
        int i = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(Constants.CRAN_DOCS));
            String line = null;
            while ((line = br.readLine())!=null) {
                if (line.startsWith(Constants.ID)) {
                    i++;
                    updateProperty=Constants.ID;
                    docs.put(i, new DocumentModel(i));
                }
                else if (line.startsWith(Constants.AUTHOR))
                    updateProperty=Constants.AUTHOR;
                else if (line.startsWith(Constants.TITLE))
                    updateProperty=Constants.TITLE;
                else if (line.startsWith(Constants.BIBLIOGRAPHY))
                    updateProperty=Constants.BIBLIOGRAPHY;
                else if (line.startsWith(Constants.CONTENT))
                    updateProperty=Constants.CONTENT;
                else {
                    updateDocumentProperty(updateProperty, docs, i, line);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void updateDocumentProperty(String property, HashMap<Integer, DocumentModel> docs, int i, String line) {
        switch(property) {
            case Constants.ID:
                docs.get(i).setId(i);
                break;
            case Constants.AUTHOR:
                docs.get(i).setAuthor(getAppendage(docs.get(i).getAuthor(), line));
                break;
            case Constants.TITLE:
                docs.get(i).setTitle(getAppendage(docs.get(i).getTitle(), line));
                break;
            case Constants.BIBLIOGRAPHY:
                docs.get(i).setBibliography(getAppendage(docs.get(i).getBibliography(), line));
                break;
            case Constants.CONTENT:
                docs.get(i).setContent(getAppendage(docs.get(i).getContent(), line));
                break;
        }
    }

    public static HashMap<Integer, String> parseQueries() {
        HashMap<Integer, String> qrys = new HashMap<>();
        parseQueriesHelper(qrys);
        System.out.println("Queries Parsed Successfully");
        return qrys;
    }

    private static void parseQueriesHelper(HashMap<Integer, String> qrys) {
        String updateProperty = null;
        int i = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(Constants.CRAN_QRYS));
            String line = null;
            while ((line = br.readLine())!=null) {
                if (line.startsWith(Constants.ID)) {
                    i++;
                    updateProperty=Constants.ID;
                    qrys.put(i, "");
                } else if (line.startsWith(Constants.CONTENT))
                    updateProperty=Constants.CONTENT;
                else
                if(updateProperty==Constants.CONTENT)
                    qrys.put(i,getAppendage(qrys.get(i), line));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static String getAppendage(String current, String line) {
        if (current!="")
            return current+" "+line;
        else
            return line;
    }

}