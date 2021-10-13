mvn clean package -DskipTests
java -jar target/brennar5-lucene-cranfield-1.0.jar

trec_eval -m map -m gm_map -m P.5 ~/lucene-cranfield/src/cran/formatted_qrel.test ~/lucene-cranfield/src/cran/custom_classic.results > ~/lucene-cranfield/performance/custom_classic.txt
trec_eval -m map -m gm_map -m P.5 ~/lucene-cranfield/src/cran/formatted_qrel.test ~/lucene-cranfield/src/cran/custom_bm25.results > ~/lucene-cranfield/performance/custom_bm25.txt
trec_eval -m map -m gm_map -m P.5 ~/lucene-cranfield/src/cran/formatted_qrel.test ~/lucene-cranfield/src/cran/english_classic.results > ~/lucene-cranfield/performance/english_classic.txt
trec_eval -m map -m gm_map -m P.5 ~/lucene-cranfield/src/cran/formatted_qrel.test ~/lucene-cranfield/src/cran/english_bm25.results > ~/lucene-cranfield/performance/english_bm25.txt

echo " "
echo "Performance of Search Engines"
echo " "

echo "custom_classic"
cat ~/lucene-cranfield/performance/custom_classic.txt
echo " "
echo "custom_bm25"
cat ~/lucene-cranfield/performance/custom_bm25.txt
echo " "
echo "english_classic"
cat ~/lucene-cranfield/performance/english_classic.txt
echo " "
echo "english_bm25"
cat ~/lucene-cranfield/performance/english_bm25.txt

echo " "