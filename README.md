# lucene-cranfield
CA Project 1 for CS7IS3 Information Retrieval and Web Search

##  Getting Started
###   Setting up Trec_Eval
```
git clone https://github.com/usnistgov/trec_eval.git
cd trec_eval
make
mv trec_eval /usr/local/bin/
```
*execute trec_eval to see usage instructions*

###   Setting up the project
```
git clone https://github.com/ruthbrennankk/CS7IS3-Lucene-Cranfield.git
cd lucene-cranfield
./run.sh
```
*(note you may need to change permissions in order to execute the run.sh file, as root execute the command - ```chmod 777 run.sh``` )*

##   Key Directories
<ol>
    <li>Inputs</li>
    cranfield collection is stored at <i>lucene-cranfield/src/cran/cran.all.1400</i>
    <br>cranfield collection queries are stored at <i>lucene-cranfield/src/cran/cran.qry</i>
    <br>cranfield query relevance reformatted file at <i>lucene-cranfield/src/formatted_qrel.test</i>
    <li>System Outputs</li>
    Results/output from a run with a custom analyzer and classic similarity is stored at <i>lucene-cranfield/src/cran/custom_classic.results</i>
    <br>Results/output from a run with a custom analyzer and BM25 similarity is stored at <i>lucene-cranfield/src/cran/custom_bm25.results</i>
    <br>Results/output from a run with the english language analyzer and classic similarity is stored at <i>lucene-cranfield/src/cran/english_classic.results</i>
    <br>Results/output from a run with the english language analyzer and bm25 similarity is stored at <i>lucene-cranfield/src/cran/english_bm25.results</i>
    <li>Trec_eval Outputs</li>
    Outputs from the trec_eval commands executed by run.sh on each of the above runs can be found in the performance folder
</ol>
