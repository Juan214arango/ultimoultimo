package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Reservations;
import co.usa.ciclo3.ciclo3.repository.crud.ReservationsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationsRepository {

    @Autowired
    private ReservationsCrudRepository reservationsCrudRepository;

    public List<Reservations> getAll(){
        return (List<Reservations>) reservationsCrudRepository.findAll();
    }
    public Optional<Reservations> getReservations(int id){
        return  reservationsCrudRepository.findById(id);
    }

    public Reservations save(Reservations r){
        return reservationsCrudRepository.save(r);
    }

}
