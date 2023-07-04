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
				System.out.println("salvando clientes");
				
				clientes.salvar(new Cliente("Douglas"));

				clientes.salvar( new Cliente("outro cliente"));

				List<Cliente> todosClientes = clientes.obterTodos();
				todosClientes.forEach(System.out::println);

				System.out.println("atualizando clientes");

				todosClientes.forEach(c -> {
					c.setNome(c.getNome()+ "atualizada");
					clientes.atualizar(c);
				});

				todosClientes = clientes.obterTodos();
				todosClientes.forEach(System.out::println);	

				System.out.println("buscando clientes");
				
				clientes.buscarPorNome("cli").forEach(System.out::println);

				System.out.println("deletando clientes");
				clientes.obterTodos().forEach(c -> {
					clientes.deletar(c);
				});
				todosClientes = clientes.obterTodos();
				if(todosClientes.isEmpty()){
					System.out.println("Nenhum cliente encontrado");
				}
				todosClientes.forEach(System.out::println);	
			};

			
		}
	public static void main(String[] args) {

		

		SpringApplication.run(VendasApplication.class, args);
	}

}
