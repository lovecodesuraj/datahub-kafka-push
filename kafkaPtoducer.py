from kafka import KafkaProducer
import json
import time

producer = KafkaProducer(bootstrap_servers='localhost:9092', value_serializer=lambda v: json.dumps(v).encode('utf-8'))

while True:
    data = {'key': 'value'}  # Replace with actual data generation logic
    producer.send('my_topic', data)
    time.sleep(0.001)  # Adjust the sleep to control the rate


