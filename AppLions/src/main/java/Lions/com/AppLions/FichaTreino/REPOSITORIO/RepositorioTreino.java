package Lions.com.AppLions.FichaTreino.REPOSITORIO;

import Lions.com.AppLions.FichaTreino.TreinoModelo.Treinos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTreino extends JpaRepository<Treinos, Integer>{
}
