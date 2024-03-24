package br.edu.infnet.gestaocomanda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Entity
@Table(name = "T_BEBIDA")
@PrimaryKeyJoinColumn(name = "produto_id")
public class Bebida extends Produto {
		
	@Getter
	@Setter
	private Boolean gelada;
	
	@Getter
	@Setter
	private Float tamanho;
	
	@Getter
	@Setter
	private String marca;
	
}
