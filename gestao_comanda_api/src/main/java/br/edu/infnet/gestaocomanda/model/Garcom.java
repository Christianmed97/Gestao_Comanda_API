package br.edu.infnet.gestaocomanda.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Entity
@DiscriminatorValue("GAR")
public class Garcom extends Funcionario {

}
