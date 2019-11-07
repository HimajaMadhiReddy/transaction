package com.ucm.transaction.configuration;

import com.mongodb.MongoClient;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

public class MongoConfiguration extends AbstractMongoConfiguration {
    @Override
    public MongoClient mongoClient() {
        return new MongoClient("127.0.0.1",27017);
    }

    @Override
    protected String getDatabaseName() {
        return "transactions";
    }
}
