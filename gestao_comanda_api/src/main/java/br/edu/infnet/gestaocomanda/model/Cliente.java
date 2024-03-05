package br.edu.infnet.gestaocomanda.model;

import java.util.List;

import org.hibernate.annotations.ValueGenerationType;

import br.edu.infnet.gestaocomanda.model.vo.EmailVO;
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


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity(name="t_Cliente")
public class Cliente {
	
	
	@Id
	@Column(name="vl_cpf_Cnpj")
	@EqualsAndHashCode.Include
	private String cpfCnpj; 
	
	@Transient
	private TipoCLienteEnum tipoCliente;
	@Transient
	private TipoSexoEnum sexo;
	
	@Column(name="nm_cliente")
	@EqualsAndHashCode.Include
	private String nome;
	
	@Column(name="vl_email")
	@EqualsAndHashCode.Include
	private String email;
	
	@Transient
	private List<Comanda> comandas;
	
	
	
	
	


}
