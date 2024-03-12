package br.edu.infnet.gestaocomanda.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Comanda {
	
	@Getter
	@Setter
	@Id
	private Long id;
	
	@Getter
	@Setter
	private Cliente cliente;
	
	@Getter
	@Setter
	private int numeroMesa;
	
	@Getter
	@Setter
	private Date dataHoraAbertura;
	
	@Getter
	@Setter
	private Date dataHoraFechamento;
	
	@Getter
	@Setter
	private List<Pedido> pedidos;

}
