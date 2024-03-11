package br.edu.infnet.gestaocomanda.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.Id;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Produto {
	
	@Getter
	@Setter
	@Column(name="id_produto")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Getter
	@Setter
	@Column(name="nm_produto")
	private String nome;
	
	@Getter
	@Setter
	@Column(name="nm_valor")
	private Float valor;
	
	@Transient
	@Column(name="pedido")
	private Pedido pedido;

}
