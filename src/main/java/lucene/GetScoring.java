package lucene;

import org.apache.lucene.search.similarities.*;

public class GetScoring {


    //  Returns Vector Space Model
    public static Similarity getClassicSimilarity() {
        return new ClassicSimilarity();
    }

    //  Returns BM25
    public static Similarity getBM25Similarity() {
//        float k1 = (float) 1.2; //default values
//        float b = (float) 0.75;
        return new BM25Similarity();
    }

    //  Returns BooleanSimilarity
    public static Similarity getBooleanSimilarity() {
        return new BooleanSimilarity();
    }

    //  Returns LMDirichletSimilarity
    public static Similarity getLMDirichletSimilarity() {
        return new LMDirichletSimilarity();
    }

    //  Returns LMJelinekMercerSimilarity
    public static Similarity getLMJelinekMercerSimilarity() {
        return new LMJelinekMercerSimilarity((float) 0.7);
    }

}
