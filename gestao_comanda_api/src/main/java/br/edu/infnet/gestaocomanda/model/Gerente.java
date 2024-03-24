package br.edu.infnet.gestaocomanda.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Entity
@DiscriminatorValue("GER")
public class Gerente extends Funcionario {

}
