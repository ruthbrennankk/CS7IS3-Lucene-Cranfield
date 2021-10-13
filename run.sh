mvn clean package -DskipTests
java -jar target/brennar5-lucene-cranfield-1.0.jar

trec_eval -m map -m gm_map -m P.5 ~/CS7IS3-Lucene-Cranfield/src/cran/formatted_qrel.test ~/CS7IS3-Lucene-Cranfield/src/cran/custom_classic.results > ~/CS7IS3-Lucene-Cranfield/performance/custom_classic.txt
trec_eval -m map -m gm_map -m P.5 ~/CS7IS3-Lucene-Cranfield/src/cran/formatted_qrel.test ~/CS7IS3-Lucene-Cranfield/src/cran/custom_bm25.results > ~/CS7IS3-Lucene-Cranfield/performance/custom_bm25.txt
trec_eval -m map -m gm_map -m P.5 ~/CS7IS3-Lucene-Cranfield/src/cran/formatted_qrel.test ~/CS7IS3-Lucene-Cranfield/src/cran/english_classic.results > ~/CS7IS3-Lucene-Cranfield/performance/english_classic.txt
trec_eval -m map -m gm_map -m P.5 ~/CS7IS3-Lucene-Cranfield/src/cran/formatted_qrel.test ~/CS7IS3-Lucene-Cranfield/src/cran/english_bm25.results > ~/CS7IS3-Lucene-Cranfield/performance/english_bm25.txt

echo " "
echo "Performance of Search Engines"
echo " "

echo "custom_classic"
cat ~/CS7IS3-Lucene-Cranfield/performance/custom_classic.txt
echo " "
echo "custom_bm25"
cat ~/CS7IS3-Lucene-Cranfield/performance/custom_bm25.txt
echo " "
echo "english_classic"
cat ~/CS7IS3-Lucene-Cranfield/performance/english_classic.txt
echo " "
echo "english_bm25"
cat ~/CS7IS3-Lucene-Cranfield/performance/english_bm25.txt

echo " "
