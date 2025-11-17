package Lions.com.AppLions.Controle;

import Lions.com.AppLions.AlunoModelo.AlunoModelo;
import Lions.com.AppLions.AlunoModelo.RespostaModelo;
import Lions.com.AppLions.FichaTreino.DTO.RecordDTOtreino;
import Lions.com.AppLions.FichaTreino.REPOSITORIO.RepositorioTreino;
import Lions.com.AppLions.FichaTreino.TreinoModelo.Treinos;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")     // para dar acesso a todas as portas
public class ControleAluno {


    @Autowired
    RepositorioAluno repositorioAluno;

    @Autowired
   private RespostaModelo respostaModelo;



    @PostMapping("adicionar_aluno")
    public ResponseEntity<?> INSERIR(@RequestBody RecordDTO recordDTO) {

        if(recordDTO.nome().equals("")){
            respostaModelo.setMensagem("O nome é OBRIGATÓRIO!");
            return new ResponseEntity<RespostaModelo>(respostaModelo,HttpStatus.BAD_REQUEST);
        }

        var novo = new AlunoModelo();
        BeanUtils.copyProperties(recordDTO, novo);
        return ResponseEntity.status(HttpStatus.CREATED).body(repositorioAluno.save(novo));
    }


    @GetMapping("obter")
    public ResponseEntity<List<AlunoModelo>> LISTAR() {
        return ResponseEntity.status(HttpStatus.OK).body(repositorioAluno.findAll());
    }


    @GetMapping("obter/{codigo}")
    public ResponseEntity<Object> OBTER_ID(@PathVariable(value = "codigo") Integer codigo ) {
        Optional<AlunoModelo> aluno = repositorioAluno.findById(codigo);
        if (aluno.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("INEXISTENTE!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(aluno.get());
    }


    @PutMapping("atualizar/{codigo}")
    public ResponseEntity<Object> ATUALIZAR(@PathVariable(value = "codigo") Integer codigo, @RequestBody RecordDTO recordDTO) {
        Optional<AlunoModelo> aluno = repositorioAluno.findById(codigo);
        if (aluno.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NAO EXISTE!");
        }
        var atual = aluno.get();
        BeanUtils.copyProperties(recordDTO, atual);
       return ResponseEntity.status(HttpStatus.OK).body(repositorioAluno.save(atual));
    }


    @DeleteMapping("deletar/{codigo}")
    public ResponseEntity<Object> DELETAR(@PathVariable(value = "codigo") Integer codigo) {
        Optional<AlunoModelo> aluno = repositorioAluno.findById(codigo);
        if (aluno.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NAO EXISTE!");
        }

        repositorioAluno.delete(aluno.get());
        return ResponseEntity.status(HttpStatus.OK).body("DELETADO COM SUCESSO!");
    }






}


