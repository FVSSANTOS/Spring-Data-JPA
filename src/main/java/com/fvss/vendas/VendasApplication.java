package com.fvss.vendas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fvss.vendas.domain.entity.Cliente;
import com.fvss.vendas.domain.repositorio.Clientes;

@SpringBootApplication
public class VendasApplication {
		
		@Bean
		public CommandLineRunner init(@Autowired Clientes clientes){
			return args -> {
				clientes.salvar(new Cliente("Douglas"));

				clientes.salvar( new Cliente("outro cliente"));

				List<Cliente> todosClientes = clientes.obterTodos();
				todosClientes.forEach(System.out::println);
			};
		}
	public static void main(String[] args) {

		

		SpringApplication.run(VendasApplication.class, args);
	}

}