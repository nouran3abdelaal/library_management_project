package com.example.moiveAppMicroservice.services;
import com.example.moiveAppMicroservice.moive.Moive;
import com.example.moiveAppMicroservice.repositories.MoiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MoiveService {
    private final MoiveRepository moiveRepository;

    public List<Moive> getAllMoivesPaginated(Pageable paging){

        List<Moive> Moives = new ArrayList<>();
        Page<Moive> page= (Page<Moive>) moiveRepository.findAll(paging);
        return page.getContent();
//        return Moives;
    }
    public List<Moive> getAllMoives(){

        List<Moive> Moives = new ArrayList<>();
        moiveRepository.findAll().forEach(Moives::add);
        return Moives;
    }
    public Optional<Moive> getMoiveByID(String Id){
        return  moiveRepository.findById(Id);
    }

    public List<Moive> addMoive(Moive t) {
        List<Moive> Moives = new ArrayList<>();
        moiveRepository.save(t);
        moiveRepository.findAll().forEach(Moives::add);
        return Moives;
    }

    public void updateMoive(String id, Moive newMoive) {
        moiveRepository.save(newMoive);
    }

    public void deleteMoive(String id) {
        moiveRepository.deleteById(id);
    }

    public List<Moive> addMoives(List<Moive> moives) {
        return (List<Moive>) moiveRepository.saveAll(moives);

    }
}
