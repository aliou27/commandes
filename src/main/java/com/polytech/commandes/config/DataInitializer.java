package com.polytech.commandes.config;

import com.polytech.commandes.entity.Client;
import com.polytech.commandes.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final ClientRepository clientRepository;

    @Override
    public void run(String... args) {
        log.info("=== Initialisation des données ===");


        Client client1 = new Client(null, "Aliou Diallo", "aliou.diallo@example.com");
        Client client2 = new Client(null, "Fatou Sow", "fatou.sow@example.com");
        Client client3 = new Client(null, "Moussa Kane", "moussa.kane@example.com");

        clientRepository.save(client1);
        clientRepository.save(client2);
        clientRepository.save(client3);

        log.info("✓ 3 clients créés");
        log.info("=== Initialisation terminée ===");
    }
}
