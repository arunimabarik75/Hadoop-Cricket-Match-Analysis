# Hadoop Cricket Match Analysis

## Overview
This project leverages Apache Hadoop to analyze cricket match data, extracting valuable insights and generating comprehensive reports. The focus is on event data, which includes information such as the batsman, bowler, runs scored and wickets taken.

## Scope
The project focuses on event data and uses MapReduce functionalities like Mapper, Reducer, Combiner and Partitioner to calculate:

- Total Runs Team-Wise: Calculates the total runs scored by each team.
- Total Runs Player-Wise: Calculates the total runs scored by each player, considering individual team contributions.
- Top 3 Batsmen: Identifies the top 3 batsmen based on their total runs scored.
- Top 3 Bowlers: Identifies the top 3 bowlers based on the wickets taken.

## Technical Setup
- Framework: Apache Hadoop [Tutorial](https://hadoop.apache.org/docs/current/hadoop-mapreduce-client/hadoop-mapreduce-client-core/MapReduceTutorial.html)
- Dataset: CSV file containing event data (match details, players, runs, wickets)
- Functionalities: Implemented various combinations of Mapper, Reducer, Combiner and Partitioner to analyze four key aspects of cricket matches

`cricket_match.jar` is the combined jar file which can be used to perform required MapReduce operations on any dataset of your choice.

## Report
Access project documentation and report from [here](https://docs.google.com/document/d/1ac8QxAE07KYFVUNIIvezaaxwFAH8TBjv/edit)
