package br.com.erudio;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static br.com.erudio.converters.NumberConverter.convertToDouble;
import static br.com.erudio.converters.NumberConverter.isNumeric;

@RestController
public class MathController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    //soma
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric Value!!!");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }


    //subtracao
    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric Value!!!");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }


    //multiplicacao
    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric Value!!!");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }


    //divisao
    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric Value!!!");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }


    //media
    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double media(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric Value!!!");
        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
    }


    //RaizQuadrada
    @RequestMapping(value = "/raiz/{number}", method = RequestMethod.GET)
    public Double raiz(@PathVariable(value = "number") String number) throws Exception {

        if(!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric Value!!!");
        }
        return Math.sqrt(convertToDouble(number));
    }




}
