package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Messages;
import co.usa.ciclo3.ciclo3.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessagesService {

    @Autowired
    private MessagesRepository mesagesRepository;

    public List<Messages> getAll(){
        return mesagesRepository.getAll();
    }

    public Optional<Messages> getMessages(int id){
        return mesagesRepository.getMessages(id);
    }

    public Messages save(Messages m){
        if(m.getIdMessage()==null){
            return mesagesRepository.save(m);
        }else{
            Optional<Messages> paux=mesagesRepository.getMessages(m.getIdMessage());
            if(paux.isEmpty()){
                return mesagesRepository.save(m);
            }else{
                return m;
            }
        }
    }

}
