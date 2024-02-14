package com.reservo;

import java.time.LocalDate;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Bean;

//import com.reservo.dao.UserDao;
//import com.reservo.entities.UserEntity;
//import com.reservo.entities.UserRole;

@SpringBootApplication
public class ReservoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservoApplication.class, args);
	}

	@Bean // equivalent to <bean id ..../> in xml file
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
				.setPropertyCondition(Conditions.isNotNull());// only non null properties will be transferred from src
		// --> dest , during the mapping
		modelMapper.addConverter(new StringToDateConverter());
		return modelMapper;
	}
	
	public class StringToDateConverter extends AbstractConverter<String,LocalDate> {
	    @Override
	    protected LocalDate convert(String source) {
	        return LocalDate.parse(source);
	    }
	}
	
//	@Bean
//	CommandLineRunner run(UserDao userDao, PasswordEncoder passwordEncoder) {
//		return args -> {
//			UserEntity user = new UserEntity("Shikhar", "Shikhar01", "Sharma", "shikhar@gmail.com",passwordEncoder.encode("shikhar123"),"12345", UserRole.ROLE_USER);
//			
//			userDao.save(user);
//		};
//	}
}
