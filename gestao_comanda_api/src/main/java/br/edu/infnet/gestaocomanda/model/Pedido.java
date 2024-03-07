package br.edu.infnet.gestaocomanda.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "pedido")
public class Pedido {
	

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "id_pedido")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@EqualsAndHashCode.Include
	@Column(name = "vl_observacao")
	private String observacao;
	
	@Transient
	private Comanda comanda;
	@Transient
	private List<Produto> produtos;

}
