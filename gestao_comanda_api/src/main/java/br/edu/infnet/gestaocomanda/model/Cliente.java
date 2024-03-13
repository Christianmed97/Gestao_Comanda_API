package br.edu.infnet.gestaocomanda.model;

import br.edu.infnet.gestaocomanda.model.vo.EmailVO;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	
	@OneToOne
	@JoinColumn(name="comanda_id")
	private Comanda comanda;
	
	@Enumerated(EnumType.STRING)
	private TipoCLienteEnum tipoCliente;
	
	@Enumerated(EnumType.STRING)
	private TipoSexoEnum sexo;
	
	private String nome;
	
	@Transient
	private EmailVO email;
	
	private boolean ativo;
	
	
	
}
