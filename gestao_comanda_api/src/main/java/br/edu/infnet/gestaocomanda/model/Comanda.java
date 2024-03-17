package br.edu.infnet.gestaocomanda.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.infnet.gestaocomanda.repository.ClienteRepository;
import br.edu.infnet.gestaocomanda.service.impl.ClienteServiceImp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name = "T_COMANDA")
public class Comanda {
	
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@Setter
	@OneToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@Getter
	@Setter
	@Column(name = "numero_mesa")
	private int numeroMesa;
	
	@Getter
	@Setter
	@Column(name = "datahora_abertura")
	private Date dataHoraAbertura;
	
	@Getter
	@Setter
	@Column(name = "datahora_fechamento")
	private Date dataHoraFechamento;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "comanda")
	private List<Pedido> pedidos;
	
	

}
