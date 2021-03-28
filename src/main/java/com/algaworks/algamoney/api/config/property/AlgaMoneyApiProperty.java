package com.algaworks.algamoney.api.config.property;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("algamoney")
@Getter
@Setter
public class AlgaMoneyApiProperty {

    private String originPermitida = "http://localhost:8000";

    private final Seguranca seguranca = new Seguranca();


    public static class Seguranca {

        private boolean enableHttps;

        public boolean isEnableHttps() {
            return enableHttps;
        }

        public void setEnableHttps(boolean enableHttps) {
            this.enableHttps = enableHttps;
        }

    }
}
