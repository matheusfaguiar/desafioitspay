package aguiar.matheus.controller;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aguiar.matheus.model.Cartoes;
import aguiar.matheus.response.ResponseHandler;
import aguiar.matheus.services.CartoesServices;  

//creating RestController  
@RestController
@RequestMapping("/cartoes")
public class CartoesController{

    @Autowired
    CartoesServices cartoesServices;

    public CartoesServices getCartoesServices() {
        return cartoesServices;
    }
    public void setCartoesServices(CartoesServices cartoesServices) {
        this.cartoesServices = cartoesServices;
    }  

   

    @PostMapping("")  
    public ResponseEntity<Object> Post(@RequestBody Cartoes params){  
        try{
            Cartoes novoCartao = cartoesServices.saveCartoes(params);
            return ResponseHandler.generateResponse("Cartão criado com sucesso.", HttpStatus.OK, novoCartao);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }  

    //lista de cartões
    @GetMapping("") 
    public ResponseEntity<Object> Get() {
        try {
            List<Cartoes> allCartoes = cartoesServices.getAllCartoes();
        return ResponseHandler.generateResponse("Cartões encontrados!", HttpStatus.OK, allCartoes);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    //consultar um cartão
    @GetMapping("/{id}")  
    public ResponseEntity<Object> Get(@PathVariable int id) {
        try {
            Cartoes cartao = cartoesServices.getCartoesById(id);
            return ResponseHandler.generateResponse("Cartão encontrado.", HttpStatus.OK, cartao);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
   
   
    // editar um cartao
    @PutMapping("/{id}")
    public ResponseEntity<Object> Update(@PathVariable int id, @RequestBody Cartoes params) {
        try {
            Cartoes cartao = params;
            cartao.id = id; 
            cartao = cartoesServices.saveCartoes(cartao);
            return ResponseHandler.generateResponse("Cartão atualizado.", HttpStatus.OK, cartao);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    //deletar um cartão
    @DeleteMapping("/{id}") 
    public ResponseEntity<Object> deleteCartoes(@PathVariable int id) {
        try {
            cartoesServices.delete(id);
            return ResponseHandler.generateResponse("Cartão deletado com sucesso.", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    } 
   

  
   
}  