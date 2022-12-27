package com.example.solva.repository;

import com.example.solva.model.Currency;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface CurrencyRepository extends MongoRepository<Currency,String> {

}
