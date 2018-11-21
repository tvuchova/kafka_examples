# kafka_examples

Apache Kafka is distributed and fault-tolerant stream processing system.

<br>To create messages, first, we need to configure a ProducerFactory which sets the strategy for creating Kafka Producer instances.
Then we need a KafkaTemplate which wraps a Producer instance and provides convenience methods for sending messages to Kafka topics.
Producer instances are thread-safe and hence using a single instance throughout an application context will give higher performance. ,  KakfaTemplate instances are also thread-safe 

<br>For consuming messages, we need to configure a ConsumerFactory and a KafkaListenerContainerFactory. Once these beans are available in spring bean factory, POJO based consumers can be configured using @KafkaListener annotation.

@EnableKafka annotation is required on the configuration class to enable detection of @KafkaListener annotation on spring managed beans.


All Kafka terminology:
<table class="table table-bordered">
<tr>
<th style="text-align:center;">S.No</th>
<th style="text-align:center;">Components and Description</th>
</tr>
<tr>
<td>1</td>
<td><p><b>Topics</b></p>
<p>A stream of messages belonging to a particular category is called a topic. Data is stored in topics.</p>
<p>Topics are split into partitions. For each topic, Kafka keeps a mini-mum of one partition. Each such partition contains messages in an immutable ordered sequence. A partition is implemented as a set of segment files of equal sizes.</p>
</td>
</tr>
<tr>
<td>2</td>
<td><p><b>Partition</b></p>
<p>Topics may have many partitions, so it can handle an arbitrary amount of data.</p>
</td>
</tr>
<tr>
<td>3</td>
<td>
<p><b>Partition offset</b></p>
<p>Each partitioned message has a unique sequence id called as <q>offset</q>.</p>
</td>
</tr>
<tr>
<td>4</td>
<td>
<p><b>Replicas of partition</b></p>
<p>Replicas are nothing but <q>backups</q> of a partition. Replicas are never read or write data. They are used to prevent data loss.</p>
</td>
</tr>
<tr>
<td>5</td>
<td>
<p><b>Brokers</b></p>
<ul class="list">
<li><p>Brokers are simple system responsible for maintaining the pub-lished data. Each broker may have zero or more partitions per topic. Assume, if there are N partitions in a topic and N number of brokers, each broker will have one partition.</p></li>
<li><p>Assume if there are N partitions in a topic and more than N brokers (n + m), the first N broker will have one partition and the next M broker will not have any partition for that particular topic.</p></li>
<li><p>Assume if there are N partitions in a topic and less than N brokers (n-m), each broker will have one or more partition sharing among them. This scenario is not recommended due to unequal load distri-bution among the broker.</p></li>
</ul>
</td>
</tr>
<tr>
<td>6</td>
<td>
<p><b>Kafka Cluster</b></p>
<p>Kafka’s having more than one broker are called as Kafka cluster. A Kafka cluster can be expanded without downtime. These clusters are used to manage the persistence and replication of message data.</p>
</td>
</tr>
<tr>
<td>7</td>
<td>
<p><b>Producers</b></p>
<p>Producers are the publisher of messages to one or more Kafka topics. Producers send data to Kafka brokers. Every time a producer pub-lishes a message to a broker, the broker simply appends the message to the last segment file. Actually, the message will be appended to a partition. Producer can also send messages to a partition of their choice.</p>
</td>
</tr>
<tr>
<td>8</td>
<td>
<p><b>Consumers</b></p>
<p>Consumers read data from brokers. Consumers subscribes to one or more topics and consume published messages by pulling data from the brokers.</p>
</td>
</tr>
<tr>
<td>9</td>
<td>
<p><b>Leader</b></p>
<p><q>Leader</q> is the node responsible for all reads and writes for the given partition. Every partition has one server acting as a leader.</p>
</td>
</tr>
<tr>
<td>10</td>
<td>
<p><b>Follower</b></p>
<p>Node which follows leader instructions are called as follower. If the leader fails, one of the follower will automatically become the new leader. A follower acts as normal consumer, pulls messages and up-dates its own data store.</p>
</td>
</tr>
</table>
