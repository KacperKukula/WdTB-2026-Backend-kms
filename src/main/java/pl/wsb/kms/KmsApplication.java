package pl.wsb.kms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punkt startowy aplikacji.
 *
 * <p>LAB 01: zmień pakiet {@code pl.wsb.kms} na {@code pl.wsb.<nazwaprojektu>}
 * (np. {@code pl.wsb.kawiarnia}), a klasę na {@code <NazwaProjektu>Application}.
 * Reguła R1.01 sprawdza, czy to zrobiliście.
 */
@SpringBootApplication
public class KmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(KmsApplication.class, args);
    }
}
