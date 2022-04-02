package br.com.fiap.mq.consumer.component;
 
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.fiap.mq.consumer.model.UsuarioLoginHistorico;
import br.com.fiap.mq.consumer.repository.UsuarioLoginHistoricoRepository;
 

@EnableRabbit
@Component
public class QueueConsumer {

	@Autowired
	UsuarioLoginHistoricoRepository usuarioRepository;
	
	
	@RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload String fileBody) {
        System.out.println("Message 1" + fileBody);
        UsuarioLoginHistorico usuarioLoginHistorico =  new Gson().fromJson(fileBody, UsuarioLoginHistorico.class);
        usuarioRepository.save(usuarioLoginHistorico);
    }
	
 
}
