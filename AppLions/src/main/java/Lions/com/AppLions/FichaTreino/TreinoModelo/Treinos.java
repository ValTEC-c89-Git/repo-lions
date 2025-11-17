package Lions.com.AppLions.FichaTreino.TreinoModelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;



    @Entity
//eqivale aos getters e setter com uso do lombok
    @Table(name = "treinos")
    @Getter
    @Setter
    public class Treinos implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer codigo;
        private String periodo;
        private String objetivo;
        private String caracteristicas_do_aluno;
        private String graviton;

        private String tipo_de_treino;
        private String serie;
        private String repetiçao;
        private String carga;

        private String esteira;
        private String bicicleta;
        private String caminhada;
        private String obs;




}
