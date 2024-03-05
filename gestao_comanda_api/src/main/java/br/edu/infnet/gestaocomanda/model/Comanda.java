package br.edu.infnet.gestaocomanda.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity(name="t_comanda")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
public class Comanda {
	
	@Getter
	@Setter
	@Column(name="id_comanda")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	// @Setter
	@Column
	@Transient
	private Cliente cliente;
	
	@Getter
	@Setter
	@EqualsAndHashCode.Include
	@Column(name="nr_mesa")
	private int numeroMesa;
	
	@Getter
	@Setter
	@EqualsAndHashCode.Include
	@Column(name="dt_abertura")
	private Date dataHoraAbertura;
	
	@Getter
	@Setter
	@EqualsAndHashCode.Include
	@Column(name="dt_fechamento")
	private Date dataHoraFechamento;
	
	@Getter
	//@Setter
	@Column(name="pedidos")
	@Transient
	private List<Pedido> pedidos;

}
