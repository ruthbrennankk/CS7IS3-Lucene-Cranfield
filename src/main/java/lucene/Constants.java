package lucene;

// Class to house Constants for the Information Retrieval System
public class Constants {

    // Properties
    public static final String ID = ".I";
    public static final String AUTHOR = ".A";
    public static final String TITLE = ".T";
    public static final String BIBLIOGRAPHY = ".B";
    public static final String CONTENT = ".W";

    //  File Addresses
    public static final String CRAN_DOCS = "src/cran/cran.all.1400";
    public static final String CRAN_QRYS = "src/cran/cran.qry";
    public static final String INDEX_DIR = "src/index";

    public static final String OUTPUT_FILE_CUSTOM_CLASSIC = "src/cran/custom_classic.results";
    public static final String OUTPUT_FILE_CUSTOM_BM25 = "src/cran/custom_bm25.results";
    public static final String OUTPUT_FILE_ENGLISH_CLASSIC = "src/cran/english_classic.results";
    public static final String OUTPUT_FILE_ENGLISH_BM25 = "src/cran/english_bm25.results";

    //  Results number
    public static final int N = 1000;

    //  Fields
    public static final String [] FIELDS = {TITLE, AUTHOR, BIBLIOGRAPHY, CONTENT};

}
