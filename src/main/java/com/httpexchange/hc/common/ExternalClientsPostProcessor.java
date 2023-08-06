package com.httpexchange.hc.common;

import com.httpexchange.hc.rest.api.ExternalApiClients;
import org.reflections.Reflections;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Component
public class ExternalClientsPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        Reflections ref = new Reflections("com.httpexchange.hc");

        for (Class<?> clazz : ref.getTypesAnnotatedWith(ExternalClients.class)) {
            ExternalClients annotation = clazz.getAnnotation(ExternalClients.class);
            WebClient webClient = WebClient.builder()
                    .baseUrl(annotation.baseUrl())
                    .build();

            HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();
            Object externalClientsBean = factory.createClient(clazz);

            beanFactory.registerSingleton(clazz.getSimpleName(), externalClientsBean);
        }
    }
}
