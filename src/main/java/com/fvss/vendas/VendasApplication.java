package com.fvss.vendas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fvss.vendas.domain.entity.Cliente;
import com.fvss.vendas.domain.entity.Pedido;
import com.fvss.vendas.domain.repository.Clientes;
import com.fvss.vendas.domain.repository.Pedidos;

@SpringBootApplication
public class VendasApplication {
		
		@Bean
		public CommandLineRunner init(@Autowired Clientes clientes, @Autowired Pedidos pedidos){
			return args -> {
				System.out.println("salvando clientes");
				
				Cliente fulano = new Cliente("Fulano");
				clientes.save(fulano);

				Pedido p = new Pedido();
				p.setCliente(fulano);
				p.setDataPedido(LocalDate.now());
				p.setTotal(BigDecimal.valueOf(100));

				pedidos.save(p);
				
				Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
				System.out.println(cliente);
				System.out.println(cliente.getPedidos());

				pedidos.findByCliente(cliente).forEach(System.out::println);
			};

			
		}
	public static void main(String[] args) {

		

		SpringApplication.run(VendasApplication.class, args);
	}

}
