package com.example.MiniAssignment1.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfig {
    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;
    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;
    @Value("${amazon.aws.secretkey}")
    private String amazonSecretAccessKey;
    @Value("${amazon.aws.region}")
    private String amazonAWSRegion;

    @Bean
    public DynamoDBMapper DynamoDBMapper(){
        return new DynamoDBMapper(amazonDynamoDB());
    }
    private AmazonDynamoDB amazonDynamoDB(){
        BasicAWSCredentials credentials=new BasicAWSCredentials(amazonAWSAccessKey,amazonSecretAccessKey);
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(amazonDynamoDBEndpoint,amazonAWSRegion))
                .withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
    }


}
