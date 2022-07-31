package aguiar.matheus.model;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


// definições de classe e entidade
@Entity
@Table  
public class Cartoes   
{  
    //definições e validações
    @Id  
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;  

    @NotBlank(message = "Número não pode ficar em branco!")
    @Column
    @Pattern(regexp="\\d{4}-\\d{4}-\\d{4}-\\d{4}", message="O número do cartão não é válido!") //adicionar validações para bandeira, etc
    public String numero;  

    
    @NotBlank(message = "Nome não pode ficar em branco!")
    @Column  
    public String nomeUsuario;  

    @NotBlank(message = "Código de Segurança não pode ficar em branco!")
    @Column
    @Pattern(regexp="\\d{3}", message="O número do cartão não é válido!")
    public String codigoSeguranca;

    @NotBlank(message = "Data de Validade não pode ficar em branco!")
    @Column
    @Pattern(regexp="\\d{2}/\\d{4}", message="A data de validade não é válida!")  //Criar validação específica para datas
    public String dataValidade; //alterar para formato específico para datas


    //construtores
    public Cartoes() {

    }

    public Cartoes(int id, String numero, String nomeUsuario, String codigoSeguranca, String dataValidade) {
        this.id = id;
        this.numero = numero;
        this.nomeUsuario = nomeUsuario;
        this.codigoSeguranca = codigoSeguranca;
        this.dataValidade = dataValidade;
    }


    // getters
    public int getId(){
        return id;
    }

    public String getNumero(){
        return numero;
    }

    public String getNomeUsuario(){
        return nomeUsuario;
    }

    public String getCodigoSeguranca(){
        return codigoSeguranca;
    }

    public String getDataValidade(){
        return dataValidade;
    }



    // setters
    public void setNumero(String numero){  
        this.numero = numero;  
    }

    public void setNomeUsuario(String nomeUsuario){  
        this.nomeUsuario = nomeUsuario;  
    }

    public void setCodigoSeguranca(String codigoSeguranca){  
        this.codigoSeguranca = codigoSeguranca;
    }

    public void setDataValidade (String dataValidade){
        this.dataValidade = dataValidade;

    }
}