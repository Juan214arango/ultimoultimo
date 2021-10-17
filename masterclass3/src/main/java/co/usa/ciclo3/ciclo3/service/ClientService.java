package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client l){
        if(l.getIdClient()==null){
            return clientRepository.save(l);
        }else{
            Optional<Client> paux=clientRepository.getClient(l.getIdClient());
            if(paux.isEmpty()){
                return clientRepository.save(l);
            }else{
                return l;
            }
        }
    }

}
