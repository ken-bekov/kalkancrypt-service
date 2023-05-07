package kz.talgau.crypto;

import kz.gov.pki.kalkan.jce.provider.KalkanProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.security.Provider;
import java.security.Security;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Scope("singleton")
    public Provider getKalkanProvider() {
        Provider kalkanProvider = new KalkanProvider();
        Security.addProvider(kalkanProvider);
        return kalkanProvider;
    }
}
