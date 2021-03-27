package com.io.t11.reportingservice.config;

import com.io.t11.reportingservice.service.ReportServiceSubscriber;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import redis.clients.jedis.JedisPool;

@Configuration
public class RedisConfig {
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(
                "redis-18040.c257.us-east-1-3.ec2.cloud.redislabs.com",
                18040);
        redisStandaloneConfiguration.setPassword("TGYqAObAPjsrZEd5KbDnzBexK5MYWTBS");
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

   /* @Bean
    String orderService() {
        return "validationService";
    }

    @Bean
    String exchangeConnectivity() {
        return "exchangeConnectivity";
    }

    @Bean
    String tradeEngine() {
        return "tradeService";
    }

    @Bean
    String clientConnectivity() {
        return "clientConnectivity";
    }

    @Bean
    ChannelTopic registerTopic() {
        return new ChannelTopic(orderService());
    }

    */

    @Bean
    JedisPool jedisPool() {
        return new JedisPool("redis-18040.c257.us-east-1-3.ec2.cloud.redislabs.com", 18040, "default", "TGYqAObAPjsrZEd5KbDnzBexK5MYWTBS");
    }


    @Bean("orderServiceListener")
    MessageListenerAdapter orderServiceListener() {
        return new MessageListenerAdapter(new ReportServiceSubscriber(), "onMessage");
    }

    @Bean("tradeServiceListener")
    MessageListenerAdapter tradeServiceListener() {
        return new MessageListenerAdapter(new ReportServiceSubscriber(), "onMessage");
    }

    @Bean("exchangeServiceListener")
    MessageListenerAdapter exchangeServiceListener() {
        return new MessageListenerAdapter(new ReportServiceSubscriber(), "onMessage");
    }

    @Bean("clientConnectivity")
    MessageListenerAdapter clientConnectivity() {
        return  new MessageListenerAdapter(new ReportServiceSubscriber(), "onMessage");
    }

    @Bean
    RedisMessageListenerContainer redisContainer( @Qualifier("orderServiceListener") MessageListenerAdapter orderServiceListener,
                                                  @Qualifier("tradeServiceListener") MessageListenerAdapter tradeServiceListener, @Qualifier("exchangeServiceListener") MessageListenerAdapter exchangeServiceListener) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(jedisConnectionFactory());
        container.addMessageListener(orderServiceListener, new ChannelTopic("validationService"));
        container.addMessageListener(tradeServiceListener, new ChannelTopic("tradeService"));
        container.addMessageListener(exchangeServiceListener, new ChannelTopic("exchangeService"));
        return container;
    }





    // there may be no need for a redis template
}
