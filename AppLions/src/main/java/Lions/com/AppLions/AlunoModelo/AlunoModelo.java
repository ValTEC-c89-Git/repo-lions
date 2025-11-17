package Lions.com.AppLions.AlunoModelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
//eqivale aos getters e setter com uso do lombok

@Table(name = "alunos")
@Getter
@Setter
public class AlunoModelo implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nome;
    private Integer idade;
    private String endereço;
    private Integer telefone;


    private String periodo;
    private String objetivo;
    private String caracteristicas_do_aluno;
    private String graviton;

    private String tipo_de_treino;
    private String tipo_de_treino2;
    private String tipo_de_treino3;
    private String tipo_de_treino4;
    private String tipo_de_treino5;

    private String serie;
    private String serie2;
    private String serie3;
    private String serie4;
    private String serie5;

    private String repetiçao;
    private String repetiçao2;
    private String repetiçao3;
    private String repetiçao4;
    private String repetiçao5;

    private String carga;
    private String carga2;
    private String carga3;
    private String carga4;
    private String carga5;

    private String esteira;
    private String esteira2;
    private String esteira3;
    private String esteira4;
    private String esteira5;

    private String bicicleta;
    private String bicicleta2;
    private String bicicleta3;
    private String bicicleta4;
    private String bicicleta5;

    private String caminhada;
    private String caminhada2;
    private String caminhada3;
    private String caminhada4;
    private String caminhada5;

    private String obs;
    private String obs2;
    private String obs3;
    private String obs4;
    private String obs5;


}
