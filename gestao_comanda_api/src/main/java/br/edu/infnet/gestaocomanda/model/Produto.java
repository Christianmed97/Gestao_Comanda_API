package br.edu.infnet.gestaocomanda.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "T_PRODUTO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Getter
	@Setter
	private String nome;
	
	@Getter
	@Setter
	private Float valor;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

}
