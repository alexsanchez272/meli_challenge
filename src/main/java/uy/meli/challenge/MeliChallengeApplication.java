package uy.meli.challenge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uy.meli.challenge.interfaces.IItemExternal;
import uy.meli.interfaces.MeliClient;
import uy.meli.interfaces.dto.MeliBaseItemDTO;
import uy.meli.interfaces.dto.MeliItemDTO;

@SpringBootApplication
public class MeliChallengeApplication implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(MeliChallengeApplication.class);

	
	@Autowired
	private IItemExternal meliClient;
	
	public static void main(String[] args) {
		SpringApplication.run(MeliChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MeliItemDTO item = meliClient.getItem("MLU460998489");
		MeliBaseItemDTO[] childrens = meliClient.getItemChilds("MLU460998489");
		log.info("Response: " + item);
		
	}

}
