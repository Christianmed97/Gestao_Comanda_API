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
@Table(name = "T_REFEICAO")
@PrimaryKeyJoinColumn(name = "produto_id")
public class Refeicao extends Produto{
	
	@Getter
	@Setter
	private float peso;
	
	@Getter
	@Setter
	private boolean vegano;
	
	@Getter
	@Setter
	private String ingredientes;
   
}