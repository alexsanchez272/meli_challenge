package uy.meli.challenge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import uy.meli.challenge.interfaces.IItemExternal;
import uy.meli.interfaces.MeliClient;
import uy.meli.interfaces.dto.MeliBaseItemDTO;
import uy.meli.interfaces.dto.MeliItemDTO;

@SpringBootApplication
@EnableAsync
public class MeliChallengeApplication{

	private static final Logger log = LoggerFactory.getLogger(MeliChallengeApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MeliChallengeApplication.class, args);
	}

}
