package com.davidevanoni.msscbeerservice.bootstrap;

import com.davidevanoni.msscbeerservice.domain.Beer;
import com.davidevanoni.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) {
        loadBeerObject();
    }

    private void loadBeerObject() {
        if(beerRepository.count() == 0){
            beerRepository.save(Beer.builder()
                    .beerName("Ipa beer")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(45087340835L)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Pale ale beer")
                    .beerStyle("PALE_ALE")
                    .quantityToBrew(200)
                    .upc(34765939884L)
                    .price(new BigDecimal("10.95"))
                    .build());
        }

        System.out.println("Loaded beers " + beerRepository.count());
    }
}
