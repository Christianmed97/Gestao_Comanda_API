package br.edu.infnet.gestaocomanda.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name = "T_PEDIDO")
public class Pedido {
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@Setter
	private String observacao;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "comanda_id")
	private Comanda comanda;
	
	@Getter
	@Setter
	@OneToMany
	@JoinColumn(name = "pedido")
	private List<Produto> produtos;

}
