package Lions.com.AppLions.Controle;

import Lions.com.AppLions.AlunoModelo.AlunoModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  RepositorioAluno extends JpaRepository<AlunoModelo, Integer>{
}
