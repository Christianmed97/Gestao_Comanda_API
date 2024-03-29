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
@Table(name = "T_SOBREMESA")
@PrimaryKeyJoinColumn(name = "produto_id")
public class Sobremesa extends Produto{
		
	@Getter
	@Setter
	private String informacao;
	
	@Getter
	@Setter
	private boolean doce;
	
	@Getter
	@Setter
	private float quantidade;

}
