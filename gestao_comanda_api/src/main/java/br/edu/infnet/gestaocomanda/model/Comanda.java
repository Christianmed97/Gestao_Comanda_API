package br.edu.infnet.gestaocomanda.model;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.infnet.gestaocomanda.repository.ClienteRepository;
import br.edu.infnet.gestaocomanda.service.impl.ClienteServiceImp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Entity
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
	private int numeroMesa;
	
	@Getter
	@Setter
	private Date dataHoraAbertura;
	
	@Getter
	@Setter
	private Date dataHoraFechamento;
	
	@Getter
	@Setter
	@Transient
	private List<Pedido> pedidos;

}
