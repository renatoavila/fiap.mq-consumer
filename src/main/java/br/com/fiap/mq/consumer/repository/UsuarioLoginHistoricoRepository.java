package br.com.fiap.mq.consumer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
 
import br.com.fiap.mq.consumer.model.UsuarioLoginHistorico;
  
public interface UsuarioLoginHistoricoRepository extends JpaRepository<UsuarioLoginHistorico, Long> {
	

}

