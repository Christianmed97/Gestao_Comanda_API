package br.edu.infnet.gestaocomanda.model;

import java.util.List;



import br.edu.infnet.gestaocomanda.model.vo.EmailVO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cliente {
	
	@Id
	private String cpfCnpj; 
	@Transient
	private TipoCLienteEnum tipoCliente;
	@Transient
	private TipoSexoEnum sexo;
	private String nome;
	@Transient
	private EmailVO email;
	@Transient
	private List<Comanda> comandas;
	private boolean ativo;
	
	


}
