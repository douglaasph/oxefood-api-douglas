package br.edu.ifpe.oxefood_api_douglas.api.cliente;

import java.time.LocalDate;

import br.edu.ifpe.oxefood_api_douglas.api.acesso.Usuario;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLRestriction;

import br.edu.ifpe.oxefood_api_douglas.util.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cliente")
@SQLRestriction("habilitado = true")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel  {
    @OneToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    @Column(nullable = false, length = 100)
    private String nome;

   @Column
   private LocalDate dataNascimento;

   @Column(unique = true)
   private String cpf;

   @Column
   private String foneCelular;

   @Column
   private String foneFixo;

}
