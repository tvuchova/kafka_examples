Apache Kafka is distributed and fault-tolerant stream processing system.
$ bin/kafka-topics.sh --create \
  --zookeeper localhost:2181 \
  --replication-factor 1 --partitions 1 \
  --topic first_topic
