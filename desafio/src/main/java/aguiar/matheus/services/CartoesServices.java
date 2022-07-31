package aguiar.matheus.services;  
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aguiar.matheus.model.Cartoes;
import aguiar.matheus.repository.CartoesRepository;  

@Service  
public class CartoesServices{  
    
    
    @Autowired
    CartoesRepository cartoesRepository;

    public List<Cartoes> getAllCartoes() {  
        List<Cartoes> cartoes = new ArrayList<Cartoes>();  
        cartoesRepository.findAll().forEach(cartao -> cartoes.add(cartao));  
        return cartoes;  
    }

    public Cartoes getCartoesById(int id)   {  
        return cartoesRepository.findById(id).get();  
    }  

    public Cartoes saveCartoes(Cartoes params)   
    {  
        Cartoes novoCartao = cartoesRepository.save(params);  
        return novoCartao;
    }  


    public void delete(int id){  
        cartoesRepository.deleteById(id);  
    }  
}  