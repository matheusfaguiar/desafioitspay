package aguiar.matheus.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler{
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> responseMap = new HashMap<String, Object>();
        
        responseMap.put("mensagem", message);
        responseMap.put("statusCode", status.value());
        
        map.put("cartao", responseObj);
        map.put("response", responseMap);   
        return new ResponseEntity<Object>(map,status);
    }
}